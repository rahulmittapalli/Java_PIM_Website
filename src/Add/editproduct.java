package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class editproduct {

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
		String checkboxs = "How to Use";
		WebElement nav = driver.findElement(By.id(("sidebar")));
		List<WebElement> list = nav.findElements(By.xpath("//ul[@class='list-unstyled components']/li"));
		System.out.println(list.size());
		for (int i = 1; i < list.size(); i++) {
			Thread.sleep(2000);
			if (i > 1) {
				list.get(i).findElement(By.tagName("a")).click();
			}
			System.out.println(list.get(i).findElement(By.tagName("a")).getText());
			if (list.get(i).findElement(By.tagName("a")).getText().equals("Products Database")) {
				if (list.get(i).findElement(By.tagName("ul")) != null) {
					List<WebElement> child = list.get(i).findElements(By.tagName("li"));
					// System.out.println(child.size());
					for (int j = 0; j < child.size(); j++) {
						if (child.get(j).getText().equals("Products")) {
							child.get(j).click();
							Thread.sleep(3000);
						}
					}
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollTo(0,0)");
					driver.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).get(7)
							.findElement(By.className("fa-eye")).click();
					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//input[@placeholder='product name']")));
//					driver.findElement(By.className("vue-treeselect__control")).click();
//					Thread.sleep(2000);
//					driver.findElement(By.className("vue-treeselect__input")).sendKeys("cleansers");
//					Thread.sleep(2000);
//					List<WebElement> category = driver.findElements(By.className("vue-treeselect__option--matched"));
//					for (int c = 0; c < category.size(); c++) {
//						if ((category.get(c).getText()).toLowerCase().trim().equals("cleansers")) {
//							category.get(c).click();
//						}
//					}
//					driver.findElement(By.className("vue-treeselect__input")).clear();
//					driver.findElement(By.className("fa-check")).click();
//					Thread.sleep(3000);
//					// product name change
//					WebElement productname = driver.findElement(By.xpath("//input[@placeholder='product name']"));
//					productname.click();
//					productname.clear();
//					Thread.sleep(3000);
//					productname.sendKeys("HAHAH");
//					Thread.sleep(2000);
//					driver.findElement(By.className("fa-check")).click();
//					Thread.sleep(2000);
//					//
//					driver.findElement(By.xpath("//input[@placeholder='add subtitle']")).click();
//					driver.findElement(By.xpath("//input[@placeholder='add subtitle']")).clear();
//					driver.findElement(By.xpath("//input[@placeholder='add subtitle']")).sendKeys("Edit Sub title");
//					driver.findElement(By.className("fa-check")).click();
//					Thread.sleep(2000);
//					driver.findElement(By.xpath("//*[@data-placeholder='add description']")).clear();
//					driver.findElement(By.xpath("//*[@data-placeholder='add description']"))
//							.sendKeys("Edit Description");
//					driver.findElement(By.className("fa-check")).click();
//					Thread.sleep(2000);
//					driver.findElement(By.xpath("//input[@type='search']")).sendKeys("active moist");
//					WebElement prescribeproducts = driver.findElement(By.className("dropdown-menu"));
//					List<WebElement> drop = prescribeproducts.findElements(By.tagName("li"));
//					for (int v = 0; v < drop.size(); v++) {
//						if ((drop.get(v).getText().trim()).equals("active moist")) {
//							Thread.sleep(2000);
//							drop.get(v).click();
//						}
//					}
//					Thread.sleep(2000);
//					driver.findElement(By.className("fa-check")).click();
//					Thread.sleep(2000);
//					driver.findElement(By.xpath("//*[@data-placeholder='add ingredients']")).clear();
//					driver.findElement(By.xpath("//*[@data-placeholder='add ingredients']"))
//							.sendKeys(" Edit Ingredients");
//					driver.findElement(By.className("fa-check")).click();
//					Thread.sleep(2000);
//					 driver.findElement(By.xpath("//p[@class='m-0 ptb-10 fs-12 c-point' and contains(text(),'select')]")).click();
//					 WebElement checkbox = driver.findElement(By.className("inn-attr"));
//					 List<WebElement> value = checkbox.findElements(By.tagName("input"));
//					 WebElement Element=driver.findElement(By.xpath("//*[@data-placeholder='add ingredients']"));
//					 js.executeScript("arguments[0].scrollIntoView();", Element);
//					 Thread.sleep(3000);
//					 for (int i1 = 0; i1 < value.size(); i1++) {
//					 if ((value.get(i1).getAttribute("value").equals(checkboxs))) {
//					 System.out.println(value.get(i1).getAttribute("value"));
//					 value.get(i1).click();
//					 }
//					 }
//					 Thread.sleep(2000);
//					 driver.findElement(By.xpath("//button[@type='button' and contains(text(),'Add')]")).click();
//					 Thread.sleep(5000);
//					 driver.findElement(By.xpath("//*[@placeholder='add description']")).sendKeys("How");
//					 Thread.sleep(3000);
//					 System.out.println(driver.findElement(By.className("fa-check")).isDisplayed());
//					 driver.findElement(By.className("fa-check")).click();
//					 Thread.sleep(2000);
//					WebElement date = driver.findElement(By.className("date_select"));
//					date.click();
//					List<WebElement> select = date.findElements(By.tagName("li"));
//					for (int i1 = 0; i1 < select.size(); i1++) {
//						if ((select.get(i1).getText().trim()).equals("Start Date")) {
//							Thread.sleep(2000);
//							select.get(i1).click();
//						}
//					}
//					Thread.sleep(8000);
//					driver.findElement(By.className("dateInput")).click();
//					WebElement calendar = driver.findElement(By.className("dateInput"));
//					Thread.sleep(4000);
//					List<WebElement> dateread = calendar.findElements(By.className("c-day-content"));
//					for (int i1 = 0; i1 < dateread.size(); i1++) {
//						if (dateread.get(i1).getText().equals("22")) {
//							System.out.println("Selected the date");
//							dateread.get(i1).click();
//							break;
//						}
//					}
//					Thread.sleep(3000);
//					calendar.findElement(By.className("fa-check")).click();
//					Thread.sleep(2000);
					js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.className("dateInput")));
					driver.findElement(By.xpath("//*[@data-placeholder='how to use']")).sendKeys("message");
					driver.findElement(By.xpath("//label[@class='toggle_yes2 m-0']")).click();
					Thread.sleep(5000);
					//span[contains(text(), 'ABZ')]/../following-sibling::section/span[@name='edit']
					System.out.println(driver.findElement(By.xpath("//div[@class='anchor c-point']/following-sibling::div[@class='inpt-icons']")).isDisplayed());
					System.out.println(driver.findElement(By.className("inpt-icons")).findElement(By.className("fa-check")).isDisplayed());
					driver.findElement(By.className("inpt-icons")).findElement(By.className("fa-check")).click();
					Thread.sleep(2000);
//					driver.findElement(By.xpath("//input[@placeholder='www.dermalogica.com']")).click();
//					driver.findElement(By.xpath("//input[@placeholder='www.dermalogica.com']")).clear();
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("//input[@placeholder='www.dermalogica.com']"))
//							.sendKeys("www.google1.com");
//					Thread.sleep(2000);
//					driver.findElement(By.className("fa-check")).click();
//					Thread.sleep(2000);
//					driver.findElement(By.xpath("//a[@class='anchor c-point' and contains(text(),'add size')]"))
//							.click();
//					Thread.sleep(3000);
//					driver.findElement(By.id("file_0"))
//							.sendKeys("/Users/rahulmittapalli/Desktop/udayEmulator screens/8.png");
//					Thread.sleep(3000);
//					driver.findElement(By.id("siliconImage_0"))
//							.sendKeys("/Users/rahulmittapalli/Desktop/udayEmulator screens/8.png");
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("//input[@placeholder='select size']")).click();
//					Thread.sleep(5000);
//					WebElement size = driver.findElement(By.className("dropdown-menu"));
//					List<WebElement> sizes = size.findElements(By.tagName("li"));
//					for (int i1 = 0; i1 < sizes.size(); i1++) {
//						if ((sizes.get(i1).getText().trim()).equals("100 mL (3.4 Oz)")) {
//							// System.out.println("sizes values");
//							Thread.sleep(2000);
//							sizes.get(i1).click();
//						}
//					}
//					driver.findElement(By.name("check")).click();
//					Thread.sleep(2000);
//					driver.findElement(By.id("img_file"))
//							.sendKeys("/Users/rahulmittapalli/Desktop/udayEmulator screens/8.png");
//					Thread.sleep(3000);
//					driver.findElement(By.className("fa-check")).click();
					Thread.sleep(2000);
					driver.findElement(By.className("fa-arrow-left")).click();
					Thread.sleep(4000);
				}
				break;
			}
		}
		driver.close();
	}
}