package com.evs.vtiger.appreusablecode.inventory.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.webUtil.WebUtil;

public class InventoryInvoiceSelectOfMember {

    @FindBy(xpath ="http://localhost:8888/index.php?module=Contacts&action=Popup&html=Popup_picker&popuptype=specific&form=EditView")
	private String SwitchToWindowByUrl;
    
    @FindBy(xpath ="//input[@name='search_text']")
	private WebElement SearchText;
    
    @FindBy(xpath ="//input[@class='crmbutton small create']")
	private WebElement ClickSearchButton;
    
    @FindBy(xpath ="//input[@name='search']")
	private WebElement ClickElementButton;
	
    @FindBy(xpath ="http://localhost:8888/index.php?module=SalesOrder&action=Popup&html=Popup_picker&popuptype=specific&form=EditView")
	private String SwitchToWindowHandelByUrl;
	
    @FindBy(xpath ="//input[@name='search_text']")
    private WebElement SearchTextButton;
	
    @FindBy(xpath ="//input[@class='crmbutton small create']")
    private WebElement ClickBySearchButton;
	
    @FindBy(xpath ="//a[text()='SO1']")
    private WebElement ClickByElementButton;
	
    @FindBy(xpath ="http://localhost:8888/index.php?module=Contacts&action=Popup&html=Popup_picker&popuptype=specific&form=EditView")
	private String SwitchToWindowUrl;
	
    @FindBy(xpath ="//input[@name='search_text']")
    private WebElement SearchTextByButton;
	
    @FindBy(xpath ="//input[@class='crmbutton small create']")
    private WebElement ClickSearchByButton;
	
    @FindBy(xpath ="//a[text()='Johnson Patricia']")
    private WebElement ClickElementByButton;


	public void selectOfMemberContactName() {
		WebUtil.switchToWindowByUrl(SwitchToWindowByUrl);
		WebUtil.inputData(SearchText, "Johnson Patricia");
		WebUtil.click(ClickSearchButton);
		WebUtil.click(ClickElementButton);
		WebUtil.acceptPopUpAlert();


	}
	public void selectOfMemberSalesOrder() {
		WebUtil.switchToWindowByUrl(SwitchToWindowHandelByUrl);
		WebUtil.inputData(SearchTextButton, "Johnson Patricia");
		WebUtil.click(ClickBySearchButton);
		WebUtil.click(ClickByElementButton);
		WebUtil.acceptPopUpAlert();


	}
	public void selectOfMemberAccountName() {
		WebUtil.switchToWindowByUrl(SwitchToWindowUrl);
		WebUtil.inputData(SearchTextByButton, "Johnson Patricia");
		WebUtil.click(ClickSearchByButton);
		WebUtil.click(ClickElementByButton);
		WebUtil.acceptPopUpAlert();


	}


}
