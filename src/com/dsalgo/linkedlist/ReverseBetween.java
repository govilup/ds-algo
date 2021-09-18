package com.dsalgo.linkedlist;

public class ReverseBetween {

    public Node reverseBetween(Node A, int B, int C) {
        if(A == null || A.getNext() == null) {
            return A;
        }
        Node first = A;
        Node last = A;

        int count = 1;
        while(first != null && count < B - 1) {
            first = first.getNext();
            count++;
        }

        count = 1;

        while(last.getNext() != null && count <= C ) {
            count++;
            if(count == C) {
                break;
            }
            last = last.getNext();
        }

        if(last.getNext() != null) {
            last = last.getNext();
        }

        Node current = first.getNext();
        Node next = null;
        Node prev = null;

        count = 1;
        while(current != null && count <= C) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            count++;
        }

        first.setNext(prev);
        if(current != null) {
            current.setNext(last);
        }

        return A;
    }
}
