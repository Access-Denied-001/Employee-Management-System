import java.io.*;
public class Tester2 {
  public static void main(String[] args){
  
	try{
   	PrintStream o = new PrintStream(new File("Student_out2.txt"));
        PrintStream console = System.out;
  
        // Assign o to output stream
        System.setOut(o);
        }
         catch (FileNotFoundException ex)  
    {
        // insert code to run when exception occurs
    }
        
    int  N = 6;
    OrgHierarchyInterface org = new OrgHierarchy();
    //System.out.println("\n--Initialized an Empty Tree--");
    //isEmpty()
    //System.out.println("\nIs Tree Empty- " + org.isEmpty());
    
    //hireowner
     try{
    org.hireOwner(1000);
   // System.out.println("Hired Owner successfully with id = 1" );
    }
    catch(NotEmptyException e)
    {
      System.out.println("Exeption3");
    }
    
    //isEmpty()
    System.out.println("\nIs Tree Empty- "+ org.isEmpty()+"\n");
    
    
    // catch notempty exception
    //System.out.println("\n--Trying to hire owner with id = 2--");
    try{
    org.hireOwner(2);
    }
    catch(NotEmptyException e)
    {
      System.out.println("Exeption3");
    }
   
      
    /* 
    Tree-
                  1000
                /     \ 
              13       2
              /|\
     	     1000000 99999 1000000000
    */

    //insert employees
    try{
    org.hireEmployee(13,1000);
    org.hireEmployee(2,1000);
    org.hireEmployee(1000000, 13);
    org.hireEmployee(99999, 13);
    org.hireEmployee(1000000000, 13);
    }
    catch(IllegalIDException e){
      System.out.println("Exception1");
     }
    catch(EmptyTreeException e)
    { 
    System.out.println("Exception2");
    }
    //print tree
   
    int size1 = org.size();
    System.out.println("\nNew Organization Size: " + size1);
    try{
    System.out.println("\nOrganization = "+org.toString(1000));
    }
    catch (IllegalIDException e) {
        System.out.println("Exeption1");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption2");
    }
    //check size
    if(size1 != N){
      System.out.println("FAIL");
      }
    else{
      System.out.println("PASS");
    }
    
    //check fireEmployee(id, Manageid)
    try{
        org.fireEmployee(13,2);
        size1 = org.size();
        System.out.println("--Employee fired successfully--");
        System.out.println("Size: "+ size1);
        System.out.println("New Tree- "+ org.toString(1000));
        System.out.println("Subtree rooted at 2- "+ org.toString(2));
        //check if boss is changed after deletion
        int boss1 = org.boss(1000000000);
        if(boss1 != 2){
          System.out.println("FAIL");
        }
        else{
          System.out.println("--Employee 2 is made new boss successfully--");
          System.out.println("PASS");
        }
      }
      catch (IllegalIDException e) {
        System.out.println("Employee does not exist");
      }
  
     catch(EmptyTreeException e){ 
      System.out.println("Exeption2");
    }   
    


    //check toString exception IllegalIdException-
     try{
    System.out.println("\nOrganization = "+org.toString(1));
    }
    catch (IllegalIDException e) {
        System.out.println("Exeption1");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exeption2");
    }
      

  }
}
