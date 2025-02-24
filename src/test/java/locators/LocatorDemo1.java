package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * @author mitrabhanu
 * @created 20-Feb-2025
 */
public class LocatorDemo1 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
		// Single element
		Locator locator = page.locator("text=Get Your Free Trial");
		locator.click();

	}

}
