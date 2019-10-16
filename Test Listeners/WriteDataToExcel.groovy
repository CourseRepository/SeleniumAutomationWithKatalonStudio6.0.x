import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.question.RandomNumberGenerator
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class WriteDataToExcel {
	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	
	private XSSFWorkbook xssfWorkBook;
	
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		try{
			writeTOExcelFile("C:\\Data\\Katalon\\MyExcel.xlsx","Sheet1",RandomNumberGenerator.dataToWriteInExcel)
			
		}catch(Exception err){
			err.printStackTrace();
			KeywordUtil.markError(err.toString())
		}
	}

	// Create Work book

	private XSSFWorkbook getWorkBook(){
		if(xssfWorkBook == null)
			xssfWorkBook = new XSSFWorkbook();
		return xssfWorkBook;
	}

	//Create the Sheet

	private XSSFSheet getSheet(XSSFWorkbook workBook,String sheetName){
		return workBook.createSheet(sheetName);
	}

	//Keyword , which write the data to excel

	public void writeTOExcelFile(String excelPath,String sheetName,Map<String, String> data){
		XSSFWorkbook book = getWorkBook() // created the book
		XSSFSheet sheet = getSheet(book, sheetName) //created the sheet
		int rowCount = 1;
		for(String key : data.keySet()){
			XSSFRow aRow = sheet.createRow(rowCount) // created the row-> index
			XSSFCell bCell = aRow.createCell(0) // created the col -> index
			bCell.setCellValue(String.format("Welcome %s ",key));
			rowCount++;
		}
		writeToFileSystem(book,excelPath)
	}


	//Write the excel to the FS

	private void writeToFileSystem(XSSFWorkbook book,String excelPath){
		try {
			FileOutputStream aOut = new FileOutputStream(excelPath)
			book.write(aOut)
			aOut.close()
		} catch (Exception e) {
			KeywordUtil.markError(e.toString())
		}
	}
}