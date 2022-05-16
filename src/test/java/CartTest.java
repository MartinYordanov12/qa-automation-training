import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest{
    private static final double TAX = 0.2;

    @Test
    void getTotalPriceTest() {
        double expectedPrice = realItem.getPrice() + realItem.getPrice() * TAX;
        double actualPrice = 14400;

        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void getCartRealItemAndVirtualNameTest() {
        String actualRealItemName = realItem.getName();
        String actualVirtualItemName = virtualItem.getName();
        String expectedRealItemName = "Garrett Turbo";
        String expectedVirtualItemName = "iOS Safari";
        Assertions.assertAll(() -> {
            Assertions.assertEquals(actualRealItemName, expectedRealItemName);
            Assertions.assertEquals(actualVirtualItemName, expectedVirtualItemName);
            Assertions.assertFalse(actualRealItemName.contains(expectedVirtualItemName),
                    "expectedVirtualItemName is not contains in actualRealItemName");
        });
    }
}