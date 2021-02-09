package in.rakesh.redbus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	public WebElement element = null;
	String input_from	="src";
	String input_to="dest";
	String btn_search = "search_btn";
	String date_selector = ".fl.icon-calendar_icon-new.icon-onward-calendar.icon";
	
	
	public WebElement getElement(WebDriver driver, String locator_path, String locator_type) {
		
		if(locator_type.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locator_path));
		}
		if(locator_type.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locator_path));
		}
		if(locator_type.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locator_path));
		}
		return element;
	}
	
	public WebElement getInputFrom(WebDriver driver) {
		return getElement(driver, input_from, "id");
	}
	
	public WebElement getInputTo(WebDriver driver) {
		return getElement(driver, input_to, "id");
	}
	
	public WebElement getSearchBtn(WebDriver driver) {
		return getElement(driver, btn_search, "id");
	}
	
	public WebElement getDateSelector(WebDriver driver) {
		
		return getElement(driver, date_selector, "css");
	}
	
	
}
