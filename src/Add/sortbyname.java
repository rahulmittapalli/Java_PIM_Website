package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class sortbyname {

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
		Thread.sleep(3000);
		String value = null;
		int count = 0;
		int pagecount = 0;
		WebElement page = driver.findElement(By.xpath("//ul[@name='Pagination']"));
		List<WebElement> pagenumbers = page.findElements(By.tagName("li"));
		value = pagenumbers.get(pagenumbers.size() - 2).findElement(By.tagName("a")).getText();
		System.out.println("value is " + value);
		pagecount = Integer.parseInt(value);
		System.out.println("pagecount is " + pagecount);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)");
		driver.findElement(By.className("fa-sort")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("fa-sort-down")).click();
		Thread.sleep(5000);
		for (int p = 1; p <= pagecount; p++) {
			List<WebElement> rows = driver.findElements(By.tagName("tr"));
			for (int k = 1; k <= rows.size() - 2; k++) {
				List<WebElement> columns = rows.get(k).findElements(By.tagName("td"));
				System.out.println(columns.get(1).getText());
			}
			Thread.sleep(2000);
			if (p != pagecount && driver.findElement(By.className("fa-chevron-double-right")).isDisplayed()) {
				WebElement svgObj = driver.findElement(By.className("fa-chevron-double-right"));
				Actions actionBuilder = new Actions(driver);
				actionBuilder.click(svgObj).build().perform();
				Thread.sleep(3000);
			}
		}
		System.out.println("Total Count value is " + count);
		driver.close();
	}
}