/**
 * @author Mitra Bhanu
 * @created 25-Feb-2025
 */
package selectVisibleElements;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Demo1 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("http://127.0.0.1:5500/src/test/java/selectVisibleElements/index.html");

		// button:visible
		String btn1Text = page.locator("button:visible").textContent();
		System.out.println(btn1Text);

		// or,
		// button >> visible=true
		String btn1TextAnotherWay = page.locator("button >> visible=true").textContent();
		System.out.println(btn1TextAnotherWay);

	}

}
