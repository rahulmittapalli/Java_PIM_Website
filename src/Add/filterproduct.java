package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class filterproduct {

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
					driver.findElement(By.xpath("//button[contains(text(),'Filter')]")).click();
					Thread.sleep(3000);
					WebElement filterbox = driver.findElement(By.className("filter-box"));
					List<WebElement> filter = filterbox.findElements(By.cssSelector("div.treeview.p-all3>ul"));
					System.out.println("filter size is " + filter.size());
					for (int f = 0; f < filter.size(); f++) {
						List<WebElement> childs = filter.get(f).findElements(By.cssSelector("li>ul>li"));
						// System.out.println(filter.get(f).getText());
						filter.get(f).click();
						Thread.sleep(2000);
						for (int c = 0; c < childs.size(); c++) {
							System.out.println(childs.get(c).getText());
							if (childs.get(c).getText().equals("skin health")) {
								childs.get(c).findElement(By.xpath("//span[@class='checkmark']")).click();
								Thread.sleep(2000);
								break;
							}
						}
						// filter.get(f).click();
						driver.findElement(By.className("fa-times")).click();
						Thread.sleep(2000);
						break;
					}
					System.out.println("Product information");
					Thread.sleep(3000);
					// product data
					WebElement page = driver.findElement(By.xpath("//ul[@name='Pagination']"));
					List<WebElement> pagenumbers = page.findElements(By.tagName("li"));
					if (pagenumbers.size() > 1) {
						System.out.println("Inside");
						pagecount = pagenumbers.size() - 1;
					} else {
						pagecount = pagenumbers.size();
					}
					// System.out.println(pagecount);
					for (int p = 1; p <= pagecount; p++) {
						// System.out.println("p value is "+p);
						List<WebElement> rows = driver.findElements(By.tagName("tr"));
						for (int k = 1; k <= rows.size() - 2; k++) {
							// System.out.println("rows size " + rows.size());
							List<WebElement> columns = rows.get(k).findElements(By.tagName("td"));
							// System.out.println("column size is " + columns.size());
							// System.out.println("Value of k " + k);
							System.out.println("DATA");
							System.out.println(columns.get(1).getText());
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
				}
				System.out.println("Total number of products are " + count);
				break;
			}
			list.get(i).findElement(By.tagName("a")).click();
		}
		driver.close();
	}
}