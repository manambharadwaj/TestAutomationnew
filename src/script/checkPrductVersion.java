package script;

import org.testng.annotations.Test;

import generic.AUL;
import generic.BaseTest;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class checkPrductVersion extends BaseTest{
	@Test(priority=4,groups="version")
	public void testcheckprductVersion() {
		String un = AUL.getCellValue(XL_PATH, "valid login", 1, 0);
		String pw = AUL.getCellValue(XL_PATH, "valid login", 1, 1);
		
		//enter valid username and pwsrd
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		l.setPassword(pw);
		//clicl login
		l.clickLogin();
		//click help
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.clickHelp();
		//click about your
		e.clickAboutActiTIME();
		//check version
		String eVersion=AUL.getCellValue(XL_PATH, "valid login", 1, 3);
		e.verifyVersion(eVersion);
		//click close
		e.clickClose();
		//click logout
		e.clickLogout();
		String eTitle=AUL.getCellValue(XL_PATH, "valid login", 1, 4);
		e.verifyTitle(driver, eTitle);	
	}
}
