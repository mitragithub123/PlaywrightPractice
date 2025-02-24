/**
 * @author Mitra Bhanu
 * @created 24-Feb-2025
 */
package shadowDom;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Demo1 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://books-pwakit.appspot.com/");

		// Page-->DOM-->Shadow DOM-->Elements

		page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing Books");
		String text = page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
		System.out.println(text);
	}

}
