package frames;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * @author mitrabhanu
 * @created 21-Feb-2025
 */
public class IframeDemo {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

		page.locator("div#imageTemplateContainer img").click();

		page.frameLocator("//iframe[contains(@id, 'frame-one')]").locator("div#q1 input").fill("Mitrabhanu");

	}

}
