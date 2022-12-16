package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ReasonForTravelPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']//label[text()]")
    List<WebElement> reasonForTravel;

    //This method will click on Start Now Button
    public void clickOnContinueButton() {
        Reporter.log("Click on Continue Button " + continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Clicked on Continue Button ");
    }

    //This method will select reason for visit
    public void selectReasonForVisit(String reason) {
        switch (reason) {
            case "Tourism or visiting family and friends":
                clickOnElement(reasonForTravel, reason);
                break;
            case "Work, academic visit or business":
                clickOnElement(reasonForTravel, reason);
                break;
            case "Study":
                clickOnElement(reasonForTravel, reason);
                break;
            case "Transit (on your way to somewhere else)":
                clickOnElement(reasonForTravel, reason);
                break;
            case "Join partner or family for a long stay":
                clickOnElement(reasonForTravel, reason);
                break;
            case "Get married or enter into a civil partnership":
                clickOnElement(reasonForTravel, reason);
                break;
            case "Stay with your child, if they’re at school":
                clickOnElement(reasonForTravel, reason);
                break;
            case "Have medical treatment":
                clickOnElement(reasonForTravel, reason);
                break;
            case "For official diplomatic or government business (including transit through the UK)":
                clickOnElement(reasonForTravel, reason);
                break;
            default:
                System.out.println("Wrong Reason");
        }
    }
}


