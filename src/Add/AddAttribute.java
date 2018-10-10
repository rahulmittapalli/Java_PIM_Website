package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddAttribute {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/rahulmittapalli/Downloads/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver=new SafariDriver();
		driver.manage().window().maximize();
		login credentials = new login();
		credentials.logindetails(driver);
		sidebarmenu sd = new sidebarmenu();
		sd.sidebar(driver,"Products Database","Attributes");
		driver.findElement(By.xpath("//button[contains(text(),'Add New')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='attribute name']")).sendKeys("Attribute1234");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@data-placeholder='add description']")).sendKeys("Attribute Description");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='search']")).click();
		Thread.sleep(2000);
		dropdown d=new dropdown();
		WebElement prescribeproducts = driver.findElement(By.className("dropdown-menu"));
		List<WebElement> drop = prescribeproducts.findElements(By.tagName("li"));
		d.dropdownvalue(driver,drop,"Text");
		driver.findElement(By.xpath("//input[@placeholder='add Text']")).sendKeys("Default value");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.close();
	}
}