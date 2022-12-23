
public class LinkedList {
    private Node head;
    private int numElements;
    
    public LinkedList() {
        //technically not necessary, since fields
        //are automatically initialized
        makeEmpty();
    }//end ctor
    
    public void add(int newItem) {
        Node newNode = new Node(newItem, null);
        Node walker = head;
        Node currentNode = null;
        
        //if list is currently empty
        if(head == null) {
            head = newNode;
        }
        else {
            while(walker != null) {
                currentNode = walker;
                walker = walker.getNext();
            }//end while
            
            //currentNode is the current lastNode
            currentNode.setNext(newNode);
        }//end else
        
        numElements++;
    }//end add
    
    public void insert(int newItem, int position) {
        //is the position in range?
        if(position < 0 || position >= numElements) {
            System.out.println("Position is out of range.");
            return;
        }
        
        int count = 0;
        Node nodeBefore = head;
        
        if(position == 0) {
            //make newNode the new head
            //first create node with its next set to
            //the current head
            Node newNode = new Node(newItem, head);
            //now make this the new head
            head = newNode;            
        }
        else {
            while(nodeBefore != null && count < position - 1) {
                nodeBefore = nodeBefore.getNext();
                count++;
            }   

            if(nodeBefore != null) {
                Node nodeAtPosition = nodeBefore.getNext();
                Node newNode = new Node(newItem, null);
                newNode.setNext(nodeAtPosition);
                nodeBefore.setNext(newNode);
            }
        }
      
        numElements++;
    }//end insert
    
    public int remove(int position) {
        int oldValue = 0;
        if(position < 0 || position >= numElements) {
            System.out.println("Position is out of range.");
            return oldValue;
        }
        
        int count = 0;
        Node nodeBefore = head;
        
        if(position == 0) {
            //remove current head by progressing
            //to the next node in the chain
            head = head.getNext();
        }
        else {
            //walk up to the node before the position
            //we want to remove
            while(nodeBefore != null && count < position - 1) {
                nodeBefore = nodeBefore.getNext();
                count++;
            }//end while
            
            if(nodeBefore != null) {
                Node nodeToDelete = nodeBefore.getNext();
                //bypass the node being removed
                nodeBefore.setNext(nodeToDelete.getNext());
            }
        }
          
        numElements--;
        return oldValue;
    }//end remove
    
    public int replace(int position, int newValue) {
        int oldValue = 0;
        
         if(position < 0 || position >= numElements) {
            System.out.println("Position is out of range.");
            return oldValue;
        }       
        
        Node walker = head;
        int count = 0;

        while(walker != null) {
            if(count == position) {
                break;
            }
            
            walker = walker.getNext();
            count++;
        }//end while
        
        if(walker != null) {
            oldValue = walker.getData();
            walker.setData(newValue);
        }
        
        return oldValue;
    }//end replace
    
    public int getElement(int position) {
        int count = 0;
        Node walker = head;
        int result = 0;
        
        if(position < 0 || position >= numElements) {
            System.out.println("Position is out of range.");
            return result;
        }
        
        while(walker != null) {
            if(count == position) {
                result = walker.getData();
                break;  //done!
            }
            
            walker = walker.getNext();
            count++;
        }//end while
        
        if(walker == null) {
            System.out.println("Element not found");
        }   

        return result;
    }//end getElement
    
    public boolean contains(int value) {
        boolean found = false;
        
        Node walker = head;
        
        while(walker != null)
        {
            if(walker.getData() == value)
            {
                found = true;
                break;
            }
            walker = walker.getNext();
        }//end while
        
        return found;
    }//end contains
    
    public int getNumElements() {
        return numElements;
    }//end getNumElements
    
    public void makeEmpty() {
        head = null;
        numElements = 0;
    }//end makeEmpty
    
    public boolean isEmpty() {
        return numElements == 0;
    }
}
