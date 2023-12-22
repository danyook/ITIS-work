package ru.itis.inf304.progEnikeyDZ.tree;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BTree heap = new BTree();
        for (int i = 0; i < 31; i++) {
            heap.add((int)(Math.random() * 1000) + 1);
        }

        System.out.println(heap);
        heap.sort();
        System.out.println(heap);
    }
}
