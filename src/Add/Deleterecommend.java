package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Deleterecommend {

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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)");
		driver.findElement(By.className("searchable")).click();
		WebElement size = driver.findElement(By.className("dropdown-menu"));
		List<WebElement> sizes = size.findElements(By.tagName("li"));
		for (int i1 = 0; i1 < sizes.size(); i1++) {
			if (sizes.get(i1).getText().equals("Rapid Reveal")) {
				sizes.get(i1).click();
				break;
			}
		}
		Thread.sleep(5000);
		Deletefunction del = new Deletefunction();
		del.delete(driver, 5, 0);
		driver.close();
	}
}