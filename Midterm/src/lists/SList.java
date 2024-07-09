package lists;

public class SList {
    private class ListNode{
        int item;
        ListNode next;

        private ListNode(int value){
            this.item = value;
            this.next = null;
        }

        private ListNode(int value, ListNode next){
            this.item = value;
            this.next = next;
        }
    }

    ListNode sentinelNode;
    int listSize;
    public SList(){
        sentinelNode = new ListNode(-1);
        listSize = 0;
    }
    public SList(int value){
        ListNode headNode = new ListNode(value);
        sentinelNode = new ListNode(Integer.MAX_VALUE, headNode);
        listSize = 1;
    }

    public void addFirst(int value){
        if(sentinelNode.next == null){
            sentinelNode.next = new ListNode(value);
        } else {
            ListNode currentHead = sentinelNode.next;
            ListNode newheadNode = new ListNode(value, currentHead);
            sentinelNode.next = newheadNode;
        }
        listSize += 1;
    }

    public int size(){
        return listSize;
    }

    /*
        Question 5.
     */
    public void filterValues(Comparable lowerBound, Comparable upperBound) {
        // TODO
    }

    /*
       Question 6.
    */
    public void compressNodes() {
        if(size() <= 1) {
            return;
        }
        ListNode currentNode = sentinelNode.next;
        ListNode runnerNode = currentNode;
        while(runnerNode != null) {
            runnerNode = currentNode.next;
            int currentValue = currentNode.item;

            while (runnerNode != null && runnerNode.item == currentNode.item) {
                currentValue += runnerNode.item;
                runnerNode = runnerNode.next;
                currentNode.next = runnerNode;
            }
            currentNode.item = currentValue;
            currentNode = runnerNode;
        }
    }
    public boolean equals(Object o) {
        if(o == null){
            return false;
        } else if(!(o instanceof SList)) {
            return false;
        }

        ListNode currentRunner = this.sentinelNode.next;
        ListNode oRunner = ((SList) o).sentinelNode.next;
        while(currentRunner != null && oRunner != null) {
            if(currentRunner.item != oRunner.item) {
                return false;
            }
            currentRunner = currentRunner.next;
            oRunner = oRunner.next;
        }

        if(currentRunner == null && oRunner == null) {
            return true;
        }
        return false;
    }

    public String toString(){
        StringBuilder stringRepr = new StringBuilder();
        ListNode runner = sentinelNode.next;
        while(runner != null){
            stringRepr.append(runner.item);
            if(runner.next != null){
                stringRepr.append(",");
            }
            runner = runner.next;
        }
        return stringRepr.toString();
    }
}

