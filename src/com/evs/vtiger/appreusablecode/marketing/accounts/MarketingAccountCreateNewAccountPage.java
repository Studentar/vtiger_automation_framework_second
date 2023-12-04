package com.evs.vtiger.appreusablecode.marketing.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.webUtil.WebUtil;

public class MarketingAccountCreateNewAccountPage {
	
	@FindBy(xpath ="//input[@name='accountname']")
	private WebElement AccountName;
	
	@FindBy(xpath ="//input[@name='website']")
	private WebElement DetailedViewTextBox;
	
	@FindBy(xpath ="//input[@name='tickersymbol']")
	private WebElement TickerSymbol;
	
	@FindBy(xpath ="//input[@id='phone']")
	private WebElement EnterPhoneNumber;
	
	@FindBy(xpath ="//img[@title='Select']" )
	private WebElement SelectTitle;
	
	@FindBy(xpath = "//input[@id='fax']")
	private WebElement FaxName;
	
	@FindBy(xpath = "//input[@id='email1']")
	private WebElement EnterEmail;
	
	@FindBy(xpath = "//textarea[@name='bill_street']")
	private WebElement BillingAddress;
	
	@FindBy(xpath ="//input[@id='bill_pobox']")
	private WebElement BillingPoBox;
	
	@FindBy(xpath ="//input[@id='bill_city']")
	private WebElement BillingCity;
	
	@FindBy(xpath ="//input[@id='bill_state']")
	private WebElement BillingState;
	
	@FindBy(xpath ="//input[@id='bill_code']")
	private WebElement BillingCode;
	
	@FindBy(xpath ="//input[@id='bill_country']")
	private WebElement BillingCountry;
	
	@FindBy(xpath ="//b[text()='Copy Billing address']")
	private WebElement CopyBillingAddress;
	
	@FindBy(xpath ="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement ClickSevBottun;
	
	public void enterAndSaveMarketingAccountInfo() {
		WebUtil.inputData(AccountName, "Vikesh");
		WebUtil.inputData(DetailedViewTextBox, "localhost:8888");
		WebUtil.inputData(TickerSymbol, "plus");
		WebUtil.inputData(EnterPhoneNumber, "8567887984");
		WebUtil.click(SelectTitle);
		
		MarketingAccountsSelectOfMember member =PageFactory.initElements(WebUtil.driver, MarketingAccountsSelectOfMember.class);
		member.selectOfMemberAccountName();
		WebUtil.switchToMainWindow();
		WebUtil.inputData(FaxName, "evs");
		WebUtil.inputData(EnterEmail, "vikeshyadav8542@gmail.com");
		WebUtil.inputData(BillingAddress, "Jaunpur Panwara");
		WebUtil.inputData(BillingPoBox, "mondh");
		WebUtil.inputData(BillingCity, "Jaunpur");
		WebUtil.inputData(BillingState, "Up");
		WebUtil.inputData(BillingCode, "1225");
		WebUtil.inputData(BillingCountry, "India");
		WebUtil.click(CopyBillingAddress);
		WebUtil.click(ClickSevBottun);
		WebUtil.acceptPopUpAlert();
	}

	
}
