package lists;

public class PromotionQueue<T> {
    private class QueueNode {
        QueueNode prev;
        QueueNode next;
        T item;
        private final int nodeId;
        private QueueNode(T value, int id){
            this.item = value;
            this.prev = null;
            this.next = null;
            this.nodeId = id;
        }
    }

    private QueueNode sentFront;
    private QueueNode sentBack;
    private int listSize;

    public PromotionQueue(){
        sentFront = new QueueNode(null, -1);
        sentBack = new QueueNode(null, -1);
        sentFront.next = sentBack;
        sentBack.prev = sentFront;
        listSize = 0;
    }

    public void addFront(T value){
        QueueNode node = new QueueNode(value, listSize + 1);
        QueueNode currentHead = sentFront.next;

        node.next = currentHead;
        currentHead.prev = node;

        node.prev = sentFront;
        sentFront.next = node;
        listSize += 1;
    }

    public void addBack(T value){
        QueueNode node = new QueueNode(value, listSize + 1);
        QueueNode currentTail = sentBack.prev;

        node.next = sentBack;
        currentTail.next = node;

        node.prev = currentTail;
        sentBack.prev = node;
        listSize += 1;
    }

    public void promote(int indexToPromote) {
        if(indexToPromote < 0 || indexToPromote >= listSize) {
            throw new IndexOutOfBoundsException("Index out of bounds for list of size " + size());
        }
        QueueNode nodeToPromote = getNode(indexToPromote);
        if(nodeToPromote.prev != sentFront) {
            QueueNode nodeToDemote = nodeToPromote.prev;
            adjustPointers(nodeToPromote, nodeToDemote);
        }
    }

    public void demote(int indexToDemote) {
        if(indexToDemote < 0 || indexToDemote >= listSize) {
            throw new IndexOutOfBoundsException("Index out of bounds for list of size " + size());
        }
        QueueNode nodeToDemote = getNode(indexToDemote);
        if(nodeToDemote.next != sentBack) {
            QueueNode nodeToPromote = nodeToDemote.next;
            adjustPointers(nodeToPromote, nodeToDemote);
        }
    }

    public void adjustPointers(QueueNode nodeToPromote, QueueNode nodeToDemote) {
        nodeToPromote.prev = nodeToDemote.prev;
        nodeToPromote.prev.next = nodeToPromote;

        nodeToDemote.next = nodeToPromote.next;
        nodeToDemote.next.prev = nodeToDemote;

        nodeToPromote.next = nodeToDemote;
        nodeToDemote.prev = nodeToPromote;
    }

    public QueueNode getNode(int idx) {
        int nodeIdx = 0;
        QueueNode runner = sentFront.next;
        while(nodeIdx < idx) {
            runner = runner.next;
            nodeIdx += 1;
        }
        return runner;
    }
    public int size() {
        return listSize;
    }

    /*
        Do not modify this method in any way
     */
    public String toString(){
        StringBuilder stringRepr = new StringBuilder();
        QueueNode runner = sentFront.next;
        while(runner != sentBack){
            String nodeRepr = "ID:" + runner.nodeId + "-" + runner.item;
            stringRepr.append(nodeRepr);
            if(runner.next != sentBack){
                stringRepr.append(", ");
            }
            runner = runner.next;
        }
        return stringRepr.toString();
    }
}
