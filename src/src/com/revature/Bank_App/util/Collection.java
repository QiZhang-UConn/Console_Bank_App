package com.revature.Bank_App.util;

//homemade collection interface
public interface Collection<T> {
    boolean add(T element);
    boolean contains(T element);
    boolean isEmpty();
    boolean remove(T element);
    int getSize();
}
