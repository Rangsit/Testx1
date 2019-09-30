import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('http://www.calculator.net/gas-mileage-calculator.html')

WebUI.setText(findTestObject('GasOR/Page_Gas Mileage Calculator/input_uscodreading'), '12000')

WebUI.setText(findTestObject('GasOR/Page_Gas Mileage Calculator/input_uspodreading'), '10000')

WebUI.setText(findTestObject('GasOR/Page_Gas Mileage Calculator/input_usgasputin'), '40')

WebUI.setText(findTestObject('GasOR/Page_Gas Mileage Calculator/input_usgasprice'), '4.5')

WebUI.click(findTestObject('GasOR/Page_Gas Mileage Calculator/input'))

WebUI.waitForElementPresent(findTestObject('GasOR/Page_Gas Mileage Calculator (1)/result'), GlobalVariable.TimeOut)

String output = WebUI.getText(findTestObject('GasOR/Page_Gas Mileage Calculator (1)/result'))

println(output)

if (WebUI.verifyMatch(output, '(.*) miles per gallon', true)) {
    KeywordUtil.markPassed('Pass: Actual matches Expected Result')
} else {
    KeywordUtil.markFailed('Fail: Actual does not matches Expected Result')
}

