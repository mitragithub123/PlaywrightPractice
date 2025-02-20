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
public class LocatorDemo4 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial");

		Locator locators = page.locator("text=Privacy Policy");
		// Locator locators = page.locator("'Privacy Policy'"); // Same as above

		for (int i = 0; i < locators.count(); i++) {
			String text = locators.nth(i).textContent();
			if (text.contains("Service Privacy Policy")) {
				locators.nth(i).click();
				break;
			}
		}

	}

}
