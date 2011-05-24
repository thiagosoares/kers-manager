/**
 * 
 */
package br.com.capanema.kers.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.capanema.kers.RealWorldHelper;
import br.com.capanema.kers.SeleniumTestBase;
import br.com.capanema.kers.RealWorldHelper.HtmlConstants;

/**
 * @author Konstantin Mishin
 *
 */
public class ScrollerUseCasesTest extends SeleniumTestBase {
	
	@Test
	public void testScroller() {
		renderPage();
		RealWorldHelper.login(this);
		selenium.click(HtmlConstants.ToolBarArea.VIEW_IMAGES_PATH);
		waitForAjaxCompletion();
		RealWorldHelper.openImageFromPreview(selenium);
		String firstImageName = selenium.getText(HtmlConstants.ImageArea.SCROLLER_PREVIEW_PATH + "[1]" + HtmlConstants.ImageArea.PREVIEW_NAME_PATH_SUFFIX);
		String secondImageName = selenium.getText(HtmlConstants.ImageArea.SCROLLER_PREVIEW_PATH + "[2]" + HtmlConstants.ImageArea.PREVIEW_NAME_PATH_SUFFIX);
		selenium.click(HtmlConstants.ImageArea.SCROLLER_NEXT_PATH);
		waitForAjaxCompletion();
		Assert.assertEquals(selenium.getText(HtmlConstants.ImageArea.SCROLLER_PREVIEW_PATH + "[1]" + HtmlConstants.ImageArea.PREVIEW_NAME_PATH_SUFFIX), secondImageName);
		selenium.click(HtmlConstants.ImageArea.SCROLLER_PREVIOUS_PATH);
		waitForAjaxCompletion();
		Assert.assertEquals(selenium.getText(HtmlConstants.ImageArea.SCROLLER_PREVIEW_PATH + "[1]" + HtmlConstants.ImageArea.PREVIEW_NAME_PATH_SUFFIX), firstImageName);
		Assert.assertEquals(selenium.getText(HtmlConstants.ImageArea.SCROLLER_PREVIEW_PATH + "[2]" + HtmlConstants.ImageArea.PREVIEW_NAME_PATH_SUFFIX), secondImageName);
		selenium.click(HtmlConstants.ImageArea.SCROLLER_PREVIEW_PATH + "[2]" + HtmlConstants.ImageArea.PREVIEW_NAME_PATH_SUFFIX);
		waitForAjaxCompletion();
		RealWorldHelper.testImageArea(selenium, secondImageName);
	}
}
