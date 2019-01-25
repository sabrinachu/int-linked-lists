import javax.lang.model.util.ElementScanner6;

public class IntLinkedList implements IntList {
  protected Node head;
  
  //default constructor will suffice
  public int indexOf(int value)
  {
    int count = 0; 
    for(Node p = head; p != null; p = p.next)
    {
      if(p.data == value)
      {
        return count; 
      }
      count++; 
    }
    return -1; 
  }
  
  public int indexOf (int value, int startIndex)
  {
    int count = 0; 
    
    for(Node p = head; p != null; p = p.next)
    {
      if (count != startIndex && count <= startIndex)
      {
        count++; 
        continue; 
      }

      if(p.data == value)
      {
        return count; 
      }
      else
      {
        count++; 
      }
    }
    return -1; 
  }
  
  public IntList allIndicesOf(int value)
  {
    IntList tempList = new IntLinkedList(); 
    int count = 0; 

    for(Node p = head; p !=null; p = p.next)
    {
      if (p.data == value)
      {
        tempList.add(count); 
      }
      count++; 
    }
     
    return tempList; 
  } 
  
  public int min()
  {
    int min = head.data; 
    for(Node p = head; p != null; p = p.next)
    {
      if (p.data < min)
      {
        min = p. data; 
      }
    }
    return min; 
  }
  
  public int max()
  {
    int max = head.data; 
    for (Node p = head; p != null; p = p.next)
    {
      if (p.data > max)
      {
        max = p.data; 
      }
    }
    return max; 
  }
  
  public int indexOfMin()
  {
    int minNum = min();
    int count = 0; 
    for (Node p = head; p != null; p = p.next)
    {
      if (p.data == minNum)
      {
        break; 
      }
      count++; 
    }
    return count;
    
    
  }
  
  public int indexOfMax()
  {
    int maxNum = max();
    int count = 0; 
    for (Node p = head; p != null; p = p.next)
    {
      if (p.data == maxNum)
      {
        break; 
      }
      count++; 
    }
    return count;
  }
  
  public void removeAll(int value)
  {  
    Node p = head; 

    while(p.data == value)
    {
      head = head.next;
      p = p.next; 
    }

    while(p.next != null)
    {
      if(p.next.data == value)
      {
        p.next = p.next.next;
      }
      else
      {
        p = p.next; 
      }
    }

  }
  
  public int size() {
    int count = 0;
    for (Node p = head; p != null; p = p.next) {
      count++;
    }
    return count;
  }
  
//adds value to the end of the list
  public boolean add(int value) {
    Node newNode = new Node(value);
    
    //special case: list is empty
    if (size() == 0) {
      head = newNode;
      return true;
    } 
    for (Node p = head; p != null; p = p.next) {
      if (p.next == null) {
        p.next = newNode;
        return true;
      }
    }    
    return true;
  }
  
  public void add(int index, int value) {
    Node newNode = new Node(value);
    
    if(index < 0 || index > size())
      throw new IndexOutOfBoundsException("No node at location: " + index);
    if(index == 0){
      newNode.next = head;
      head = newNode;
      return;
    }                   
    Node p = head;
    for(int i = 0; i < index - 1; i++){
      p = p.next;          
    }
    newNode.next = p.next;
    p.next = newNode;            
  }  
  
  public int get(int index) {
    if (index >= size() || index < 0) {
      throw new IndexOutOfBoundsException("Index not defined: " + index);
    }
    Node p = head;
    for (int r = 0; r < index; r++) {      
      p = p.next;
    }
    
    return p.data; 
  }
  
  public int set(int index, int value) {
    if (index >= size() || index < 0) {
      throw new IndexOutOfBoundsException("Index not defined: " + index);
    }
    Node p = head;
    for (int r = 0; r < index; r++) {   
      p = p.next;
    } 
    int temp = p.data;
    p.data = value; 
    return temp; 
  }  
  
  public int remove(int index) {
    if(index < 0 || index >= size())
      throw new IndexOutOfBoundsException("No node at location: " + index);
    if (index == 0) {
      int result = head.data;
      head = head.next;
      return result;
    }
    
    Node p = head;
    for(int i = 0; i < index - 1; i++)
      p = p.next;   
    int result = p.next.data;   
    p.next = p.next.next;
    
    return result;   
  }  
  
  public String toString() {
    String result = "[";
    for (Node p = head; p != null; p = p.next) {
      result += p.data;
      if (p.next != null) {
        result += ", ";
      }
      // else {
      //   result += "]";
      // }
    }
    return result + "]";
    
    
  }

  
  //protected inner class
  protected class Node {
    protected int data;
    protected Node next;
    
    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
    
    public Node(int data) {
      this(data, null);
    }
    
   
  }
  
  //testing code
  public static void main(String[] args) {
    IntLinkedList list = new IntLinkedList();
    list.add(4);
    list.add(4);
    list.add(4); 
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(4);
    list.add(5);
    list.add(4);
    list.add(4);
    System.out.println(list);
    
    System.out.println("index of 9: should return -1: " + list.indexOf(9));
    System.out.println("index of 4, starting index is 2: " + list.indexOf(4,2));
    System.out.println("should print 0 and 3: " + list.allIndicesOf(4));
    System.out.println(list.allIndicesOf(10));
    System.out.println("should be 2: " + list.min());
    System.out.println("should be 5: " + list.max());
    System.out.println("index of min = 1: " + list.indexOfMin());
    System.out.println("index of max = 4: " + list.indexOfMax());

    list.removeAll(4);
    System.out.println(list);


    IntLinkedList list2 = new SortedIntLinkedList(); 

    list2.add(6);
    list2.add(6);
    list2.add(-1);
    list2.add(0);
    list2.add(2);
    list2.add(4);
    list2.add(5); 
    list2.add(21);
    list2.add(3);
    list2.add(7);
    list2.add(1);

    System.out.println("sorted: " + list2);
  }
  
}

