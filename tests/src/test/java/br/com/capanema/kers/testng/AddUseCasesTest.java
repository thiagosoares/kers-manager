/**
 * 
 */
package br.com.capanema.kers.testng;

import junit.framework.Assert;

import org.testng.annotations.Test;

import br.com.capanema.kers.RealWorldHelper;
import br.com.capanema.kers.SeleniumTestBase;
import br.com.capanema.kers.RealWorldHelper.HtmlConstants;

/**
 * @author Konstantin Mishin
 *
 */
public class AddUseCasesTest extends SeleniumTestBase {
	
	@Test
	public void testAddAlbum() {
		String albumName = "_album";
		renderPage();

        RealWorldHelper.login(this, "user_for_add");
		selenium.click(HtmlConstants.ToolBarArea.VIEW_ALBUMS_PATH);
		waitForAjaxCompletion();
		Assert.assertFalse(RealWorldHelper.isAlbumPresentOnPage(selenium, albumName));

        RealWorldHelper.addAlbum(selenium, albumName);
		selenium.click(HtmlConstants.ToolBarArea.VIEW_ALBUMS_PATH);
		waitForAjaxCompletion();
		Assert.assertTrue(RealWorldHelper.isAlbumPresentOnPage(selenium, albumName));
	}
	
	@Test
	public void testAddShelf() {
		String shelfName = "_shelf";
		renderPage();

        RealWorldHelper.login(this, "user_for_add");
		selenium.click(HtmlConstants.ToolBarArea.VIEW_SHELFS_PATH);
		waitForAjaxCompletion();
		Assert.assertFalse(RealWorldHelper.isShelfPresentOnPage(selenium, shelfName));

        RealWorldHelper.addShelf(selenium, shelfName);
		selenium.click(HtmlConstants.ToolBarArea.VIEW_SHELFS_PATH);
		waitForAjaxCompletion();
		Assert.assertTrue(RealWorldHelper.isShelfPresentOnPage(selenium, shelfName));
	}
}
