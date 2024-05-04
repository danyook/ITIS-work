package ru.itis.inf304.progEnikeyAuditor.u_tests.first_test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class CheckFile {

    public static int checkFile(String fileName) throws NullPointerException, IOException, IllegalArgumentException {
        if (fileName == null || fileName.isEmpty()) {
            throw new NullPointerException("Имя файла не должно быть пустым");
        }

        // Проверка наличия файла и его доступности для чтения
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Проверка текстового содержимого файла
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            for (char c : line.toCharArray()) {
                if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c) && c != '{' && c != '}' && c != '[' && c != ']') {
                    throw new IllegalArgumentException("Файл содержит недопустимые символы");
                }
            }
        }

        // Проверка корректности расстановки скобок
        int lineNumber = 0;
        int position = 0;
        while ((line = bufferedReader.readLine()) != null) {
            lineNumber++;
            for (char c : line.toCharArray()) {
                position++;
                if (c == '{' || c == '[') {
                    // Начало новой пары скобок
                    push(c);
                } else if (c == '}' || c == ']') {
                    // Конец пары скобок
                    if (!match(c)) {
                        return position + lineNumber;
                    }
                }
            }
            position = 0;  // Сброс позиции в начало строки
        }

        if (!stack.isEmpty()) {
            return position + 1;
        }

        return 0; // Все скобки корректно расставлены
    }

    private static Stack<Character> stack = new Stack<>();

    private static void push(char bracket) {
        stack.push(bracket);
    }

    private static boolean match(char bracket) {
        if (stack.isEmpty()) {
            return false;
        }
        char popped = stack.pop();
        if (bracket == '}' && popped == '{') {
            return true;
        } else if (bracket == ']' && popped == '[') {
            return true;
        }
        return false;
    }
}
