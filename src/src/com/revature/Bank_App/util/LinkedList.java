package com.revature.Bank_App.util;

public class LinkedList<T> implements List<T> {

    private int size;
    private Node<T> head; // implicitly null
    private Node<T> tail = null; // you can explicitly declare them as null, but it's not required.


    //singly-linked-list
    private static class Node<T> {
        //each node contains piece of data, and a pointer to next node
        T data;
        Node<T> nextNode;

        //constructor takes a value to work
        public Node(T data) {
            this.data = data;
        }
    }


    @Override
    public boolean add(T data) {
        // Not required, as some data structures do allow for null values.
        if (data == null) {
            return false;
        }
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            tail = head = newNode;
        } else {
            tail = tail.nextNode = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean contains(T data) {

        Node<T> runner = head;
        while (runner != null) {
            if (runner.data.equals(data)) {
                return true;
            }
            runner = runner.nextNode;
        }

        // No node with matching data was found
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(T data) {
        //idea: since it's singly-linked, we always scan one after the next
        Node<T> runner = head;
        if (runner.data.equals(data)){
            head=head.nextNode;
            size--;
        }
        while (runner.nextNode !=null) {
            if (runner.nextNode.data.equals(data)) {
                runner.nextNode = runner.nextNode.nextNode;
                size--;
            }
            runner = runner.nextNode;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if (index<0 || index>size){
            throw new RuntimeException("index value out of bound");
        }
        int i=0;
        Node<T> runner=head;
        while(runner.nextNode!=null){
            if (i==index){
                return runner.data;
            }
            i++;
        }
        return null;
    }



}