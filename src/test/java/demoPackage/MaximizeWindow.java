package demoPackage;
import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class MaximizeWindow {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();

		ArrayList<String> arg = new ArrayList<>();
		arg.add("--start-maximized");

		Browser browser = playwright.chromium()
									.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setArgs(arg));

		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions()
												.setViewportSize(null));

		Page page = browserContext.newPage();
		page.navigate("https://www.orangescrum.com/");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign in")).click();
		page.locator("#txt_UserId").fill("andolasoft.user133@gmail.com");
		page.locator("#txt_Password").click();
		page.locator("#txt_Password").fill("12345678");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("devoop")).click();
		
		browser.close();
		playwright.close();
	}
}
