import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import sun.net.www.content.image.gif

WebUI.openBrowser('https://www.shway.me/charter-bus-quote/wizard')

WebUI.maximizeWindow()

WebUI.waitForPageLoad(60)

try {
	if(!WebUI.waitForElementPresent(findTestObject('Object Repository/BusCom/DepatureDate'), 30))
		throw new NoSuchElementException("Element Not Found " + findTestObject('Object Repository/BusCom/DepatureDate').toString())
	
		/*-------------------- Getting all the web element form Test Object---------------------------*/
		
	WebElement depatureDate =  WebUiCommonHelper.findWebElement(findTestObject('Object Repository/BusCom/DepatureDate'), 30)
	WebElement depatureTime =  WebUiCommonHelper.findWebElement(findTestObject('Object Repository/BusCom/DepatureTime'), 30)
	WebElement returnDate =  WebUiCommonHelper.findWebElement(findTestObject('Object Repository/BusCom/ReturnDate'), 30)
	WebElement returnTime =  WebUiCommonHelper.findWebElement(findTestObject('Object Repository/BusCom/ReturnTime'), 30)
	
	/*-------------------- Remove the readonly attribute for sendkeys to work---------------------------*/
	
	WebUI.executeJavaScript("arguments[0].removeAttribute('readonly');", Arrays.asList(depatureDate))
	WebUI.executeJavaScript("arguments[0].removeAttribute('readonly');", Arrays.asList(depatureTime))
	WebUI.executeJavaScript("arguments[0].removeAttribute('readonly');", Arrays.asList(returnDate))
	WebUI.executeJavaScript("arguments[0].removeAttribute('readonly');", Arrays.asList(returnTime))
	
	WebUI.sendKeys(findTestObject('Object Repository/BusCom/DepatureDate'), 'May 5, 2019')
	WebUI.click(findTestObject('Object Repository/BusCom/DepatureDate'))
	
	WebUI.selectOptionByValue(findTestObject('Object Repository/BusCom/DepatureTime'), "1:30", false)
	
	WebUI.sendKeys(findTestObject('Object Repository/BusCom/ReturnDate'), 'May 7, 2019')
	WebUI.click(findTestObject('Object Repository/BusCom/ReturnDate'))
	
	WebUI.selectOptionByValue(findTestObject('Object Repository/BusCom/ReturnTime'), "2:00", false)
	
	WebUI.delay(4)
}
finally { 
    WebUI.closeBrowser()
}