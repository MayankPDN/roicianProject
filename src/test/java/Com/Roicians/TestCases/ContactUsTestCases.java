package Com.Roicians.TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClass.RoicianBaseclass;
import Com.Roicians.Pages.ContactUsPageRoician;
import Com.Roicians.Pages.HomePageRoician;
import Com.TestUtility.RoisianUtills;

public class ContactUsTestCases extends RoicianBaseclass{
	
	HomePageRoician  homepage;
	ContactUsPageRoician  ContactUs;
	RoisianUtills  Utills;
	
	
	
	String sheetName = "roicians1";
	
	public ContactUsTestCases() {
		super();// calling prop from baseclass
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePageRoician();
		ContactUs = homepage.clickonContactUsLink();
		Utills = new RoisianUtills();
		
	}
	
	@Test
	public void verifyContactPageTitle_Test1() {
		Assert.assertEquals(ContactUs.ContactUsPageRoicianTitle(),"Contact Us | Roicians", "Tetle is not correct");
		}
	@Test
	public void ValidateContactPageFunction_Test2() {
		ContactUs.FillForm("YN", "EM", "Sub", "Mess");
		}
	
	@DataProvider
	public Object [][] getRoicianTestData()   {
		Object data[][] = RoisianUtills.getTestData(sheetName);
		return data;
	}
	
	@Test (dataProvider="getRoicianTestData")
	
	public void ValidateContactPageFunction_Test3(String YourName, String YourEmail, String Subject , String YourMessage) {

		//ContactUs.FillForm("YN", "EM", "Sub", "Mess"); //these are hard coded as in "".
	ContactUs.FillForm(YourName, YourEmail, Subject, YourMessage);
	}
	@Test
	public void verifyActualError() {
		 ContactUs.verifyError("YN", "EM", "Sub", "Mess");
		 String error = driver.findElement(By.xpath("//div[@role='alert'and@style='display: block;']")).getText();
		 
		 Assert.assertEquals(error, "One or more fields have an error. Please check and try again." , "Test Is Expected to Fail As Error Is Different Then Error Requested By Customer //");
		 try {
			Utills.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 
		
	
	}
	
	
}

