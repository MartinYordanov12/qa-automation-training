package UnitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.List;

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
            Assertions.assertEquals("cart1",cart1.getCartName(),"The cart1 names are not equals");
            Assertions.assertEquals("cart2",cart2.getCartName(), "The cart2 names are not equals");
            Assertions.assertFalse(cart1.getCartName().contains(cart2.getCartName()),
                    "expectedVirtualItemName is not contains in actualRealItemName");
            Assertions.assertNotEquals(cart1.getCartName(),cart2.getCartName(), "The expected name and the actual name are equal");
        });
    }
    @Test
    public void addRealItemTest(){
        Cart cart = new Cart("myCart");
        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);
        // Print some output: goes to your special stream
        System.out.println(realItem);
        // Put things back
        System.out.flush();
        System.setOut(old);
        String expectedPrintStream = baos.toString();

        cart.addRealItem(realItem);

        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
        PrintStream ps1 = new PrintStream(baos1);
        PrintStream old1 = System.out;
        System.setOut(ps1);
        cart.showItems();
        System.out.flush();
        System.setOut(old1);
        String actualPrintStream = baos1.toString();

        double actualTotalPrice = cart.getTotalPrice();

        Assertions.assertAll(() -> {
            Assertions.assertEquals(actualPrintStream,expectedPrintStream,"The item is not added to cart");
            Assertions.assertEquals(14400.0,actualTotalPrice, "Real item is not added to cart");
        });
    }
    @Test
    public void deleteVirtualItemTest(){
        Cart cart = new Cart("yourCart");
        cart.addVirtualItem(virtualItem);
        cart.deleteVirtualItem(virtualItem);

        Assertions.assertEquals(0.0,cart.getTotalPrice(),"Virtual item is not deleted from yourCart");
    }
}