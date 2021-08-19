package com.dsalgo.linkedlist;

public class Runner {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node head = new Node(10);
        Node newHead = list.insertAtBeginning(head, 20);
        list.printLinkedList(newHead);
        System.out.println(list.size(newHead));
    }
}
