package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DeleteAttribute {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/rahulmittapalli/Downloads/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver=new SafariDriver();
		driver.manage().window().maximize();
		driver.get("https://dev-pim.dermalogica.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("mittapalli.rahul@gmail.com");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		int count = 0;
		String value = null;
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
					// System.out.println(child.size());
					for (int j = 0; j < child.size(); j++) {
						if (child.get(j).getText().equals("Attributes")) {
							child.get(j).click();
							Thread.sleep(3000);
						}
					}
					WebElement page = driver.findElement(By.xpath("//ul[@name='Pagination']"));
					List<WebElement> pagenumbers = page.findElements(By.tagName("li"));
					value = pagenumbers.get(pagenumbers.size() - 2).findElement(By.tagName("a")).getText();
					System.out.println("value is " + value);
					pagecount = Integer.parseInt(value);
					System.out.println("pagecount is " + pagecount);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollTo(0,0)");
					// System.out.println(pagecount);
					System.out.println("clicked on View button");
					driver.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).get(6)
							.findElement(By.className("fa-trash-alt")).click();
					Thread.sleep(5000);
					// List<WebElement>dialog=driver.findElements(By.xpath("//div[@id='Confirmation'][1]//following-sibling::div[@class='vodal-dialog']"));
					List<WebElement> dialogbox = driver.findElements(By.xpath(
							"//div[@id='Confirmation'][1]//following-sibling::div[@class='vodal-dialog']//following-sibling::button[@class='vodal-confirm-btn']"));
					dialogbox.get(1).click();
					Thread.sleep(2000);
				}
				break;
			}
			list.get(i).findElement(By.tagName("a")).click();
		}
		driver.close();
	}
}