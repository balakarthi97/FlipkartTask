package org;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartNew {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bala karthi\\eclipse-workspace\\FlipkartTask\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//input[@autocomplete = 'off'])[2]")).sendKeys("9443822714");
		driver.findElement(By.xpath("(//input[@autocomplete = 'off'])[3]")).sendKeys("bala@1704");
		driver.findElement(By.xpath("(//button[@type= 'submit'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys("realme");
		driver.findElement(By.xpath("//button[@type= 'submit']")).click();
		Thread.sleep(3000);
		List<WebElement> mobiles = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		File f = new File("C:\\Users\\Bala karthi\\eclipse-workspace\\FlipkartTask\\src\\test\\resources\\Flipkart1.xlsx");
		
	    FileOutputStream f1 = new FileOutputStream (f);
	    HSSFWorkbook w = new HSSFWorkbook();
	    HSSFSheet sheet = w.createSheet("all mobiles");
	    
		for(WebElement x : mobiles) {
			String m =  x.getText();
			System.out.println(m);
			for (int i=0; i<=mobiles.size();i++) {
				HSSFRow row = sheet.createRow(i);
			    HSSFCell cell= row.createCell(0); 
			    cell.setCellValue(m);
			    w.write(f);
			}
		}
		
	Thread.sleep(3000);
	    
		WebElement select = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[4]"));
		select.click();
		Thread.sleep(3000);
		String s = select.getText();
		System.out.println(s);
String prwnd = driver.getWindowHandle();
		
		Set<String> allwin = driver.getWindowHandles();
		for(String x :allwin ) {
			if(!x.equals(prwnd)){
				driver.switchTo().window(x);
				
			}
		}
		
		
		HSSFSheet sheet2 = w.createSheet("selected mobile");
		HSSFRow row = sheet2.createRow(0);
	    HSSFCell cell= row.createCell(0); 
	    cell.setCellValue(s);
		w.write(f);
	    w.close();
	    
	    FileInputStream f2 = new  FileInputStream (f);
	    HSSFWorkbook w1 = new HSSFWorkbook(f2);
	    HSSFSheet Sheet2 = w1.getSheet("selected mobile");
	    HSSFRow Row2= Sheet2.getRow(0);
	    HSSFCell cell2=Row2.getCell(0);
	    
	    String value = cell2.getStringCellValue();
	    System.out.println(value);
	    
	    if (s.equals(value)) {
	    	System.out.println("pass");
	    }else {
	    	System.out.println("fail");
	    }

		}
}


