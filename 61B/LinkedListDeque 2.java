public class LinkedListDeque<T> {

    private class BlahNode {
        private BlahNode prev;
        private T item;
        private BlahNode next;


//constructor (initializes instance of class)
        BlahNode(BlahNode prev, T item, BlahNode next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private BlahNode sentinel;
    private int size;

//@source Josh Hug.
//youtube video; deep copy of other
    //other can hold any generic item; users should only copy to other when same type
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new BlahNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i += 1) {
            addLast((T) other.get(i));
        }
    }


    public void addFirst(T x) {
//item after x is now the new sentinel.next
//        BlahNode newBlahfirst = new BlahNode(sentinel, x, sentinel.next);
//        sentinel.next = newBlahfirst;
//        newBlahfirst.prev = sentinel;
//        sentinel.prev = sentinel.prev.next;
////        newBlahfirst.next.prev = sentinel.next.next;
//        size += 1;

        BlahNode front = new BlahNode(sentinel, x, sentinel.next);
        if (isEmpty()) { // add node to empty list
            sentinel.next = front;
            sentinel.prev = front;
            front.next = sentinel;
        } else {
            sentinel.next.prev = front;
            sentinel.next = front;
        }
        size += 1;

    }

    public void addLast(T x) {
//sentinel.prev will always point to last item in list; it's now the last item in list
        BlahNode last = new BlahNode(sentinel.prev, x, sentinel);

        if (isEmpty()) { // add node to empty list
            sentinel.next = last;
            sentinel.prev = last;
            last.prev = sentinel;
        } else {
            sentinel.prev.next = last;
            sentinel.prev = sentinel.prev.next;
        }
        size += 1;
    }


    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }


    public int size() {
        return size;
    }


    public void printDeque() {
        BlahNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }


//thing after sentinel is first item
//change what sentinel is pointing to to the item after the first item


    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T varFirst = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return varFirst;
    }


    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T varLast = sentinel.prev.item;
        if (size >= 2) {
            sentinel.prev.prev.next = sentinel; //actuallastnode.prev.next = newlastnode.next
            sentinel.prev = sentinel.prev.prev;
        } else {
            sentinel.prev = null;
            sentinel.next = null;
        }
        size -= 1;
        return varLast;
    }

//return p'th value?? pass in a list?

    public T get(int index) {
        BlahNode nextNode = sentinel.next;
        if (index >= size) {
            return null;
        }
        while (index > 0) {
            nextNode = nextNode.next;
            index -= 1;
        }
        return nextNode.item;
    }


//@source Josh Hug.
//youtube video; create empty linked list deque
    public LinkedListDeque() {
        sentinel = new BlahNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }


    //same as get but with recursion
    private T recursiveHelper(BlahNode link, int index) {
        if (index == 0) {
            return link.item;
        } else if (index >= size) {
            return null;
        } else {
            return recursiveHelper(link.next, index - 1);
        }
    }

    public T getRecursive(int index) {
//        if (index > size - 1) {
//            return null;
//        }
        return recursiveHelper(sentinel.next, index);
    }
//
//    public static void main(String[] args) {
//        LinkedListDeque<Integer> l = new LinkedListDeque<Integer>();
////        l.get(2);
//        //BlahNode x = new BlahNode(null, Integer, null); //don't need because when u
//        //go into method it'll already create instance of BlahNode
//        l.addFirst(3);
//        System.out.println(l.removeFirst());
//        l.isEmpty();
//        l.addLast(2);
//
//        System.out.println(l.removeLast());
//        System.out.println(l.isEmpty());
//        l.removeFirst();
//        l.get(3);
//    }


}


