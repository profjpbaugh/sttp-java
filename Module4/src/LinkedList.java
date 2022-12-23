
public class LinkedList<T> {
    private Node<T> head;
    private int numElements;
    
    public LinkedList() {
        //technically not necessary, since fields
        //are automatically initialized
        makeEmpty();
    }//end ctor
    
    public void add(T newItem) {
        Node<T> newNode = new Node<>(newItem, null);
        Node<T> walker = head;
        Node<T> currentNode = null;
        
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
    
    public void insert(T newItem, int position) {
        //is the position in range?
        if(position < 0 || position >= numElements) {
            System.out.println("Position is out of range.");
            return;
        }
        
        int count = 0;
        Node<T> nodeBefore = head;
        
        if(position == 0) {
            //make newNode the new head
            //first create node with its next set to
            //the current head
            Node<T> newNode = new Node<>(newItem, head);
            //now make this the new head
            head = newNode;            
        }
        else {
            while(nodeBefore != null && count < position - 1) {
                nodeBefore = nodeBefore.getNext();
                count++;
            }   

            if(nodeBefore != null) {
                Node<T> nodeAtPosition = nodeBefore.getNext();
                Node<T> newNode = new Node<>(newItem, null);
                newNode.setNext(nodeAtPosition);
                nodeBefore.setNext(newNode);
            }
        }
      
        numElements++;
    }//end insert
    
    public T remove(int position) {
        T oldValue = null;
        
        if(position < 0 || position >= numElements) {
            System.out.println("Position is out of range.");
            return oldValue;
        }
        
        int count = 0;
        Node<T> nodeBefore = head;
        
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
                Node<T> nodeToDelete = nodeBefore.getNext();
                //bypass the node being removed
                nodeBefore.setNext(nodeToDelete.getNext());
            }
        }
          
        numElements--;
        return oldValue;
    }//end remove
    
    public T replace(int position, T newValue) {
        T oldValue = null;
        
         if(position < 0 || position >= numElements) {
            System.out.println("Position is out of range.");
            return oldValue;
        }       
        
        Node<T> walker = head;
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
    
    public T getElement(int position) {
        int count = 0;
        Node<T> walker = head;
        
        T result = null;
        
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
    
    public boolean contains(T value) {
        boolean found = false;
        
        Node walker = head;
        
        while(walker != null)
        {
            if(walker.getData().equals(value))
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
