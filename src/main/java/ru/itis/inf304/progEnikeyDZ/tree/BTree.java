package ru.itis.inf304.progEnikeyDZ.tree;

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
    public void sort() {
        for (int i = 0; i < heapSize / 2 ; i++) {
            siftUp(i);
            if (heap[getLeftHeirPos(i)] > heap[getRightHeirPos(i)]) {
                swap(getLeftHeirPos(i), getRightHeirPos(i));
            }
        }
    }

    //добавляем элемент в кучу и перемещаем наверх до тех пор, пока родитель не станет больше этого числа
    public void add(int value) {
        capacityIncrease();
        heap[heapSize] = value;
        siftUp(heapSize);
        heapSize++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < heapSize; i *= 2) {
            for (int j = i - 1; j < i * 2 - 1 && j < heapSize; j++) {
                sb.append(" ").append(heap[j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }




}
