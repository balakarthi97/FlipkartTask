package org.flipkart.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MobilePurchase {
	
	static String mobileName=null;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bala karthi\\eclipse-workspace\\SeleniumProject\\driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");

		  driver.manage().window().maximize();
		  
		  WebElement log = driver.findElement(By.xpath("(//input [@type = 'text'])[2]"));
		  log.sendKeys("9688593090");
			 
			 WebElement pass = driver.findElement(By.xpath("//input [@type = 'password']"));
			 pass.sendKeys("bala@123");
			 
			 WebElement logIn = driver.findElement(By.xpath("(//button [@type = 'submit'])[2]")); logIn.click();
			 
			 Thread.sleep(3000);
			 
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 
			 WebElement mobile = driver.findElement(By.xpath("//input [@type = 'text']")); 
			 mobile.sendKeys("Realme Mobile");
			 mobile.sendKeys(Keys.ENTER);
			 Thread.sleep(3000);		
			 
			 File f = new File ("C:\\Users\\Bala karthi\\eclipse-workspace\\FlipkartTask\\src\\test\\resources\\Flipkart1.xlsx");
			 FileOutputStream f1 = new FileOutputStream(f);
			 HSSFWorkbook xl = new HSSFWorkbook();
			 HSSFSheet xlsheet = xl.createSheet("Mobile Model Names");
			 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			 List<WebElement> mobileNames = driver.findElements(By.xpath("//div [@class = '_4rR01T']"));
		
			 for (int j=0; j< mobileNames.size(); j++) {
			
				 WebElement mobileName = mobileNames.get(j);
				 String allnames = mobileName.getText();
				 System.out.println(allnames); 
				 HSSFRow xlrow = xlsheet.createRow(j);
				 HSSFCell xlcolumn = xlrow.createCell(0);
				 xlcolumn.setCellValue(allnames);
				 }
			 
			 driver.findElement(By.xpath("(//div [@class = ('_4rR01T')])[4]")).click();
			 
			 Set<String> winId = driver.getWindowHandles();
			 List<String> list = new ArrayList();
			 list.addAll(winId);
			 driver.switchTo().window(list.get(1));
			 
			 WebElement mobile4 = driver.findElement(By.xpath("//span [@class = 'B_NuCI']"));
			 String mobile4Name = mobile4.getText();
			 System.out.println("Fourth Mobile Name: " + mobile4Name);
			 
			 HSSFSheet xlsheet2 = xl.createSheet("Fourth Mobile Name"); 
			 HSSFRow xlrow2 = xlsheet2.createRow(0); 
			 HSSFCell xlcolumn2 = xlrow2.createCell(0);
			 xlcolumn2.setCellValue(mobile4Name);
			 xl.write(f);
			 xl.close();
			 
			 driver.findElement(By.xpath("//button [text() = 'ADD TO CART']")).click();
			 Thread.sleep(3000);
			 
			 TakesScreenshot ss = (TakesScreenshot)driver;
			 File obj1 = ss.getScreenshotAs(OutputType.FILE);
			 File obj2 = new File ("C:\\Users\\Bala karthi\\eclipse-workspace\\FlipkartTask\\Screenshots\\snap.png");
			 FileUtils.copyFile(obj1, obj2); 
			 
			 File ff = new File ("C:\\Users\\Bala karthi\\eclipse-workspace\\FlipkartTask\\src\\test\\resources\\Flipkart.xlsx");
			   FileInputStream f2 = new FileInputStream (ff);
				 HSSFWorkbook xl2 = new HSSFWorkbook(f2);
				 
				 HSSFSheet xlsheet3 = xl2.getSheet("Fourth Mobile Name"); 
				 HSSFRow xlrow3 = xlsheet3.getRow(0); 
				 HSSFCell xlcolumn3 = xlrow3.getCell(0);
				 String name = xlcolumn3.getStringCellValue();
				 System.out.println(name);
	}

}





 
