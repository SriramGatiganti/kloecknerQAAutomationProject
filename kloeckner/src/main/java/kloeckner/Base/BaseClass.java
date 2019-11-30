package kloeckner.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;
	
	
	String driverPath = "./Drivers\\";
	
	public BaseClass() {		
		//Configuration of Config file
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/kloeckner/Config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//instantiation of webdriver 
	public void StartBrowser() {
		System.out.println("Driver Started");
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {			
			System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (browserName.equals("IE")) {			
			System.setProperty("webdriver.gecko.driver", driverPath+"IEDriverServer.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().pageLoadTimeout(BaseClass.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(BaseClass.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

	// Quite webdriver
	public void CloseDriver() {
		System.out.println("Driver Closed");
		driver.quit();
	}

}
