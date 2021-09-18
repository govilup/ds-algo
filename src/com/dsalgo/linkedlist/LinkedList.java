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

    public Node deleteAtPosition(Node head, int position) {
        Node currentNode = head;
        Node prevNode = null;

        if(position == 0 && currentNode != null) {
            head = currentNode.getNext();
            return head;
        }

        int positionLocator = 0;
        while(currentNode != null) {
            if(positionLocator == position) {
                prevNode.setNext(currentNode.getNext());
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
            positionLocator++;
        }
        return head;
    }

    public Node reverse(Node head) {
        Node currentNode = head;
        Node next = null;
        Node prev = null;

        while(currentNode != null) {
            next = currentNode.getNext();
            currentNode.setNext(prev);
            prev = currentNode;
            currentNode = next;
        }
        head = prev;
        return head;
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

    public Node removeNthNodeFromEnd(Node head, int n) {
        Node first = head;
        Node second = head;

        for(int i = 0; i < n; i++) {
            if(second.getNext() == null) {
                    head = head.getNext();
                    return head;
            }
            second = second.getNext();
        }

        while(second.getNext() != null) {
            second = second.getNext();
            first = first.getNext();
        }

        first.setNext(first.getNext().getNext());

        return head;
    }

    public Node reverseTillNode(Node head, int n) {
        Node currentNode = head;
        Node prev = null;
        Node next = null;
        int i = 0;
        while(currentNode != null && i < n) {
            next = currentNode.getNext();
            currentNode.setNext(prev);
            prev = currentNode;
            currentNode = next;
            i++;
        }
        head = prev;
        return head;
    }

    public Node reverseUsingSplit(Node head, int n) {
        Node currentNode = head;
        Node prev = null;
        Node next = null;

        int count = 0;
        while(currentNode != null && count < n) {
            next = currentNode.getNext();
            currentNode.setNext(prev);
            prev = currentNode;
            currentNode = next;
            count++;
        }

        if(next != null) {
            head.setNext(reverseUsingSplit(next, n));
        }

        return prev;
    }

    public boolean isPalindrome(Node head) {
       /*String llData = readLL(head);
       Node reverseLL = reverse(head);
       String reversedData = readLL(reverseLL);
       return llData.equals(reversedData);*/
       Node slow = head;
       Node fast = head.getNext();

       while(fast != null && fast.getNext() != null) {
           slow = slow.getNext();
           fast = fast.getNext().getNext();
       }

       Node head1 = reverse(slow);
       Node head2 = head;

       return compare(head1, head2);
    }

    private boolean compare(Node head1, Node head2) {
        while(head1 != null) {
            if(head1.getData() == head2.getData()) {
                head1 = head1.getNext();
                head2 = head2.getNext();
                continue;
            }
            return false;
        }
        return true;
    }

    public String readLL(Node head) {
        Node currentNode = head;
        StringBuilder sb = new StringBuilder();
        while(currentNode != null) {
            sb.append(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        return sb.toString();
    }

}
