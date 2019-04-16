//General questions
2.3; public and private
how do you know how many bits are in stuff?
python3 for java??

int vs integer; primitives vs pointers


//Format of java
1. public class
2. public static void main(String[] args)
3. curly brackets
4. actual code
5. semicolon

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

//running shit
jacav HelloWorld.java
java Helloworld

/**
//git
git init - tells the git version control system that we want to track the history of the current directory
git add - tracks file; directs photographer's attention to picture that will be taken
		multiple adds adds more objects to photo that will be taken
git commit -m MESSAGE    commit means photographer takes polaroid photo, polaroid is now a save point, message tells what changes commit makes to code REMEMBER TO HAVE MESSAGE IN ""
git status - things shown in red are items photographer hasn't included, reminding you that they're not there
git log - actually shows you log of what you've done
	to go more in depth with each commit, do git show [commit ID number]

	git show would automatically show u earliest version
git checkout - goes through polaroids and chooses polaroid to arrange objects same way as that picture

How to get earliest version of a file?
	git checkout [commit ID number] [file name]
	REMEMBER FILE NAME OR ELSE IT'LL REMOVE HEAD
	(might wanna git log first to see which commit u wanna revert back to)
how do u save repo and directory?
git cat - shows actual shit written in file
**submitting all the work:
add, commit push
git push origin master - push changes to master branch on origin remote repo
git commit -a -m "message". --> adds and commits at same time
*/

//chapter 1.2
every method needs class
every class NEEDS a main method e.g. 
	public static void main(String[] args)

nonstatic can take variables static can't
static does not look at variables that are mine
in java "this" refers to current object/current instance
can think of "this" as "self" in python

class method = static method
instance method = non-static method


you can have static and nonstatic variables too (variable common to all)
static belongs to class
nonstatic belongs to object of class

Dog[] dogs = new Dog[2];  <- creates array of dogs of size 2
dogs[0] = new Dog(8); 
dogs[1] new Dog(20);
dogs[0].makeNoise();




//Project 0
set each instance attribute (e.g. xxPos) to a different parameter (double xP, double yP, etc. is constructor)

public class Human {. <-- object with bunch of attri
	public string name; <-- instance variable
	public int age;
}

public void Human(string naame, int number){  <-- constructor (initializes instance of class)
	name = naame;							similar to method but nOT a method; you can tell its not method since it says Human
	age = number;							a constructor is essentially a function w/ parameters and all, and depending what you put into param it'll make a new instance of human using those parameters
}											syntax: public void (or int or whatever) const_name() {


Human(Janet, 19)
new Human(Janet, 19)

public void do_thing() { <-- method

how to tell diff?
constructor is same name as that of class, method isn't


when working with partner do this before git master origin:
git pull --rebase



//chapter 2.1
8 primitive types: byte, short, int, long, float, double, boolean, char
everything else including arrays is a reference type

reference types are 64 bits no matter what type of object


when u see iteration think POINTER and while loop
primitive and reference types??

//QUESTIONS 2.1
idg the concept of "this"
@return size list using recursion.....once rest == null, wouldn't it just return 1 instead of the total size it has accumulated?
^ nah man it adds 1 + 1 + 1 with every recursive call
@get method....idg how it works
can only use first and rest for IntList but i think can use rest and next for SLList???

public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! ITERATIVE. */
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null) {
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	/** Returns the ith item of this IntList. */
	public int get(int i) {
		if (i == 0) {
			return first;
		}
		return rest.get(i - 1);
	}

	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);

		System.out.println(L.get(100));
	}
} 

//chapter 2.2
SLList - like IntList but apparently better lol 
- don't need to specify null
IntNode X = new IntNode(10, null);
vs 
SLList Y = new SLList(10);

IntList format:
public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

SLList format:
public class IntNode {
    public int item;
    public IntNode next;

    public IntNode(int i, IntNode n) {
        item = i;
        next = n;
    }
}

Key: IntList vs SLList
IntList - first, rest, e.g. IntList rest
SLList - IntNode, Intnode next, first, NO REST VARIABLE
can only use first and rest for IntList but i think can use rest and next for SLList???


Rule of thumb:
If you don't use any instance members of the outer class, make the nested class static.
e.g.:

public class SLList {
       public static class IntNode {
            public int item;
            public IntNode next;
            public IntNode(int i, IntNode n) {
                item = i;
                next = n;
            }
       }

       private IntNode first;

//add an int to end of list ITERATIVELY
 public void addLast(int x) {
 	IntNode p = first
 	while (p.next != null) {
 		p = p.next;
 	}
 	p.next = new IntNode(x, null)
 }


SENTINEL NODE 
- always there so empty list doesnt point to null and can point to sentinal node 
- actual first item of list is after sentinal node
- never reassign sentinel because cuz it's always faithful companion, must be an Integer
- after implementing u gotta fix constructors + methods to be compat. w/ sent node
- size variable is always total number of items that have been added
/* creates empty SLList */
public SLList(){
	sentinel = new IntNode(63, null)    <-- faithful companion, 63 can be literally anything just couldnt use ?? lol
	size = 0;
}

/*modifying method to be compat. w/ sentinel node */
og:
public void addFirst(int x){
	first = new IntNode(x, first);
	size = size + 1;
}

modified:
public void addFirst(int x){
	sentinel.next = new IntNode(x, sentinel.next); //YO! sentinel = new IntNode(x, sentinel) is WRONG 
	//because sentinel should be pointing to same faithful companion NEVER REASSIGN SENTINEL
	//we are just saying hey sentinel someone wants to get in line behind you
}

og:
public void addLast(int x){

//og but taking into account chance that first starts off as null
	if (first == null) {
		first = new IntNode(x, null);
		return;
	}
//ye end of dat shit
	IntNode p = first;
	while (p != null){
		p = p.next;
	}
	p.next = new IntNode(x, null);
}

modified:
public void addLast(int x){
//got rid of that if first is null condition shit cuz we got sentinel now ye
	IntNode p = sentinel;
	while(p.next != null){
		p = p.next;
	}
	p.next = new IntNode(x, null);
}

//Invariants
condition guaranteed to be true
e.g. variants of SLList are that if a first node exists it's always at sentinel.next

//chapter 2.3
Improvements to methods from IntList to SLList:
addFirst(int x) - IntList to IntNode
getFirst() - SLList
addLast(int x) - public --> private
size() - nested class: bring IntNode into SLList
caching: save size as int
add a sentinel node to rep empty list


DLList = doubly linked list (SLList is singly)

problem w/ DLList = sometimes points at sentinels sometimes at real node
1st solution: have 2 sentinels, one always at front one always at back
2nd solution(better) the circular sentinel: 1 sentinel both front and back; 

SLList has IntNodes and IntNodes have int items therefore can't add string to SLList (gotta add <lochness> after class name and change int to class name)
to fix that you can parameterize the type that SLList will take
e.g. public class SLList --> public class SLList<Lochness> and then change all int to Lochness
and IntNode to whatever like StuffNode

then you can do SLList<String> s1 = new SLList<String>("bone");
	*oh also you don't need to specify type on instantiation side so it's:
		SLList<String> s1 = new SLList<>("bone");
everytime instantiate an SLList the string will get substituted everywhere in for Lochness(like a type parameter)

1. pick any arbitrary string (lochness) and in class creating put right after SLList<Lochness> 
2. when wanna use, make sure specify type you want when declaring or instantiating

Format of a generic DLList that can hold any type:
public class DLList<BleepBlorp> {
    private IntNode sentinel;
    private int size;

    public class IntNode {
        public IntNode prev;
        public BleepBlorp item;
        public IntNode next;
        ...
    }
    ...
}

Special syntax to instantiate this class:
DLList<String> d2 = new DLList<>("hello");
d2.addLast("world");
**remember u can't use primitives inside angle brackets like <int>

Proj 1 rules:
1. in java file for IMPLEMENTING data structure, specify "generic type" only once at top of file
2.  in java files USING data structure, specify type once e.g. SLList<Lochness> (placeholder for a type that is not decided at time SLList created)
	- write out desired type during DECLARATION
	- use <> during instantiation 
	- when declaring or instantiating, use reference type:
		int: Integer  ya can't do: DLList<int> d1 = new DLList<(5); gotta do DLList<Integer> d1 = new DLList<(5);
		double: Double
		char: Character
		boolean: Booleanlong
		long: Long
e.g.
SLList<Integer> s1 = new SLList<>(5);
s1.insertFront(10);

SLList<String> s2 = new SLList<>("hi");
s2.insertFront("apple");

DLList<Double> s1 = new DLList<>(5.3);
double x = 9.3 + 15.2;
s1.insertFront(x);



//chapter 2.4 [LinkedListDeque.java for project1]
AList - use arrays to build list instead of recursion like with IntList, SLList, and DLList
array - numbered sequence of memory boxes
access info with brackets e.g. A[i]
array has:
- fixed integer length N numbered 0 to N-1
- all boxes same type
- whenever u instantiate array u get one reference at time created 
- like classes, almost always instantiated with "new"...3 WAYS TO CREATE ARRAYS:
	y = new int[3];  <-- array of length 3, 0 is default value for each item unless you do int[3][] where null is each value
	y = new int[]{1,2,3,4}; <-- actually puts numbers in array
	int[] y = {1,2,3,4}; <-- creates new int array y; can only be used when combined w/ a variable declaration (in this case y)
More:
 int[][] w = new int[3][3]; <-- three boxes that each point to arrays of length 3 w/ default value zero in 
String[] s = new String[6]; <-- six boxes, each one's 64 bits, boxes can hold string references, defulat value is null
btw when you do like s[4] it's retrieving the 4th index so u count starting from zero

two ways to copy arrays:
1. for loop; while i is less than x.length y of i equals x of i
2. arraycopy (faster)
system.arraycopy(parameters) <-- weird shit, look it up 
e.g. system.arraycopy(b, 0, x, 3, 2);
copy from the array b starting at index 0 to the destination array x starting at x's position 3, copy 2 of those
The array to use as a source
Where to start in the source array
The array to use as a destination
Where to start in the destination array
How many items to copy


//chapter 2.5
public class AList {
	private int[] item;
	private int size;
}

//instanitate a list of size 100
public AList() {
	items = new int[100];
	size = 0;
}

//next item we want to add will go into position size
public void addLast(int x) {
	items[size] = x;
	size = size + 1;
}
 
public int getLast() {
	return items[size - 1];
}

piblic int get(int i ) {
	returns items[i];
}

public int size() {
	return size;
}

public int removeLast() {
	int x = getLast();
	size = size - 1;
	return x;
}

resizing steps:
when array gets too full (size == items.length) just make a new array
int[]a = new int[size + 1];  <-- makes array that's one larger
system.arraycopy(items, 0, a, 0, size); <-- all info gets copied to second array
a[size] = 11;  <-- go to last position and put number u want to insert
items = a; 
size += 1;  


//resizes array to target capacity
private void resize(int capacity) {
	int[] a = new int[size + 1];
	System.arraycopy(items, 0, a, 0, size);
	items = a;
}	 

//inserts X into back of list
public void addLast(int x) {
	if (size == items.length) {
		resize(size + 1);
	}
	items[size] = x;
	size = size + 1;
}


Java doesn't allow u to create arrays of generic objects
casting - lets u bypass compiler; hey compiler let this slip
doesn't work: items = new Item[100]
works: items = (Item[])new Object[100];   cast
format: (Glorp []) new Object[cap];

loitering: when u don't null out items that were deleted

//Lab 3 testing
precede each test with @Test 
all tests must be nonstatic
can have one or more assertEquals or assertTrue
white/blue renderer is josh hug's 
red/green is default renderer

have tests timeout to prevent infinite loops e.g.:
 @Test(timeout = 1000)
    public void testReverse() {
    	IntList A = IntList.of(1, 2, 3);
        IntList exp = IntList.of(3, 2, 1);
        assertEquals(exp, IntList.reverse(A));
    }

//ch 3.1
//the method; in a different file
public class Sort {
	public static void sort(String[] x) {	
	}
}    

//the test class for the method (tests sort method of sort class)
public class TestSort {
	//test sort.sort method
	public static void testSort() {
		String[] input = {"I", "have", "an" "egg"};
		String[] expected = {"an", "egg", "have", "I"};
		Sort.sort(input);
		org.junit.Assert.assertArrayEquals(expected, input);
		//^DON'T DO == WHEN COMPARING TWO OBJECTS!!!!
	}

	public static void main(String[] args) {
		testSort();
	}
}    

//project 1a
to test out a method
1. create main method
2. create instance of constructor i think
3. call method u want to test with .method
public static void main(String[] args) {
        System.out.println("hi");
        ArrayDeque <Integer> x = new ArrayDeque<Integer>();
        System.out.print(x.get(1));
    }


//4.1
static type - specified at declaration; never changes
dynamic type - specified at instantiation (new)

List61B<String> lst = new SLList<String>();
^intrinsically SLList since declared as such but also a List61B; called 
"dynamic type"

when Java checks to see which method to call, it checks the static type 
and calls the method with the parameter of the same type

interface inheritance vs implementation inheritance
interface inheritance - simple. tells subclasses what they shOULD be able to do
imp inheritance - tell subclasses HOW they should behave

overloading vs overriding
overloading - you have two of same method
Method Selection 
- choose static type's method unless there's an overriden method
- parameters based on param's static type when you have two of same method
- UNLESS override, then select method based on dynamic type
- casting changes dynamic type to whatever the casted type is!



"extends" keyword
- subclasses inherit all members of parent class
members are: all instance and static variables, methods, and nested
classes
public class RotatingSLList<Item> extends SLList<Item>
e.g. public class TA extends Human {
}
makes sense because all TA's are human

overriding allows us reuse code and modify to fit needs
overlloading 

extend does what methods does 

extend = taking over its methods
VengefulSLList extends SLList means VengefulSLList is-an SLList
@override means do this method (that's under override) 
	(not to get overridden lol)

josh hug is x (interface), i am y. I know josh but he doesn't care about me. so i can 
extend interface's methods but override them (do them my own way)

//4.2

public class VengefulSLList<Item> extends SLList<Item> {
    SLList<Item> deletedItems;

public VengefulSLList() {
	deletedItems = new SLList<Item>();
}

super - use to invoke overridden superclass methods and constructors
basically use to still be able to use parent class method even when current
method is overriden

override the removeLast method to remove last item, add item to 
deletedItems list then returns it
@Override
public item removeLast() {
	 Item x = super.removeLast();  <-- call the superclass's version of remove last method 
     deletedItems.addLast(x); <-- get last item, add to deletedItems list
     return x; 
}

public void printLostItems() {
    deletedItems.print();
}
}



anytime you write a constructor, that constructor must start with a call
to one of the superclasses's constructors if u dont it does it anyway 

public VengefulSLList(Item x) {
    deletedItems = new SLList<Item>();
}

is equivalent to 

public VengefulSLList(Item x) {
    super();
    deletedItems = new SLList<Item>();
}

but not this

public VengefulSLList(Item x) {
    super(x);
    deletedItems = new SLList<Item>();
}


compilation error shit
VengefulSLList<Integer> vsl = new VengefulSLList<Integer>(9);
SLList<Integer> sl = vsl;
^both good cuz VengefulSLList "is an" SLList

sl.addLast(50);
sl.removeLast();
^also compile; addLast method execused is in SLList
removeLast overridden by VengefulSLList 
dynamic type of sl is VengefulSLList, so overridden method chosen 
in VengefulSLList class


HOF
def tenX(x):
    return 10*x

def do_twice(f, x):
    return f(f(x))

print(do_twice(tenX, 2)) <-- returns 200


python: f(f(x))
java: f.apply(f.apply(x))

//4.3
HOF approach (won't see often)
def print_larger(x, y, compare, stringify):
    if compare(x, y):
        return stringify(x)
    return stringify(y)


Subtype Polymorphism Approach
def print_larger(x, y):
    if x.largerThan(y):
        return x.str();
    return y.str();


//4.4

map example

public static Map<String, Integer> collectWordCount(List<String> words) {
    Map<String, Integer> counts = new HashMap<String, Integer>();
    for (String t: target) {
        counts.put(s, 0);
    }
    for (String s: words) {
        if (counts.containsKey(s)) {
            counts.put(word, counts.get(s)+1);
        }
    }
    return counts;
}    


//6.1
throw keyword - provide own error message

public V get(K key) {
    intlocation = findKey(key);
if(location < 0) {
    throw newIllegalArgumentException("Key " + key + " does not exist in map."\); 
}
    return values[findKey(key)];
}


keywords try and break break the normal flow of the program, 
protecting it from exceptions

Dog d = new Dog("Lucy", "Retriever", 80);
d.becomeAngry();

try {
    d.receivePat();
} catch (Exception e) {
    System.out.println(
    "Tried to pat: " + e);
    d.eatTreat("banana");
} 
d.receivePat();
System.out.println(d);

//6.2
unchecked exceptions- cannot be known until runtime; can't be recovered from
Errors and Runtime Exceptions

Everything else is a checked exception
throwable, exception, IOException, midi unavailable exception, file not found exception, etc.
can be fixed

two ways to handle checked error
1. catch
2. specify

catch: (catch method def)
public static void gulgate() {
    try {
        if (today == “Thursday”) { 
            throw new IOException("hi"); 
        }
    } catch (Exception e) {		//catch - catches specific errors, letting others go by; don't want whole program to crash
        System.out.println("psych!");
    }
}

specify: (modify method def)
public static void gulgate() throws IOException {
... throw new IOException("hi"); ...		//throw - tell person they're doing something illegal, program crashes and dw about how it's handled at the end user figure out themselves
}


catch main method: (catch main def)
public static void main(String[] args) {
    try {
        gulgate();
    } catch(IOException e) {
        System.out.println("Averted!");
    }
}


specify main method: (modify main def)
public static void main(String[] args) throws IOException {
    gulgate();
}


//6.3

steps to using iterator
//iterable - interface that makes a class able to be iterated on,
//requires iterator() method which returns iterator object
public interface Iterable<T> {
    Iterator<T> iterator();
}

//
public interface List<T> extends Iterable<T>{
    ...
}

//iterator - interface that defines the object with methods to 
//actually do that iteration
public interface Iterator<T> {
    boolean hasNext();
    T next();
}




//list "friends"
List<Integer> friends = new ArrayList<Integer>();
friends.add(5);
friends.add(23);
friends.add(42);
for (int x : friends) {
    System.out.println(x);
}


//define iterator() method 
public Iterator<E> iterator();

//use object to loop thru list
List<Integer> friends = new ArrayList<Integer>();
Iterator<Integer> seer = friends.iterator();

while (seer.hasNext()) {
    System.out.println(seer.next());
}



//hw1
packages
org.junit = package name
assert = class name
assertEquals = method name

//hw1 questions
why do u have to override abstract methods

when u modulo and left is less than right output is just left
3 % 4 = 3
2 % 5 = 2
0 % 2 = 0


//6.4
//java has special stringbuilder class (creates string obj that is mutable)
public String toString() {
        StringBuilder returnSB = new StringBuilder("{");
        for (int i = 0; i < size - 1; i += 1) {
            returnSB.append(items[i].toString());
            returnSB.append(", ");
        }
        returnSB.append(items[size - 1]);
        returnSB.append("}");
        return returnSB.toString();
    }

//equals()
// == checks if two obj are same obj in memory
    //for primitives (int) checks if values equal
    //for objects checks if pointer equal

equals(Object o) is method that acts like == but we can override it to 
define equality whichever way we wish

example equals method

public boolean equals(Object other) {
        if (this == other) {
            return true;    
        }
        if (other == null) {
            return false;   <-- nulls
        }
        if (other.getClass() != this.getClass()) {
            return false;   <-- objects of different class
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if (o.size() != this.size()) {
            return false;
        }
        for (T item : this) {
            if (!o.contains(item)) {
                return false;
            }
        }
        return true;
    }

rules for equals
1. equivalence relation 
	reflexive: x.equals(x) is true
	symmetric: x.equals(y) if and only if y.equals(x)
	transitive: x.equals(y) and y.equals(z) implies z.equals(z)
2. must take an object argument in order to override og .equals() method
3. consistent; if x.equals(y) x must cont equal y
4. x.equals(null) must be false


//8.1
API (Application Programming Interface) -  list of constructors and 
methods and a short description of each

//8.2
bad: comparing each value
public static boolean dup1(int[] A) {  
  for (int i = 0; i < A.length; i += 1) {
    for (int j = i + 1; j < A.length; j += 1) {
      if (A[i] == A[j]) {
         return true;
      }
    }
  }
  return false;
}

good: compare only neighbors
public static boolean dup2(int[] A) {
  for (int i = 0; i < A.length - 1; i += 1) {
    if (A[i] == A[i + 1]) { 
      return true; 
    }
  }
  return false;
}


//discussion - asymptotic notation
disregard lower order terms e.g. x^3 + x^2 + 5, disregard everything but x^3
disregard constants (coefficient in front of variable)

Big O - upper bound.."less than or equal to"
Big Theta - special case, when u have an upper and lower bound that match

f = theta(g) <- order of growth is g
f = O(g) <- order of growth is less than or equal to f(N)
f = omega(g) <- order of growth is greater than or equal to g

disjoint sets 
implementations: quick find, quick union, weighted quick union

improvements to Union Find ADT:
- union by size
- path compression

//9.1-9.5 Disjoint Sets
disjoint sets have no elements in common
two operations:
union: void connect(int p, int q) 
boolean isConnected(int p, int q)	returns true if x and y are connected

tree's size is the number of nodes, not height

quick find - 



depth of a node = how far it is from root
height of tree = depth of its deepest leaf; determines worst case runtime because in the worst case the node we are 
looking for is at the bottom of the tree.
avg depth = average of the total depths in the tree; determines the average-case runtime.


//11.1
B-trees
theta N = worst case
theta log N = best case

left-leaning red-black trees (LLRB)
- choose arbitrarily to make the left element a child of the right one
- show that a link is a glue link by making it red
- link added will always be red and added to leaf node 
- can never have a right red link. If so need to use a rotation 


//abstracted code for a LLRB
private Node put(Node h, Key key, Value val) {
    if (h == null) { 
    	return new Node(key, val, RED); 
    }
    int cmp = key.compareTo(h.key);
    if (cmp < 0) { 
    	h.left  = put(h.left, key, val); 
    }
    else if (cmp > 0) { 
    	h.right = put(h.right, key, val); 
    }
    else { 
    	h.val = val;                    
    }
    if (isRed(h.right) && !isRed(h.left)) {  //can never have right red link
    	h = rotateLeft(h);  
    }
    if (isRed(h.left)  &&  isRed(h.left.left)) { 
    	h = rotateRight(h); 
    }
    if (isRed(h.left)  &&  isRed(h.right)) { 
    	flipColors(h);      
    } 
    return h;
}


7091
(7 * 10^3) + (0 * 10^2) + (9 * 10^1) + (1 * 10^0)
works w/ english words too
bee --> (2 * 27^2) + (5 * 27^1) + (5 * 27^0)

hash tables
data converted by hash function to integer representation called hash code, hash code reduced to 
index usually using mod (%) e.g. 1598 in index 8




































