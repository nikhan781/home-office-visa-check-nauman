package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class WorkTypePage extends Utility {

    //Declaring WebElement variable
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextstepbutton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']//div//label")
    List<WebElement> selectJobtypeList;

    //This method will click on Start Now Button
    public void clickOnContinueButton() {
        Reporter.log("Click on Continue Button " + nextstepbutton.toString());
        clickOnElement(nextstepbutton);
        CustomListeners.test.log(Status.PASS, "Clicked on COntinue Button ");
    }

    //This method will select job type
    public void selectJobTyp(String job) {
        switch (job) {
            case "Health and care professional":
                clickOnElement(selectJobtypeList, job);
                break;
            case "Digital technology professional":
                clickOnElement(selectJobtypeList, job);
                break;
            case "Academic or researcher":
                clickOnElement(selectJobtypeList, job);
                break;
            case "Work in arts or culture":
                clickOnElement(selectJobtypeList, job);
                break;
            case "Professional sportsperson":
                clickOnElement(selectJobtypeList, job);
                break;
            case "Religious worker":
                clickOnElement(selectJobtypeList, job);
                break;
            case "I want to start a business":
                clickOnElement(selectJobtypeList, job);
                break;
            case "I want to do another type of job - show me other work visas":
                clickOnElement(selectJobtypeList, job);
                break;
            default:
                System.out.println("Wrong Job Type");
        }
    }
}
