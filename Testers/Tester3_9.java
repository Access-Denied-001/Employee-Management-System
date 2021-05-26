//miscellaneous

import java.io.*;
public class Tester3_9 {
  public static void main(String[] args){
  
	try{
   	PrintStream o = new PrintStream(new File("Student_out3_9.txt"));
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
    org.hireOwner(1);
    }
    catch(NotEmptyException e)
    {
      System.out.println("Exeption3");
    }
    
    //insert employees
    try{
    org.hireEmployee(2,1);
    org.hireEmployee(3,1);
    org.hireEmployee(4, 2);
    org.hireEmployee(5, 2);
    org.hireEmployee(6, 3);
    org.hireEmployee(7, 3);
    org.hireEmployee(11,4);
    org.hireEmployee(8, 4);
    org.hireEmployee(9, 4);
    org.hireEmployee(10,4);
    org.hireEmployee(15, 7);
    org.hireEmployee(12, 7);
    org.hireEmployee(13, 7);
    org.hireEmployee(14, 7);

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
    System.out.println(org.lowestCommonBoss(4,10)); 
    System.out.println(org.boss(4));
    org.fireEmployee(2,3);
    System.out.println(org.boss(4)); 
    System.out.println(org.lowestCommonBoss(4,10)); 
    System.out.println(org.toString(1)); 
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
