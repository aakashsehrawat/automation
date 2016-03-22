package pricecomparison;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PackagePrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();

		String appUrl = "http://www.tripfactory.com/package/get-price-req?pkgId=27433&ahdate=06%2F05%2F2016";
		driver.get(appUrl);

		WebElement wE = driver.findElement(By.xpath(".//*[@id='invCalMth2']/table"));

		System.out.println(wE.getText());

		driver.findElement(By.xpath(".//*[@id='invCalMth2']/table/tbody/tr[2]/td[1]/div[2]/div[3]")).click();
		System.out.println("selecting date: 1/05/2016");
		driver.findElement(By.xpath(".//*[@id='calculateButton']/a")).click();

		try {
			Thread.sleep(1000 * 5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String summary = driver.findElement(By.xpath(".//*[@id='tprcTxt']")).getText();
		System.out.println(summary);
		driver.findElement(By.className("stps")).click();

		driver.findElement(By.xpath(".//*[@id='invCalMth2']/table/tbody/tr[2]/td[2]/div[2]/div[2]")).click();
		System.out.println("date 2/05/2016");
		driver.findElement(By.xpath(".//*[@id='calculateButton']/a")).click();

		try {
			Thread.sleep(1000 * 5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String Summary = driver.findElement(By.xpath(".//*[@id='tprcTxt']")).getText();
		System.out.println(Summary);

		// close the browser
		System.out.println("Test scripted executed successfully.");

	}

}
