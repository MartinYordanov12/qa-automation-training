package UnitTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import parser.NoSuchFileException;
import shop.Cart;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.testng.Assert.assertThrows;

public class JsonParserTest extends BaseTest {
    private static final String ANDREW_CART_EXPECTED_STRING = "andrew-cart";
    private static final String DISABLE_CART_FILE_PATH = "src/main/resources/disable-cart.xml";
    private static final String EXPECTED_RESULT_EXPECTED_CART = "{\"cartName\":\"expectedCart\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}";

    @Test(
            groups = "exceptions",
            expectedExceptions = NoSuchFileException.class,
            dataProvider = "ExceptionProvider",
            dataProviderClass = DataProviders.class
    )
    public void noSuchFileExceptionTest(String input) {
        jsonParser.readFromFile(new File(String.valueOf(input)));

    }

    @Test(enabled = false)
    public void noSuchFileExceptionTestDisable() {
        File input = new File(DISABLE_CART_FILE_PATH);
        assertThrows(NoSuchFileException.class, () -> {
            BaseTest.jsonParser.readFromFile(input);
        });
    }

    @Test
    public void readFromFile() {
        Cart actualResult = jsonParser.readFromFile(new File("src/main/resources/andrew-cart.json"));
        Assert.assertEquals(ANDREW_CART_EXPECTED_STRING, actualResult.getCartName(), "The file was not read");
    }

    @Test
    public void writeToFile() throws IOException {
        jsonParser.writeToFile(cart);
        String actualResult = Files.readString(Path.of("src/main/resources/expectedCart.json"));
        Assert.assertEquals(EXPECTED_RESULT_EXPECTED_CART, actualResult, "The file was not written");
    }

}