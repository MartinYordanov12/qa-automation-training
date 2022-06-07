package UnitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RealItemTest extends BaseTest {
    @Test
    public void createRealItemTest() {
        String expectedResults = String
                .format("Class: %s; Name: %s; Price: %s; Weight: %s",
                        BaseTest.realItem.getClass(),
                        "Garrett Turbo",
                        12000d,
                        8.5d
                );

        String actualResult = BaseTest.realItem.toString();
        Assertions.assertEquals(expectedResults, actualResult,"The real item was not created");
    }
}