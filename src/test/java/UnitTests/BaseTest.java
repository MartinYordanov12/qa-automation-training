package UnitTests;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.testng.annotations.BeforeMethod;
import parser.JsonParser;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

public class BaseTest {
    protected Gson gson;
    protected Faker faker;
    protected Cart cart;
    protected JsonParser jsonParser;
    protected RealItem realItem;
    protected VirtualItem virtualItem;


    @BeforeMethod
    void setupItem() {
        gson = new Gson();
        faker = new Faker();
        cart = new Cart(faker.name().firstName());
        jsonParser = new JsonParser();
        realItem = new RealItem();
        realItem.setName("Garrett Turbo");
        realItem.setPrice(12000);
        realItem.setWeight(8.5);
        cart.addRealItem(realItem);

        virtualItem = new VirtualItem();
        virtualItem.setName("iOS Safari");
        virtualItem.setPrice(1.5);
        virtualItem.setSizeOnDisk(130.5);

        cart.addVirtualItem(virtualItem);
    }
}