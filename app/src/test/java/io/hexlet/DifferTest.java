package io.hexlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static hexlet.code.Differ.generate;

public class DifferTest {
    private static String result;

    @BeforeAll
    public static void expected() throws IOException {
        var expected = Paths.get("src/test/resources/fixtures/filepathTest.json").toAbsolutePath().normalize();
        result = Files.readString(expected).trim();
    }

    @Test
    public void test1() throws Exception {

        var str1 = "src/test/resources/fixtures/filepath1.json";
        var str2 = "src/test/resources/fixtures/filepath2.json";
        var actual = generate(str1, str2);
        assertEquals(result, actual);
    }
}
