package Com.Roicians.TestCases;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.RoicianBaseclass;
import Com.Roicians.Pages.AboutUsPageRoician;
import Com.Roicians.Pages.ContactUsPageRoician;
import Com.Roicians.Pages.HomePageRoician;
import Com.Roicians.Pages.RequestAQuotePageRoician;

public class HomePageTestCases extends RoicianBaseclass{
	
	HomePageRoician homepage;
	AboutUsPageRoician AboutUsPage;
	ContactUsPageRoician ContactUs;
	RequestAQuotePageRoician RequestAQuote;
	
	
	
	public HomePageTestCases() {
		super(); // calling prop from baseclass
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePageRoician();
	}
	@Test
	public void verifyHomePageTitle_Test1() {
		String homepageTitle= homepage.verifyHomePageRoician();
		Assert.assertEquals(homepageTitle, "QA, SQL,Oracle Database and BA Training along with Web Development - Roicians");
	}
		
	 @Test
	 public void verifyRoiciansLogo_Test2() {
		 boolean homepageLogo = homepage.verifyRoicianslogo();
				 Assert.assertTrue(homepageLogo);
	 }
	 @Test
	 public void clcikOnAboutUsPageRoician_Test3() {
		 AboutUsPage = homepage.clickonAboutUslink();
	}
	 @Test
	 public void clickonContactUsPageRoician_Test4() {
		 ContactUs = homepage.clickonContactUsLink();
	 }
	 
	 @Test
	 public void clickOnRequestAQuotePageRoician_Test5(){
		 RequestAQuote = homepage.clickonServiceLink();
	 }
	 @Test
	 public void verifyHomePageTitle_Test6() throws InterruptedException {
			String homepageTitle= homepage.verifyHomePageRoician();
//			Assert.assertEquals(homepageTitle, "QA, SQL,Oracle Database and BA Training along with Web Development - Roicians");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,2000)");
			
	 }
}
