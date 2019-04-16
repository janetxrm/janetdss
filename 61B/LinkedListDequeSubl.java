public class LinkedListDeque<blah> {

    private class StuffNode {
        public StuffNode prev;
        public blah item;
        public StuffNode next;
    }

//constructor (initializes instance of class)
    public void StuffNode(StuffNode prev, blah item, StuffNode next) {
        this.prev = prev;
        this.item = item;
        this.next = next;
        }

    private StuffNode sentinel;
        private int size;

    public void addFirst(blah x){
//item after x is now the new sentinel.next
        sentinel.next = new StuffNode(sentinel, x, sentinel.next);
//        sentinel.item =
//        sentinel.prev =
        size += 1;
    }

    public void addLast(blah x){
//sentinel.prev will always point to last item in list; it's now the last item in list
        sentinel.prev = new StuffNode(sentinel.prev.prev, x, sentinel);
        size += 1;
    }


//what do you even pass in to parameter?
    public boolean isEmpty(){
        return sentinel.next == null;
    }
//        if (sentinel.next == null) {
//            return True;
//        }
//    return False;
//    }

//if it's circular then can you still do while p != null? cuz prev for sent is null right
    public int size(){
        StuffNode p = this;
        blah totalSize = 0;
//while the last item does not circle back to sentinel
        while (sentinel.prev != sentinel){
            totalSize += 1;
            p = p.next;
        }
        return totalSize;
    }

//size using iteration
//    public int iterativeSize() {
//        IntList p = this;
//        int totalSize = 0;
//        while (p != null) {
//            totalSize += 1;
//            p = p.rest;
//        }
//        return totalSize;
//    }

    public void printDeque(){
        StuffNode p = this;

        while (sentinel.prev != sentinel) {
            system.out.print(p + " " + p.next);
            p = p.next;
        }
        return system.out.println;
    }


//thing after sentinel is first item
    public blah removeFirst(){
//change what sentinel is pointing to to the item after the first item
        sentinel.next = sentinel.next.next;
        return sentinel.next.item;
    }


    public blah removeLast(){
        sentinel.prev = sentinel.prev.prev;
        return sentinel.prev;
    }


//must use iteration, not recursion
//returns null when no such item exists
    public blah get(int index) {
        StuffNode p = this;
        while (index != size) {
            size -= 1;
            p = p.next;
        }
        return blah[index];

    }



//youtube video; create empty linked list deque
    public LinkedListDeque(){
        sentinel = new StuffNode(blah, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

//youtube video; deep copy of other
    public LinkedListDeque(LinkedListDeque other){
        sentinel = new StuffNode(blah, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i += 1) {
            addLast((blah) other.get(i));
        }
    }


    //same as get but with recursion
    public blah getRecursive(int index){
        if (index == size) {
            return blah[index];
        }
        if (index > size){
            return null;
        }
        size -= 1;
        return getRecursive(index);
    }


}


