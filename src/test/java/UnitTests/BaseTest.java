package UnitTests;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import parser.JsonParser;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

public class BaseTest {
    protected static RealItem realItem;
    protected static VirtualItem virtualItem;
    protected static Faker faker;
    protected static Cart cart;
    protected static JsonParser jsonParser;
    protected static Gson gson;
    protected static SoftAssert softAssert;

    @BeforeClass
    void setupItem() {
        gson = new Gson();
        faker = new Faker();
        cart = new Cart(faker.name().firstName());
        jsonParser = new JsonParser();
        realItem = new RealItem();
        softAssert = new SoftAssert();
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