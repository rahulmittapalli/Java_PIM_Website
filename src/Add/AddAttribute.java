package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AddAttribute {

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
		// System.out.println(driver.findElement(By.id("sidebar")).isDisplayed());
		WebElement nav = driver.findElement(By.id(("sidebar")));
		List<WebElement> list = nav.findElements(By.xpath("//ul[@class='list-unstyled components']/li"));
		System.out.println(list.size());
		for (int i = 1; i < list.size(); i++) {
			// list.get(i).click();
			Thread.sleep(2000);
			//System.out.println(list.get(i).findElement(By.tagName("a")).getText());
			if (list.get(i).findElement(By.tagName("ul")) != null) {
				List<WebElement> child = list.get(i).findElements(By.tagName("li"));
				for (int j = 0; j < child.size(); j++) {
					// child.get(j).click();
					Thread.sleep(2000);
					//System.out.println(child.get(j).getText());
					if (child.get(j).getText().equals("Attributes")) {
						child.get(j).click();
						Thread.sleep(5000);
						driver.findElement(By.xpath("//button[contains(text(),'Add New')]")).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//input[@placeholder='attribute name']")).sendKeys("Attribute123");
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@data-placeholder='add description']"))
								.sendKeys("Attribute Description");
						Thread.sleep(2000);
						driver.findElement(By.xpath("//input[@type='search']")).click();
						Thread.sleep(2000);
						WebElement attribute = driver.findElement(By.className("dropdown-menu"));
						List<WebElement> drop = attribute.findElements(By.tagName("li"));
						for (int k = 0; k < drop.size(); k++) {
							System.out.println("Inside the dropdown");
							System.out.println(drop.get(k).getText());
							if ((drop.get(i).getText().trim()).equals("Text")) {
								Thread.sleep(2000);
								drop.get(k).click();
							}
						}
						driver.findElement(By.xpath("//input[@placeholder='add Text']")).sendKeys("Default value");
						Thread.sleep(2000);
						driver.findElement(By.xpath("//button[@type='submit']")).click();
						Thread.sleep(3000);
						break;

					}
				}
				break;
			}
		}
		driver.close();
	}
}