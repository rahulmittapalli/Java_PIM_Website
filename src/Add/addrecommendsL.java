package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class addrecommendsL {

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
			if (list.get(i).findElement(By.tagName("a")).getText().equals("Applications")) {
				if (list.get(i).findElement(By.tagName("ul")) != null) {
					List<WebElement> child = list.get(i).findElements(By.tagName("li"));
					System.out.println(child.size());
					for (int j = 0; j < child.size(); j++) {
						if (child.get(j).getText().equals("Recommendations")) {
							child.get(j).click();
							Thread.sleep(3000);
							driver.findElement(By.xpath("//input[@type='search']")).click();
							WebElement dropdown = driver.findElement(By.className("dropdown-menu"));
							List<WebElement> drop = dropdown.findElements(By.tagName("li"));
							for (int k = 0; k < drop.size(); k++) {
								if ((drop.get(k).getText().trim()).equals("APP")) {
									Thread.sleep(2000);
									drop.get(k).click();
								}
							}
							driver.findElement(By.xpath("//button[contains(text(),'Add New')]")).click();
							Thread.sleep(3000);
							driver.findElement(By.xpath("//input[@placeholder='recommendation name']")).sendKeys("recommendation");
							Thread.sleep(2000);
							driver.findElement(By.xpath("//input[@placeholder='select type']")).click();
							WebElement dropdown1 = driver.findElement(By.className("dropdown-menu"));
							List<WebElement> drop1 = dropdown1.findElements(By.tagName("li"));
							for (int k = 0; k < drop1.size(); k++) {
								if ((drop1.get(k).getText().trim()).equals("SimpleList")) {
									Thread.sleep(2000);
									drop1.get(k).click();
									Thread.sleep(3000);
									driver.findElement(By.xpath("//input[@placeholder='select product']")).click();
									WebElement dropdown2 = driver.findElement(By.className("dropdown-menu"));
									List<WebElement> drop2 = dropdown2.findElements(By.tagName("li"));
									for (int l = 0; l < drop2.size(); l++) {
										if ((drop2.get(l).getText().trim()).equals("precleanse")) {
											Thread.sleep(2000);
											drop2.get(l).click();
											break;
										}
									}
									Thread.sleep(3000);
									driver.findElement(By.xpath("//button[@type='submit']")).click();
									Thread.sleep(3000);
									break;
								}
								if((drop1.get(k).getText().trim()).equals("Matrix"))	
								{	
									Thread.sleep(2000);
									drop1.get(k).click();
									Thread.sleep(3000);
									driver.findElement(By.xpath("//input[@placeholder='add category name']")).sendKeys("Category NAme");
									Thread.sleep(2000);
									driver.findElement(By.xpath("//input[@placeholder='add skin type']")).sendKeys("SKIN");
									Thread.sleep(3000);
									driver.findElement(By.xpath("//button[@type='submit']")).click();
									Thread.sleep(3000);
									break;
								}
							}
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