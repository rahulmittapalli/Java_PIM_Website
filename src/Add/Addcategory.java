package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Addcategory {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/rahulmittapalli/Downloads/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver=new SafariDriver();
		driver.manage().window().maximize();
		login credentials = new login();
		credentials.logindetails(driver);
		sidebarmenu sd = new sidebarmenu();
		sd.sidebar(driver,"Products Database","Categories");
		Thread.sleep(5000);
		WebElement cat = driver.findElement(By.className("prods-box"));
		System.out.println(driver.findElement(By.cssSelector("#Categories"))
				.findElements(By.cssSelector("div.treeview>ul")).size());
		List<WebElement> category = cat.findElements(By.cssSelector("div.treeview>ul"));
		System.out.println(category.size());
		for (int k = 0; k < category.size(); k++) {
			System.out.println(k);
			System.out.println(category.get(k).getText());
			// System.out.println((category.get(k).getText().toString()).split(""));
			System.out.println(
					category.get(k).getText().replaceAll("[^a-zA-Z0-9\\s+]", "").replaceAll("[-+.^:,]", "").trim());
			category.get(k).click();
			Thread.sleep(5000);
			System.out.println("clicked");
			System.out.println(category.get(k).findElements(By.cssSelector("li>ul>li")).size());
			List<WebElement> catchild = category.get(k).findElements(By.cssSelector("li>ul>li"));
			System.out.println("child size is " + catchild.size());
			for (int l = 0; l < catchild.size(); l++) {
				// System.out.println(catchild.get(l).getText().split("+")[1]);
				System.out.println(
						catchild.get(l).getText().replaceAll("[^a-zA-Z0-9\\s+]", "").replaceAll("[-+.^:,]", "").trim());
				System.out.println("l value is " + l);
				System.out.println("K value is " + k);
				Thread.sleep(2000);
				// if (l == catchild.size()) {
				// break;
				// }
			}
		}
		// if(catchild.get(l).getText().indexOf("+")>-1)
		// {
		// System.out.println(catchild.get(l).getText().split("+"));
		//
		// }

		// driver.findElement(By.xpath("//a[@href='#/categories/add/0']")).click();
		// driver.findElement(By.xpath("//input[@placeholder='category
		// name']")).sendKeys("HELLO123");
		// Thread.sleep(3000);
		// driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Thread.sleep(3000);

		driver.close();
	}
}