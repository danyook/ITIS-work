package ru.itis.inf304.progEnikeyAuditor.sem2_KR2;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final String logFileName = "logv22.log";
    private static final String outputFileName = "outv22.txt";
    public static PrintWriter logWriter;
    public static ArrayList<FileContent> contents;

    public static void main(String[] args) {
        try {
            // Синхронизированный доступ к лог файлу
            logWriter = new PrintWriter(new FileWriter(logFileName), true);

            ExecutorService executorService = Executors.newFixedThreadPool(5);

            File folder = new File("cw2/v22");
            File[] listOfFiles = folder.listFiles();
            contents = new ArrayList<>();

            for (File file : listOfFiles) {
                executorService.submit(new Logging(file));
            }

            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.MINUTES);

            //cортировка содержимого файлов по номеру части
            Collections.sort(contents, (f1, f2) -> Integer.compare(f1.p, f2.p));

            // запись в результатирующий файл
            PrintWriter outputWriter = new PrintWriter(new FileWriter(outputFileName));
            for (FileContent content : contents) {
                outputWriter.println(content.s);
            }
            outputWriter.close();
            logWriter.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static FileContent readFile(File file) {
        FileContent content = new FileContent();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            content.k = dis.readInt();
            byte[] bytes = new byte[content.k];
            dis.readFully(bytes);
            content.s = new String(bytes, "UTF-8");
            content.d = dis.readInt();
            content.p = dis.readInt();
            if (content.s.length() != content.d) {
                throw new IllegalStateException("Данные не совпадают с контрольным числом.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
