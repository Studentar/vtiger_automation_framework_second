package com.evs.vtiger.appreusablecode.marketing.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.webUtil.WebUtil;

public class MarketingAccountDetailPage {

	@FindBy(xpath ="//input[@value='Edit']")
	private WebElement ClickEditButton;

	
	public static void gotoMarketingLeadsPage() {
		
	//	WebUtil.mouseClick(ClickEditButton);

	}

}
