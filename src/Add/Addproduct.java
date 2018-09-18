package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Addproduct {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/rahulmittapalli/Downloads/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver=new SafariDriver();
		driver.manage().window().maximize();
		driver.get("https://dev-pim.dermalogica.com");
		Thread.sleep(2000);
		String searchKey = "category";
		String products = "precleanse";
		String checkboxs = "shortdescription";
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("mittapalli.rahul@gmail.com");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),'Add New')]")).click();
		driver.findElement(By.className("vue-treeselect__control")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("vue-treeselect__input")).sendKeys(searchKey);
		Thread.sleep(2000);
		List<WebElement> category = driver.findElements(By.className("vue-treeselect__option--matched"));
		for (int i = 0; i < category.size(); i++) {
			if ((category.get(i).getText()).toLowerCase().trim().equals(searchKey)) {
				category.get(i).click();
			}
		}
		driver.findElement(By.className("vue-treeselect__input")).clear();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='product name']")).sendKeys("NAME");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='add subtitle']")).sendKeys("Sub title");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@data-placeholder='add description']")).sendKeys("Description");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='select preferred products']")).sendKeys(products);
		WebElement prescribeproducts = driver.findElement(By.className("dropdown-menu"));
		List<WebElement> drop = prescribeproducts.findElements(By.tagName("li"));
		for (int i = 0; i < drop.size(); i++) {
			if ((drop.get(i).getText().trim()).equals(products)) {
				Thread.sleep(2000);
				drop.get(i).click();
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@data-placeholder='add ingredients']")).sendKeys("Ingredients");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[@class='m-0 ptb-10 fs-12 c-point' and contains(text(),'select')]")).click();
		WebElement checkbox = driver.findElement(By.className("inn-attr"));
		List<WebElement> value = checkbox.findElements(By.tagName("input"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		WebElement Element = driver.findElement(By.xpath("//button[@type='button' and contains(text(),'Add')]"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(3000);
		for (int i = 0; i < value.size(); i++) {
			if ((value.get(i).getAttribute("value").replaceAll("\\s+", "").toLowerCase()).trim().equals(checkboxs)) {
				value.get(i).click();
			}
		}
		driver.findElement(By.xpath("//button[@type='button' and contains(text(),'Add')]")).click();
		Thread.sleep(5000);
		WebElement date = driver.findElement(By.className("date_select"));
		date.click();
		List<WebElement> select = date.findElements(By.tagName("li"));
		for (int i = 0; i < select.size(); i++) {
			if ((select.get(i).getText().trim()).equals("Start Date")) {
				Thread.sleep(2000);
				select.get(i).click();
			}
		}
		Thread.sleep(8000);
		driver.findElement(By.className("dateInput")).click();
		WebElement calendar = driver.findElement(By.className("dateInput"));
		Thread.sleep(4000);
		List<WebElement> dateread = calendar.findElements(By.className("c-day-content"));
		for (int i = 0; i < dateread.size(); i++) {
			if (dateread.get(i).getText().equals("12")) {
				System.out.println("Selected the date");
				dateread.get(i).click();
				break;
			}
		}
		Thread.sleep(4000);
		driver.findElement(By.cssSelector(".anchor.c-point")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@data-placeholder='how to use']")).sendKeys("Error message");
		driver.findElement(By.xpath("//label[@class='toggle_yes2 m-0']")).click();
		driver.findElement(By.xpath("//input[@placeholder='optional text']")).sendKeys("HAHAHAHA");
		driver.findElement(By.xpath("//input[@placeholder='www.dermalogica.com']")).sendKeys("www.google.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='anchor c-point' and contains(text(),'add size')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("file_0")).sendKeys("/Users/rahulmittapalli/Desktop/udayEmulator screens/8.png");
		Thread.sleep(3000);
		driver.findElement(By.id("siliconImage_0"))
		.sendKeys("/Users/rahulmittapalli/Desktop/udayEmulator screens/8.png");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='select size']")).click();
		Thread.sleep(5000);
		WebElement size = driver.findElement(By.className("dropdown-menu"));
		List<WebElement> sizes = size.findElements(By.tagName("li"));
		for (int i = 0; i < sizes.size(); i++) {
			if ((sizes.get(i).getText().trim()).equals("100 mL (3.4 Oz)")) {
				// System.out.println("sizes values");
				Thread.sleep(2000);
				sizes.get(i).click();
			}
		}
		driver.findElement(By.name("check")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("img_file")).sendKeys("/Users/rahulmittapalli/Desktop/udayEmulator screens/8.png");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000);
		driver.close();
	}

}
