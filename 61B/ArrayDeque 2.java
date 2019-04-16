public class ArrayDeque<T> {
    private int nextFirst;
    private int nextLast;
    private int size = 0;
    private T [] items;


//creates an empty array deque
//constructor (initializes instance of class)
    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 0;
    }


//NO IDEA
    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        if (nextFirst < nextLast) {
            System.arraycopy(items, nextFirst, newArray, 0, size);
        } else {
            System.arraycopy(items, nextFirst, newArray, 0, items.length - nextFirst);
            System.arraycopy(items, 0, newArray, items.length - nextFirst, nextLast + 1);
        }
        items = newArray;
        nextFirst = 0;
        nextLast = size - 1;
    }

//        get(0); //figure out actual first value in list and return
//        T[] resized = (T[]) new Object[capacity];
//        T indexFirst = get(0); //step 1, returns item; GET ALL ITEMS WITH FOR LOOP?
//        System.arraycopy(indexFirst, 0, resized, ((resized.length / 2) - 1), capacity);
//        //step 2, not sure about capacity
//
//        nextFirst = ((resized.length / 2) - 1);
//        nextLast = ((resized.length / 2) + 1);
//
//    }


    //I FEEL LIKE THIS SHOULD BE RIGHT BUT IDK
    public T get(int index) {
        if (index >= this.size) {
            return null;
        }
        int realDeal = (index + this.nextFirst) % this.items.length;
        return this.items[realDeal];
    }
//        int pnextLast = nextLast - 1; //currently 1, make it 0
//        for (int i = 0; i < items.length - 1; i++) {
////            if (index == 0 ) { //&& items[i] != null dude its fine to return null
////                return items[0];
////            }
//            if (index == pnextLast) { //goes on to index 1
//                return items[i]; //return item in index 1
//            }
////            if (index == items.length - 1) {
////                pnextLast = 0; //loop back to front when index reach end of array
////            }
//            pnextLast += 1; //else increment pointer by one
//        }
//        return null; //item in current index is null
//    }


    //SEEMS GOOD
    public void addFirst(T first) {
        if (size + 1 > items.length) {
            resize(size * 2);
        }
        if (size + 1 == 1) {
            nextFirst = nextFirst;
        } else if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }
        size += 1;
        items[nextFirst] = first;
    }



//SEEMS GOOD
    public void addLast(T last) {
        if (size + 1 > items.length) { //if NL at last index
            resize(size * 2);
        }
        if (size + 1 == 1) {
            nextLast = nextLast;
        } else if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
        size += 1;
        items[nextLast] = last;
    }
//        if (items[nextLast] == last) {
//        nextLast += 1;
//        size += 1;
//        return;
//        { if (size == items.length) {
//            resize(size + 1);



//GOOD
    public boolean isEmpty() {
        return size() == 0;
    }

//GOOD
    public int size() {
        return size;
    }

//IDK; two pointers, one to head one to tail; start/end; circular array
    public void printDeque() {
        for (int i = 0; i < size - 1; i++) {
            System.out.print(items[(nextFirst + i) % items.length]);
            System.out.print(" ");
        }
    }
//        int pFirst = nextFirst; //starts at 0
//        int pLast = nextLast; //starts at 1
//        for (int i = 0; i < size; i += 1) {
//            if (items[i] == null) {
//                pLast = nextLast + 1;
//                continue;
//            }
//            System.out.print(items[i]);
//            pFirst = nextFirst - 1;
//            pLast = nextLast + 1;
//        }
//        System.out.println();
//    }


//gotta change pointers and shit
//getFirst helper function

    private T getFirst() {
        int pnextFirst = nextFirst; //currently 0
        for (int i = 0; i < items.length - 1; i++) {
            //if item 0 isn't null return cuz it's the first item
            if (items[pnextFirst] != null && items[i] != null)  {
                return items[pnextFirst];
            }
            pnextFirst += 1; //else increment
        }
        return null;
    }
        //if statement first index isn't null, then return 0th index



    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item = items[nextFirst];
        items[nextFirst] = null;
        if (size == 1) {
            nextFirst = nextFirst;
        } else if (nextFirst == items.length - 1) {
            nextFirst = 0;
        } else {
            nextFirst += 1;
        }
        size -= 1;

        if ((size <= items.length / 3) && (size > 3)) {
            resize(items.length / 3);
        }
        return item;
    }

//        T resultFirst = getFirst();
//        size -= 1;
//        nextFirst += 1;
//        return resultFirst;
//    }


//NO PARAMETER PASSED IN??; created helper method getLast to do removeLast
//    public T getLast() {
//        int pnextLast = nextLast; //currently 1
//        for (int i = 0; i < items.length - 1; i++) {
//            while (items[i] != null) {
//                if (items.length == 1) {
//                    return items[0];
//                }
//                if (pnextLast == items.length - 1) {
//                    return items[pnextLast];
//                    pnextLast += 1;
//                } else {
//                    return null;
//                }
//
//            }
//
//        }
//    }


    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T item = items[nextLast];
        items[nextLast] = null;
        if (size == 1) {
            nextLast = nextLast;
        } else if (nextLast == 0) {
            nextLast = items.length - 1;
        } else {
            nextLast -= 1;
        }
        size -= 1;

        if ((size <= items.length / 3) && (size > 3)) {
            resize(items.length / 3);
        }
        return item;
    }
//        if (items.length <= 2) { //if greater 2 then removing last doesn't matter
//            nextLast -= 1;
//        }
////        return resultLast;
//        return null;
//    }




//    System.arraycopy(b, 0, x, 3, 2);
//    copy from the array b starting at index 0 to the destination array x
//    starting at x's position 3, copy 2 of those
//creates a deep copy of other NO IDEA LOL

    public ArrayDeque(ArrayDeque other) {
        T[] copy = (T[]) new Object[other.items.length];
        System.arraycopy(other.items, nextFirst, copy, 0, other.items.length);
        this.items = copy;
        this.nextFirst = other.nextFirst;
        this.nextLast = other.nextLast;
        this.size = other.size;

    }

    //main method
//    public static void main(String[] args) {
//        System.out.println("hi");
//        ArrayDeque<Integer> x = new ArrayDeque<Integer>();
// specify data type contained e.g. integer
//        System.out.print(x.get(3));

//        x.addLast(1);
//        x.addLast(5);
//        x.addLast(5);
//        x.addLast(5);
//        x.addLast(5);
//        x.addLast(5);
//        x.addLast(5);
//        x.addLast(5);





}






