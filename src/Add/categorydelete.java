package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class categorydelete {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/rahulmittapalli/Downloads/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver=new SafariDriver();
		driver.manage().window().maximize();
		login credentials = new login();
		credentials.logindetails(driver);
		sidebarmenu sd = new sidebarmenu();
		sd.sidebar(driver, "Products Database", "Categories");
		String value = null;
		Thread.sleep(5000);
		WebElement cat = driver.findElement(By.className("prods-box"));
		List<WebElement> category = cat.findElements(By.cssSelector("div.treeview>ul"));
		for (int k = 0; k < category.size(); k++) {
			value = category.get(k).getText().replaceAll("[^a-zA-Z0-9\\s+]", "").replaceAll("[-+.^:,]", "").trim();
			if (value.equals("HAppy")) {
				category.get(k).findElement(By.tagName("a")).click();
				Thread.sleep(2000);
				WebElement delete = driver
						.findElement(By.xpath("//button[@type='button' and contains(text(),'Delete')]"));
				delete.click();
				Thread.sleep(2000);
				List<WebElement> confirm = driver
						.findElements(By.xpath("//div[@id='Confirmation'][1]//following-sibling::div[1]//child::*"));
				confirm.get(3).click();
				Thread.sleep(5000);
			}
		}
		driver.close();
	}
}