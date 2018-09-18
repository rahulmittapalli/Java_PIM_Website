package Add;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginD {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/rahulmittapalli/Downloads/Drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		//WebDriver driver=new SafariDriver();
		driver.manage().window().maximize();
		driver.get("https://dev-pim.dermalogica.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("mittapalli.rahul@gmail.com");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("profile_box")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).clear();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Mittapalli");
//		driver.findElement(By.xpath("//input[@placeholder='First Name']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".close-icons.bord-all.c-point.svg-inline--fa.fa-check.fa-w-14.fa-pull-right")).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notification-content")));
		System.out.println(driver.findElement(By.className("notification-content")).isDisplayed());
		String Text=driver.findElement(By.className("notification-content")).getText();
		System.out.println(Text);
		driver.close();
		}

}
