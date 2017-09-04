import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyStack<AnyType> 
    {
    ArrayList<AnyType> list = new ArrayList<>(); 
    int getSize()                                               // get size of ArrayList
        {
        return list.size();
        }
    void push( AnyType element)                                //Create push for stack adds to end position in ArrayList
        {
        list.add(element);
        }
    public AnyType pop()                                      //Create pop for stack removes last item in ArrayList
        {
        return list.remove(list.size()-1);
        }
    @Override
    public String toString()                                            //Override toString
        {  
        StringBuilder sb = new StringBuilder( "MyStack : " );
        for (AnyType x : list) 
            {
            sb.append(x + " ");
            }
        return new String( sb );
        }
        
    public AnyType top()
      {
      int size = list.size();
      if(size == 0)
            return null;
      else
          return list.get(size-1); 
      }
    
    public static void main(String[] args) throws NoSuchElementException
        {
        MyStack<Character> st = new MyStack<>() ;
        String format = "%-20s%s%n";
        
         String s = "[({}{})]";                      // Balanced input
     //  String s = "[({{})]";                       // Unbalanced input
     //  String s = "[({};{})]";                     // Invalid input
        
        for(int i = 0; i < s.length(); i++) 
            {
            char element = s.charAt(i);
            if(element == '[' || element == '(' || element == '{' )     // if element is starting brace push
                {
                st.push(element);
                }
            else if(element == ']') 
                {
                if( st.getSize() == 0)                                  //if stack is empty and closed brace 
                    {
                    System.out.println("No element inside stack.");     
                    break;
                    }     
                if(st.pop() != '[')                                    //if stack does not have balancing brace [
                    {
                    System.out.println("NOT BALANCED.");
                    break;
                    }
                }
            else if(element == '}') 
                {
                if( st.getSize() == 0)
                    {
                    System.out.println("No element inside stack.");    //if stack is empty and closed brace 
                    break;
                    }     
                if(st.pop() != '{') 
                    {
                    System.out.println("NOT BALANCED.");                //if stack does not have balancing brace {
                    break;
                    }
                }
            else if(element == ')') 
                {
                if( st.getSize() == 0)
                    {
                    System.out.println("No element inside stack.");     //if stack is empty and closed brace
                    break;
                    }     
                if(st.pop() != '(') 
                    {
                    System.out.println("NOT BALANCED.");                //if stack does not have balancing brace (
                    break;
                    }
                }
            else
                {
                throw new NoSuchElementException(element+" character is invalid.");     //invalid
                }
            System.out.printf(format,st,"Top: "+st.top());
            if(st.getSize() == 0)                                       //if at end stack is empty, balanced
                {
                System.out.println("BALANCED");
                }
            }
        } 
    }
