package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T>{
    private int listSize;
    private int front;
    private int back;
    private T[] elements;
    private static final int INITIAL_CAPACITY = 8;

    public ArrayDeque(){
        this.elements = (T[]) new Object[INITIAL_CAPACITY];
        front = 0;
        back = 0;
        listSize = 0;
    }

    public void addFirst(T value){
        int capacity = elements.length;
        if(listSize == capacity){
            resize(true);
        }

        capacity = elements.length;
        if(listSize == 0){
            front = 0;
            back = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }
        elements[front] = value;
        listSize += 1;

    }

    public void addLast(T value){
        int capacity = elements.length;
        if(listSize == capacity){
            resize(true);
        }

        capacity = elements.length;
        if(listSize == 0){
            front = 0;
            back = 0;
        } else {
            back = (back + 1) % capacity;
        }
        elements[back] = value;
        listSize += 1;
    }

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        int capacity = elements.length;

        T valToReturn = get(0);
        elements[front] = null;
        listSize -= 1;
        front = (front + 1) % capacity;
        double usageRatio = (double) listSize / capacity;

        if(capacity >= 16 && usageRatio < .25){
            resize(false);
        }
        return valToReturn;
    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        int capacity = elements.length;

        T valToReturn = get(listSize - 1);
        elements[back] = null;
        listSize -= 1;
        back = (back - 1 + capacity) % capacity;
        double usageRatio = (double) listSize / capacity;

        if(capacity >= 16 && usageRatio < .25){
            resize(false);
        }
        return valToReturn;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return listSize;
    }

    public T get(int i){
        int capacity = elements.length;;
        if(i < 0 || i > listSize){
            return null;
        }

        return elements[(front + i) % capacity];
    }

    public void resize(boolean expandFlag){
        int currentCapacity = elements.length;
        int newCapacity;
        T[] newElements;

        if(expandFlag){
            newCapacity = currentCapacity * 2;
            newElements = (T[]) new Object[newCapacity];
        } else {
            newCapacity = (int)(currentCapacity * .5);
            newElements = (T[]) new Object[newCapacity];
        }

        for(int i = 0; i < listSize; i++){
            newElements[i] = get(i);
        }
        elements = newElements;
        front = 0;
        back = listSize - 1;
    }

    public static class ArrayDequeIterator<T> implements Iterator<T> {
        private int runner;
        private int elementsProcessed = 0;
        private int listSize;
        private T[] iteratorElements;
        private ArrayDequeIterator(int front, int listSize, T[] elements){
            this.runner = front;
            this.listSize = listSize;
            this.iteratorElements = elements;
            this.elementsProcessed = 0;
        }

        public boolean hasNext(){
            return elementsProcessed < listSize;
        }

        public T next(){
            int capacity = iteratorElements.length;
            T value = iteratorElements[runner];
            runner = (runner + 1) % capacity;
            elementsProcessed += 1;
            return value;
        }


    }

    public void printDeque(){
        return;
    }

    public ArrayDequeIterator<T> iterator(){
        return new ArrayDequeIterator(front, listSize, elements);
    }
}
