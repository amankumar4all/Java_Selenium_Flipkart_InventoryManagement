package com.selenium.work;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import read_excel.ReadExcel;

	public class Selenium2Example extends SeleniumDriver {
		
		public  void seleniumFunction(String emailId ,String pwd) throws IOException{
	    	
//	    	ReadExcel.readExcel(a,b);
			
	    	   	
	        // Create a new instance of the Firefox driver
	        // Notice that the remainder of the code relies on the interface, 
	        // not the implementation.
	    	
	    	System.setProperty("webdriver.chrome.driver","C:/Excel/chromedriver.exe");
			System.out.println("id verified");
//	        WebDriver driver = new ChromeDriver();
			
	        
	        // And now use this to visit Google
	    	driver=new ChromeDriver();
	        driver.get("https://seller.flipkart.com");
	        
	    	
//	    	else {driver.quit();}
	        // Alternatively the same thing can be done like this
	        // driver.navigate().to("http://www.google.com");

	        // Find the text input element by its name
	        
//	        key word driven, hybrid, data driven
	        
//	        InputFrame inputFrame=new InputFrame();
//	        String emailId=inputFrame.getId().getText();
	        WebElement element_username = driver.findElement(By.id("username"));	        
	        element_username.sendKeys(emailId);
	        
//	        String password=inputFrame.getPassword().getText();
	        WebElement element_userpass=driver.findElement(By.id("userpass"));
	        element_userpass.sendKeys(pwd);
//	        System.out.println("email"+emailId+"pwd-->"+password);
	        

	        WebElement element_login=driver.findElement(By.id("edit-submit"));
	        element_login.submit();
//			Now submit the form. WebDriver will find the form for us from the element
//	        element.submit();
	        
	        
	        WebDriverWait wait = new WebDriverWait(driver,60);
	        Actions action = new Actions(driver);

	        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Inventory")));
	        
	        WebElement element_inventory=driver.findElement(By.linkText("Inventory"));
	        action.moveToElement(element_inventory).build().perform();
	        
	        driver.findElement(By.linkText("Inventory Management")).click();
//	        driver.findElement(By.xpath("//*[@id='Inventory']/ul/li[2]/ul/li/a")).click();
//	        above code is same as before-above line
	        
//	        Excel gets loaded and input is occuring	        
	        String filePath = System.getProperty("user.dir")+"\\src\\";
    	    //Call read file method of the class to read data
    	    ReadExcel.readExcel(filePath,"TestData.xlsx","Sheet1");
	        
    	    
    	    
	        // Check the title of the page
	        System.out.println("Page title is: " + driver.getTitle());
	        
	        // Google's search is rendered dynamically with JavaScript.
	        // Wait for the page to load, timeout after 10 seconds
	        
//	        (new WebDriverWait(driver, 3)).until(new ExpectedCondition<Boolean>() {
//	            public Boolean apply(WebDriver d) {
//	                return d.getTitle().toLowerCase().startsWith("cheese!");
//	            }
//	        });

	        // Should see: "cheese! - Google Search"
	        System.out.println("Page title is: " + driver.getTitle());
	        
	        //Close the browser
	        driver.quit();
	    
		}
	
//	    public static void main(String[] args) throws IOException {
//	    	
//	    	seleniumFunction();
//	}


}