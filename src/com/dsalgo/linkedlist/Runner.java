package com.dsalgo.linkedlist;

public class Runner {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node head = new Node(1);
        list.insert(head, 2);
        list.insert(head, 3);
//        list.insert(head, 42);
//        list.insert(head, 73);
//        list.insert(head, 25);
//        list.insert(head, 84);
//        list.insert(head, 63);
//        list.insert(head, 72);
//        list.insert(head, 20);
//        list.insert(head, 77);
//        list.insert(head, 38);
//        list.insert(head, 8);
//        list.insert(head, 99);
//        list.insert(head, 92);
//        list.insert(head, 49);
//        list.insert(head, 74);
//        list.insert(head, 45);
//        list.insert(head, 30);
//        list.insert(head, 51);
//        list.insert(head, 50);
//        list.insert(head, 95);
//        list.insert(head, 56);
//        SortLinkedList sortLinkedList = new SortLinkedList();
//        list.printLinkedList(sortLinkedList.sortList(head));

        //list.insert(head, 4);
       // System.out.println("***************************");
        //list.printLinkedList(list.reverse(head));
        //System.out.println("");
        //System.out.println("***************************");
        /*Node removeNthNode = list.removeNthNodeFromEnd(head, 1);
        System.out.println("***************************");
        list.printLinkedList(removeNthNode);*/
        //System.out.println(list.isPalindrome(head));
        //list.printLinkedList(head);

        ReverseBetween reverseBetween = new ReverseBetween();
        reverseBetween.reverseBetween(head, 1, 2);
    }
  /*  [ 5 -> 66 -> 68 -> 42 -> 73 -> 25 -> 84 -> 63 -> 72 -> 20 -> 77 -> 38 -> 8 -> 99 -> 92 -> 49 -> 74 -> 45 -> 30 -> 51 -> 50 -> 95 -> 56 -> 19 -> 31 -> 26 ->
            98 -> 67 -> 100 -> 2 -> 24 -> 6 -> 37 -> 69 -> 11 -> 16 -> 61 -> 23 -> 78 -> 27 -> 64 -> 87 -> 3 -> 85 -> 55 -> 22 -> 33 -> 62 ]*/
}
