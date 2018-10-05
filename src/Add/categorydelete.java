package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class categorydelete {

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
		String value = null;
		WebElement nav = driver.findElement(By.id(("sidebar")));
		List<WebElement> list = nav.findElements(By.xpath("//ul[@class='list-unstyled components']/li"));
		for (int i = 1; i < list.size(); i++) {
			Thread.sleep(2000);
			if (list.get(i).findElement(By.tagName("ul")) != null) {
				List<WebElement> child = list.get(i).findElements(By.tagName("li"));
				for (int j = 0; j < child.size(); j++) {
					Thread.sleep(2000);
					if (child.get(j).getText().equals("Categories")) {
						child.get(j).click();
						Thread.sleep(5000);
						WebElement cat = driver.findElement(By.className("prods-box"));
						List<WebElement> category = cat.findElements(By.cssSelector("div.treeview>ul"));
						for (int k = 0; k < category.size(); k++) {
							value = category.get(k).getText().replaceAll("[^a-zA-Z0-9\\s+]", "")
									.replaceAll("[-+.^:,]", "").trim();
							if (value.equals("HAppy")) {
								category.get(k).findElement(By.tagName("a")).click();
								Thread.sleep(2000);
								WebElement delete = driver.findElement(
										By.xpath("//button[@type='button' and contains(text(),'Delete')]"));
								delete.click();
								Thread.sleep(2000);
								List<WebElement> confirm = driver.findElements(
										By.xpath("//div[@id='Confirmation'][1]//following-sibling::div[1]//child::*"));
								confirm.get(3).click();
								Thread.sleep(5000);
								break;
							}
						}
					}
				}
			}
			break;
		}
		driver.close();
	}
}