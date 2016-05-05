package packagesprice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PackageInfoTest {

	public static void main(String[] args) {
		generateCsvFile("C:\\Users\\Aakash\\workspace\\trippackage.csv");
	}

	private static void generateCsvFile(String sFileName) {
		try {
			FileWriter writer = new FileWriter(sFileName);

			WebDriver driver = new FirefoxDriver();

			String appUrl = "file:///C:/Users/Aakash/Desktop/tfhome/Book%20Holiday%20Packages%20in%20India%20or%20Globally%20-%20TripFactory.htm";
			driver.get(appUrl);

			List<WebElement> allElements = driver.findElements(By.xpath(".//*/div[@class='catCntTbC u_block']/div"));

			for (int i = 0; i < allElements.size(); i++) {
				WebElement element = allElements.get(i);
				WebElement aElement = element.findElement(By.xpath(".//a"));
				WebElement bElement = aElement.findElement(By.xpath(".//div[@class='dscBlk u_block']/h3"));

				System.out.println(bElement.getAttribute("innerHTML"));
				System.out.println(aElement.getAttribute("href"));
				System.out.println(element.getAttribute("data-base-prc"));

				ArrayList<WebElement> packageInfoList = new ArrayList();
				packageInfoList.add(element);
				packageInfoList.add(aElement);
				packageInfoList.add(bElement);

				writer.append(bElement.getAttribute("innerHTML")).append(',').append(aElement.getAttribute("href"))
						.append(',').append(element.getAttribute("data-base-prc")).append('\n');

			}

			writer.flush();
			writer.close();
			System.out.println("Successfully Generated Csv file");

		} catch (IOException e) {
			e.printStackTrace();

		}

	}
}
