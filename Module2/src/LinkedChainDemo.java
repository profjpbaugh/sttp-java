
public class LinkedChainDemo {
    public static void main(String[] args) {
        final int NUM_NODES = 5;
        
        Node headNode = null;
        
        //put new nodes at the beginning
        //create 5 nodes, total
        for(int i = 0; i < NUM_NODES; i++) {
            //if this is the first node, it’s the head
            //otherwise, update the new head node 
            //to the newest node
            headNode = new Node(100 + (i * 5), headNode);
        }//end for
        
        //print out the node content
        Node walker = headNode;
        
        while(walker != null) {
            //while not at the end, print out data
            System.out.println(walker.getData());
            walker = walker.getNext();
        }//end while
    }//end main
}
