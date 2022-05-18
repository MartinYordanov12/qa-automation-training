package UnitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {
    private static final double TAX = 0.2;
    private static final String GARRETT_TURBO = "Garrett Turbo";
    private static final String IOS_SAFARI = "iOS Safari";

    @Test
    void getTotalPriceTest() {
        double expectedPrice = BaseTest.realItem.getPrice() + BaseTest.realItem.getPrice() * TAX;
        double actualPrice = 14400;

        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void getCartRealItemAndVirtualNameTest() {
        String actualRealItemName = BaseTest.realItem.getName();
        String actualVirtualItemName = BaseTest.virtualItem.getName();
        String expectedRealItemName = GARRETT_TURBO;
        String expectedVirtualItemName = IOS_SAFARI;
        Assertions.assertAll(() -> {
            Assertions.assertEquals(actualRealItemName, expectedRealItemName);
            Assertions.assertEquals(actualVirtualItemName, expectedVirtualItemName);
            Assertions.assertFalse(actualRealItemName.contains(expectedVirtualItemName),
                    "expectedVirtualItemName is not contains in actualRealItemName");
            Assertions.assertNotEquals(expectedRealItemName, expectedVirtualItemName);
        });
    }
}