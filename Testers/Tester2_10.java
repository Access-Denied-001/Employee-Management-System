//hireOwner()

import java.io.*;
public class Tester2_10 {
  public static void main(String[] args){
  
	try{
   	PrintStream o = new PrintStream(new File("Student_out2_10.txt"));
        PrintStream console = System.out;
  
        // Assign o to output stream
        System.setOut(o);
        }
         catch (FileNotFoundException ex)  
    {
        // insert code to run when exception occurs
    }
        
    
    OrgHierarchyInterface org = new OrgHierarchy();
    
   //hireowner
    try
    {
    org.hireOwner(10);
    }
    catch(NotEmptyException e)
    {
      System.out.println("Exeption3");
    }
    
    System.out.println(10);
  }
}
