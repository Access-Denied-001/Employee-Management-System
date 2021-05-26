 // Advanced Tester File
import java.io.*;
public class TesterAdv {
  public static void main(String[] args){
  
  try{
   	PrintStream o = new PrintStream(new File("StudentOutAdv.txt"));
        PrintStream console = System.out;
  
        // Assign o to output stream
        System.setOut(o);
        }
         catch (FileNotFoundException ex)  
    {
        // insert code to run when exception occurs
    }
	
	
    int  N = 16;
    OrgHierarchyInterface org = new OrgHierarchy();
    System.out.println("\n--Initialized an Empty Tree--");
    //isEmpty()
    System.out.println("\nIs Tree Empty- " + org.isEmpty());
    
    // catch notempty exception #1
    try{
      System.out.println("\nWhat is the level of employee 70?" );
      int l = org.level(70); 
      System.out.println("Level = "+l);
      if(l != 5) {
        System.out.println("FAIL");
      }else{
        System.out.println("PASS");
      }
    }
    catch (IllegalIDException e){
      System.out.println("Exception2");
    }
     catch(EmptyTreeException e){ 
      System.out.println("Exception3");
    }

    //hireowner #1
    try{
    org.hireOwner(20);
    System.out.println("Hired Owner successfully with id = 20" );
    }
    catch(NotEmptyException e)
    {
      System.out.println("Exception3");
    }
    
    //isEmpty() #1
    System.out.println("\nIs Tree Empty- "+ org.isEmpty()+"\n");
    
    
    // catch notempty exception #2
    System.out.println("\n--Trying to hire owner with id = 2--");
    try{
    org.hireOwner(2);
    }
    catch(NotEmptyException e)
    {
      System.out.println("Exception2");
    }
   
      
    /* 
    Tree-
               20
             /    \
           4       26
          / \     /  \ 
         3   9   21   30 
        /   / \ 
       2   7   11
      /        /\ 
     1        35 19
              / \
             8   18
               
              
    */

    //insert employees
    try{
    // L1
    org.hireEmployee(4,20);
    System.out.println("\nHired employee successfully with id = 4" );
    org.hireEmployee(26,20);
    System.out.println("Hired employee successfully with id = 26" );
    // L2
    org.hireEmployee(3,4);
    System.out.println("Hired employee successfully with id = 3" );
    org.hireEmployee(9,4);
    System.out.println("Hired employee successfully with id = 9" );
    org.hireEmployee(21,26);
    System.out.println("Hired employee successfully with id = 21" );
    org.hireEmployee(30,26);
    System.out.println("Hired employee successfully with id = 30" );
    // L3
    org.hireEmployee(2,3);
    System.out.println("Hired employee successfully with id = 2" );
    org.hireEmployee(7,9);
    System.out.println("Hired employee successfully with id = 7" );
    org.hireEmployee(11,9);
    System.out.println("Hired employee successfully with id = 11" );
    // L4
    org.hireEmployee(1,2);
    System.out.println("Hired employee successfully with id = 1" );
    org.hireEmployee(35,11);
    System.out.println("Hired employee successfully with id = 35" );
    org.hireEmployee(19,11);
    System.out.println("Hired employee successfully with id = 19" );
    // L5 
    org.hireEmployee(8,35);
    System.out.println("Hired employee successfully with id = 8" );
    org.hireEmployee(18,35);
    System.out.println("Hired employee successfully with id = 18" );
    // L6
    }
    catch(IllegalIDException e){
      System.out.println("Exception2");
     }
    catch(EmptyTreeException e)
    { 
    System.out.println("Exception3");
    }
    //print tree

    int size1 = org.size();
    System.out.println("\nNew Organization Size: " + size1);
    try{
    System.out.println("\nOrganization = "+org.toString(20)); 
    }
    catch (IllegalIDException e) {
        System.out.println("Exception2");
    }
    catch(EmptyTreeException e){ 
      System.out.println("Exception3");
    }
    
    
    // level #1 : normal
    try{
      System.out.println("\nWhat is the level of employee 35?" );
      int l = org.level(35); 
      System.out.println("Level = "+l);
      
    }
    catch (IllegalIDException e){
      System.out.println("Exception2");
    }
     catch(EmptyTreeException e){ 
      System.out.println("Exception3");
    }

    // level #2 : root
    try{
      System.out.println("\nWhat is the level of employee 20?" );
      int l = org.level(20); 
      System.out.println("Level = "+l);
      
    }
    catch (IllegalIDException e){
      System.out.println("Exception2");
    }
     catch(EmptyTreeException e){ 
      System.out.println("Exception3");
    }

    // level #3 : IllegalID Exception
    try{
      System.out.println("\nWhat is the level of employee 70?" );
      int l = org.level(70); 
      System.out.println("Level = "+l);
     
    }
    catch (IllegalIDException e){
      System.out.println("Exception2");
    }
     catch(EmptyTreeException e){ 
      System.out.println("Exception3");
    }


    // fireEmployee #1 : Remove least id
    try{
        System.out.println("\n--Trying to fire employee with id = 1--");
        org.fireEmployee(1);
        size1 = org.size();
        System.out.println("--Employee fired successfully--");
        System.out.println("Size: "+size1);
        System.out.println("Updated Organization = "+ org.toString(20));
      }
      catch (IllegalIDException e) {
        System.out.println("Exception2");
      }
      catch(EmptyTreeException e){ 
      System.out.println("Exception3");
    }   


    // fireEmployee #2 : Remove any leaf ID
    try{
        System.out.println("\n--Trying to fire employee with id = 30--");
        org.fireEmployee(30);
        size1 = org.size();
        System.out.println("--Employee fired successfully--");
        System.out.println("Size: "+size1);
        System.out.println("Updated Organization = "+ org.toString(20));

        
      }
      catch (IllegalIDException e) {
        System.out.println("Exception2");
      }
      catch(EmptyTreeException e){ 
      System.out.println("Exception3");
    }   


    // fireEmployee #3 : IllegalID Exception - non existent ID
    try{
        System.out.println("\n--Trying to fire employee with id = 70--");
        org.fireEmployee(70);
        size1 = org.size();
        System.out.println("--Employee fired successfully--");
        System.out.println("Size: "+size1);
        System.out.println("Updated Organization = "+ org.toString(20));

       
      }
      catch (IllegalIDException e) {
        System.out.println("Exception2");
      }
      catch(EmptyTreeException e){ 
      System.out.println("Exception3");
    }   

    
    // fireEmployee(id, Manageid) #1
    try{
        org.fireEmployee(9,3);
        size1 = org.size();
        System.out.println("Size: "+ size1);
        System.out.println("New Tree- "+ org.toString(20));
        System.out.println("Subtree rooted at 3- "+ org.toString(3));
        //check if boss is changed after deletion
        int boss1 = org.boss(11);
          System.out.println(boss1);
       
      }
      catch (IllegalIDException e) {
        System.out.println("Employee does not exist");
      }
  
     catch(EmptyTreeException e){ 
      System.out.println("Exception3");
    }   
    try{
    System.out.println("New Tree- "+ org.toString(20));
    System.out.println("Subtree rooted at 3- "+ org.toString(3));
  }
  catch (IllegalIDException e) {
        System.out.println("Employee does not exist");
      }
  
     catch(EmptyTreeException e){ 
      System.out.println("Exception3");
    }   

    // fireEmployee(id, Manageid) #3 - exception  - id not present
    try{
        org.fireEmployee(9,26);
        size1 = org.size();
        System.out.println("Size: "+ size1);
        System.out.println("New Tree- "+ org.toString(20));
        System.out.println("Subtree rooted at 3- "+ org.toString(4));
        //check if boss is changed after deletion
        int boss1 = org.boss(11);
            System.out.println(boss1);
      }
      catch (IllegalIDException e) {
        System.out.println("Employee does not exist");
      }
  
     catch(EmptyTreeException e){ 
      System.out.println("Exception3");
    }   

    /* 
    Tree-
                   20  
             /  \       \   \
           4     26     9   10
           /\     /|\   |\   | \
          3  30 21 1 22 1715 29 33
        / / \                    |
       2 7   11                  31
              /\ 
             35 19
            / \
          8   18
           
    */

    //insert employees 
    try{
    // L1
    org.hireEmployee(9,20);
    System.out.println("\nHired employee successfully with id = 9" );
    org.hireEmployee(10,20);
    System.out.println("Hired employee successfully with id = 10" );
    // L2
    org.hireEmployee(22,26);
    System.out.println("Hired employee successfully with id = 22" );
    org.hireEmployee(15,9);
    System.out.println("Hired employee successfully with id = 15" );
    org.hireEmployee(17,9);
    System.out.println("Hired employee successfully with id = 17" );
    org.hireEmployee(30,4);
    System.out.println("Hired employee successfully with id = 30" );
    org.hireEmployee(1,26);
    System.out.println("Hired employee successfully with id = 1" );
    org.hireEmployee(29,10);
    System.out.println("Hired employee successfully with id = 29" );
    org.hireEmployee(33,10);
    System.out.println("Hired employee successfully with id = 33" );
    // L3
    org.hireEmployee(31,33);
    System.out.println("Hired employee successfully with id = 31" );
    }
    catch(IllegalIDException e){
      System.out.println("Exception2");
     }
    catch(EmptyTreeException e)
    { 
    System.out.println("Exception3");
    }


    // fireEmployee(id, Manageid) #4
    try{
        org.fireEmployee(11,31);
        size1 = org.size();
        System.out.println("Size: "+ size1);
        System.out.println("New Tree- "+ org.toString(20));
        int boss1 = org.boss(35);
           System.out.println(boss1+"a");
      }
      catch (IllegalIDException e) {
        System.out.println("Employee does not exist");
      }
  
     catch(EmptyTreeException e){ 
      System.out.println("Exception3");
    }

    // fireEmployee(id, Manageid) #5
    try{
        org.fireEmployee(3,17);
        size1 = org.size();
        System.out.println("\n--Employee fired successfully--");
        System.out.println("Size: "+ size1);
        System.out.println("New Tree- "+ org.toString(20));
        int boss1 = org.boss(7);
            System.out.println(boss1);
      }
      catch (IllegalIDException e) {
        System.out.println("Employee does not exist");
      }
  
     catch(EmptyTreeException e){ 
      System.out.println("Exception3");
    }   

    // fireEmployee #5 : Remove any leaf ID
    try{
        org.fireEmployee(18);
        size1 = org.size();
        System.out.println("\n--Employee fired successfully--");
        System.out.println("Size: "+size1);
        System.out.println("Updated Organization = "+ org.toString(20));

    
      }
      catch (IllegalIDException e) {
        System.out.println("Exception2");
      }
      catch(EmptyTreeException e){ 
      System.out.println("Exception3");
    }  

    // fireEmployee #6 : Remove any leaf ID
    try{
        System.out.println("\n--Trying to fire employee with id = 19--");
        org.fireEmployee(19);
        size1 = org.size();
        System.out.println("--Employee fired successfully--");
        System.out.println("Size: "+size1);
        System.out.println("Updated Organization = "+ org.toString(20));

      }
      catch (IllegalIDException e) {
        System.out.println("Exception2");
      }
      catch(EmptyTreeException e){ 
      System.out.println("Exception3");
    }  
 
    //check lowest common boss-
    try{
    	System.out.println("\n--Find lowest common boss of employees 3 and 10--");
        int lcb = org.lowestCommonBoss(17,31);
        System.out.println("Lowest common boss = "+lcb);
        
      }
      catch (IllegalIDException e) {
        System.out.println("Employee does not exist");
      }
      catch(EmptyTreeException e){ 
      System.out.println("Owner Already Exists!");
    }

    try{
      System.out.println("\n--Find lowest common boss of employees 3 and 10--");
        int lcb = org.lowestCommonBoss(30,1);
        System.out.println("Lowest common boss = "+lcb);
        
      }
      catch (IllegalIDException e) {
        System.out.println("Employee does not exist");
      }
      catch(EmptyTreeException e){ 
      System.out.println("Owner Already Exists!");
    }

    try{
      System.out.println("\n--Find lowest common boss of employees 3 and 10--");
        int lcb = org.lowestCommonBoss(30,31);
        System.out.println("Lowest common boss = "+lcb);
       
      }
      catch (IllegalIDException e) {
        System.out.println("Employee does not exist");
      }
      catch(EmptyTreeException e){ 
      System.out.println("Owner Already Exists!");
    }
    

    try{
      System.out.println("\n--Find lowest common boss of employees 3 and 10--");
        int lcb = org.lowestCommonBoss(7,26);
        System.out.println("Lowest common boss = "+lcb);
        
      }
      catch (IllegalIDException e) {
        System.out.println("Employee does not exist");
      }
      catch(EmptyTreeException e){ 
      System.out.println("Owner Already Exists!");
    }  

    try{
      System.out.println("\n--Find lowest common boss of employees 3 and 10--");
        int lcb = org.lowestCommonBoss(20,31);
        System.out.println("Lowest common boss = "+lcb);
        
      }
      catch (IllegalIDException e) {
        System.out.println("Employee does not exist");
      }
      catch(EmptyTreeException e){ 
      System.out.println("Owner Already Exists!");
    }  

  }
}
