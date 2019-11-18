package read_excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.work.Selenium2Example;

public class ReadExcel extends Selenium2Example {

    public static void readExcel(String filePath,String fileName,String sheetName) throws IOException{

    //Create an object of File class to open xlsx file

//    File file =    new File(filePath+"\\TestData.xlsx");
    File file =new File("C:/Excel/TestData.xlsx");

    //Create an object of FileInputStream class to read excel file

    FileInputStream inputStream = new FileInputStream(file);

    Workbook guru99Workbook = null;

    //Find the file extension by splitting file name in substring  and getting only extension name

    String fileExtensionName = fileName.substring(fileName.indexOf("."));

    //Check condition if the file is xlsx file

    if(fileExtensionName.equals(".xlsx")){

    //If it is xlsx file then create object of XSSFWorkbook class

    guru99Workbook = new XSSFWorkbook(inputStream);
    

    }

    //Check condition if the file is xls file

    else if(fileExtensionName.equals(".xls")){

        //If it is xls file then create object of XSSFWorkbook class

        guru99Workbook = new HSSFWorkbook(inputStream);

    }

    //Read sheet inside the workbook by its name

    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

    //Find number of rows in excel file
    
    

    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
    				
    System.out.println("row count is "+rowCount);
    //Create a loop over all the rows of excel file to read it
    
//	System.setProperty("webdriver.chrome.driver","E:/Software/drive/chromedriver/chromedriver.exe");
//    WebDriver driver = new ChromeDriver();
//    Selenium2Example sss=new Selenium2Example(driver);
    
    for (int i = 1; i < rowCount+1; i++) {

        Row row = guru99Sheet.getRow(i);
        
//        For List_Id

        WebDriverWait wait_productInput = new WebDriverWait(driver,60);
        wait_productInput.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".productId-input")));
        WebElement elementLId=driver.findElement(By.cssSelector(".productId-input"));
        elementLId.sendKeys(row.getCell(1).getStringCellValue());
        elementLId.sendKeys(Keys.ENTER);
        

        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='qc-pass']")));
        driver.findElement(By.xpath("//*[@id='qc-pass']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("bin")));
        
        WebElement elementBin=driver.findElement(By.id("bin"));
        elementBin.sendKeys(row.getCell(0).getStringCellValue());
        
        WebElement elementUnit=driver.findElement(By.xpath("//*[@id='quantity']"));
//        String quantity =String.valueOf(row.getCell(2));
//        String intValue = quantity.replaceAll("[^0-9]", "");
        String intvalue=row.getCell(2).toString();
        Double x = Double.parseDouble(intvalue);
        int x1=(int) Math.round(x);
        String units=String.valueOf(x1);
        elementUnit.sendKeys(units);
        
        
//        WebDriverWait wait_tax = new WebDriverWait(driver,1);
//        wait_tax.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='blinx-wrapper-16']/div[1]/div[2]/div[2]/div/div[4]/div/div/div[2]/div/input"));
//        if
//        WebElement elementTax=driver.findElement(By.xpath("//*[@id='blinx-wrapper-16']/div[1]/div[2]/div[2]/div/div[4]/div/div/div[2]/div/input"));
//        String tax=new String("0");
//        elementTax.sendKeys(tax);
        
        WebElement elementSubmit=driver.findElement(By.xpath("//*[@id='save-to-bin']"));
        elementSubmit.click();
        
        System.out.println("Successful entry number "+i);
        
//        //Create a loop to print cell values in a row
//        for (int j = 0; j < row.getLastCellNum(); j++) {
//
//            //Print Excel data in console
//        	if(j==0){
//        		System.out.print(row.getCell(j).getStringCellValue()+" ");
//        	}
//        	if(j==1){
//        		System.out.print(row.getCell(j).getStringCellValue()+" ");
//        		WebElement elementLId=driver.findElement(By.cssSelector(".productId-input"));
//        	}
//        	if(j==2){
//        		System.out.print(row.getCell(j));
//        	}
//        	
//        }

        System.out.println();
    } 

    }  

    //Main function is calling readExcel function to read data from excel file

//    public static void main(String...strings) throws Exception{
//
//    //Create an object of ReadGuru99ExcelFile class
//
//    ReadExcel objExcelFile = new ReadExcel();
//
//    //Prepare the path of excel file
//
//    String filePath = System.getProperty("user.dir")+"\\src\\";
//
//    //Call read file method of the class to read data
//
//    objExcelFile.readExcel(filePath,"TestData.xlsx","Sheet1");
//
//    }

}