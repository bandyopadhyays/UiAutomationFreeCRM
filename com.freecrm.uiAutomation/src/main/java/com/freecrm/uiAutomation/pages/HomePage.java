package com.freecrm.uiAutomation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.uiAutomation.base.TestBase;
import com.freecrm.uiAutomation.utility.ActionUtil;
import com.freecrm.uiAutomation.utility.LoggerUtil;
import com.freecrm.uiAutomation.utility.PageElementUtil;
import com.freecrm.uiAutomation.utility.WinUtil;

public class HomePage extends TestBase {

	private final Logger log = LoggerUtil.getLogger(HomePage.class);

	@FindBy(xpath = "//a[contains(@href,'logout')]")
	WebElement linkLogout;
	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement linkContacts;
	@FindBy(xpath = "//li/a[contains(.,'Calendar')]")
	WebElement linkCalender;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isLoginSuccess() {
		WinUtil.switchToFrame(driver, "mainpanel");
		log.info("checking presence of element : " + linkLogout);
		boolean flag = PageElementUtil.isElementPresent(linkLogout);
		WinUtil.switchBackToParentFrame(driver);
		return flag;
	}

	public void logOut() {
		try {
			WinUtil.switchToFrame(driver, "mainpanel");
			log.info("Logging Out from app..");
			linkLogout.click();
			WinUtil.switchBackToParentFrame(driver);
		} catch (Exception e) {
			log.info("Logging Out from app..");
			linkLogout.click();
		}
	}

	public ContactsPage clickOnContactsLink() {
		log.info("Clicking on contact link..");
		WinUtil.switchToFrame(driver, "mainpanel");
		linkContacts.click();
		return new ContactsPage();
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public void mouseHoverToContactsLink() {
		log.info("Mouce Hovering to Contacts link..");
		ActionUtil.mouseHoverToElement(driver, linkContacts);
	}
	
	public void mouceHoverToCalenderLink() {
		log.info("Mouce Hovering to Calender link..");
		ActionUtil.mouseHoverToElement(driver, linkCalender);
	}
	
	public NewEventPage selectNewEvent() {
		log.info("Clicking on New Event..");
		driver.findElement(By.xpath("//li/a[contains(.,'New Event')]")).click();
		return new NewEventPage();
	}
}
