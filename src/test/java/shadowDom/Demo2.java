/**
 * @author Mitra Bhanu
 * @created 24-Feb-2025
 */
package shadowDom;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Demo2 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://selectorshub.com/shadow-dom-in-iframe/");

		// Page-->DOM-->iFrame-->Shadow DOM-->Elements

		page.frameLocator("#pact").locator("div#snacktime #tea").fill("chicken");
	}

}
