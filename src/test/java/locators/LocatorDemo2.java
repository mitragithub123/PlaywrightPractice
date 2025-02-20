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
public class LocatorDemo2 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://academy.naveenautomationlabs.com/");
		// Multiple element
		Locator locator = page.locator("text=Courses");
		int locCount = locator.count();
		System.out.println(locCount);
		locator.first().click();
		//locator.last().click();

	}

}
