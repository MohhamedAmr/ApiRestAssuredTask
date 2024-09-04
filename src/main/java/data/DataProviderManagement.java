package data;

import org.testng.annotations.DataProvider;

public class DataProviderManagement {
    @DataProvider(name = "userData")
    public static Object[][] getCheckoutData() {
        return new Object[][]{
                {"Mohamed", "QC"},
                {"Ahmed","Android Dev"},
                {"Mahmoud","iOS Dev"},
                {"Malek","Product Owner"}
        };
    }
}
