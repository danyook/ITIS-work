package ru.itis.inf304.progEnikeyAuditor.sem2_KR2;

import java.io.File;

import static ru.itis.inf304.progEnikeyAuditor.sem2_KR2.Main.*;

public class Logging implements Runnable {
    File file;
    public Logging(File file) {
        this.file = file;
    }
    @Override
    public void run() {
        FileContent fileContent = readFile(file);
        synchronized (logWriter) {
            logWriter.println("Прочитали файл: " + file.getName() + ", кол-во байт данных: " + fileContent.k +
                    ", кол-во считанных символов: " + fileContent.s.length() +
                    ", контрольное число: " + fileContent.d + ", номер части: " + fileContent.p);
        }
        synchronized (contents) {
            contents.add(fileContent);
        }
    }
}
