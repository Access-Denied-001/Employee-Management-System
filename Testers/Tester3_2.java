//miscellaneous

import java.io.*;
public class Tester3_2 {
  public static void main(String[] args){
  
	try{
   	PrintStream o = new PrintStream(new File("Student_out3_2.txt"));
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
    
    //insert employees
    try{
    org.hireEmployee(60, 10);
    org.hireEmployee(50, 10);
    org.hireEmployee(100, 10);
    org.hireEmployee(30, 10);
    org.hireEmployee(80, 60);
    org.hireEmployee(15, 60);
    org.hireEmployee(70, 60);
    org.hireEmployee(300, 50);
    org.hireEmployee(400, 50);
    org.hireEmployee(8, 100);
    org.hireEmployee(7, 100);
    org.hireEmployee(6, 100);
    org.hireEmployee(5, 100); 
    org.hireEmployee(4, 100);
    org.hireEmployee(1000, 30);    
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
    System.out.println(org.lowestCommonBoss(60,300));
    org.fireEmployee(300);
    org.fireEmployee(60, 50);
    System.out.println(org.toString(50));
    org.hireEmployee(60, 400);

    System.out.println(org.lowestCommonBoss(60,400));
    System.out.println(org.lowestCommonBoss(80,15));
    org.hireEmployee(600, 400);
    System.out.println(org.lowestCommonBoss(400,5));
    }
    catch (IllegalIDException e)
    {
      System.out.println("Exeption1");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption2");
    }   
    
    }
}
