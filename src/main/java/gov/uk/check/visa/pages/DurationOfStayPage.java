package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DurationOfStayPage extends Utility {
    // Declaring Web Element
    @CacheLookup
    @FindBy(xpath = "response-0")
    WebElement lessThanSixMonths;
    @CacheLookup
    @FindBy(id = "response-1")
    WebElement moreThanSixMonths;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;

    //This method will click on Start Now Button
    public void selectLengthOfStay(String moreOrLess) {
        switch (moreOrLess) {
            case "6 months or less":
                clickOnElement(lessThanSixMonths);
                break;
            case "longer than 6 months":
                clickOnElement(moreThanSixMonths);
                break;
        }
    }

    //This will click on continue button
    public void clickNextStepButton() {
        Reporter.log("Click on Next Step Button" + nextStepButton.toString());
        clickOnElement(nextStepButton);
        CustomListeners.test.log(Status.PASS, "Clicked on Next Step Button ");
    }

}
