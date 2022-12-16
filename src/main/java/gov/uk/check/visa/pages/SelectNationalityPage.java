package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SelectNationalityPage extends Utility {
    //Declaring WebElement type variables
    @CacheLookup
    @FindBy(xpath = "//select[@id='response']")
    WebElement nationalityDropDownList;

    @CacheLookup
    @FindBy(xpath = "//button[@class='gem-c-button govuk-button gem-c-button--bottom-margin']")
    WebElement nextStepButton;

    //This method will select the nationality
    public void selectNationality(String nationality) {
        Reporter.log("Select Nationality " + nationalityDropDownList.toString());
        selectByContainsTextFromDropDown(nationalityDropDownList, nationality);
        CustomListeners.test.log(Status.PASS, "Selected Nationality is " + nationality.toString());
    }

    //This method will click on Next Step Button
    public void clickNextStepButton() {
        Reporter.log("Click on Next Step Button " + nextStepButton.toString());
        clickOnElement(nextStepButton);
        CustomListeners.test.log(Status.PASS, "Clicked on Next Step Button ");
    }

}
