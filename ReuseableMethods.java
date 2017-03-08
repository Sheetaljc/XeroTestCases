package XeroTestCases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.openqa.selenium.WebElement;

public class ReuseableMethods {
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;
	/* Name of the method : enterText
	 * Brief desc : Enter into text field
	 * Arguments : obj--> WebElement Object, textval -->Text to be entered, objName--> name of the object
	 * Created by :automation team
	 * Created date : March 4,2017
	 * Last modified : Mar 4,2017
	 */
	public static void enterText(WebElement webObj, String textVal, String objName ) throws IOException{
		if(webObj.isDisplayed()){
			webObj.sendKeys(textVal);
			Update_Report("Pass", "enterText", textVal + "  entered in " + objName+" field");

		}else{
			Update_Report("Fail", "enterText", objName + " field does not exist , please check your application.");

		}
	}
 
 
   /* Name of the method : clickObj
	 * Brief desc : To click the object
	 * Arguments : obj--> WebElement Object, objName--> name of the object
	 * Created by :automation team
	 * Created date : Mar 4,2017
	 * Last modified : Mar 7,2017
	 */
  public static void clickObj(WebElement obj,String objName)
      {
	     if(obj.isDisplayed())
	       {
		 obj.click();
		 System.out.println("Pass: " + objName +" is clicked");
	 }else
	 {
		 System.out.println("Fail: " + objName +" field is not displayed, Please check your application");
	 }
}
	     public static void validateMsg(WebElement obj,String expectedText,String objName)
	     {
	    	 if(obj.isDisplayed())
	    	 {
	    		 String actualText = obj.getText().trim();
	    		 if(expectedText.equals(actualText))
	    		 {
	    			System.out.println("Pass: Actual message is matching with expected message " +actualText);
	    		 }else
	    		 {
	    			 System.out.println("Fail: Actual message" + actualText +" is not matching with expected message." +expectedText);
	    		 }
	    	 }
	    	 else
	    	 {
	    		 System.out.println("Fail: " + objName +" field is not displayed, Please check your application");
	    	 }
	    	 }

	     public static void getText(WebElement obj,String expectedValue,String objName)
		 {
			 String actualValue = obj.getAttribute("value");
				 if(expectedValue.equals(actualValue))
				 {
					System.out.println("Pass: Actual text is matching with expected text " +actualValue);
				 }else
				 {
					 System.out.println("Fail: Actual text" + actualValue +" is not matching with expected text." +expectedValue);
				 }
		 } 	 
	     /* Name of the Method: readSheet ( CMMI - 5 level coding )
	 	 * Brief Description: Read xl sheet content 
	 	 * Arguments: dt_path --> Path of Xl sheet, sheetName --> Name of the sheet
	 	 * Created By:  Automation team
	 	 * Creation Date: Mar 5 2017
	 	 * Last Modified date: Mar 06 2017
	 	 * */

	 	public static String[][] readSheet(String dt_Path, String sheetName) throws IOException{


	 		/*Step 1: Get the XL Path*/
	 		File xlFile = new File(dt_Path);

	 		/*Step2: Access the Xl File*/
	 		FileInputStream xlDoc = new FileInputStream(xlFile);


	 		/*Step3: Access the work book */
	 		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);


	 		/*Step4: Access the Sheet */
	 		HSSFSheet sheet = wb.getSheet(sheetName);

	 		int iRowCount = sheet.getLastRowNum()+1;
	 		int iColCount = sheet.getRow(0).getLastCellNum();

	 		String[][] xlData = new String[iRowCount][iColCount];

	 		for(int i=0; i<iRowCount; i++){
	 			for(int j = 0; j<iColCount; j++){

	 				xlData[i][j]= sheet.getRow(i).getCell(j).getStringCellValue();
	 			}

	 		}

	 		return xlData;
	 	}

	 	
	 	/* Name of the Method: writeExcel ( CMMI - 5 level coding )
	 	 * Brief Description: Write to xl sheet content 
	 	 * Arguments: dt_path --> Path of Xl sheet, sheetName --> Name of the sheet, iRowCount --> row number
	 	 * iColCount --> colNumber, XlData --> text to be entered 
	 	 * Created By:  Automation team
	 	 * Creation Date: Feb 15 2017
	 	 * Last Modified date: Feb 15 2017
	 	 * */
	 	public static void writeExcel(String dt_path, String sheetName, int iRowCount, int iColCount, String XlData) throws IOException{
	 		/*Step 1: Get the XL Path*/
	 		File xlFile = new File(dt_path);

	 		/*Step2: Access the Xl File*/
	 		FileInputStream xlDoc = new FileInputStream(xlFile);

	 		/*Step3: Access the work book */
	 		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);

	 		/*Step4: Access the Sheet */
	 		HSSFSheet sheet = wb.getSheet(sheetName);
	 		
	 		/*Step 5: Access Row*/
	 		HSSFRow row = sheet.getRow(iRowCount);
	 		
	 		/*Step 6: Access Column*/
	 		HSSFCell cell = row.getCell(iColCount);
	 		
//	 		cell.setCellValue(XlData);
	 		
	 		if(XlData.equalsIgnoreCase("Pass")){
	 			HSSFCellStyle titleStyle = wb.createCellStyle();
	 			titleStyle.setFillForegroundColor(new HSSFColor.GREEN().getIndex());
	 			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	 			cell.setCellStyle(titleStyle);
	 		}else if(XlData.equalsIgnoreCase("Fail")){
	 			HSSFCellStyle titleStyle = wb.createCellStyle();
	 			titleStyle.setFillForegroundColor(new HSSFColor.RED().getIndex());
	 			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	 			cell.setCellStyle(titleStyle);
	 		}else{
	 			HSSFCellStyle titleStyle = wb.createCellStyle();
	 			titleStyle.setFillForegroundColor(new HSSFColor.BLUE_GREY().getIndex());
	 			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	 			cell.setCellStyle(titleStyle);
	 		}
	 		

	 		
	 		FileOutputStream fout = new FileOutputStream(dt_path);
	 		wb.write(fout);
	 		fout.flush();
	 		fout.close();
	 	}
  
	     public static void startReport(String scriptName, String ReportsPath) throws IOException{

	 		String strResultPath = null;


	 		String testScriptName =scriptName;


	 		cur_dt = new Date(); 
	 		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	 		String strTimeStamp = dateFormat.format(cur_dt);

	 		if (ReportsPath == "") { 

	 			ReportsPath = "C:\\";
	 		}

	 		if (ReportsPath.endsWith("\\")) { 
	 			ReportsPath = ReportsPath + "\\";
	 		}

	 		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
	 		File f = new File(strResultPath);
	 		f.mkdirs();
	 		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
	 				+ ".html";



	 		bw = new BufferedWriter(new FileWriter(htmlname));

	 		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
	 		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
	 		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
	 				+ "FireFox " + "</B></FONT></TD></TR>");
	 		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
	 		bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Line Number</B></FONT></TD>"
	 				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
	 				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
	 				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
	 				+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


	 	}

	 	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
	 		String str_time;
	 		Date exec_time = new Date();
	 		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	 		str_time = dateFormat.format(exec_time);
	 		if (Res_type.startsWith("Pass")) {
	 			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
	 					+ (j++)
	 					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
	 					+Action
	 					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
	 					+ str_time
	 					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
	 					+ "Passed"
	 					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
	 					+ result + "</FONT></TD></TR>");

	 		} else if (Res_type.startsWith("Fail")) {
	 			exeStatus = "Failed";
	 			int reportflag = 1;
	 			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
	 					+ (j++)
	 					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
	 					+Action
	 					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
	 					+ str_time
	 					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
	 					+ "<a href= "
	 					+ htmlname
	 					+ "  style=\"color: #FF0000\"> Failed </a>"

	 				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
	 				+ result + "</FONT></TD></TR>");

	 		} 
	 	}


	
}