package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class StartPage extends Utility {
    // Declaring WebElement variable
    @CacheLookup
    @FindBy(xpath = "//a[@class='gem-c-button govuk-button govuk-button--start']")
    WebElement startNowButton;

    //This method will click on Start Now Button
    public void clickOnStartNowButton() {
        Reporter.log("Click on Start Now Button " + startNowButton.toString());
        clickOnElement(startNowButton);
        CustomListeners.test.log(Status.PASS, "Clicked on Start Now Button ");

    }

}
