package lists;

public class DList<T> {
    private class DListNode {
        DListNode prev;
        DListNode next;
        T item;
        private DListNode(T value){
            this.item = value;
            this.prev = null;
            this.next = null;
        }

        private DListNode(T value, DListNode prev, DListNode next){
            this.item = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private DListNode sentFront;
    private DListNode sentBack;
    private int listSize;

    public DList(T value){
        sentFront = new DListNode(null);
        sentBack = new DListNode(null);

        DListNode headNode = new DListNode(value, sentFront, sentBack);

        sentFront.next = headNode;
        sentBack.prev = headNode;
        listSize = 1;
    }

    public DList(){
        sentFront = new DListNode(null);
        sentBack = new DListNode(null, sentFront, null);
        sentFront.next = sentBack;
        listSize = 0;
    }

    public void insertElement(int index, T value){
        if(index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of bounds for list of size " + size());
        } else {
            DListNode runner = sentFront.next;
            int runnerCount = 0;
            while(runnerCount < index) {
                runner = runner.next;
                runnerCount += 1;
            }

            DListNode prevNode = runner.prev;
            DListNode nodeToInsert = new DListNode(value, prevNode, runner);
            prevNode.next = nodeToInsert;
            runner.prev = nodeToInsert;
            listSize += 1;
        }
    }

    /*
        Question 7
     */
    public T get(int index) {
        if(index >= 0 && index >= size()) {
            String message = "Index %d out of bounds for list of size %d";
            throw new IndexOutOfBoundsException(String.format(message, index, size()));
        } else if(index < 0 && Math.abs(index) > size()) {
            String message = "Index %d out of bounds for list of size %d";
            throw new IndexOutOfBoundsException(String.format(message, index, size()));
        }

        int counter;
        DListNode runner;
        if(index >= 0) {
            counter = 0;
            runner = sentFront.next;
            while(counter < index) {
                runner = runner.next;
                counter += 1;
            }
        } else {
            counter = 1;
            runner = sentBack.prev;
            while(counter < Math.abs(index)) {
                runner = runner.prev;
                counter += 1;
            }
        }
        return runner.item;
    }

    public int size(){
        return listSize;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        DListNode runner = sentFront.next;
        while(runner != sentBack){
            result.append(runner.item);
            runner = runner.next;
            if(runner != sentBack){
                result.append(",");
            }
        }
        return result.toString();
    }
}
