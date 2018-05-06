package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.AUL;
import generic.IAutoConst;

public class EnterTimeTrackPage implements IAutoConst {
	@FindBy(xpath="(//div[@class='popup_menu_arrow'])[3]")
	private WebElement help;
	
	@FindBy(xpath="//a[contains(text(),'About actiTIME')]")
	private WebElement aboutActiTIME;
	
	@FindBy(xpath="//span[starts-with(.,'actiTIME')]")
	private WebElement version;
	
	@FindBy(css="img[title='Close']")
	private WebElement closeBTN;
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	String strETO=AUL.getProperty(SETTINGS_PATH,"ETO");
	long ETO = Long.parseLong(strETO);
	
	public EnterTimeTrackPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickHelp() {
		help.click();
	}
	public void clickAboutActiTIME() {
		aboutActiTIME.click();
	}
	public void verifyVersion(String eVersion) {
		String aVersion=version.getText();
		Assert.assertEquals(aVersion, eVersion);
	}
	public void clickClose() {
		closeBTN.click();
	}
	public void clickLogout() {
		logoutLink.click();
	}
	public void verifyTitle(WebDriver driver, String eTitle) {
		WebDriverWait wait=new WebDriverWait(driver, ETO);
		try {
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("logout is Displayed",true);
			
		}
		catch(Exception e){
			Reporter.log("logout is not Displayed",true);
			Assert.fail();	
		}
	}
}
