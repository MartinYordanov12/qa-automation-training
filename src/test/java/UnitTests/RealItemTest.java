package UnitTests;

import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertEquals(expectedResults, actualResult,"The real item was not created");
    }
}