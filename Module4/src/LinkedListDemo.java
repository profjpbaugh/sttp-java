
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<>();
        LinkedList<String> stringList = new LinkedList<>();
        
        stringList.add("John");
        stringList.add("Samuel");
        stringList.add("Samantha");
        stringList.add("Oliver");
        stringList.add("Carrie");
        
        stringList.replace(0, "Robert");
        
        printList(stringList);
        System.out.println(""); //extra spacing
        
        myList.add(100);
        myList.add(200);
        myList.add(300);
        myList.add(400);
        
        myList.insert(250, 0);
        
        printList(myList);
        
        myList.remove(3);
        
        System.out.println("\nAfter Removal at index 3:");
        printList(myList);
        
        System.out.println("\nReplace element 1 with 222");
        myList.replace(1, 222);
        printList(myList);
        
        if(myList.contains(250)) {
            System.out.println("It contains 250!");
        }
        else {
            System.out.println("It does NOT contain 250!");
        }
    }//end main
    
    public static<T> void printList(LinkedList<T> list) {
        int position = 0;
        
        while(position < list.getNumElements()) {
            System.out.println(list.getElement(position));
            position++;
        }//end while        
    }
}
