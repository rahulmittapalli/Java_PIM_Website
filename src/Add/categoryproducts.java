package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class categoryproducts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/rahulmittapalli/Downloads/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver=new SafariDriver();
		driver.manage().window().maximize();
		login credentials = new login();
		credentials.logindetails(driver);
		sidebarmenu sd = new sidebarmenu();
		sd.sidebar(driver, "Products Database", "Category Products");
		WebElement cat = driver.findElement(By.className("prods-box"));
		List<WebElement> category = cat.findElements(By.cssSelector("div.treeview>ul"));
		for (int k = 0; k < category.size(); k++) {
			System.out.println(
					category.get(k).getText().replaceAll("[^a-zA-Z0-9\\s+]", "").replaceAll("[-+.^:,]", "").trim());
			category.get(k).click();
			Thread.sleep(5000);
			List<WebElement> catchild = category.get(k).findElements(By.cssSelector("li>ul>li"));
			for (int l = 0; l < catchild.size(); l++) {
				System.out.println(
						catchild.get(l).getText().replaceAll("[^a-zA-Z0-9\\s+]", "").replaceAll("[-+.^:,]", "").trim());
				catchild.get(l).click();
				Thread.sleep(2000);
			}
		}
		Thread.sleep(3000);
		driver.close();
	}
}