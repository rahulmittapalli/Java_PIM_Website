package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Addproduct {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/rahulmittapalli/Downloads/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		login credentials=new login();
		credentials.logindetails(driver);	
		String searchKey = "cleansers";
		String products = "precleanse";
		String checkboxs = "shortdescription";
		driver.findElement(By.xpath("//button[contains(text(),'Add New')]")).click();
		driver.findElement(By.className("vue-treeselect__control")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("vue-treeselect__input")).sendKeys(searchKey);
		Thread.sleep(2000);
		dropdown d=new dropdown();
		List<WebElement> category = driver.findElements(By.className("vue-treeselect__option--matched"));
		for (int i = 0; i < category.size(); i++) {
			System.out.println(category.get(i).getText());
			if ((category.get(i).getText()).trim().equals("cleansers")) {
				category.get(i).click();
			}
		}
		driver.findElement(By.className("vue-treeselect__input")).clear();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='product name']")).sendKeys("RAHUL");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='add subtitle']")).sendKeys("Sub title");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@data-placeholder='add description']")).sendKeys("Description");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='select preferred products']")).sendKeys(products);
		WebElement prescribeproducts = driver.findElement(By.className("dropdown-menu"));
		List<WebElement> drop = prescribeproducts.findElements(By.tagName("li"));
		d.dropdownvalue(driver,drop,"products");
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
		d.dropdownvalue(driver,select,"Start Date");
		WebElement calendar = driver.findElement(By.className("dateInput"));
		calendar.click();	
		Thread.sleep(4000);
		List<WebElement> dateread = calendar.findElements(By.className("c-day-content"));
		d.dropdownvalue(driver,dateread,"12");
		Thread.sleep(4000);
		driver.findElement(By.cssSelector(".anchor.c-point")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@data-placeholder='how to use']")).sendKeys("Error message");
		driver.findElement(By.xpath("//label[@class='toggle_yes2 m-0']")).click();
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
		d.dropdownvalue(driver,sizes,"100 mL (3.4 Oz)");
		driver.findElement(By.name("check")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("img_file")).sendKeys("/Users/rahulmittapalli/Desktop/udayEmulator screens/8.png");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000);
		driver.close();
	}

}
