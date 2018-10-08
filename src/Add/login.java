package Add;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class login {

	public void logindetails(WebDriver driver) throws InterruptedException {
		// WebDriver driver=new SafariDriver();
		driver.get("https://dev-pim.dermalogica.com");	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("mittapalli.rahul@gmail.com");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
	}
}
