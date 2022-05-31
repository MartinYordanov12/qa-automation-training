package UnitTests;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "ExceptionProvider")
    public static Object[][] exceptionData() {
        return new String[][]{
                {"src/main/resources/NoSuchFile.file"},
                {"src/main/resources/NoSuchFile"},
                {""},
                {" "},
                {"src/main/resources/eugen-cart.xml"},
                {"src/main/resources/eugen-cart"},
                {"src/main/resources/andrew-cart"},
                {"src/main/resources/andrew-cart.xml"}
        };
    }
}
