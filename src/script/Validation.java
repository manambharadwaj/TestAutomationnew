package script;

import org.testng.annotations.Test;

import generic.AUL;
import generic.BaseTest;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class Validation extends BaseTest{
	@Test(priority=2, groups= {"Login","smoke"})
	public void testvalidLogin() {
		String un=AUL.getCellValue(XL_PATH, "valid login", 1, 0);
		String pw=AUL.getCellValue(XL_PATH, "valid login", 1, 1);
		String eTitle=AUL.getCellValue(XL_PATH, "valid login", 1, 2);
		//enter valid username
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		//enter valid password
		l.setPassword(pw);
		//click login
		l.clickLogin();
		//verify the home page is displayed
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.verifyTitle(driver, eTitle);
		
		
	}

}
