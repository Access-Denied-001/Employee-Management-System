//check empty tree exception

import java.io.*;
public class Tester1_1 {
  public static void main(String[] args){
  
	try{
   	PrintStream o = new PrintStream(new File("Student_out1_1.txt"));
        PrintStream console = System.out;
  
        // Assign o to output stream
        System.setOut(o);
        }
         catch (FileNotFoundException ex)  
    {
        // insert code to run when exception occurs
    }
        
    
    OrgHierarchyInterface org = new OrgHierarchy();

    //isEmpty()
    System.out.println("\nIs Tree Empty- "+ org.isEmpty()+"\n");
    
    //catch empty tree exception-
    try{
    org.level(7);
    } 
    catch (IllegalIDException e){
        System.out.println("Exeption1");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption21");
    }   
    
    try{
    org.hireEmployee(85,7);
    } 
    catch (IllegalIDException e){
        System.out.println("Exeption12");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption22");
    }   
    
    try{
    org.fireEmployee(7);
    } 
    catch (IllegalIDException e){
        System.out.println("Exeption13");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption23");
    }   
    
    try{
    org.fireEmployee(7,1);
    } 
    catch (IllegalIDException e){
        System.out.println("Exeption14");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption24");
    }   
    
    try{
    org.boss(7);
    } 
    catch (IllegalIDException e){
        System.out.println("Exeption15");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption25");
    }   
    
    try{
    org.lowestCommonBoss(7,1);
    } 
    catch (IllegalIDException e){
        System.out.println("Exeption16");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption26");
    }   
    
    try{
    org.toString(7);
    } 
    catch (IllegalIDException e){
        System.out.println("Exeption17");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption27");
    }  
    
  }
}
