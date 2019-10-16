import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

try{
	
	WebUI.openBrowser('https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_dropdown-menu&stacked=h')
	
	WebUI.waitForPageLoad(60)
	
	WebUI.maximizeWindow()
	
	WebUI.switchToFrame(findTestObject('Object Repository/W3School/BootStrap/Frame'), 60)
	
	WebUI.click(findTestObject('Object Repository/W3School/BootStrap/DropDownButton'))
	
	WebUI.waitForElementVisible(findTestObject('Object Repository/W3School/BootStrap/Element'), 60)
	
	WebUI.click(findTestObject('Object Repository/W3School/BootStrap/Element'))
	
	WebUI.delay(10)
	
	
}finally{
	WebUI.switchToDefaultContent()
	
	WebUI.closeBrowser()
}