package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class adduser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/rahulmittapalli/Downloads/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver=new SafariDriver();
		driver.manage().window().maximize();
		login credentials = new login();
		credentials.logindetails(driver);
		sidebarmenu sd = new sidebarmenu();
		sd.sidebar(driver,"System","Users");
		driver.findElement(By.xpath("//button[contains(text(),'Add New')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='enter first name']")).sendKeys("FIRST");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='enter last name']")).sendKeys("LAST");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='enter email id']")).sendKeys("lang@lan.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Select role']")).click();
		WebElement dropdown = driver.findElement(By.className("dropdown-menu"));
		List<WebElement> drop = dropdown.findElements(By.tagName("li"));
		dropdown d=new dropdown();
		d.dropdownvalue(driver, drop, "SuperAdministrator");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.close();
	}
}