import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RealItemTest extends BaseTest {
    @Test
    public void createRealItemTest() {
        String expectedResults = String
                .format("Class: %s; Name: %s; Price: %s; Weight: %s",
                        realItem.getClass(),
                        "Garrett Turbo",
                        12000d,
                        8.5d
                );

        String actualResult = realItem.toString();
        Assertions.assertEquals(expectedResults, actualResult);
        System.out.printf("Expected result = %s \n", expectedResults);
        System.out.printf("Actual result = %s", expectedResults);
    }
}