import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('http://www.calculator.net/gas-mileage-calculator.html')

WebUI.setText(findTestObject('GasOR/Page_Gas Mileage Calculator/input_uscodreading'), endMiles)

WebUI.setText(findTestObject('GasOR/Page_Gas Mileage Calculator/input_uspodreading'), startMiles)

WebUI.setText(findTestObject('GasOR/Page_Gas Mileage Calculator/input_usgasputin'), gallon)

WebUI.setText(findTestObject('GasOR/Page_Gas Mileage Calculator/input_usgasprice'), price)

WebUI.click(findTestObject('GasOR/Page_Gas Mileage Calculator/input'))

WebUI.waitForElementPresent(findTestObject('GasOR/Page_Gas Mileage Calculator (1)/consumption1'), GlobalVariable.TimeOut)

String output = WebUI.getText(findTestObject('GasOR/Page_Gas Mileage Calculator (1)/consumption1'))

output = output.substring(0, 5)

def ans  = (Integer.parseInt(endMiles) - Integer.parseInt(startMiles)) / Integer.parseInt(gallon)

println ('output = '+ output + ' ans = '+ans)

if(ans == Double.parseDouble(output))  {
	KeywordUtil.markPassed('Pass: Actual matches Expected Result')
}
else {
	KeywordUtil.markFailed('Fail: Actual does not matches Expected Result')
}

WebUI.closeBrowser()

