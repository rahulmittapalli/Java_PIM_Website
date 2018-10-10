package Add;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dropdown {

	public void dropdownvalue(WebDriver driver,List<WebElement> choose, String value) throws InterruptedException {
		for (int k = 0; k < choose.size(); k++) {
			System.out.println("Inside the dropdown");
			System.out.println(choose.get(k).getText());
			if (choose.get(k).getText().trim().equals(value)) {
				choose.get(k).click();
				Thread.sleep(5000);
				break;
			}

		}
	}
}
