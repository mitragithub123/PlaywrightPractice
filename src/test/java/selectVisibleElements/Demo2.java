/**
 * @author Mitra Bhanu
 * @created 25-Feb-2025
 */
package selectVisibleElements;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Demo2 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.amazon.in/");

		List<String> visibleLinks = page.locator("a:visible").allInnerTexts();
		visibleLinks.stream().forEach(System.out::println);

		int visibleImageCount = page.locator("xpath=//img >> visible=true").count();
		System.out.println("Visible image counts are: " + visibleImageCount);

		// You can write like this also
		// text=login >> visible=true

	}

}
