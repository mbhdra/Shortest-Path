import java.util.*;

public class NodeComparator implements Comparator<Node>{ 
    
  // Overriding compare()method of Comparator  
              // for descending order of cgpa 
  public int compare(Node n1, Node n2) { 
      if (n1.getDistance() > n2.getDistance()) 
          return 1; 
      else if (n1.getDistance() < n2.getDistance()) 
          return -1; 
      return 0; 
      } 
} 
