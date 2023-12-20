package ru.itis.inf304.progEnikeyAuditor.LiftKR;

public class FreeElevator implements ElevatorFreeImp {

    private Node current;
    public FreeElevator() {
        Node root = new Node(Status.generateStatus());
        current = root;
        for (int i = 2; i < 4; i++) {
            current.next = new Node(Status.generateStatus());
            current = current.next;

        }
        current.next = root;
    }

    @Override
    public Status ElevatorFree() {
        current = current.next;
        Status result = current.value;
        return result;

    }

    private static class Node {
        private Node next;
        private Status value;

        public Node(Status value) {
            this.value = value;

        }
    }
}
