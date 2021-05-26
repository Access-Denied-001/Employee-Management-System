//miscellaneous

import java.io.*;
public class Tester3_5 {
  public static void main(String[] args){
  
	try{
   	PrintStream o = new PrintStream(new File("Student_out3_5.txt"));
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
    org.hireOwner(1000000000);
    }
    catch(NotEmptyException e)
    {
      System.out.println("Exeption3");
    }
    
    //insert employees
    try{
    org.hireEmployee(289,1000000000);
    org.hireEmployee(1, 1000000000);
    org.hireEmployee(2, 1000000000);
    org.hireEmployee(3, 1000000000);
    org.hireEmployee(4, 1000000000);
    org.hireEmployee(50, 3);
    int a = 49;
    for(int i = a; i >= 15; i--)
    {
	  org.hireEmployee(i,i+1);
    }
    }
    catch(IllegalIDException e){
      System.out.println("Exception1");
     }
    catch(EmptyTreeException e)
    { 
    System.out.println("Exception2");
    }


   
    try
    {
    for(int i = 15; i <= 50; i++)
    {
	  org.fireEmployee(i);
	  System.out.println(org.toString(1000000000));
    }
    }
    catch (IllegalIDException e)
    {
      System.out.println("Exeption14");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption2");
    }   
    }
}
