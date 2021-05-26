import java.io.*;
public class Tester1 {
  public static void main(String[] args){
  
	try{
   	PrintStream o = new PrintStream(new File("Student_out1.txt"));
        PrintStream console = System.out;
  
        // Assign o to output stream
        System.setOut(o);
        }
         catch (FileNotFoundException ex)  
    {
        // insert code to run when exception occurs
    }
        
    int  N = 10;
    OrgHierarchyInterface org = new OrgHierarchy();
    //System.out.println("\n--Initialized an Empty Tree--");
    //isEmpty()
    //System.out.println("\nIs Tree Empty- " + org.isEmpty());
    
    //hireowner
     try{
    org.hireOwner(1);
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
                  1
                / | \
           3      2     12
          / \     |     |
         8   4    7     10
        / \
       16  5 
    */

    //insert employees
    try{
    org.hireEmployee(3,1);
    //System.out.println("\nHired employee successfully with id = 3" );
    org.hireEmployee(2,1);
    //System.out.println("Hired employee successfully with id = 2" );
    org.hireEmployee(12,1);
    //System.out.println("Hired employee successfully with id = 12" );
    org.hireEmployee(8,3);
    //System.out.println("Hired employee successfully with id = 8" );
    org.hireEmployee(4,3);
    //System.out.println("Hired employee successfully with id = 4" );
    org.hireEmployee(7,2);
    //System.out.println("Hired employee successfully with id = 7" );
    org.hireEmployee(10,12);
    //System.out.println("Hired employee successfully with id = 10" );
    org.hireEmployee(16,8);
    //System.out.println("Hired employee successfully with id = 16" );
    org.hireEmployee(5,8);
    //System.out.println("Hired employee successfully with id = 5\n" );
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
    System.out.println("\nOrganization = "+org.toString(1)); // "1,2 3 12,4 7 8 10,5 16"
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
    
    //check level

    try{
    //  System.out.println("\nWhat is the level of employee 5?" );
      int l = org.level(5); 
      System.out.println("Level = "+l);
      if(l != 4) {
        System.out.println("FAIL");
      }else{
        System.out.println("PASS");
      }
    }
    catch (IllegalIDException e){
      System.out.println("Exeption1");
    }
     catch(EmptyTreeException e){ 
      System.out.println("Exeption2");
    }


    //check fireEmployee
      try{
      //  System.out.println("\n--Trying to fire employee with id = 7--");
        org.fireEmployee(7);
        size1 = org.size();
        //System.out.println("--Employee fired successfully--");
        System.out.println("Size: "+size1);
        System.out.println("Updated Organization = "+ org.toString(1));

        if(size1 != N-1){
          System.out.println("FAIL");
        }
        else{
          System.out.println("PASS");
        }
      }
      catch (IllegalIDException e) {
        System.out.println("Exeption1");
      }
      catch(EmptyTreeException e){ 
      System.out.println("Exeption2");
    }   
    
    //check fireEmployee(id, Manageid)
    try{
        //System.out.println("\n-- fire employee with id = 8 and make id = 4 new boss of its children--");
        org.fireEmployee(8,4);
        size1 = org.size();
        System.out.println("--Employee fired successfully--");
        System.out.println("Size: "+ size1);
        System.out.println("New Tree- "+ org.toString(1));
        System.out.println("Subtree rooted at 3- "+ org.toString(3));
        //check if boss is changed after deletion
        int boss1 = org.boss(5);
        if(boss1 != 4){
          System.out.println("FAIL");
        }
        else{
          System.out.println("--Employee 3 is made new boss successfully--");
          System.out.println("PASS");
        }
      }
      catch (IllegalIDException e) {
        System.out.println("Employee does not exist");
      }
  
     catch(EmptyTreeException e){ 
      System.out.println("Exeption2");
    }   
    


    //check lowest common boss-
    try{
    	//System.out.println("\n--Find lowest common boss of employees 3 and 10--");
        int lcb = org.lowestCommonBoss(3,10);
        System.out.println("Lowest common boss = "+lcb);
        if(lcb != 1){
          System.out.println("FAIL");
        }
        else{
          System.out.println("PASS");
        }
      }
      catch (IllegalIDException e) {
        System.out.println("Exception1");
      }
      catch(EmptyTreeException e){ 
      System.out.println("Exception2");
    }
      

  }
}
