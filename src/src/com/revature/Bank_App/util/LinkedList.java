package com.revature.Bank_App.util;

//homemade generic Singly-Linked-List ADT
public class LinkedList<T> implements List<T> {

    //a linked-list holds its size, and keeps a record of head and tail
    private int size;
    private Node<T> head;
    private Node<T> tail;


    //singly-linked-list-Node type
    private static class Node<T> {
        //each node contains piece of data, and a pointer to next node
        T data;
        Node<T> nextNode;

        //constructor takes a value that can assign to its data cell
        public Node(T data) {
            this.data = data;
        }
    }


    @Override //overriding interface function add
    public boolean add(T data) {

        //if inserted data is null, then return false to indicate fail add
        if (data == null) {return false;}

        //otherwise, instantiate a new node and add
        Node<T> newNode = new Node<T>(data);
        if (head == null) { //if head is null the added node will be head and tail at the same time
            tail = head = newNode;
        } else {
            tail = tail.nextNode = newNode;//else append new node after tail and assign new tail
        }
        size++;//keep on track of size of linked list
        return true;
    }



    @Override//Overriding interface function of contains
    public boolean contains(T data) {

        //simply create a runner's node and loop around to compare each node's data with given
        Node<T> runner = head;
        while (runner != null) {
            if (runner.data.equals(data)) {
                return true;// linked-list contains desired node
            }
            runner = runner.nextNode;
        }
        return false;//the linked-list doesn't contain desired node
    }



    @Override//Overriding interface function of isEmpty()
    public boolean isEmpty() {
        return size == 0;
    }//since we keep on track of size, just check if size==0



    @Override//Overriding interface function of remove
    public boolean remove(T data) {
        if (data==null){return false;}//if removing null, simply don't continue
        /*
            idea: since it's singly-linked-list, we can't easily get previous node. We then choose to scan
            a node after next, so we have three nodes on track of at the same time. Compare the middle node
            to see if we want to delete it
        */
        Node<T> runner = head;
        //this idea needs to handle the special case of first node, check if first node is the one need to delete
        if (runner.data.equals(data)){
            head=head.nextNode;
            size--;
            return true;
        }
        while (runner.nextNode !=null) {
            if (runner.nextNode.data.equals(data)) {
                runner.nextNode = runner.nextNode.nextNode;
                size--;
                return true;
            }
            runner = runner.nextNode;
        }
        return false;
    }



    @Override //overriding interface function get size
    public int getSize() {return size;}



    @Override //overriding parent function of get by passing index
    public T get(int index) {
        if (index<0 || index>size){//providing index out of bound, no need to continue
            throw new RuntimeException("index value out of bound");
        }
        //otherwise, we loop around until the desired node
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