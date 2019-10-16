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

WebUI.openBrowser('https://www.google.com/')

WebUI.maximizeWindow()

WebUI.waitForPageLoad(60)

/*
 * Normal Mode - Mozilla/X.0 (Windows NT XX.0; Win64; x64) AppleWebKit/XX.YY (KHTML, like Gecko) Chrome/XX.Y.XXXX.YY Safari/XXX.X
 * HeadLess Mode - Mozilla/X.0 (Windows NT XX.0; Win64; x64) AppleWebKit/XX.YY (KHTML, like Gecko) HeadlessChrome/XX.X.XX.XX Safari/XXX.X
 * */

println WebUI.executeJavaScript('return window.navigator.userAgent;', null)

WebUI.delay(2)

WebUI.closeBrowser()



