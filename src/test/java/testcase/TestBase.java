package testcase;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
public class TestBase {




	public static WebDriver driver;


	@BeforeSuite 

	@Parameters(("browser"))
	public void intiateDriver(@Optional("chrome")  String browserName) {

		if(browserName.equals("chrome")) {
			String chromePath=System.getProperty("user.dir")+"/resorces/chromedriver.exe";

			System.setProperty("webdriver.chrome.driver",chromePath);
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.navigate().to("https://www.gocardi.com/");



	}

	@AfterSuite

	public void StopDriver() {
		driver.quit();
	}

}
