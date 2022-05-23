package UnitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import parser.NoSuchFileException;
import shop.Cart;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JsonParserTest extends BaseTest {
    private static final String ANDREW_CART_EXPECTED_STRING = "{\"cartName\":\"andrew-cart\",\"realItems\":[{\"weight\":1560.0,\"name\":\"Audi\",\"price\":32026.9}],\"virtualItems\":[{\"sizeOnDisk\":20000.0,\"name\":\"Windows\",\"price\":11.0}],\"total\":38445.479999999996}";
    private static final String ANDREW_CART_FILE_PATH = "src/main/resources/andrew-cart.json";
    private static final String EXPECTED_CART_FILE_PATH = "src/main/resources/expectedCart.json";
    private static final String DISABLE_CART_FILE_PATH = "src/main/resources/disable-cart.xml";
    private static final String EXPECTED_CART_FILE_NAME = "expectedCart";

    @Nested
    class ExceptionTests {
        @ParameterizedTest
        @ValueSource(strings = {
                "src/main/resources/Json",
                "src/main/resources/eugen-cart.JPEG",
                "src/main/resources/andrew-cart.JPEG",
                "src/main/resources/eugen-cart",
                "src/main/resources/andrew-cart",
                ""
        })
        public void noSuchFileExceptionTest(String input) {
            assertThrows(NoSuchFileException.class, () -> {
                BaseTest.jsonParser.readFromFile(new File(String.valueOf(input)));
            });
        }

        @Disabled("No such exception test disabled")
        @Test
        public void noSuchFileExceptionTestDisable() {
            File input = new File(DISABLE_CART_FILE_PATH);
            assertThrows(NoSuchFileException.class, () -> {
                BaseTest.jsonParser.readFromFile(input);
            });
        }

        @Test
        public void readFromFile() throws IOException {
            Path fileName = Path.of(ANDREW_CART_FILE_PATH);
            String str = Files.readString(fileName);

            Assertions.assertEquals(str, ANDREW_CART_EXPECTED_STRING, "The file was not readed");
        }

        @Test
        public void writeToFile() throws FileNotFoundException {
            BaseTest.cart = new Cart(EXPECTED_CART_FILE_NAME);
            String expectedResult = BaseTest.gson.toJson(BaseTest.cart);;
            BaseTest.jsonParser.writeToFile(BaseTest.cart);
            Cart jsonCartObject = BaseTest.gson.fromJson(new FileReader(EXPECTED_CART_FILE_PATH), Cart.class);
            String actualResult = BaseTest.gson.toJson(jsonCartObject);

            Assertions.assertEquals(expectedResult,actualResult,"The file was not written");
        }
    }
}