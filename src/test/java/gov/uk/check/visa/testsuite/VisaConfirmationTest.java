package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class VisaConfirmationTest extends BaseTest {

    DurationOfStayPage durationOfStayPage;
    ResultPage resultPage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;
    ReasonForTravelPage reasonForTravelPage;
    SelectNationalityPage selectNationalityPage;
    StartPage startPage;
    WorkTypePage workTypePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        durationOfStayPage = new DurationOfStayPage();
        resultPage = new ResultPage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();
        reasonForTravelPage = new ReasonForTravelPage();
        selectNationalityPage = new SelectNationalityPage();
        startPage = new StartPage();
        workTypePage = new WorkTypePage();
    }

    @Test(dataProvider = "dataset", dataProviderClass = TestData.class, groups = {"sanity", "regression"})
    public void verifyJobSearchResultUsingDifferentDataSet(String nationality, String reason, String message) throws InterruptedException {
        //        Click on start button
        startPage.clickOnStartNowButton();
        //        Select a Nationality 'Australia'
        selectNationalityPage.selectNationality(nationality);
        //        Click on Continue button
        selectNationalityPage.clickNextStepButton();
        //        Select reason 'Tourism'
        reasonForTravelPage.selectReasonForVisit(reason);
        //        Click on Continue button
        reasonForTravelPage.clickOnContinueButton();
        //        verify result 'You will not need a visa to come to the UK'
        resultPage.confirmResultMessage(message);
    }

    @Test(dataProvider = "dataset2", dataProviderClass = TestData.class, groups = {"smoke", "regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths(String nationality, String reason, String moreorless, String job, String message) throws InterruptedException {
        //Click on start button
        startPage.clickOnStartNowButton();
        //Select a Nationality 'Chile'
        selectNationalityPage.selectNationality(nationality);
        //Click on Continue button
        selectNationalityPage.clickNextStepButton();
        Thread.sleep(1000);
        //Select reason 'Work, academic visit or business'
        reasonForTravelPage.selectReasonForVisit(reason);
        Thread.sleep(1000);
        //Click on Continue button
        reasonForTravelPage.clickOnContinueButton();
        Thread.sleep(1000);
        //Select intend to stay for 'longer than 6 months'
        durationOfStayPage.selectLengthOfStay(moreorless);
        //Click on Continue button
        durationOfStayPage.clickNextStepButton();
        //Select have planning to work for 'Health and care professional'
        workTypePage.selectJobTyp(job);
        //Click on Continue button
        workTypePage.clickOnContinueButton();
        //verify result 'You need a visa to work in health and care'
        resultPage.confirmResultMessage(message);
    }

    @Test(dataProvider = "dataset3", dataProviderClass = TestData.class, groups = "regression")
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card(String nationality, String reason, String status, String message) throws InterruptedException {
        Thread.sleep(1000);
        //Click on start button
        startPage.clickOnStartNowButton();
        //Select a Nationality 'Colombia'
        selectNationalityPage.selectNationality(nationality);
        //Click on Continue button
        selectNationalityPage.clickNextStepButton();
        //Select reason 'Join partner or family for a long stay'
        reasonForTravelPage.selectReasonForVisit(reason);
        //Click on Continue button
        reasonForTravelPage.clickOnContinueButton();
        //Select state My partner of family member have uk immigration status 'yes'
        familyImmigrationStatusPage.selectImmigrationStatus(status);
        //Click on Continue button
        workTypePage.clickOnContinueButton();
        //verify result 'You’ll need a visa to join your family or partner in the UK'
        resultPage.confirmResultMessage(message);
    }
}
