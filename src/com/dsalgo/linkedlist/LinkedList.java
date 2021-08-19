package com.dsalgo.linkedlist;

public class LinkedList {

    public void insert(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            newNode = head;
        } else {
            Node currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
    }

    public Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        newNode.setNext(head);
        return newNode;
    }

    //Traversing linkedlist to print the data.
    public void printLinkedList(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            //Go to next node
            currentNode = currentNode.getNext();
        }
    }

    public int size(Node head) {
        Node currentNode = head;
        int counter = 0;
        while (currentNode != null) {
            counter++;
            currentNode = currentNode.getNext();
        }
        return counter;
    }

}
