package Com.Roicians.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sun.tools.javac.util.Assert;

import BaseClass.RoicianBaseclass;

public class ContactUsPageRoician extends RoicianBaseclass {
	
		@FindBy(xpath="//input[@type='text'and@name='your-name']")
			WebElement Name;
		@FindBy(name="your-email")
			WebElement email;
		@FindBy(name="your-subject")
			WebElement sub;
		@FindBy(name="your-message")
			WebElement message;
		@FindBy(xpath="//input[@type='submit'and@value='Send']")
			WebElement Send;
		@FindBy(xpath="//div[@role='alert'and@style='display: block;']")
		WebElement displayError;
		
		//Initializing page Objects:
		
			public ContactUsPageRoician() {
				PageFactory.initElements(driver, this);
			}
			public String ContactUsPageRoicianTitle() {
				return driver.getTitle();
			}
			public void FillForm(String YourName, String YourEmail, String Subject , String YourMessage) {
				Name.sendKeys("YN");
				email.sendKeys("EM");
				sub.sendKeys("Sub");
				message.sendKeys("Mess");
				Send.click();
				}
			public void verifyError(String YourName, String YourEmail, String Subject , String YourMessage) {
				Name.sendKeys("YN");
				email.sendKeys("EM");
				sub.sendKeys("Sub");
				message.sendKeys("Mess");
				Send.click();
				displayError.getText();
			}
}
