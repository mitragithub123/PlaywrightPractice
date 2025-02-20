package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * @author mitrabhanu
 * @created 20-Feb-2025
 */
public class LocatorDemo5 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://demo.opencart.com/index.php?route=account/login");

		String locator = page.locator("text=New Customer").textContent();
		System.out.println(locator);
		// Same
		String locator1 = page.locator("'New Customer'").textContent();
		System.out.println(locator1);
		// Same
		String locator2 = page.locator("h2 >> text=New Customer").textContent();
		System.out.println(locator2);
		// Same
		String locator3 = page.locator("div#content h2 >> text=New Customer").textContent();
		System.out.println(locator3);

	}

}
