package locators;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
public class LocatorDemo3 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial");

		// Multiple element
		Locator countryOptions = page.locator("select#Form_getForm_Country option");
		System.out.println(countryOptions.count());

		// Method 1-Using a Traditional For Loop
		for (int i = 0; i < countryOptions.count(); i++) {
			String text = countryOptions.nth(i).textContent();
			System.out.println(text);
		}

		// Method 2-Using an Enhanced For Loop (For-Each)
		List<String> options = countryOptions.allTextContents();
		for (String option : options) {
			System.out.println(option);
		}

		// Method 3-Using Streams (Method Reference)
		options.forEach(op -> System.out.println(op));

		// Method 4-Using Streams (Method Reference Shortcut)
		options.forEach(System.out::println);

		// Method 5-Using Streams with forEachOrdered
		options.stream().forEachOrdered(System.out::println);

		// Method 6-Using Streams (Collecting in to a list)
		List<String> optionsText = options.stream().collect(Collectors.toList());
		System.out.println(optionsText);

		// Method 7-Using an Iterator
		Iterator<String> itr = options.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());

		}
	}

}
