package testPackages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PackageInfo {

	private static final String APP_URL = "https://payments.tripfactory.com/";
	private static final By ISSUER_CODE_OPTIONS_XPATH = By.xpath(".//div[@class='dscBlk u_block']/h3");
	private static final By ISSUER_CODE_XPATH = By.xpath(".//*/div[@class='catCntTbC u_block']/div");
	private static final String FILE_DIR = "C:\\Users\\Aakash\\workspace\\";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runTest();
	}

	private static final WebDriver getWebDriver(String url) {
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		return driver;
	}

	private static void runTest() {
		try {
			Map<String, String> packageNames = getListOfPackageNames();
			if (packageNames == null) {
				System.out.println("Null packageNames received");
				return;
			}
			List<PackageUrlInfo> packageInfoList = new ArrayList<>();
			int i = 0;
			for (String packageName : packageNames.keySet()) {
				packageInfoList.add(getPackageInfo(packageName));
				i++;
				// if (MAX_BANKS_TO_LOAD != null && i > MAX_BANKS_TO_LOAD) {
				// break;
				// }
			}
			generateCsv(packageInfoList, packageNames);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static final void generateCsv(List<PackageUrlInfo> packageInfoList, Map<String, String> packageNames)
			throws IOException {
		String filePath = FILE_DIR + "package-url-info-" + System.nanoTime() + ".csv";
		FileWriter writer = new FileWriter(filePath);
		System.out.println("Generating file at - " + filePath);
		for (PackageUrlInfo info : packageInfoList) {
			writer.append(packageNames.get(info.getPackageName())).append(',').append(info.getPackageName()).append(',')
					.append(info.getRedirectedUrl()).append('\n');
		}
		writer.flush();
		writer.close();
		System.out.println("Successfully Generated file at - " + filePath);
	}

	private static final Map<String, String> getListOfPackageNames() {
		System.out.println("Getting List of packages");
		WebDriver driver = getWebDriver(APP_URL);
		// selectNetBanking(driver);
		List<WebElement> allBankSelectElements = driver.findElements(ISSUER_CODE_OPTIONS_XPATH);
		// if (allPackageSelectElements == null) {
		// return null;
		// }
		Map<String, String> packageNames = new HashMap<>();
		// for (WebElement element : allPackageSelectElements) {
		// String packageName = element.getText();
		// if (packageName.contains("|")) {
		// packageName = packageName.split("|")[0];
		// }
		// packageNames.put(element.getAttribute("value"), packageName);
		// }
		// System.out.println("Received " + allBankSelectElements.size() + "
		// packages: " + packageNames);
		// driver.close();
		return packageNames;
	}
	// private static final void selectNetBanking(WebDriver driver) {
	// driver.findElement(NET_BANKING_TAB_XPATH).click();
	// }

	private static final PackageUrlInfo getPackageInfo(String packageName) {
		WebDriver driver = getWebDriver(APP_URL);
		System.out.println("Getting PackageUrlInfo for " + packageName);
		// selectNetBanking(driver);
		Select selectPackageElement = new Select(driver.findElement(ISSUER_CODE_XPATH));
		selectPackageElement.selectByValue(packageName);
		// driver.findElement(T_N_C_XPATH).click();
		// driver.findElement(PAY_NOW_XPATH).click();
		// try {
		// Thread.sleep(10000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		PackageUrlInfo info = new PackageUrlInfo(packageName, driver.getCurrentUrl());
		System.out.println("Received PackageUrl for " + packageName + " as " + info.getRedirectedUrl());
		driver.close();
		return info;
	}

	private static final class PackageUrlInfo {
		private String packageName;
		private String redirectedUrl;

		public PackageUrlInfo(String packageName, String redirectedUrl) {
			super();
			this.packageName = packageName;
			this.redirectedUrl = redirectedUrl;
		}

		public String getPackageName() {
			return packageName;
		}

		public String getRedirectedUrl() {
			return redirectedUrl;
		}

	}
}