package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class approveproduct {

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
		WebElement nav = driver.findElement(By.id(("sidebar")));
		List<WebElement> list = nav.findElements(By.xpath("//ul[@class='list-unstyled components']/li"));
		System.out.println(list.size());
		for (int i = 1; i < list.size(); i++) {
			Thread.sleep(2000);
			if (i > 1) {
				list.get(i).findElement(By.tagName("a")).click();
			}
			System.out.println(list.get(i).findElement(By.tagName("a")).getText());
			if (list.get(i).findElement(By.tagName("a")).getText().equals("Review")) {
				if (list.get(i).findElement(By.tagName("ul")) != null) {
					List<WebElement> child = list.get(i).findElements(By.tagName("li"));
					// System.out.println(child.size());
					for (int j = 0; j < child.size(); j++) {
						if (child.get(j).getText().equals("Products")) {
							child.get(j).click();
							Thread.sleep(3000);
						}
					}

					// Find total products in the review page
					Select s = new Select(
							driver.findElement(By.cssSelector(".form-control.input-sm.-page-size-select.fs-12.f-clr")));
					s.selectByValue("20");
					Thread.sleep(3000);
					WebElement page = driver.findElement(By.xpath("//ul[@name='Pagination']"));
					List<WebElement> pagenumbers = page.findElements(By.tagName("li"));
					if (pagenumbers.size() > 1) {
						System.out.println("Inside");
						pagecount = pagenumbers.size() - 1;
					} else {
						pagecount = pagenumbers.size();
					}
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollTo(0,0)");

					// System.out.println(pagecount);
					for (int p = 1; p <= pagecount; p++) {
						// System.out.println("p value is "+p);
						List<WebElement> rows = driver.findElements(By.tagName("tr"));
						for (int k = 1; k <= rows.size() - 2; k++) {
							List<WebElement> columns = rows.get(k).findElements(By.tagName("td"));
							count++;
							System.out.println("Count value is " + count);
						}
						Thread.sleep(2000);
						if (p != pagecount
								&& driver.findElement(By.cssSelector(".svg-inline--fa.fa-chevron-double-right.fa-w-12"))
										.isDisplayed()) {
							WebElement svgObj = driver
									.findElement(By.cssSelector(".svg-inline--fa.fa-chevron-double-right.fa-w-12"));
							Actions actionBuilder = new Actions(driver);
							actionBuilder.click(svgObj).build().perform();
							Thread.sleep(3000);
						}
					}
					JavascriptExecutor js1 = (JavascriptExecutor) driver;
					js1.executeScript("window.scrollTo(0,0)");
					for (int c = 1; c <= count; c++) {
						driver.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).get(6)
								.findElement(By.className("fa-eye")).click();
						System.out.println("clicked on View button");
						WebDriverWait wait = new WebDriverWait(driver, 10);
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Approve')]")));
						Thread.sleep(2000);
						driver.findElement(By.xpath("//button[contains(text(),'Approve')]")).click();
						;
						Thread.sleep(5000);
					}
					System.out.println("Total number of Products are " + count);
				}
				break;
			}
			list.get(i).findElement(By.tagName("a")).click();
		}

		driver.close();
	}
}