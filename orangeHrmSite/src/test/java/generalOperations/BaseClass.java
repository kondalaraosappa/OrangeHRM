package generalOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	public BaseClass() throws Throwable {
	 prop=new Properties();
	 File path=new File(System.getProperty("user.dir")+"/Configuration/config.properties");
		FileInputStream fis=new FileInputStream(path);
		prop.load(fis);
		
		}
	

	@BeforeMethod
	public void intilizeBrowser() {
		String Browser = prop.getProperty("browser");
		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));
		
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	public static String randomString() {
		 String str=RandomStringUtils.randomAlphabetic(8);
		 return str;
	}
    public static String randomPassword() {
    	String str1=RandomStringUtils.randomAlphanumeric(7);
    	return str1;
    }
    
    public static String captureScreenShots (String TestName) throws Throwable {
    	TakesScreenshot tss= (TakesScreenshot) driver;
    	File sc=tss.getScreenshotAs(OutputType.FILE);
    	String path=System.getProperty("user.dir")+"/ScreenShots/"+TestName+".png";
    	File targetfolder=new File(path);
    	FileUtils.copyFile(sc, targetfolder);
    	return path;
    }
}
