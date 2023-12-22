package ru.itis.inf304.progEnikeyDZ.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BTree {

    private int[] heap = new int[1];
    private int heapCapacity = 1;
    private int heapSize = 0;

    public int getLeftHeirPos(int position) {
        return position * 2 + 1;
    }

    public int getRightHeirPos(int position) {
        return position * 2 + 2;
    }

    public int getParentPos(int position) {
        return (position - 1) / 2;
    }
    public int getHeapSize() {
        return heapSize;
    }
    public int[] getHeap () {
        return heap;
    }

    private void swap(int position1, int position2) {
        int temp = heap[position1];
        heap[position1] = heap[position2];
        heap[position2] = temp;
    }

    private void capacityIncrease() {
        if (heapSize + 1 == heapCapacity) {
            int[] newHeap = new int[heapCapacity * 2];
            for (int i = 0; i < heapCapacity; i++) {
                newHeap[i] = heap[i];
            }
            heap = newHeap;
            heapCapacity *= 2;
        }
    }


    //метод следит, чтобы родитель всегда был больше наследников
    private void siftUp(int position) {
        while (position > 0 && heap[position] > heap[getParentPos(position)]) {
            swap(position, getParentPos(position));
            position = getParentPos(position);
        }
    }

    // метод следит, чтобы у родителя наследники стояли правильно(число слева < число справа)
//    public void sort() {
//        for (int i = 0; i < heapSize / 2 ; i++) {
//            siftUp(i);
//            if (heap[getLeftHeirPos(i)] > heap[getRightHeirPos(i)]) {
//                swap(getLeftHeirPos(i), getRightHeirPos(i));
//            }
//        }
//    }


    //добавляем элемент в кучу и перемещаем наверх до тех пор, пока родитель не станет больше этого числа
    public void add(int value) {
        capacityIncrease();
        heap[heapSize] = value;
        siftUp(heapSize);
        heapSize++;
    }

    public class HeapPrinter {
        public static String printHeapTree(int[] heap, int heapSize) {
            StringBuilder sb = new StringBuilder();
            int height = (int) (Math.log(heapSize + 1) / Math.log(2));
            int nodesAtLevel = 1;
            int maxLength = 6 * (int) Math.pow(2, height - 1);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);

            for (int i = 0; i < height; i++) {
                sb.append(indent(maxLength / (int) Math.pow(2, i + 1)));
                for (int j = 0; j < nodesAtLevel; j++) {
                    int index = queue.remove();
                    if (index < heapSize) {
                        sb.append(String.format("%-6d", heap[index]));
                        queue.add(2 * index + 1);
                        queue.add(2 * index + 2);
                    } else {
                        sb.append(" ");
                        queue.add(-1);
                        queue.add(-1);
                    }
                    sb.append(indent(maxLength / (int) Math.pow(2, i + 1) - 1));
                }
                sb.append("\n");
                nodesAtLevel *= 2;
            }
            return sb.toString();
        }

        private static String indent(int length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
    }


}
