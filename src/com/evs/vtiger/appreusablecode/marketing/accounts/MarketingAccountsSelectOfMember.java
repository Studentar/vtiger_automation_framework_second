package com.evs.vtiger.appreusablecode.marketing.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.webUtil.WebUtil;

public class MarketingAccountsSelectOfMember {
	
	private String SwitchToWindowByUrl= "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=";
	
	@FindBy(xpath ="//input[@name='search_text']")
	private WebElement SearchText;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement ClickSearchButton;
	
	@FindBy(xpath = "//a[text()='Vikesh']")
	private WebElement ClickElementButton;
	
	
	public void selectOfMemberAccountName() {
		WebUtil.switchToWindowByUrl(SwitchToWindowByUrl);
		WebUtil.inputData(SearchText, "Vikesh");
		WebUtil.click(ClickSearchButton);
		WebUtil.click(ClickElementButton);
		WebUtil.acceptPopUpAlert();
		
		
	}

}
