 package com.evs.vtiger.appreusablecode.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.webUtil.WebUtil;

public class CommonReusableCode {


	@FindBy(xpath ="//input[@name='user_name']")    // all class ko PageFactory kahte hai 
	private WebElement UserName;              ///null 
	
	@FindBy(xpath ="//input[@name='user_password']")
	private WebElement UserPass;
	
	@FindBy(xpath ="//input[@name='Login']")
	private WebElement UserLogin;
	
	@FindBy(xpath ="//a[text()='Sign Out']")
	private WebElement LogOut;

	
	
	public void validLogin() {
//		WebUtil.launchBrowserAndOpenloginPage();
		WebUtil.inputData(UserName, "admin");
		WebUtil.inputData(UserPass, "admin");
		WebUtil.click(UserLogin);

	}
	public void inValidLogin() {
		WebUtil.launchBrowserAndOpenloginPage();
		WebUtil.inputData(UserName, "admins");
		WebUtil.inputData(UserPass, "admins");
		WebUtil.click(UserLogin);

	}


	public void logout() {
		
		WebUtil.click(LogOut);

	}
	
	
	
	

//		public void gotoMarketingLeadsPage() {
//			WebUtil.mouseOver("//a[text()='Marketing']", "Marketing Link");
//			WebUtil.mouseClick("//div[@class='drop_mnu']/table/tbody/tr/td/a[@href='index.php?module=Leads&action=index&parenttab=Marketing']", "Leads");
//			
//			
//		}

}
