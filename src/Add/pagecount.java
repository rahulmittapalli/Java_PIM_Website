package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pagecount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/rahulmittapalli/Downloads/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver=new SafariDriver();
		driver.manage().window().maximize();
		login credentials = new login();
		credentials.logindetails(driver);
		sidebarmenu sd = new sidebarmenu();
		sd.sidebar(driver, "Products Database", "Products");
		String value = null;
		int pagecount = 0;
		// pagination count value
		WebElement page = driver.findElement(By.xpath("//ul[@name='Pagination']"));
		List<WebElement> pagenumbers = page.findElements(By.tagName("li"));
		value = pagenumbers.get(pagenumbers.size() - 2).findElement(By.tagName("a")).getText();
		System.out.println("value is " + value);
		pagecount = Integer.parseInt(value);
		System.out.println("pagecount is " + pagecount);
		driver.close();
	}
}