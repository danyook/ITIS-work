package ru.itis.inf304.progEnikeyAuditor.singletone;

import java.io.*;

public class SingletoneExample {

    private static SingletoneExample instance;

    private SingletoneExample() {}

    public static SingletoneExample getInstance() {
        if (instance == null) {
            synchronized (SingletoneExample.class) {
                if (instance == null) {
                    instance = new SingletoneExample();
                }
            }
        }
        return instance;
    }

    // Метод для чтения из файла
    public String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    // Метод для записи в файл
    public void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

