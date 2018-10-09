package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class sidebarmenu {
	

	public void sidebar(WebDriver driver,String mainmenu,String submenu) throws InterruptedException {

		WebElement nav = driver.findElement(By.id(("sidebar")));
		List<WebElement> list = nav.findElements(By.xpath("//ul[@class='list-unstyled components']/li"));
		System.out.println(list.size());
		for (int i = 1; i < list.size(); i++) {
			Thread.sleep(2000);
			System.out.println(list.get(i).findElement(By.tagName("a")).getText());
			if (list.get(i).findElement(By.tagName("a")).getText().equals(mainmenu)) {
				if(driver.findElement(By.className("rotate_sideicon")).isDisplayed()) {	
				}
				else
				{
				list.get(i).findElement(By.tagName("a")).click();
				Thread.sleep(2000);
				}
				if (list.get(i).findElement(By.tagName("ul")) != null) {
					List<WebElement> child = list.get(i).findElements(By.tagName("li"));
					// System.out.println(child.size());
					for (int j = 0; j < child.size(); j++) {
						System.out.println(child.get(j).getText());
						if (child.get(j).getText().equals(submenu)) {
							child.get(j).click();
							Thread.sleep(3000);
							break;
						}
					}
				}
			}
		}
	}
}
