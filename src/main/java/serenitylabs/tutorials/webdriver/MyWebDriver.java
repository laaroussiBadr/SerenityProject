package serenitylabs.tutorials.webdriver;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.thucydides.core.webdriver.DriverSource;

public class MyWebDriver implements DriverSource {
	
	private String BROWSER = "Chrome";

	@Override
	public WebDriver newDriver() {
		if(BROWSER.equals("Chrome")) {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			return new ChromeDriver(capabilities);
		}
		else if (BROWSER.equals("Firefox")) {
			FirefoxProfile FF = new FirefoxProfile(new File("C:\\Users\\blaaroussi\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\40z4mcka.blaaroussi"));
			return new FirefoxDriver(FF);
		}
		return null;
	}

	@Override
	public boolean takesScreenshots() {
		// TODO Auto-generated method stub
		return true;
	}

}