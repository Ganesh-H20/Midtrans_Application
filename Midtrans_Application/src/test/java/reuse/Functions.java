package reuse;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.BrowserLaunch;
import objectRepository.CreatePage;
import commands.ActionDriver;

public class Functions {

	WebDriver driver;
	ActionDriver ad;
	WebElement frame;
	WebDriverWait waits;

	public Functions() {
		driver = BrowserLaunch.driver;
		ad = new ActionDriver();
	}

	public void SCreditCardPayment() throws Exception {

		BrowserLaunch.childTest = BrowserLaunch.parentTest.createNode("Midtrans Application");
		ad = new ActionDriver();

		// URL
		ad.navigateToApplication("https://demo.midtrans.com/");
		ad.click(CreatePage.btnbuy, "Buy Now ");
		ad.click(CreatePage.cartCheckOut, "CheckOut");

		frame = driver.findElement(By.id("snap-midtrans"));
		driver.switchTo().frame(frame);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='text-button-main']/span")));

		// Continue Button
		ad.click(CreatePage.btnContinue, "Continue");
		ad.click(CreatePage.linkCreditCard, "Credit Card Details");

		// Credit Card Details
		ad.click(CreatePage.entCardNum, "Card Number");
		ad.clear(CreatePage.entCardNum);
		ad.type(CreatePage.entCardNum, "4811 1111 1111 1114", "enter Card Number");

		ad.click(CreatePage.expiryDate, "ExpiryDate");
		ad.clear(CreatePage.expiryDate);
		ad.type(CreatePage.expiryDate, "05 / 22", "enter ExpiryDate");

		ad.click(CreatePage.cvv, "CVV Details");
		ad.clear(CreatePage.cvv);
		ad.type(CreatePage.cvv, "123", "enter CVV");

		// Information
		ad.click(CreatePage.email, "Email");
		ad.click(CreatePage.phoneNum, "PhoneNumber");
		ad.click(CreatePage.btnPaynow, "PayNow");

		waits = new WebDriverWait(driver, 25);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.getElementById('PaRes').value='112233';");

		ad.click(CreatePage.pass, "Password");
		ad.clear(CreatePage.pass);
		ad.type(CreatePage.pass, "112233", "enter password ");
		ad.click(CreatePage.btnOk, "ok");

		// Successfully Done
		ad.click(CreatePage.btnDone, "Done");
	}

	/*public void FCreditCardPayment() throws Exception {

		BrowserLaunch.childTest = BrowserLaunch.parentTest.createNode("Midtrans Application");
		ad = new ActionDriver();

		// URL
		ad.navigateToApplication("https://demo.midtrans.com/");
		ad.click(CreatePage.btnbuy, "Buy Now ");
		ad.click(CreatePage.cartCheckOut, "CheckOut");

		frame = driver.findElement(By.id("snap-midtrans"));
		driver.switchTo().frame(frame);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='text-button-main']/span")));

		// Continue Button
		ad.click(CreatePage.btnContinue, "Continue");
		ad.click(CreatePage.linkCreditCard, "Credit Card Details");

		// Credit Card Details
		ad.click(CreatePage.entCardNum, "Card Number");
		ad.clear(CreatePage.entCardNum);
		ad.type(CreatePage.entCardNum, "4911 1111 1111 1113", "enter Card Number");

		ad.click(CreatePage.expiryDate, "ExpiryDate");
		ad.clear(CreatePage.expiryDate);
		ad.type(CreatePage.expiryDate, "05 / 22", "enter ExpiryDate");

		ad.click(CreatePage.cvv, "CVV Details");
		ad.clear(CreatePage.cvv);
		ad.type(CreatePage.cvv, "123", "enter CVV");

		// Information
		ad.click(CreatePage.email, "Email");
		ad.click(CreatePage.phoneNum, "PhoneNumber");
		ad.click(CreatePage.btnPaynow, "PayNow");

		waits = new WebDriverWait(driver, 25);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.getElementById('PaRes').value='112233';");

		ad.click(CreatePage.pass, "Password");
		ad.clear(CreatePage.pass);
		ad.type(CreatePage.pass, "112233", "enter password ");
		ad.click(CreatePage.btnOk, "ok");

		// Successfully Done
		ad.click(CreatePage.btnDone, "Done");
	}*/
}