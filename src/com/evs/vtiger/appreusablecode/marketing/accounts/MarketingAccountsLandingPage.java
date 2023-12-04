package com.evs.vtiger.appreusablecode.marketing.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.webUtil.WebUtil;

public class MarketingAccountsLandingPage {

	@FindBy(xpath = "//a[text()='Marketing']")
	private WebElement MarketingMouseOver;

	@FindBy(xpath ="//div[@id='Marketing_sub']//a[text()='Accounts']" )
	private WebElement AccountClick;

	@FindBy(xpath = "//img[@alt='Create Account...']")
	private WebElement CreateMarketingAccount;


	public void gotoMarketingAccountPage() {
		WebUtil.mouseOver(MarketingMouseOver);
		WebUtil.mouseClick(AccountClick);
		WebUtil.click(CreateMarketingAccount);


	}




}
