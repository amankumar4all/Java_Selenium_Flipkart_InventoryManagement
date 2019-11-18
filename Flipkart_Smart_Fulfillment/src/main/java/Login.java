import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class Login extends Selenium_Driver {
	



	public void loginFunction(String emailId, String pwd, String pickid) throws InvalidPasswordException, IOException, AWTException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:/Excel/chromedriver.exe");

		driver=new ChromeDriver();
		driver.get("https://seller.flipkart.com");
		driver.manage().window().maximize();
		
		WebElement element_username = driver.findElement(By.id("username"));	        
        element_username.sendKeys(emailId);
		
        WebElement element_userpass=driver.findElement(By.id("userpass"));
        element_userpass.sendKeys(pwd);
        WebElement element_login=driver.findElement(By.id("edit-submit"));
        element_login.submit();
        
        WebDriverWait wait = new WebDriverWait(driver,60);
        Actions action = new Actions(driver);
        
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Orders")));

        WebElement element_inventory=driver.findElement(By.linkText("Orders"));
        action.moveToElement(element_inventory).build().perform();
        
        driver.findElement(By.linkText("Smart Fulfilment Orders")).click();
      
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'New Orders')]")));
        driver.findElement(By.xpath("//span[contains(text(), 'New Orders')]")).click();
        
        
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(pickid)));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".productId-input")));

        System.out.println("pick id is "+pickid);
        Pdf_Operation.operation(pickid);
        
        JavascriptExecutor javascript1 = (JavascriptExecutor) driver;
		  javascript1.executeScript("alert('SMART FULFILLMENT PROCESS IS COMPLETED !');");
		  Thread.sleep(10000);
		  driver.quit();
        

	}

	

}





