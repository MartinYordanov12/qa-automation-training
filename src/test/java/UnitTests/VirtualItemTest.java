package UnitTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VirtualItemTest extends BaseTest {
    @Test
    public void createVirtualItemTest() {
        String expectedResult = String
                .format("Class: %s; Name: %s; Price: %s; Size on disk: %s",
                        BaseTest.virtualItem.getClass(),
                        "iOS Safari",
                        1.5,
                        130.5d
                );

        String actualResult = BaseTest.virtualItem.toString();
        Assert.assertEquals(expectedResult, actualResult, "The virtual item was not created");
    }
}