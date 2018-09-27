package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class searchproduct {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/rahulmittapalli/Downloads/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver=new SafariDriver();
		driver.manage().window().fullscreen();
		driver.get("https://dev-pim.dermalogica.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("mittapalli.rahul@gmail.com");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		int count = 0;
		int pagecount = 0;
		String value=null;
		WebElement nav = driver.findElement(By.id(("sidebar")));
		List<WebElement> list = nav.findElements(By.xpath("//ul[@class='list-unstyled components']/li"));
		System.out.println(list.size());
		for (int i = 1; i < list.size(); i++) {
			Thread.sleep(2000);
			if (i > 1) {
				list.get(i).findElement(By.tagName("a")).click();
			}
			System.out.println(list.get(i).findElement(By.tagName("a")).getText());
			if (list.get(i).findElement(By.tagName("a")).getText().equals("Products Database")) {
				if (list.get(i).findElement(By.tagName("ul")) != null) {
					List<WebElement> child = list.get(i).findElements(By.tagName("li"));
					for (int j = 0; j < child.size(); j++) {
						if (child.get(j).getText().equals("Products")) {
							child.get(j).click();
							Thread.sleep(3000);
						}
					}
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollTo(0,0)");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//input[@placeholder='search']")).sendKeys("gel");
					Thread.sleep(5000);
					System.out.println("Product information");
					//pagecount value
					WebElement page = driver.findElement(By.xpath("//ul[@name='Pagination']"));
					List<WebElement> pagenumbers = page.findElements(By.tagName("li"));
					value=pagenumbers.get(pagenumbers.size()-2).findElement(By.tagName("a")).getText();
					System.out.println("value is "+value);
					pagecount=Integer.parseInt(value);
					System.out.println("pagecount is " + pagecount);
					// product data
					for (int p = 1; p <= pagecount; p++) {
						List<WebElement> rows = driver.findElements(By.tagName("tr"));
						for (int k = 1; k <= rows.size() - 2; k++) {
							List<WebElement> columns = rows.get(k).findElements(By.tagName("td"));
							System.out.println(columns.get(1).getText());
							count++;
							System.out.println("Count value is " + count);
						}
						Thread.sleep(4000);
						if (p != pagecount
								&& driver.findElement(By.className("fa-chevron-double-right"))
										.isDisplayed()) {
							WebElement svgObj = driver
									.findElement(By.className("fa-chevron-double-right"));
							Actions actionBuilder = new Actions(driver);
							actionBuilder.click(svgObj).build().perform();
							Thread.sleep(3000);
						}
					}
				}
				System.out.println("Total number of products are " + count);
				break;
			}
			list.get(i).findElement(By.tagName("a")).click();
		}
		driver.close();
	}
}