package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class categoryproducts {

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
			System.out.println(list.get(i).findElement(By.tagName("a")).getText());
			if (list.get(i).findElement(By.tagName("ul")) != null) {
				List<WebElement> child = list.get(i).findElements(By.tagName("li"));
				for (int j = 0; j < child.size(); j++) {
					// child.get(j).click();
					Thread.sleep(2000);
					//System.out.println(child.get(j).getText());
					if (child.get(j).getText().equals("Category Products")) {
						child.get(j).click();
						Thread.sleep(5000);
						WebElement cat = driver.findElement(By.className("prods-box"));
						System.out.println(
								driver.findElement(By.cssSelector("#CatProduct")).findElements(By.cssSelector("div.treeview>ul")).size());
						List<WebElement> category = cat.findElements(By.cssSelector("div.treeview>ul"));
						System.out.println(category.size());
						for (int k = 0; k < category.size(); k++) {
							System.out.println(k);
							System.out.println(category.get(k).getText());
							// System.out.println((category.get(k).getText().toString()).split(""));
							System.out.println(category.get(k).getText().replaceAll("[^a-zA-Z0-9\\s+]", "")
									.replaceAll("[-+.^:,]", "").trim());
							category.get(k).click();
							Thread.sleep(5000);
							System.out.println("clicked");
							System.out.println(category.get(k).findElements(By.cssSelector("li>ul>li")).size());
							List<WebElement> catchild = category.get(k).findElements(By.cssSelector("li>ul>li"));
							System.out.println("child size is " + catchild.size());
							for (int l = 0; l < catchild.size(); l++) {
								System.out.println(catchild.get(l).getText().replaceAll("[^a-zA-Z0-9\\s+]", "")
										.replaceAll("[-+.^:,]", "").trim());
								System.out.println("l value is " + l);
								System.out.println("K value is " + k);
								catchild.get(l).click();
								Thread.sleep(2000);
							}
						}
						Thread.sleep(3000);
					}
				}
				break;
			}
			Thread.sleep(3000);
		}
		driver.close();
	}
}