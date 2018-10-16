package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class editcountry {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/rahulmittapalli/Downloads/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver=new SafariDriver();
		driver.manage().window().maximize();
		login credentials = new login();
		credentials.logindetails(driver);
		sidebarmenu sd = new sidebarmenu();
		sd.sidebar(driver, "System", "Countries");
		viewfunction v = new viewfunction();
		v.view(driver, 8);
		WebElement countrycode = driver.findElement(By.xpath("//input[@placeholder='add country code']"));
		countrycode.click();
		countrycode.clear();
		Thread.sleep(2000);
		countrycode.sendKeys("hahaha");
		List<WebElement> click = driver.findElements(
				By.xpath("//input[@placeholder='add country code'][1]//following-sibling::div//child::*"));
		click.get(2).click();
		Thread.sleep(3000);
		driver.findElement(By.className("fa-arrow-left")).click();
		Thread.sleep(5000);
		driver.close();
	}
}