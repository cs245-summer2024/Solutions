package lists;
import java.util.EmptyStackException;
import java.util.Stack;
public class MaxStack<T extends Comparable> {
    private Stack<T> maxValueStack;
    private Stack<T> bufferStack;

    public MaxStack() {
        maxValueStack = new Stack<T>();
        bufferStack = new Stack<T>();
    }

    public T pop() {
        if(maxValueStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return maxValueStack.pop();
    }

    public void push(T value) {
        while(!maxValueStack.isEmpty() && maxValueStack.peek().compareTo(value) >= 0) {
            bufferStack.push(maxValueStack.pop());
        }
        maxValueStack.push(value);
        while(!bufferStack.isEmpty()) {
            maxValueStack.push(bufferStack.pop());
        }
    }

    public boolean isEmpty() {
        return maxValueStack.isEmpty();
    }
}
