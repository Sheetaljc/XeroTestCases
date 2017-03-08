package XeroTestCases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationScripts extends ReuseableMethods {

	public static WebDriver driver;
	public static String baseUrl;
	
	public static void NavigateToXero() throws IOException, InterruptedException{
		Module.launch();
		WebDriver driver = new FirefoxDriver();
		// Read test data
		String dt_path = "C:/Users/sheetudj/Excel for Selenium/XeroData.xls";
		 String[][] recData = ReuseableMethods.readSheet(dt_path,"Sheet1");
		
		
		String expectedErrorMsg = recData[1][4];
		String un = recData[1][2];
		String pwd = recData[1][3];
		//String URl = recData[1][1];
		
		
		String actualErrorMsg = "";
		
		if(driver.findElement(By.id("error")).isDisplayed()){
			 actualErrorMsg = driver.findElement(By.id("error")).getText().trim();
		}
		
	

		if(expectedErrorMsg.equals(actualErrorMsg))
		{
			Update_Report("Pass", "Validate Error message ", "Expected error message is matching to actual error message.");
			
		}
		else
		{
			Update_Report("Fail", "Validate Error message", "Expected error message is NOT matching to actual error message.");
			
		}
		System.out.println("User's Home page is displayed");

	}
	public static void IncorrectPassword() throws InterruptedException{
		Module.launch();
		/*Enter Username*/
		WebDriver driver = new FirefoxDriver();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("email")).sendKeys("sheetudj@gmail.com");

		/*Enter Password*/
		WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
		password.sendKeys("12345");

		WebElement loginButton = driver.findElement(By.xpath(".//*[@id='submitButton']"));
		loginButton.click();
		
		System.out.println("error message Your Email or Password is incorrect should be displayed");
		
	}
	public static void IncorrectEmail(){
		Module.launch();
		/*Enter Username*/
		WebElement userName = driver.findElement(By.xpath(".//*[@id='email']"));
		userName.sendKeys("sheetal@gmail.com");

		/*Enter Password*/
		WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
		password.sendKeys("sheetal18");

		WebElement loginButton = driver.findElement(By.xpath(".//*[@id='submitButton']"));
		loginButton.click();
		
		System.out.println("error message Your Email or Password is incorrect should be displayed");
		
	}
	public static void ForgotPassword() {
		Module.launch();
		WebElement ForgotPassword = driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/a"));
		ForgotPassword.click();
		
		WebElement UserName = driver.findElement(By.xpath(".//*[@id='UserName']"));
		UserName.sendKeys("sheetudj@gmail.com");
		
		WebElement SendLink = driver.findElement(By.xpath(".//*[@id='submitButton']/a/span"));
		SendLink.click();
		
		System.out.println("Password reset message page is displayed A link to reset your password has been sent to An email associated with the <username> account is sent.");
		
	}
	
	public static void SignUpToXDC(){
		Module.launch();
		WebElement FreeTrail = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[3]/div[1]/div/div/div/ul/li[6]/a/span"));
		FreeTrail.click();
		
		WebElement FirstName = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[2]/label/input"));
		FirstName.sendKeys("Sheetal");
		
		WebElement LastName = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[3]/label/input"));
		LastName.sendKeys("Dinaharan");
		
		WebElement Email = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input"));
		Email.sendKeys("sheetudj@gmail.com");
		
		WebElement PhoneNumber = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[6]/label/input"));
		PhoneNumber.sendKeys("4084776513");
		
		WebElement selectMenu=driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[7]/label/span/select"));
		Select select =new Select(selectMenu);
        select.selectByVisibleText("United States");
        
        driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/div/label/input")).click();
// how to write for captcha.. how to avoid it.
        driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div")).click();
	
	}
	public static void SignUpToXDC2() throws IOException{
		Module.launch();
		WebElement FreeTrail = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[3]/div[1]/div/div/div/ul/li[6]/a/span"));
		FreeTrail.click();
		
		WebElement GetStarted = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[10]/span/button"));
		GetStarted.click();
		System.out.println("Error Message First name,Last name,Email address, Phone number can't be empty should be dispalyed");
		
		WebElement emailid = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input"));
		emailid.sendKeys("sheetudj");
		String expectedErrorMsg = "Email address is invalid";
		String actualErrorMsg = "";
				
		if(driver.findElement(By.xpath(".//*[@id='signup-form-error-messege-3']")).isDisplayed()){
			 actualErrorMsg = driver.findElement(By.xpath(".//*[@id='signup-form-error-messege-3']")).getText().trim();
		}
		

		if(expectedErrorMsg.equals(actualErrorMsg))
		{
			Update_Report("Pass", "Validate Error message ", "Expected error message is matching to actual error message.");
			
		}
		else
		{
			Update_Report("Fail", "Validate Error message", "Expected error message is NOT matching to actual error message.");
			
		}
		
		
		WebElement FirstName = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[2]/label/input"));
		FirstName.sendKeys("Sheetal");
		
		WebElement LastName = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[3]/label/input"));
		LastName.sendKeys("Dinaharan");
		
		WebElement Email = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input"));
		Email.sendKeys("sheetudj@gmail.com");
		
		WebElement PhoneNumber = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[6]/label/input"));
		PhoneNumber.sendKeys("4084776513");
		
		WebElement selectMenu=driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[7]/label/span/select"));
		Select select =new Select(selectMenu);
        select.selectByVisibleText("United States");
        
		
		WebElement GetStartedButton = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[10]/span/button"));
		GetStartedButton.click();
		
		System.out.println("term and Policy checkbox should be highlight.");
		
		
	}
	public static void SignUpToXDC2C() throws IOException, InterruptedException{
		Module.launch();
		WebElement FreeTrail = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[3]/div[1]/div/div/div/ul/li[6]/a/span"));
		FreeTrail.click();
		
		WebElement Termuse = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/div/label/a[1]"));
		Termuse.click();
		Thread.sleep(7000);
		
		String oldwindow= driver.getWindowHandle();
		driver.switchTo().window(oldwindow);
		Thread.sleep(2000);
		WebElement Privacy = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/div/label/a[2]"));
		Privacy.click();
	
			}
	}
	


