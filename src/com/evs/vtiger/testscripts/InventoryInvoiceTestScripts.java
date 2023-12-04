package com.evs.vtiger.testscripts;

import com.evs.vtiger.appreusablecode.common.*;
import com.evs.vtiger.appreusablecode.inventory.accounts.*;

public class InventoryInvoiceTestScripts {
	
	public void inventoryVT002() {
		CommonReusableCode com=	new CommonReusableCode();
		com.validLogin();
		InventoryInvoiceLandingPage tnvoice= new InventoryInvoiceLandingPage();
		tnvoice.gotoInventoryAccountPage();
		InventoryInvoiceCreateNewAccountsPage macnap=new InventoryInvoiceCreateNewAccountsPage();
		macnap.enterAndSaveMarketingAccountInfo();

		
	}

}
