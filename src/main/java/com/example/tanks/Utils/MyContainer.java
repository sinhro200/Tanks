package com.example.tanks.Utils;


import java.util.LinkedList;
import java.util.List;

public class MyContainer<T> {
    private List<T> elements;
    private List<T> elementsToAdd;
    private List<T> elementsToRemove;

    public MyContainer() {
        elements = new LinkedList<>();
        elementsToAdd = new LinkedList<>();
        elementsToRemove = new LinkedList<>();
    }

    public List<T> get(){
        elements.addAll(elementsToAdd);
        elements.removeAll(elementsToRemove);
        elementsToAdd.clear();
        elementsToRemove.clear();
        return elements;
    }
    public void add(T elem){
        elementsToAdd.add(elem);
    }

    public void remove(T elem){
        elementsToRemove.add(elem);
    }
}
