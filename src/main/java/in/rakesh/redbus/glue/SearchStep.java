package in.rakesh.redbus.glue;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import in.rakesh.redbus.pages.SearchPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStep {
	WebDriver driver;
	WebElement inp_from,inp_to,date_selector, btn_search;
	SearchPage Sp; 
	String url = "https://www.redbus.in/";	
	String expectedRedirectUrl = "https://www.redbus.in/search?fromCityName=LB%20Nagar%2C%20Hyderabad&fromCityId=79232&toCityName=Majestic%2C%20Bangalore&toCityId=66016&onward=09-Feb-2021&srcCountry=IND&destCountry=IND&opId=0&busType=Any";
	
	@Before
	public void beforeHook() {
		System.out.println("Before Hooking");

		System.setProperty("webdriver.chrome.driver", 
				"/home/rakesh.chauhan/Documents/chromedriver");
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless","--window-size=1920,1200");
		driver = new ChromeDriver(options);
	}
	
	
	@Given("open redbus url")
	public void open_redbus_url() throws Exception{
		driver.get(url);
		Thread.sleep(2000);
		Sp = new SearchPage();
		inp_from = Sp.getInputFrom(driver);
		inp_to = Sp.getInputTo(driver);
		btn_search = Sp.getSearchBtn(driver);
		date_selector = Sp.getDateSelector(driver);
	}

	@When("enter the source {string} and select LB Nagar,Hyderabad")
	public void enter_the_source_and_select_lb_nagar_hyderabad(String string) throws Exception {
		inp_from.sendKeys(string);
		Thread.sleep(2000);
		 List<WebElement> options=driver.findElements(By.xpath("//ul[@class='autoFill'] //li"));
	        
	        for(WebElement item: options ) {
	        	if(item.getText().contains("LB Nagar, Hyderabad")) {
	        		item.click();
	        	
	        		break;
	        		
	       		
	        	}
	        }
	}

	@When("destination {string} and select Majesty,Banglore")
	public void destination_and_select_majesty_banglore(String string) throws Exception {
		inp_to.sendKeys(string);
		Thread.sleep(2000);
		 List<WebElement> options=driver.findElements(By.xpath("//ul[@class='autoFill'] //li"));
	        
	        for(WebElement item: options ) {
	        	if(item.getText().contains("Majestic, Bangalore")) {
	        		item.click();
	        	
	        		break;
	        	
	        	}
	        }
	}

	@When("selct current date")
	public void selct_current_date() {
		date_selector.click();		
		WebElement target =   driver.findElement(By.xpath("//td[@class='current day']"));
		target.click();
        
	}

	@Then("click search bus and should redirect to result page")
	public void click_search_bus() throws InterruptedException {
		btn_search.click();
		Thread.sleep(2000);
		String redirectUrl = driver.getCurrentUrl();
		Assert.assertEquals(redirectUrl.contains("search"), expectedRedirectUrl.contains("search"));
		driver.close();
	}

	
}
