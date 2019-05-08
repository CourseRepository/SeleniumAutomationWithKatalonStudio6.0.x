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

try {
    WebUI.openBrowser('https://www.amazon.com/s?k=basketball&crid=318457I4LR7LS&sprefix=baske%2Caps%2C399&ref=nb_sb_ss_i_1_5')

    WebUI.maximizeWindow()

    WebUI.waitForPageLoad(60)

    while (index <= 4) {
        index += 1

        ouputText = WebUI.getText(findTestObject('Search_Grid', [('component') : component, ('index') : index]), FailureHandling.STOP_ON_FAILURE)

        println(outputText)
    }
}
finally { 
    WebUI.closeBrowser()
}

