package com.freecrm.uiAutomation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.utility.LoggerUtil;

public class NewContactPage extends TestBase {

	private Select oSelect;
	private final Logger log = LoggerUtil.getLogger(NewContactPage.class);
	
	@FindBy(css = "select[name='title']")
	private WebElement selectTitle;
	@FindBy(css = "#first_name")
	private WebElement firstName;
	@FindBy(css = "#surname")
	private WebElement lastName;
	@FindBy(xpath = "//form[@name='contactForm']//input[@value='Save']")
	private WebElement btnSave;

	public NewContactPage() {
		PageFactory.initElements(driver, this);
	}
	public void setTitle(String title) {
		oSelect = new Select(selectTitle);
		log.info("Setting Title as:- " + title);
		oSelect.selectByValue(title);
	}
	public void setFirstName(String fName) {
		firstName.clear();
		log.info("Setting First Name as:- " + fName);
		firstName.sendKeys(fName);
	}
	public void setLastName(String lName) {
		log.info("Setting Last Name as:- " + lName);
		lastName.sendKeys(lName);
	}
	public void clickOnSaveBtn() {
		log.info("Clicking on Save Btn..");
		btnSave.click();
	}

}
