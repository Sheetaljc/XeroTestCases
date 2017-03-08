package XeroTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Module extends ReuseableMethods {
	public static void launch(){ 
	WebDriver driver;
	driver = new FirefoxDriver();
	driver.get("https://www.xero.com/us/");
	driver.manage().window().maximize();
	//click on login
	WebElement LoginButton = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[3]/div[1]/div/div/div/ul/li[5]/a"));
	LoginButton.click();
	}
	
	public static void login() throws IOException{
		WebDriver driver = new FirefoxDriver();
		// Read test data
		String dt_path = "C:/Users/sheetudj/Excel for Selenium/XeroData.xls";
		 String[][] recData = ReuseableMethods.readSheet(dt_path,"Sheet1");
		
		
		String un = recData[1][2];
		String pwd = recData[1][3];
		
		
		
		

//enter email
WebElement userName = driver.findElement(By.xpath(".//*[@id='email']"));
enterText(userName,un,"email");

/*Enter Password*/
WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
enterText(password, pwd,"password");

WebElement loginButton = driver.findElement(By.xpath(".//*[@id='submitButton']"));
loginButton.click();


		
	}
	public static void logOut(){
		
	}
	
	public static void clickAccount(){
		
	}

}
