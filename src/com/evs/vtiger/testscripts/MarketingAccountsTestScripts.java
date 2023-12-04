package com.evs.vtiger.testscripts;

import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.appreusablecode.common.*;
import com.evs.vtiger.appreusablecode.marketing.accounts.*;
import com.evs.vtiger.webUtil.WebUtil;
import com.evs.vtiger.appreusablecode.common.*;

public class MarketingAccountsTestScripts {
	
	public void marketingVT001() {
	    WebUtil.launchBrowserAndOpenloginPage();
		CommonReusableCode com = PageFactory.initElements(WebUtil.driver, CommonReusableCode.class);
		com.validLogin();
		
		MarketingAccountsLandingPage mal = PageFactory.initElements(WebUtil.driver, MarketingAccountsLandingPage.class);
		mal.gotoMarketingAccountPage();
		
        MarketingAccountCreateNewAccountPage mCreatePage = PageFactory.initElements(WebUtil.driver, MarketingAccountCreateNewAccountPage.class);
        mCreatePage.enterAndSaveMarketingAccountInfo();
        
        MarketingAccountsSelectOfMember accountSelectButton=PageFactory.initElements(WebUtil.driver, MarketingAccountsSelectOfMember.class);
        accountSelectButton.selectOfMemberAccountName();
        
//		MarketingReusebleCode mrc= new MarketingReusebleCode();
//		mrc.gotoMarketingAccountPage();
//		MarketingAccountCreateNewAccountPage macnap=new MarketingAccountCreateNewAccountPage();
//		macnap.enterAndSaveMarketingAccountInfo();
	
	}

}
