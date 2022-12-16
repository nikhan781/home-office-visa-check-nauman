package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class ResultPage extends Utility {
    //Declaring WebElement Type variable
    @CacheLookup
    @FindBy(xpath = "//h2[@class='gem-c-heading gem-c-heading--font-size-27 govuk-!-margin-bottom-6']")
    WebElement resultMessage;

    //This method will verify the result text
    public void confirmResultMessage(String expectedMessage) {
        Reporter.log("Confirm Result Message " + resultMessage);
        Assert.assertTrue(getTextFromElement(resultMessage).equals("visa"), expectedMessage);
        CustomListeners.test.log(Status.PASS, "Confirmed Result Message is " + resultMessage.getText());
    }

}
