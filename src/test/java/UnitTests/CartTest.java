package UnitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;

public class CartTest extends BaseTest {
    @Test
    void getTotalPriceTest() {
        RealItem realItem = new RealItem();
        realItem.setPrice(12000);
        cart.addRealItem(realItem);
        double actualPrice = cart.getTotalPrice();
        double expectedPrice = 14400;

        Assertions.assertEquals(expectedPrice, actualPrice, "Expected price is not equal to actual price");
    }

    @Test
    void getCartNameTest() {
        Cart cart1 = new Cart("cart1");
        Cart cart2 = new Cart("cart2");

        Assertions.assertAll(() -> {
            Assertions.assertEquals("cart1",cart1.getCartName());
            Assertions.assertEquals("cart2",cart2.getCartName());
            Assertions.assertFalse(cart1.getCartName().contains(cart2.getCartName()),
                    "expectedVirtualItemName is not contains in actualRealItemName");
            Assertions.assertNotEquals(cart1.getCartName(),cart2.getCartName());
        });
    }
}