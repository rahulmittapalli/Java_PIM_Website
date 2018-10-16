package Add;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class viewfunction {

	public void view(WebDriver driver, int number) throws InterruptedException {
		System.out.println("clicked on the view button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)");
		// driver.findElement(By.xpath("//input[@placeholder='search']")).sendKeys(value);
		Thread.sleep(3000);
		System.out.println("clicked on View button");
		driver.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).get(number)
				.findElement(By.className("fa-eye")).click();
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fa-arrow-left")));
//		driver.findElement(By.className("fa-arrow-left")).click();
		Thread.sleep(4000);
	}
}
