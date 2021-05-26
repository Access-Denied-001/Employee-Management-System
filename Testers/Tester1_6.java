//check all function's illegal id exception


import java.io.*;
public class Tester1_6 {
  public static void main(String[] args){
  
	try{
   	PrintStream o = new PrintStream(new File("Student_out1_6.txt"));
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
    org.hireOwner(25);
    }
    catch(NotEmptyException e)
    {
      System.out.println("Exeption3");
    }
    
  

  //insert employees
    try{
    org.hireEmployee(532,25);
    org.hireEmployee(208,25);
    org.hireEmployee(10, 25);
    org.hireEmployee(1201, 25);
    org.hireEmployee(1, 25);
    org.hireEmployee(92, 532);
    org.hireEmployee(33, 532);
    org.hireEmployee(4, 532);
    org.hireEmployee(102, 208);
    org.hireEmployee(35, 208);
    org.hireEmployee(51, 10);
    org.hireEmployee(65, 1201);
    org.hireEmployee(48, 51); 
    org.hireEmployee(100000, 51);
    org.hireEmployee(666, 100000);
    org.hireEmployee(99999, 666);
    org.hireEmployee(19, 99999);
     
    }
    catch(IllegalIDException e){
      System.out.println("Exception1");
     }
    catch(EmptyTreeException e)
    { 
    System.out.println("Exception2");
    }
 
    try{
    org.level(7);
    } 
    catch (IllegalIDException e){
        System.out.println("Exeption11");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption2");
    }   
    
    try{
    org.hireEmployee(85,7);
    } 
    catch (IllegalIDException e){
        System.out.println("Exeption12");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption2");
    }   
    
    try{
    org.fireEmployee(7);
    } 
    catch (IllegalIDException e){
        System.out.println("Exeption13");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption2");
    }   
    
    try{
    org.fireEmployee(7,1);
    } 
    catch (IllegalIDException e){
        System.out.println("Exeption14");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption2");
    }   
    
    try{
    org.boss(7);
    } 
    catch (IllegalIDException e){
        System.out.println("Exeption15");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption2");
    }   
    
    try{
    org.lowestCommonBoss(7,1);
    } 
    catch (IllegalIDException e){
        System.out.println("Exeption16");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption2");
    }   
    
    try{
    org.toString(7);
    } 
    catch (IllegalIDException e){
        System.out.println("Exeption17");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption2");
    }   
   
    }
}
