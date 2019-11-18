import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Pdf_Operation extends Selenium_Driver {
	
	public static void operation(String pickid) throws InvalidPasswordException, IOException, AWTException, InterruptedException{

//		String pdfFirstname="Flipkart-PickList-";		
//		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy-HH-mm");
//		Date date = new Date();
//		System.out.println(dateFormat.format(date));
		
//		final String prefix = "Flipkart-PickList-P150319-F91630687C04-";
		final String prefix = "Flipkart-PickList-"+pickid+"-";


				File dir = new File("C:/Users/hp/Downloads") ;//C:\Users\air\Downloads
//Function to search the partial name in the above path				
				File[] candidates = dir.listFiles(new FileFilter() {
				    @Override
				    public boolean accept(File pathname) {
				        return pathname.getName().startsWith(prefix);
				    }
				});
				
				System.out.println("Name of file is "+candidates[0]);
				String str = candidates[0].toString();

//				pdf_read.readPdf(str);
				List<String> lines=pdf_read.readPdf(str);
				
				
	                int n=lines.size();
//	                for(int i=0;i<n;i++){
//	                	System.out.println("Number of line is"+i+"-->"+lines.get(i));
//	                }

	                int j =11;
            		String homePageId=driver.getWindowHandle();
            		int serialNumber=1;
            		
	                for(int q=13;q<=n;q=q+7){
                		String lineQuantity=lines.get(q);
//	                	int number=lineQuantity.indexOf(' ');
	                	int quantity=Integer.valueOf(lineQuantity.substring(0));
	                	System.out.println(quantity);
	                	
	                	
                		for(int q1=1;q1<=quantity;q1++){
                			
	                		String lineLid=lines.get(j);

	                		String lid=lineLid.substring(0);
                			System.out.println(lid);
                			
                			
                	        WebDriverWait wait=new WebDriverWait(driver,30);
                	        
	                		System.out.println("1.waiting for product id");
	                		driver.switchTo().window(homePageId);               		
	                		
	                		if (j==11){
                			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".productId-input")));
	                		}
	                		Thread.sleep(1000);
//	                        Actions action = new Actions(driver);
	                		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".productId-input")));
                			WebElement inputLid=driver.findElement(By.cssSelector(".productId-input"));
                			Thread.sleep(5000);

                			inputLid.sendKeys(lid);
	                		inputLid.sendKeys(Keys.ENTER);
	                		
	                		System.out.println("2.product id sended");
	                		Thread.sleep(1000); //sleep to check if item already exist or not
	                		
	                		Boolean isPresent = driver.findElements(By.cssSelector(".toast-message-container")).size() > 0;
//	                		driver.findElement(By.cssSelector(".toast-message-container")).isDisplayed()
	                		if(isPresent){
	                            WebDriverWait wait2 = new WebDriverWait(driver,10);
	                            wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fa-close")));
	                			driver.findElement(By.cssSelector(".fa-close")).click();
		                		System.out.println("-->Number of time checking...");
	                			break;
	                		}
	                		else  {
		                		
	                		
	                		
	                		System.out.println("3.checked if Y/N");
	                		
	                		Date date = Calendar.getInstance().getTime();
	                 		DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy");
	                 		String strDate = dateFormat.format(date);

	                		
	                		String folderAddress="C:\\Excel\\Smart-Fulfilment\\"+strDate+"\\"+pickid;
	                		Files.createDirectories(Paths.get(folderAddress));
	                		String address = "C:\\Excel\\Smart-Fulfilment\\"+strDate+"\\"+pickid+"\\barcode_"+serialNumber;
	                		serialNumber=serialNumber+1;

	                		
	                		StringSelection stringSelection = new StringSelection(address);
	                		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	                		clipboard.setContents(stringSelection, stringSelection);
	                		

	                		
	                		JavascriptExecutor javascript1 = (JavascriptExecutor) driver;
	                		  javascript1.executeScript("alert('Test Case Execution Is started Now..');");
	                		  Thread.sleep(2000);
	                		  driver.switchTo().alert().accept();
	                		
	                		Thread.sleep(10000);                		
	                		
	                		Robot robot=new Robot();
	                		
	                		robot.keyPress(KeyEvent.VK_TAB);
	                		robot.keyRelease(KeyEvent.VK_TAB);
	                		Thread.sleep(100);
	                		robot.keyPress(KeyEvent.VK_TAB);
	                		robot.keyRelease(KeyEvent.VK_TAB);
	                		Thread.sleep(100);
	                		robot.keyPress(KeyEvent.VK_ENTER);
	                		robot.keyRelease(KeyEvent.VK_ENTER);
	                		Thread.sleep(100);
	                		robot.keyPress(KeyEvent.VK_DOWN);
	                		robot.keyRelease(KeyEvent.VK_DOWN);
	                		Thread.sleep(100);
	                		robot.keyPress(KeyEvent.VK_DOWN);
	                		robot.keyRelease(KeyEvent.VK_DOWN);
	                		Thread.sleep(100);
	                		robot.keyPress(KeyEvent.VK_ENTER);
	                		robot.keyRelease(KeyEvent.VK_ENTER);
	                		Thread.sleep(500);
	                		robot.keyPress(KeyEvent.VK_TAB);
	                		robot.keyRelease(KeyEvent.VK_TAB);
	                		Thread.sleep(100);
	                		robot.keyPress(KeyEvent.VK_ENTER);
	                		robot.keyRelease(KeyEvent.VK_ENTER);
	                		Thread.sleep(500);
	                		robot.keyPress(KeyEvent.VK_SHIFT);
	                		robot.keyPress(KeyEvent.VK_TAB);
	                		robot.keyRelease(KeyEvent.VK_TAB);
	                		Thread.sleep(100);
	                		robot.keyPress(KeyEvent.VK_TAB);
	                		robot.keyRelease(KeyEvent.VK_TAB);
	                		Thread.sleep(100);
	                		robot.keyRelease(KeyEvent.VK_SHIFT);
	                		robot.keyPress(KeyEvent.VK_ENTER);
	                		robot.keyRelease(KeyEvent.VK_ENTER);
	                		
	                		
//	                		driver.findElement(By.id("moreSettings")).click();
//	                		robot.keyPress(KeyEvent.VK_ENTER);
//	                		robot.keyRelease(KeyEvent.VK_ENTER);
	                		Thread.sleep(2000);
	                		
	                		robot.keyPress(KeyEvent.VK_CONTROL);
	                		robot.keyPress(KeyEvent.VK_V);
	                		robot.keyRelease(KeyEvent.VK_V);
	                		robot.keyRelease(KeyEvent.VK_CONTROL);
	                		
	                		Thread.sleep(500);
	                		
	                		robot.keyPress(KeyEvent.VK_ENTER);
	                		robot.keyRelease(KeyEvent.VK_ENTER);
	                	
	                		
	                		Tracking_Id.barCodePdf(lid,q1,address);
                		}
	                	}
//                		serialNumber=serialNumber+1;
                		j=j+7;

	                }
	                
                	
	                
	                
	            }

	        

	        
	
	  	  private static void waitForAlert(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
	  		 int i=0;
  		   while(i++<5)
  		   {
  		        try
  		        {
  		            Alert alert = driver.switchTo().alert();
  		            break;
  		        }
  		        catch(NoAlertPresentException e)
  		        {
  		          Thread.sleep(1000);
  		          continue;
  		        }
  		   }
		
	}





		public static void main(String[] args) throws Exception {
	  		  String pickid=null;
//	  		System.setProperty("webdriver.chrome.driver","C:/Excel/chromedriver.exe");
//	  		WebDriver driver=new ChromeDriver();
//
//	  		  driver.get("https://seller.flipkart.com/index.html#dashboard/fbflite-ff/LOCf4b44a547d674b43ac153ed84d22db05/nav-ff/processing");
	  		  operation(pickid);
	    }

	

}
