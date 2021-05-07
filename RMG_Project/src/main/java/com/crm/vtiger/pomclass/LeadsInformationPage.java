package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInformationPage {
	
	public LeadsInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement LeadInfo;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lnameInfo;

	/**
	 * @return the headerInfo
	 */
	public WebElement getHeaderInfo() {
		return LeadInfo;
	}

	/**
	 * @return the lnameInfo
	 */
	public WebElement getLnameInfo() {
		return lnameInfo;
	}
	
	public String getLeadInfo()
	{
		return LeadInfo.getText();
	}
	
	public String getlnameInfo()
	{
		return lnameInfo.getText();
	}

}
