package locations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Difflocwithsamepackage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();

		String appUrl = "http://www.tripfactory.com/";
		driver.get(appUrl);

		// Click on Location

		driver.findElement(By.linkText("Location")).click();

		List<WebElement> allElements = driver.findElements(By.xpath("//div[1]/div[3]/div/nav/ul/li[5]/ul"));

		for (WebElement element : allElements) {
			System.out.println(element.getText());
			if (element.equals("Australia")) {
				break;
			}

		}

		// Select the package on homepage

		driver.findElement(By.xpath("//div[5]/div[1]/div[2]/section[1]/div/div[2]/div[1]/div[1]/a/div[1]/img")).click();

		// price on tf homepage

		String initprice = driver.findElement(By.xpath(".//*[@id='startingPrice']/em")).getText();
		System.out.println(" The initial price is " + initprice);

		// click on book online

		driver.findElement(By.className("pkgAvailURL")).click();
		System.out.println("Clicking on book online");

		String price = driver.findElement(By.xpath(".//*[@id='invCalMth1']/table/tbody/tr[3]/td[5]/div[2]/div[2]/span"))
				.getText();
		System.out.println(" The price is " + price);

		// click on Continue

		driver.findElement(By.id("stp1CntActCtr"));
		driver.findElement(By.xpath("//div[2]/div/div[3]/section/section/section/form/div[1]/div[1]/div[2]/div[2]/a"))
				.click();

		System.out.println("clicking Continue");

		// click on Calculate price

		String order = driver
				.findElement(By.xpath("//div[2]/div/div[3]/section/section/div[1]/div/div[1]/div[3]/ul/li[3]"))
				.getAttribute("innerHTML");
		System.out.println(order);

		// selecting the dropdown

		Select Adults = new Select(driver.findElement(By.name("adults1")));
		Adults.selectByVisibleText("1");

		driver.findElement(By.id("calculateButton")).click();
		System.out.println("clicking calculate price");

		try {
			Thread.sleep(1000 * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		order = driver.findElement(By.xpath("//div[2]/div/div[3]/section/section/div[1]/div/div[1]/div[3]/ul/li[3]"))
				.getAttribute("innerHTML");
		System.out.println(order);

		String summary = driver.findElement(By.xpath(".//*[@id='order_summary']")).getText();
		System.out.println(" The order summary is " + summary);

		driver.findElement(By.id("bookbtn")).click();
		System.out.println("clicking on continue booking");

		// selecting the drop down

		Select Title = new Select(driver.findElement(By.id("paxTitle1")));
		Title.selectByVisibleText("Mr");

		// enter values in text fields

		driver.findElement(By.id("paxFirstName1")).sendKeys("test");
		driver.findElement(By.id("paxLastName1")).sendKeys("test");

		driver.findElement(By.id("email")).sendKeys("aakash@tripfactory.com");
		driver.findElement(By.id("promoCheckBx")).click();

		driver.findElement(By.id("mobile")).sendKeys("999999999");

		// click on Proceed for payment

		driver.findElement(By.linkText("Proceed for payment")).click();

		String finalfare = driver.findElement(By.xpath(".//*[@id='totalFare']")).getText();
		System.out.println(" The final fare is " + finalfare);

		// navigate back to tripfactory's homepage

		driver.findElement(By.xpath("//div[1]/div[1]/a/img")).click();

		// close the browser
		System.out.println("Test scripted executed successfully.");
	}
}
