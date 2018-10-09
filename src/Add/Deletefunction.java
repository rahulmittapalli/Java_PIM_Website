package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Deletefunction {
	public void delete(WebDriver driver, String value, int number) throws InterruptedException {
		System.out.println("Hello1");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)");
		driver.findElement(By.xpath("//input[@placeholder='search']")).sendKeys(value);
		Thread.sleep(3000);
		System.out.println("clicked on View button");
		driver.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).get(number)
				.findElement(By.className("fa-trash-alt")).click();
		Thread.sleep(5000);
		List<WebElement> dialogbox = driver.findElements(By.xpath(
				"//div[@id='Confirmation'][1]//following-sibling::div[@class='vodal-dialog']//following-sibling::button[@class='vodal-confirm-btn']"));
		dialogbox.get(1).click();
		Thread.sleep(3000);
	}
	public void delete(WebDriver driver, int number) throws InterruptedException {
		System.out.println("Hello2");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)");
		// driver.findElement(By.xpath("//input[@placeholder='search']")).sendKeys(value);
		Thread.sleep(3000);
		System.out.println("clicked on View button");
		driver.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).get(number)
				.findElement(By.className("fa-trash-alt")).click();
		Thread.sleep(5000);
		List<WebElement> dialogbox = driver.findElements(By.xpath(
				"//div[@id='Confirmation'][1]//following-sibling::div[@class='vodal-dialog']//following-sibling::button[@class='vodal-confirm-btn']"));
		dialogbox.get(1).click();
		Thread.sleep(3000);
	}
	public void delete(WebDriver driver, int number, int n) throws InterruptedException {
		System.out.println(driver.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).size());
		driver.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).get(number)
				.findElement(By.className("fa-trash-alt")).click();
		Thread.sleep(5000);
		List<WebElement> dialogbox = driver.findElements(By.xpath(
				"//div[@id='Confirmation'][1]//following-sibling::div[@class='vodal-dialog']//following-sibling::button[@class='vodal-confirm-btn']"));
		dialogbox.get(n).click();
		Thread.sleep(2000);
	}

}
