package datastructures.lists;

import datastructures.interfaces.List;

import java.util.Arrays;

public class CustomArrayList<T> implements List<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public CustomArrayList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    @Override
    public T get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("This index is not correct.");
        }
        return (T)elements[index];
    }

    @Override
    public T set(int index, T element){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("This index is not correct.");
        }

        elements[index] = element;
        return element;
    }

    @Override
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Object o){
        if (o == null){
            throw new NullPointerException("This object is null.");
        }
        size ++;
        ensureCapacity();
        elements[size - 1] = o;
        return true;
    }

    @Override
    public boolean remove(Object o){
        if (o == null){
            throw new NullPointerException("This object is null.");
        }

        for (int i = 0; i < size; ++ i){
            if (o.equals(elements[i])){
                for (int j = i; j < size - 1; ++ j){
                    elements[j] = elements[j + 1];
                }
                size --;
                return true;
            }
        }
        return false;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean contains(Object o){
        for (Object O : elements){
            if(o.equals(O)){
                return true;
            }
        }
        return false;
    }

}