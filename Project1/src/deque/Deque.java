package deque;

public interface Deque<T> {

    /*
        Add element to the front of the deque. Assume x is not null.
     */
    void addFirst(T x);

    /*
        Add element to the back of the deque. Assume x is not null.
     */
    void addLast(T x);


    /*
        Return true if there are no elements in the deque and false otherwise.
     */
    boolean isEmpty();

    /*
        Return the number of elements in the deque.
     */
    int size();

    /*
        Remove the first element of the deque if it exists. Otherwise return null.
     */
    T removeFirst();

    /*
        Remove the last element of the deque if it exists. Otherwise return null.
     */
    T removeLast();

    /*
        The Deque abstract data type does not typically have a get method, but for this
        assignment we will implement it.

        Gets the element specified by the parameter index. If the index is out of bounds, return null.
     */
    T get(int index);

    /*
        Prints the contents of the deque.
     */
    void printDeque();

}
