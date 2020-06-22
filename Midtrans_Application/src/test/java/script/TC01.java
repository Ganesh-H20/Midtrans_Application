package script;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import configuration.BrowserLaunch;
import reuse.Functions;

public class TC01 extends BrowserLaunch {

	@Test(priority = 1)
	public void SuccessCreditCardPayment() throws Exception {
		Functions fucs = new Functions();
		fucs.SCreditCardPayment();
	}

	/*@Test(priority = 2)
	public void FailedCreditCardPayment() throws Exception {
		Functions fucs = new Functions();
		fucs.FCreditCardPayment();
	}*/
}
