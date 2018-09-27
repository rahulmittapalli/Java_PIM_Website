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

public class productview {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/rahulmittapalli/Downloads/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver=new SafariDriver();
		driver.manage().window().maximize();
		;
		driver.get("https://dev-pim.dermalogica.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("mittapalli.rahul@gmail.com");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		int count = 0;
		int pagecount = 0;
		String value = null;
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
					// System.out.println(child.size());
					for (int j = 0; j < child.size(); j++) {
						if (child.get(j).getText().equals("Products")) {
							child.get(j).click();
							Thread.sleep(3000);
						}
					}
					Select s = new Select(
							driver.findElement(By.cssSelector(".form-control.input-sm.-page-size-select.fs-12.f-clr")));
					s.selectByValue("5");
					Thread.sleep(3000);
					WebElement page = driver.findElement(By.xpath("//ul[@name='Pagination']"));
					List<WebElement> pagenumbers = page.findElements(By.tagName("li"));
					System.out.println(pagenumbers.size());
					value=pagenumbers.get(pagenumbers.size()-2).findElement(By.tagName("a")).getText();
					System.out.println("value is "+value);
					pagecount = Integer.parseInt(value);
					System.out.println("pagecount is " + pagecount);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollTo(0,0)");
					for (int p = 1; p <= pagecount; p++) {
						System.out.println("p value is " + p);
						Thread.sleep(3000);
						List<WebElement> rows = driver.findElements(By.tagName("tr"));
						for (int k = 1; k <= rows.size() - 2; k++) {
							System.out.println("clicked on View button");
							System.out.println(rows.size());
							System.out.println(driver.findElements(By.tagName("tr")).get(k)
									.findElements(By.tagName("td")).get(1).getText());
							System.out.println(k);
							driver.findElements(By.tagName("tr")).get(k).findElements(By.tagName("td")).get(7)
									.findElement(By.className("fa-eye")).click();
							WebDriverWait wait = new WebDriverWait(driver, 10);
							// driver.findElement(By.className("fa-check")).click();
							// Thread.sleep(4000);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fa-arrow-left")));
							driver.findElement(By.className("fa-arrow-left")).click();
							Thread.sleep(4000);
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
							Thread.sleep(5000);
						}
						Thread.sleep(2000);
						JavascriptExecutor js1 = (JavascriptExecutor) driver;
						js1.executeScript("window.scrollTo(0,0)");
						Thread.sleep(5000);
					}

					System.out.println("Total number of Products are " + count);
				}
				break;
			}
		}
		driver.close();
	}
}