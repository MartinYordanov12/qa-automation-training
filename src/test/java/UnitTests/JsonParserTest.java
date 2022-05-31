package UnitTests;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import parser.NoSuchFileException;
import shop.Cart;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JsonParserTest extends BaseTest {
    private static final String ANDREW_CART_EXPECTED_STRING = "andrew-cart";
    private static final String DISABLE_CART_FILE_PATH = "src/main/resources/disable-cart.xml";
    private static final String EXPECTED_RESULT_EXPECTED_CART = "{\"cartName\":\"expectedCart\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}";

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
        public void readFromFile() {
            Cart actualResult = jsonParser.readFromFile(new File("src/main/resources/andrew-cart.json"));
            Assertions.assertEquals(ANDREW_CART_EXPECTED_STRING, actualResult.getCartName(), "The file was not read");
        }

        @Test
        public void writeToFile() throws IOException {
            jsonParser.writeToFile(cart);
            String actualResult = Files.readString(Path.of("src/main/resources/expectedCart.json"));
            Assertions.assertEquals(EXPECTED_RESULT_EXPECTED_CART, actualResult,"The file was not written");
        }

    }
}