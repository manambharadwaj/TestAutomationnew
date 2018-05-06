package script;

import org.testng.annotations.Test;

import generic.AUL;
import generic.BaseTest;
import page.LoginPage;

public class Invalidlogin extends BaseTest{
	@Test(priority=3, groups="login", enabled = false)
	public void testInvalidLogin() throws InterruptedException {
		int rc = AUL.getRowCount(XL_PATH, "invalid login");
		for(int i=1; i<=rc;i++) {
			String un = AUL.getCellValue(XL_PATH, "invalid login", i, 0);
			String pw = AUL.getCellValue(XL_PATH, "invalid login", i, 1);
			//enter invalid username
			LoginPage l=new LoginPage(driver);
			l.setUserName(un);
			//enter pw
			l.setPassword(pw);
			//click login
			l.clickLogin();
			//verify err msg is displayed
			l.verifyErrMsgIsDisplayed(driver);
			
		}
		
	}
	
}
