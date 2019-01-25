public class SortedIntLinkedList extends IntLinkedList
{
  
  public boolean add(int value)
  {
    Node newNode = new Node(value);

    
    Node p = head; 
    if (size() == 0) {
      head = newNode;
      return true;
    } 

    if(p.data > newNode.data)
    {
      newNode.next = head;
      head = newNode; 
      return true; 
    }

    
    while (p.next!= null)
    {
       if(p.next.data > newNode.data)
        {
          newNode.next = p.next;
          p.next = newNode; 
          p = p.next; 
          return true; 
        }
        else
        {
          p = p.next; 
        }
    }

    p.next = newNode;
    
    return true; 
  }
  
  public void add(int index, int value)
  {
    throw new UnsupportedOperationException("Illegal in sorted list.");
  }
  

}

