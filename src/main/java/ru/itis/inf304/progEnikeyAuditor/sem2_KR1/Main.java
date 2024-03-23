package ru.itis.inf304.progEnikeyAuditor.sem2_KR1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(new File("schedule.txt"));
        List<String> strList = new ArrayList<String>();
        while (s.hasNext()){
            strList.add(s.nextLine());
        }
        s.close();


        List<Program> listPr = new ArrayList<>();

        for (int i = 0; i < strList.size(); i++) {
            if (strList.get(i).charAt(0) == '#') {
                int count = 1;
                String channel = strList.get(i);
                while (strList.get(count).charAt(0) != '#') {
                    BroadcastsTime t = new BroadcastsTime
                            (BroadcastsTime.convertHoursToByte(strList.get(count)),BroadcastsTime.convertMinutesToByte(strList.get(count)));
                    count++;
                    String name = strList.get(count);
                    count++;
                    listPr.add(new Program(channel, t, name));
                }
            }
        }



        Map<String, List<Program>> program = new HashMap<>();

        for (int i = 0; i < listPr.size(); i++) {
            List<Program> listPrChan = new ArrayList<>();
            int count = 0;
            while (listPr.get(count).channel.equals(listPr.get(count+1).channel)) {
                listPrChan.add(listPr.get(i));
                count++;
            }
            program.put(listPr.get(i).channel, listPrChan);
        }

        for (int i = 0; i < listPr.size(); i++) {
            System.out.println(listPr.get(i).toString());
        }

        System.out.println();
        BroadcastsTime nowTime = new BroadcastsTime((byte) 4, (byte) 45);

        System.out.println("Программы начнутся сейчас");
        for (int i = 0; i < listPr.size(); i++) {
            if (listPr.get(i).time.equals(nowTime)) {
                System.out.println(listPr.get(i).toString());
            }
        }
        System.out.println();

        String needName = "Слово пастыря";

        System.out.println("Программы с названием: " + needName);
        for (int i = 0; i < listPr.size(); i++) {
            if (listPr.get(i).name.equals(needName)) {
                System.out.println(listPr.get(i).toString());
            }
        }
        System.out.println();

        String needChannel = "#Первый";
        System.out.println("Программы с канала: " + needChannel + " которые идут сейчас");
        for (int i = 0; i < listPr.size(); i++) {
            if (listPr.get(i).channel.equals(needChannel) && listPr.get(i).time.equals(nowTime)) {
                System.out.println(listPr.get(i).toString());
            }
        }
        System.out.println();

        //промежуток времени
        BroadcastsTime t1 = new BroadcastsTime((byte)1, (byte) 20);
        BroadcastsTime t2 = new BroadcastsTime((byte)16, (byte) 50);

        System.out.println("Программы с канала: " + needChannel + " которые идут в период: с " + t1.toString()+ " до " + t2.toString());
        for (int i = 0; i < listPr.size(); i++) {
            if (listPr.get(i).channel.equals(needChannel) && listPr.get(i).time.between(t1, t2)) {
                System.out.println(listPr.get(i).toString());
            }
        }

    }
}
