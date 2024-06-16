package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T>{
    private class ListNode<T> {
        ListNode prev;
        ListNode next;
        T value;

        private ListNode(T value){
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        private ListNode(T value, ListNode prev, ListNode next){
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public class LinkedListDequeIterator<T> implements Iterator<T>{
        ListNode runner;

        private LinkedListDequeIterator(ListNode headNode){
            runner = headNode;
        }

        public boolean hasNext(){
            return runner != sentinelTail;
        }

        public T next(){
            T value = (T) runner.value;
            runner = runner.next;
            return (T) value;
        }
    }

    ListNode sentinelHead;
    ListNode sentinelTail;
    int listSize;

    public LinkedListDeque(){
        sentinelHead = new ListNode<>(-1);
        sentinelTail = new ListNode<>(-1);
        sentinelHead.next = sentinelTail;
        sentinelTail.prev = sentinelHead;
    }

    @Override
    public void addFirst(T value){
        ListNode currentHead = sentinelHead.next;
        ListNode newHead = new ListNode(value, sentinelHead, currentHead);
        currentHead.prev = newHead;
        sentinelHead.next = newHead;
        listSize += 1;
    }

    @Override
    public void addLast(T value){
        ListNode currentTail = sentinelTail.prev;
        ListNode newTail = new ListNode(value, currentTail, sentinelTail);
        currentTail.next = newTail;
        sentinelTail.prev = newTail;
        listSize += 1;
    }

    @Override
    public boolean isEmpty(){
        return size() == 0;
    }

    @Override
    public int size(){
        return listSize;
    }

    public String toString(){
        StringBuilder stringRepr = new StringBuilder();
        ListNode runner = sentinelHead.next;
        while(runner != sentinelTail){
            stringRepr.append(runner.value);
            if(runner.next != sentinelTail){
                stringRepr.append(" ");
            }
            runner = runner.next;
        }
        return stringRepr.toString();
    }

    @Override
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        ListNode currentHead = sentinelHead.next;
        ListNode newHead = currentHead.next;
        newHead.prev = sentinelHead;
        sentinelHead.next = newHead;
        currentHead.next = null;
        currentHead.prev = null;
        listSize -= 1;

        return (T) currentHead.value;
    }
    @Override
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        ListNode currentTail = sentinelTail.prev;
        ListNode newTail = currentTail.prev;
        newTail.next = sentinelTail;
        sentinelTail.prev = newTail;
        currentTail.prev = null;
        currentTail.next = null;
        listSize -= 1;

        return (T) currentTail.value;
    }

    @Override
    public T get(int index){
        if(index < 0 || index >= size()){
            return null;
        }
        int nodeIdx = 0;
        ListNode runner = sentinelHead.next;
        while(nodeIdx < index){
            runner = runner.next;
            nodeIdx += 1;
        }
        return (T) runner.value;
    }

    @Override
    public void printDeque(){
        System.out.println("hello");
    }

    public LinkedListDequeIterator<T> iterator(){
        return new LinkedListDequeIterator<>(sentinelHead.next);
    }
}
