package resources.testdata;


import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "dataset")
    public Object[][] dataSet() {
        Object[][] data = new Object[][]{
                {"Australia", "Tourism or visiting family and friends", "You will not need a visa to come to the UK"}
        };
        return data;
    }

    @DataProvider(name = "dataset2")
    public Object[][] dataSet2() {
        Object[][] data2 = new Object[][]{
                {"Chile", "Work, academic visit or business", "longer than 6 months", "Digital technology professional", "You need a visa to work in health and care"}
        };
        return data2;
    }

    @DataProvider(name = "dataset3")
    public Object[][] dataSet3() {
        Object[][] data3 = new Object[][]{
                {"India", "Join partner or family for a long stay", "Yes", "You’ll need a visa to join your family or partner in the UK"}
        };
        return data3;
    }

}
