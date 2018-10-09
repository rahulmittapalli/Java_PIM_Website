package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class addrecommendsL {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/rahulmittapalli/Downloads/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver=new SafariDriver();
		driver.manage().window().maximize();
		login credentials = new login();
		credentials.logindetails(driver);
		sidebarmenu sd = new sidebarmenu();
		sd.sidebar(driver, "Applications", "Recommendations");
		driver.findElement(By.xpath("//input[@type='search']")).click();
		WebElement dropdown = driver.findElement(By.className("dropdown-menu"));
		List<WebElement> drop = dropdown.findElements(By.tagName("li"));
		for (int k = 0; k < drop.size(); k++) {
			if ((drop.get(k).getText().trim()).equals("APP")) {
				Thread.sleep(2000);
				drop.get(k).click();
			}
		}
		driver.findElement(By.xpath("//button[contains(text(),'Add New')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='recommendation name']")).sendKeys("recommendation");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='select type']")).click();
		WebElement dropdown1 = driver.findElement(By.className("dropdown-menu"));
		List<WebElement> drop1 = dropdown1.findElements(By.tagName("li"));
		for (int k = 0; k < drop1.size(); k++) {
			// if ((drop1.get(k).getText().trim()).equals("SimpleList")) {
			// Thread.sleep(2000);
			// drop1.get(k).click();
			// Thread.sleep(3000);
			// driver.findElement(By.xpath("//input[@placeholder='select
			// product']")).click();
			// WebElement dropdown2 = driver.findElement(By.className("dropdown-menu"));
			// List<WebElement> drop2 = dropdown2.findElements(By.tagName("li"));
			// for (int l = 0; l < drop2.size(); l++) {
			// if ((drop2.get(l).getText().trim()).equals("precleanse")) {
			// Thread.sleep(2000);
			// drop2.get(l).click();
			// break;
			// }
			// }
			// }
			if ((drop1.get(k).getText().trim()).equals("Matrix")) {
				Thread.sleep(2000);
				drop1.get(k).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@placeholder='add category name']")).sendKeys("Category NAme");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder='add skin type']")).sendKeys("SKIN");
				Thread.sleep(3000);
				break;
			}
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(3000);
		}
		driver.close();
	}
}