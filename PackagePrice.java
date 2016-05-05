package pricecomparison;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PackagePrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();

		String appUrl = "http://www.tripfactory.com/package/get-price-req?pkgId=78350&ahdate=14%2F05%2F2016";
		driver.get(appUrl);

		// driver.manage().timeouts().implicitlyWait(5000,
		// TimeUnit.MILLISECONDS);

		List<WebElement> allElements = driver
				.findElements(By.xpath(".//*[@id='invCalMth1']/table/tbody/tr/td/div[@class='dtCnt']"));

		for (int i = 0; i < allElements.size(); i++) {
			WebElement element = driver
					.findElements(By.xpath(".//*[@id='invCalMth1']/table/tbody/tr/td/div[@class='dtCnt']")).get(i);

			System.out.println("The Calendar price is" + element.getText());

			if ((allElements != null))

				if (element.isDisplayed()) {
					element.click();

					// Selecting number of Adults
					Select Adults = new Select(driver.findElement(By.name("adults1")));
					Adults.selectByVisibleText("2");

					// Clicking on calculate button
					driver.findElement(By.xpath(".//*[@id='calculateButton']/a")).click();
					System.out.println("clicking calculate");

					try {
						Thread.sleep(1000 * 10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					String Summary = driver.findElement(By.xpath(".//*[@id='price']")).getText();
					System.out.println("The order summary is  " + Summary);

					driver.navigate().refresh();

				}
		}

		// close the browser
		System.out.println("Test scripted executed successfully.");

	}
}
