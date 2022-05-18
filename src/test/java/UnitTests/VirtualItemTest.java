package UnitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals(expectedResult, actualResult);
    }
}