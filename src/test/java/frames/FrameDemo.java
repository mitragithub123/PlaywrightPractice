package frames;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * @author mitrabhanu
 * @created 21-Feb-2025
 */
public class FrameDemo {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.londonfreelance.org/courses/frames/index.html");
		
		// Using locator
		// String headerTitle = page.frameLocator("frame[name='main']").locator("h2").textContent(); 
		String headerTitle = page.frame("main").locator("h2").textContent();// Using frame name tag
		System.out.println(headerTitle);

	}

}
