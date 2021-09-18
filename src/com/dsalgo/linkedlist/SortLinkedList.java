package com.dsalgo.linkedlist;

public class SortLinkedList {

    public Node sortList(Node A) {
        return mergeSort(A);
    }

    private Node mergeSort(Node head) {
        if(head == null || head.getNext() == null) {
            return head;
        }

        Node middleNode = getMiddleNode(head);
        Node nextOfMiddleNode = middleNode.getNext();

        middleNode.setNext(null);

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddleNode);

        return mergeTwoSortedNodes(left, right);

    }

    private Node mergeTwoSortedNodes(Node left, Node right) {
       Node preHead = new Node(0);
       Node currentNode = preHead;

       while(left != null && right != null) {
           if(left.getData() < right.getData()) {
               currentNode.setNext(left);
               left = left.getNext();
           } else {
               currentNode.setNext(right);
               right = right.getNext();
           }
           currentNode = currentNode.getNext();
       }

       while(left != null) {
           currentNode.setNext(left);
           left = left.getNext();
           currentNode = currentNode.getNext();
       }

        while(right != null) {
            currentNode.setNext(right);
            right = right.getNext();
            currentNode = currentNode.getNext();
        }

        return preHead.getNext();
    }

    private Node getMiddleNode(Node head) {
        if(head == null) {
            return head;
        }
        Node slowPtr = head, fastPtr = head;
        while(fastPtr.getNext() != null && fastPtr.getNext().getNext() != null) {
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
        }
        return slowPtr;
    }
}
