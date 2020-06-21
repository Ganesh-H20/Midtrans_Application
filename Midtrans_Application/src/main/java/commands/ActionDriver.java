package commands;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;

import configuration.BrowserLaunch;

public class ActionDriver {

	WebDriver driver;

	public ActionDriver() {
		driver = BrowserLaunch.driver;
	}

	public void navigateToApplication(String url) throws Exception {
		try{
		driver.get(url);
		BrowserLaunch.childTest.pass("Successfully navigated to URL : "+url);
		}catch(Exception e){
			BrowserLaunch.childTest.fail("Unable to navigated to URL");
			throw e;
		}
	}

	public void click(By locator,String eleName) throws Exception {
		try{
			driver.findElement(locator).click();
			BrowserLaunch.childTest.pass("Successfully performed Click On : "+eleName);
		}catch(Exception e){
			BrowserLaunch.childTest.fail("Unable to performed Click On : "+eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			BrowserLaunch.childTest.info(e);
			throw e;
		}
	}

	public void type(By locator, String text,String eleName) throws Exception {
		try{
		driver.findElement(locator).sendKeys(text);
		BrowserLaunch.childTest.pass("Performed type in to " +eleName+ " with data : " +text);
		}catch(Exception e){
			BrowserLaunch.childTest.fail("Unable to Performed type in " +eleName+ " with data :"+text,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			BrowserLaunch.childTest.info(e);	
			throw e;
		}
	}

	public String getText(By locator) {
		try{
		String x = driver.findElement(locator).getText();
		BrowserLaunch.childTest.pass("Text is :"+x);
		return x;
		}catch(Exception e){
			BrowserLaunch.childTest.fail("Unable to return text");
			return null;
		}
	}

	public void clear(By locator) {
		driver.findElement(locator).clear();
	}

	private String screenShot() {	
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
}
