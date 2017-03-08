package XeroTestCases;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;


public class Driver {
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		
		String dataPath = "C:/Users/sheetudj/Excel for Selenium/TestsuiteXeroCase.xls";
		

		String[][] recData = ReuseableMethods.readSheet(dataPath, "Sheet1");
		System.out.println("After read sheet..........");
		for(int i = 1; i <recData.length; i++){
			System.out.println("inside for loop" + i);
			if(recData[i][1] != null && recData[i][1].equalsIgnoreCase("Y")){
				String testScript = recData[i][2];
				
				/*Java Reflection or Reflexive API*/
				Method ts =AutomationScripts.class.getMethod(testScript);
				ts.invoke(ts);
				
				//driver.quit();
				System.out.println();
			}else{
				System.out.println("Row number :" +i+ " script is not executed..");
				System.out.println();
			}
			
			
		}
		System.out.println("After for loop..");
		
	
		
		
		
		

		

		
		
		
	}

}

	
	