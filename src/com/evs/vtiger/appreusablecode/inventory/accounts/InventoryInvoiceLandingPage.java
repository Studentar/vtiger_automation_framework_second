package com.evs.vtiger.appreusablecode.inventory.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.webUtil.WebUtil;

public class InventoryInvoiceLandingPage {
	@FindBy(xpath ="//a[text()='Inventory']")
	private WebElement InventoryMouseOver;
	
	@FindBy(xpath ="//div[@id='Inventory_sub']/table/tbody/tr/td/a[text()='Invoice']")
	private WebElement InvoiceClick;
	
	@FindBy(xpath ="//img[@title='Create Invoice...']")
	private WebElement CreateInvoiceAccount;

	
	public void gotoInventoryAccountPage() {
		WebUtil.mouseOver(InventoryMouseOver);
		WebUtil.mouseClick(InvoiceClick);
		WebUtil.click(CreateInvoiceAccount);

		
	}

}
