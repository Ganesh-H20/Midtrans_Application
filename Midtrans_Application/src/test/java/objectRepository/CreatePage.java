package objectRepository;

import org.openqa.selenium.By;

public class CreatePage {

	// BuyNow
	public static By btnbuy = By.xpath("//a[@class='btn buy']");
	public static By cartCheckOut = By.xpath("//div[@class='cart-checkout']");
	public static By btnContinue = By.xpath("//*[@id='application']/div[1]/a");
	public static By btnCon = By.linkText("Continue");

	// Credit Card
	public static By linkCreditCard = By.xpath("//div[@id='payment-list']/div/a/div[2]/div[2]");
	public static By entCardNum = By.name("cardnumber");
	public static By expiryDate = By.xpath("(//input[@type='tel'])[2]");
	public static By cvv = By.xpath("//input[@value='']");

	// PayNow
	public static By email = By.xpath("//input[@type='email']");
	public static By phoneNum = By.xpath("(//input[@type='tel'])[4]");
	public static By btnPaynow = By.xpath("//a[@class='button-main-content']");

	// OTP Details
	public static By pass = By.xpath("//*[@id='PaRes']");
	public static By btnOk = By.name("ok");
	public static By btnDone = By.linkText("Done");

}
