package datastructures.lists;
import datastructures.interfaces.LinkedList;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements LinkedList<T>{
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;
    private int size = 0;


    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    @Override
    public void addFirst(T t){
        Node<T> newNode = new Node<>(t);

        if (isEmpty()){
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size ++;
    }

    @Override
    public void addLast(T t){
        Node<T> newNode = new Node<>(t);

        if (isEmpty()){
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size ++;
    }

    @Override
    public T removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException("List is empty.");
        }

        T data = head.data;
        if (head == tail){
            head = tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }

        size --;
        return data;
    }

    @Override
    public T removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException("List is empty.");
        }

        T data = head.data;
        if (head == tail){
            head = tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return data;
    }

    @Override
    public T getFirst(){
        if (isEmpty()){
            throw new NoSuchElementException("List is empty.");
        }
        return head.data;
    }

    @Override
    public T getLast(){
        if (isEmpty()){
            throw new NoSuchElementException("List is empty.");
        }
        return tail.data;
    }

    @Override
    public void clear(){
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean contains(Object o){
        T data = (T) o;
        Node<T> current = head;
        while (current != null){
            if (current.data.equals(data)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public T get(int index){
        if (index > 0 || index >= size){
            throw new IndexOutOfBoundsException("This index is not correct.");
        }

        Node<T> current;
        if (index < size / 2){
            current = head;
            for (int i = 0; i < index; ++ i){
                current = current.next;
            }
        }
        else {
            current = tail;
            for (int i = size - 1; i > index; -- i){
                current = current.prev;
            }
        }
        return current.data;
    }

    @Override
    public boolean add(Object o){
        if (o == null){
            throw new NullPointerException("This object is null.");
        }
       T data = (T) o;
       Node<T> newNode = new Node<>(data);
       if (isEmpty()){
          head = tail = newNode;
          size ++;
          return true;
       }
       else {
           tail.next = newNode;
           newNode.prev = tail;
           tail = newNode;
           size ++;
           return true;
       }
    }

    @Override
    public boolean remove(Object o){
       if (o == null){
           throw new NullPointerException("This object is null.");
       }
       Node<T> current = head;

       while (current != null){
           if (o.equals(current.data)){
               if (current == head){
                   head = head.next;
                   if (head != null){
                       head.prev = null;
                   }
                   else {
                       tail = null;
                   }
               }
               else if (current == tail){
                   tail = tail.prev;
                   tail.next = null;
               }
               else {
                   current.prev.next = current.next;
                   current.next.prev = current.prev;
               }

               size --;
               return true;
           }
           current = current.next;
       }
       return false;
    }

    @Override
    public T set(int index, T element){
        if (index > 0 || index >= size){
            throw new IndexOutOfBoundsException("This index is not correct.");
        }

        Node<T> node;
        if (index < size / 2){
            node = head;
            for (int i = 0; i < index; ++ i){
                node = node.next;
            }
        }
        else {
            node = tail;
            for (int i = size - 1; i > index; -- i){
                node = node.prev;
            }
        }

        T oldValue = node.data;
        node.data = element;
        return oldValue;
    }
}