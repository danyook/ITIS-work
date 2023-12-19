package ru.itis.inf304.progEnikeyAuditor.PizzeriaKR;

import ru.itis.inf304.progEnikeyDZ.list.linkedList.IntLinkedList;

public class NextNumberImp implements NextNumber {
    private Node current;

    public NextNumberImp() {
        Node root = new Node(1);
        current = root;
        for (int i = 2; i < 11; i++) {
            current.next = new Node(i);
            current = current.next;

        }
        current.next = root;
    }

    @Override
    public int next() {
        current = current.next;
        int result = current.value;
        return result;

    }

    private static class Node {
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;

        }
    }
}
