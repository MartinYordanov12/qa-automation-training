package UnitTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;

public class CartTest extends BaseTest {
    @Test
    void totalCalculationWhenAddingRealItemTest() {
        RealItem realItem = new RealItem();
        realItem.setPrice(12000);
        cart.addRealItem(realItem);
        double actualPrice = cart.getTotalPrice();
        double expectedPrice = 14400;

        Assert.assertEquals(expectedPrice, actualPrice, "Expected price is not equal to actual price");
    }

    @Test
    void getCartNameTest() {
        Cart cart1 = new Cart("cart1");
        Cart cart2 = new Cart("cart2");

        Assert.assertEquals("cart1", cart1.getCartName(), "The cart1 names are not equals");
        Assert.assertEquals("cart2", cart2.getCartName(), "The cart2 names are not equals");
        Assert.assertFalse(cart1.getCartName().contains(cart2.getCartName()),
                "expectedVirtualItemName is not contains in actualRealItemName");
        Assert.assertNotEquals(cart1.getCartName(), cart2.getCartName(), "The expected name and the actual name are equal");
    }

    @Test
    public void totalCalculationWhenDeletingVirtualItemTest() {
        Cart cart = new Cart("yourCart");
        cart.addVirtualItem(virtualItem);
        cart.deleteVirtualItem(virtualItem);

        Assert.assertEquals(0.0, cart.getTotalPrice(), "Virtual item is not deleted from yourCart");
    }
}