import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Tracking_Id extends Selenium_Driver {
	
	public static void barCodePdf(String lid,int q1, String address) throws InvalidPasswordException, IOException, AWTException, InterruptedException{
		
		
//		String address="C:\\Excel\\labels_3.pdf";
//		String address = "C:\\Excel\\Smart-Fulfilment\\"+lid+"\\barcode"+q1+".pdf";
		System.out.println("Address is->"+address);
//		StringSelection stringSelection = new StringSelection(address);
//		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//		clipboard.setContents(stringSelection, stringSelection);
		
		
					Thread.sleep(3000);
					List<String> lines=TrackingPdf_read.readPdf(address);
//					List<String> lines=pdf_read.readPdf(address);

//	                String lines[] = pdfFileInText.split("\\r?\\n");
//	                for (int i=0;i<=lines.size()-1;i++){
//	                	String line=lines.get(i);
//	                	System.out.println("line number"+i+"-->"+line);             		                	
//	                }


	                List <String> listClone_trackID = new ArrayList<String>(); 
	                for (String string : lines) {
	                    if(string.matches("(?i)(Courier AWB No:).*")){
	                        listClone_trackID.add(string);
	                    }
	                }
	                System.out.println("Size of lines "+lines.size());
	                lines.clear();
	                System.out.println("Size of lines after clear "+lines.size());
	                
	             System.out.println(listClone_trackID);
	                
                	System.out.println(listClone_trackID.get(0));
                	String trackLine=listClone_trackID.get(0);
                	String myString = trackLine.trim();
                	String[] wordList = myString.split("\\s+");
                	System.out.println("last word is"+wordList[wordList.length-1]);
        	       
            		String AWB_Number = wordList[wordList.length-1];
            		System.out.println("awb number is "+AWB_Number);
            		
            		
        	        StringSelection stringSelection = new StringSelection(AWB_Number);
            		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            		clipboard.setContents(stringSelection, stringSelection);
            		
            		
            		
            		Thread.sleep(2000);
            		Robot robot=new Robot();
            		robot.keyPress(KeyEvent.VK_CONTROL);
            		robot.keyPress(KeyEvent.VK_V);
            		robot.keyRelease(KeyEvent.VK_V);
            		robot.keyRelease(KeyEvent.VK_CONTROL);
            		robot.keyPress(KeyEvent.VK_ENTER);
            		robot.keyRelease(KeyEvent.VK_ENTER);
            		wordList=new String[0];
            		System.out.println("word list is "+wordList);
            		
                    WebDriverWait wait1 = new WebDriverWait(driver,10);
                    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fa-close")));
                    driver.findElement(By.cssSelector(".fa-close")).click();
            		

	            
		 }

	public static void main(String[] args) throws InvalidPasswordException, IOException, AWTException, InterruptedException{
		String lid="LSTSKIFABCRBYGF6Y9JTFSCO6";
		int q1=1;
		String address[]=new String[10];
		 address[0]="C://Excel//Smart-Fulfilment//08_Apr_2019_09//LSTSKIFABCRBYCH2G3F0DCULD//barcode1";
		 address[1]="C://Excel//Smart-Fulfilment//08_Apr_2019_09//LSTSKIFABCRBYGF6Y9JTFSCO6//barcode1";
		 address[2]="C://Excel//Smart-Fulfilment//08_Apr_2019_09//LSTSKIFABCRFUTGWQDKCFTZ6R//barcode1";
		 address[3]="C://Excel//Smart-Fulfilment//08_Apr_2019_09//LSTSKIFABCRGFGTQRVH53APGS//barcode1";
		for(int i=0;i<2;i++){
		barCodePdf(lid,q1,address[i]);
		}
	}

	

}
