import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  System.setProperty("webdriver.chrome.driver", "C:/Excel/chromedriver.exe");
//		    ChromeOptions options = new ChromeOptions();
//		    // if you like to specify another profile
//		    options.addArguments("user-data-dir=/root/Downloads/aaa"); 
//		    options.addArguments("start-maximized");
//		    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		    WebDriver driver = new ChromeDriver(capabilities);
//		    driver.get("http://www.google.com");
//		    String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
//		    String netData = ((JavascriptExecutor)driver).executeScript(scriptToExecute).toString();

		DesiredCapabilities d = DesiredCapabilities.chrome();
	    LoggingPreferences logPrefs = new LoggingPreferences();
	    logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
	    d.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
	    WebDriver driver = new ChromeDriver(d);
	    driver.get("http://www.google.com");
	    LogEntries les = driver.manage().logs().get(LogType.PERFORMANCE);
	    for (LogEntry le : les) {
	        System.out.println(le.getMessage());
	    }

	}

}
