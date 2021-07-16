package Com.Roicians.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.RoicianBaseclass;

public class HomePageRoician extends RoicianBaseclass {

	@FindBy(xpath="//img[@alt='Roicians'and@class='site-logo']")
	WebElement sitelogo;
	@FindBy(css="#menu-item-185 > a")
	WebElement AboutUslink;
	@FindBy(css="#menu-item-545 > a")
	WebElement ServiceLink;
	@FindBy(css="#menu-item-276 > a")
	WebElement TrainingLink;
	@FindBy(css="#menu-item-4173 > a")
	WebElement ContactUsLink;
	@FindBy(css="#menu-item-2109 > a:nth-child(1)")
	WebElement RequestAQuotelink;
	
	
	//Initializing page Objects:
	
		public HomePageRoician() {
			PageFactory.initElements(driver, this);
		}
		public String verifyHomePageRoician() {
			return driver.getTitle();
		}
		public boolean verifyRoicianslogo() {
			return sitelogo.isDisplayed();
		}
		public AboutUsPageRoician clickonAboutUslink() {
			AboutUslink.click();
			return new AboutUsPageRoician();
		}
		public RequestAQuotePageRoician clickonServiceLink() {
			Actions action=new Actions(driver);// passing Action object to driver
			action.moveToElement(ServiceLink).build().perform();
			RequestAQuotelink.click();
			return new RequestAQuotePageRoician();
		}
		public ContactUsPageRoician clickonContactUsLink() {
			ContactUsLink.click();
			return new ContactUsPageRoician();
		}
}
