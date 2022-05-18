package UnitTests;

import BaseTest.BaseTest;
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

public class JsonParserTest  extends BaseTest {
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
            File input = new File("src/main/resources/disable-cart.xml");
            assertThrows(NoSuchFileException.class, () -> {
                BaseTest.jsonParser.readFromFile(input);
            });
        }

        @Test
        public void readFromFile() throws IOException {

            Path fileName = Path.of("src/main/resources/andrew-cart.json");
            String str = Files.readString(fileName);
            Assertions.assertTrue(str.contains("Audi") && str.contains("Windows"));
        }

        @Test
        public void writeToFile() throws FileNotFoundException {
            BaseTest.cart = new Cart("expectedCart");
            String expectedResult = BaseTest.gson.toJson(BaseTest.cart);;
            BaseTest.jsonParser.writeToFile(BaseTest.cart);

            Cart jsonCartObject = BaseTest.gson.fromJson(new FileReader("src/main/resources/expectedCart.json"), Cart.class);
            String actualResult = BaseTest.gson.toJson(jsonCartObject);
            Assertions.assertEquals(expectedResult,actualResult);
        }
    }
}