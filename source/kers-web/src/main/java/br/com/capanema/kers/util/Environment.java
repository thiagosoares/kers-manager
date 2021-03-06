/**
 * License Agreement.
 *
 * Rich Faces - Natural Ajax for Java Server Faces (JSF)
 *
 * Copyright (C) 2007 Exadel, Inc.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1 as published by the Free Software Foundation.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 */
package br.com.capanema.kers.util;
/**
 * Convenience class to determine in which environment application running.
 *
 * @author Andrey Markhel
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.jboss.seam.contexts.ServletLifecycle;

public class Environment {

	private static final String SHOW_HELP_ICONS_STRATEGY = "showHelpIconsStrategy";

	public static final String ENVIRONMENT_PROPERTIES = "environment.properties";

	public static final String ENVIRONMENT = "environment";
	public static final String DEVELOPMENT = "development";
	public static final String PRODUCTION = "production";
	public static final String SHOW = "yes";
	public static final String NOT_SHOW = "no";
	
	private static String getEnvironment() {
		try {
			final Properties props = new Properties();
			props.load(new FileInputStream(ServletLifecycle.getServletContext()
					.getRealPath("WEB-INF/classes/" + ENVIRONMENT_PROPERTIES)));
			return props.getProperty(ENVIRONMENT);
		} catch (FileNotFoundException e) {
			// Do nothing.
		} catch (IOException e) {
			// Do nothing.
		}

		return null;
	}
	
	private static String getShowHelpIconsStrategy() {
		try {
			final Properties props = new Properties();
			props.load(new FileInputStream(ServletLifecycle.getServletContext()
					.getRealPath("WEB-INF/classes/" + ENVIRONMENT_PROPERTIES)));
			return props.getProperty(SHOW_HELP_ICONS_STRATEGY);
		} catch (FileNotFoundException e) {
			// Do nothing.
		} catch (IOException e) {
			// Do nothing.
		}

		return null;
	}
	
	/**
	 * Convenience method to determine is the application running in production mode.
	 *
	 * @return true if application running in production mode
	 */
	public static boolean isInProduction(){
		final String environment = getEnvironment();
		if (DEVELOPMENT.equals(environment)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Convenience method to determine is the application help system will be rendered
	 *
	 * @return true if the application help system need to be rendered
	 */
	public static boolean isShowHelp(){
		final String environment = getShowHelpIconsStrategy();
		if (SHOW.equals(environment)) {
			return true;
		}
		return false;
	}
}
