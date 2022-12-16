package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class FamilyImmigrationStatusPage extends Utility {
    // Declaring Web Element
    @CacheLookup
    @FindBy(xpath = "//div[@class='gem-c-radio govuk-radios__item']//input[@id='response-0']")
    WebElement yes;
    @CacheLookup
    @FindBy(xpath = "//div[@class='gem-c-radio govuk-radios__item']//input[@id='response-1']")
    WebElement no;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;

    //This method will click on Start Now Button
    public void selectImmigrationStatus(String status) {
        switch (status) {
            case "Yes":
                clickOnElement(yes);
                break;
            case "No":
                clickOnElement(no);
                break;
        }
    }

    //This will click on continue button
    public void clickNextStepButton() {
        Reporter.log("Click on Next Step Button " + nextStepButton.toString());
        clickOnElement(nextStepButton);
        CustomListeners.test.log(Status.PASS, "Clicked on Next Step Button ");
    }
}
