package ru.itis.inf304.progEnikeyAuditor.u_tests.first_test;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CheckFileTest {

    @Test
    public void testCheckFile() {
        String fileName = "valid.json";
        assertDoesNotThrow(() -> {
            int result = CheckFile.checkFile(fileName);
            assertEquals(0, result);
        });
    }

    @Test
    public void testEmptyFileName() {
        String fileName = "";
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            CheckFile.checkFile(fileName);
        });
        assertEquals("Имя файла не должно быть пустым", exception.getMessage());
    }

    @Test
    public void testNonExistentFile() {
        String fileName = "nonexistent.json";
        IOException exception = assertThrows(IOException.class, () -> {
            CheckFile.checkFile(fileName);
        });
        assertEquals("Файл не найден", exception.getMessage());
    }

    @Test
    public void testInvalidCharactersInFile() {
        String fileName = "invalidCharacters.json";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CheckFile.checkFile(fileName);
        });
        assertEquals("Файл содержит недопустимые символы", exception.getMessage());
    }

    @Test
    public void testIncorrectBracketsPosition() throws IOException {
        String fileName = "incorrectBrackets.json";
        int result = CheckFile.checkFile(fileName);
        assertEquals(15, result); // Предположим, что проблема начинается с символа под номером 15
    }
}
