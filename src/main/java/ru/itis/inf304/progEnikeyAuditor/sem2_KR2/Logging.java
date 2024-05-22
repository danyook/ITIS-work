package ru.itis.inf304.progEnikeyAuditor.sem2_KR2;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

import static ru.itis.inf304.progEnikeyAuditor.sem2_KR2.Main.*;

public class Logging implements Runnable {
    File file;
    private Writer writer;
    public Logging(File file, Writer writer) {
        this.file = file;
        this.writer = writer;
    }
    @Override
    public void run() {
        FileContent fileContent = readFile(file);
        synchronized (writer) {
            try {
                writer.write("Прочитали файл: " + file.getName() + ", кол-во байт данных: " + fileContent.k +
                        ", кол-во считанных символов: " + fileContent.s.length() +
                        ", контрольное число: " + fileContent.d + ", номер части: " + fileContent.p + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        synchronized (contents) {
            contents.add(fileContent);
        }
    }
}
