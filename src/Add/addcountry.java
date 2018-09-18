package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class addcountry {

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
		WebElement nav = driver.findElement(By.id(("sidebar")));
		List<WebElement> list = nav.findElements(By.xpath("//ul[@class='list-unstyled components']/li"));
		System.out.println(list.size());
		for (int i = 1; i < list.size(); i++) {
			Thread.sleep(2000);
			if (i > 1) {
				list.get(i).findElement(By.tagName("a")).click();
			}
			System.out.println(list.get(i).findElement(By.tagName("a")).getText());
			if (list.get(i).findElement(By.tagName("a")).getText().equals("System")) {
				if (list.get(i).findElement(By.tagName("ul")) != null) {
					List<WebElement> child = list.get(i).findElements(By.tagName("li"));
					System.out.println(child.size());
					for (int j = 0; j < child.size(); j++) {
						if (child.get(j).getText().equals("Countries")) {
							child.get(j).click();
							Thread.sleep(3000);
							driver.findElement(By.xpath("//button[contains(text(),'Add New')]")).click();
							Thread.sleep(3000);
							driver.findElement(By.xpath("//input[@placeholder='add country name']")).sendKeys("New country");
							Thread.sleep(2000);
							driver.findElement(By.xpath("//input[@placeholder='add country code']")).sendKeys("NewC");
							Thread.sleep(2000);
							driver.findElement(By.xpath("//input[@placeholder='add language']")).sendKeys("New Language");
							Thread.sleep(2000);
							driver.findElement(By.xpath("//input[@placeholder='add language code']")).sendKeys("NLC");
							Thread.sleep(2000);
							driver.findElement(By.xpath("//input[@placeholder='add currency']")).sendKeys("Dollar");
							Thread.sleep(2000);
							Select s = new Select(driver.findElement(By.cssSelector(".f-clr.fs-12.inpt-box.form-control")));
							s.selectByValue("(GMT +05:30) Asia/Kolkata");
							Thread.sleep(2000);
							driver.findElement(By.xpath("//input[@placeholder='add facebook link']")).sendKeys("Facebook");
							Thread.sleep(2000);
							driver.findElement(By.xpath("//input[@placeholder='add instagram link']")).sendKeys("Instagram");
							Thread.sleep(2000);
							driver.findElement(By.xpath("//input[@placeholder='add pinterest link']")).sendKeys("Pinterest");
							Thread.sleep(2000);
							driver.findElement(By.xpath("//input[@placeholder='add twitter link']")).sendKeys("Twitter");
							Thread.sleep(2000);
							driver.findElement(By.xpath("//input[@placeholder='add e-commerce link']")).sendKeys("Ecommerce");
							Thread.sleep(2000);
							driver.findElement(By.xpath("//button[@type='submit']")).click();
									Thread.sleep(3000);
									break;
								}
							}
				}
				break;
			}
			list.get(i).findElement(By.tagName("a")).click();
		}
		driver.close();
	}
}