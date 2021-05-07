package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateLeadsPage extends WebDriverUtility {
	
	public CreateLeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="salutationtype")
	private WebElement leadInfo1;
	
	@FindBy(name="firstname")
	private WebElement firstName;
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(name="company")
	private WebElement cmpny;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement svbtn;

	/**
	 * @return the leadInfo1
	 */
	public WebElement getLeadInfo1() {
		return leadInfo1;
	}

	/**
	 * @return the firstName
	 */
	public WebElement getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public WebElement getLastName() {
		return lastName;
	}

	/**
	 * @return the company
	 */
	public WebElement getCompany() {
		return cmpny;
	}
	
	/**
	 * Create New Leads by entering all the mandatory Field
	 * @param fname
	 * @param lname
	 * @param company
	 */
	public void createNewLeadsByEnteringAllTheField(String fname, String lname, String company )
	{
		SelectOption(leadInfo1, "Mr.");
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		cmpny.sendKeys(company);
		svbtn.click();
	}

}
