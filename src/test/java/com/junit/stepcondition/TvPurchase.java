package com.junit.stepcondition;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TvPurchase {
	
static WebDriver driver ;
	
	@BeforeClass
	public static void login() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");

		  driver.manage().window().maximize();
		  
		  WebElement log = driver.findElement(By.xpath("(//input [@type = 'text'])[2]"));
		  log.sendKeys("9688593090");
			 
			 WebElement pass = driver.findElement(By.xpath("//input [@type = 'password']"));
			 pass.sendKeys("bala@123");
			 
				WebElement logIn = driver.findElement(By.xpath("(//button [@type = 'submit'])[2]")); 
		    	logIn.click();
				 
				 Thread.sleep(3000);
				 
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
    public void Method1() throws InterruptedException {
		 
		 WebElement mobile = driver.findElement(By.xpath("//input [@type = 'text']")); 
		 mobile.sendKeys("Sony Tv");
		 mobile.sendKeys(Keys.ENTER);
		 Thread.sleep(3000);
		 
	}
	
	@Test
    public void Method2() {
		
		List<WebElement> tvNames = driver.findElements(By.xpath("//div [@class = '_4rR01T']"));
		
		 for (int j=0; j< tvNames.size(); j++) {
		
			 WebElement tvName = tvNames.get(j);
			 String allnames = tvName.getText();
			 System.out.println(allnames); 
		 }
		
	}

	@Test
    public void Method3() throws InterruptedException {
    	
    	driver.findElement(By.xpath("(//div [@class = ('_4rR01T')])[4]")).click();
		 
		 Set<String> winId = driver.getWindowHandles();
		 List<String> list = new ArrayList();
		 list.addAll(winId);
		 driver.switchTo().window(list.get(1));
		 
		 WebElement tv4 = driver.findElement(By.xpath("//span [@class = 'B_NuCI']"));
		 String tv4Name = tv4.getText();
		 System.out.println("Fourth Mobile Name: " + tv4Name);
		 driver.findElement(By.xpath("//button [text() = 'ADD TO CART']")).click();
		 Thread.sleep(3000);
	
	
}
@Test
    public void Method4() throws IOException {
    	
    	 TakesScreenshot ss = (TakesScreenshot)driver;
		 File obj1 = ss.getScreenshotAs(OutputType.FILE);
		 File obj2 = new File ("C:\\Users\\Bala karthi\\eclipse-workspace\\FlipkartTask\\Screenshots\\Mobilemodel.png");
		 FileUtils.copyFile(obj1, obj2); 
	
	
}
@Test
    public void Method5() {
	driver.quit();
}


}
