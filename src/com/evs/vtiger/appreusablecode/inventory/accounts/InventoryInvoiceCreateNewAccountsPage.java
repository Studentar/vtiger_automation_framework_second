package com.evs.vtiger.appreusablecode.inventory.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.appreusablecode.marketing.accounts.MarketingAccountsSelectOfMember;
import com.evs.vtiger.webUtil.WebUtil;

public class InventoryInvoiceCreateNewAccountsPage {

	@FindBy(xpath ="//input[@name='subject']")
	private WebElement SubjectName;
	
	@FindBy(xpath ="//input[@name='customerno']")
	private WebElement CustomerNumber;
	
	@FindBy(xpath ="//input[@name='contact_name']/following-sibling::img")
	private WebElement ContactName;
	
	@FindBy(xpath ="//input[@name='exciseduty']")
	private WebElement ExciseDuty;
	
	@FindBy(xpath ="//input[@name='salesorder_id']/following-sibling::img")
	private WebElement SalesOrder;
	
	@FindBy(xpath ="//input[@name='vtiger_purchaseorder']")
	private WebElement VtigerPurchaseOrder;
	
	@FindBy(xpath ="//input[@name='salescommission']")
	private WebElement SalesCommission;
	
	@FindBy(xpath ="//input[@name='account_id']/following-sibling::img")
	private WebElement AccountName;
	
	@FindBy(xpath ="//textarea[@name='bill_street']")
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
	private WebElement saveButton;
	
	
	public void enterAndSaveMarketingAccountInfo() {
		WebUtil.inputData(SubjectName, "Vikesh");
		WebUtil.inputData(CustomerNumber, "12250");
		WebUtil.click(ContactName);

		InventoryInvoiceSelectOfMember member = new InventoryInvoiceSelectOfMember();
		member.selectOfMemberAccountName();
		WebUtil.switchToMainWindow();
		WebUtil.inputData(ExciseDuty, "8567887984");
		WebUtil.click(SalesOrder);

		member.selectOfMemberContactName();
		WebUtil.switchToMainWindow();
		WebUtil.inputData(VtigerPurchaseOrder, "evs");
		WebUtil.inputData(SalesCommission, "1500");
		WebUtil.click(AccountName);
		
		member.selectOfMemberSalesOrder();
		WebUtil.switchToMainWindow();
		WebUtil.inputData(BillingAddress, "Jaunpur Panwara");
		WebUtil.inputData(BillingPoBox, "mondh");
		WebUtil.inputData(BillingCity, "Jaunpur");
		WebUtil.inputData(BillingState, "Up");
		WebUtil.inputData(BillingCode, "1225");
		WebUtil.inputData(BillingCountry, "India");
		WebUtil.click(CopyBillingAddress);

		WebUtil.click(saveButton);
	}

}
