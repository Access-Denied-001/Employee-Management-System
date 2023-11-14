# Employee Management System

Problem Statement-
We want to mantain a system which keeps list of employees. The system must be dynamic enough to support change in employee status( new employee added under some current employee, current employee getting fired or quitting( if current employee has some employees under then these employees will be transfered to other employee on the same level in the company. CEO is the first person to get into the company and cannot be fired(assumption as a better approach would be to change the data of root node of the Tree as this is rooted on CEO better efficiency). Each employee stored in the system is stored with ID(unique), and level of the employee in the company(grade to which the employee is getting hired).
 
Interface- 
More over the system supports following operations:
 1. isEmpty() -->
   
                  a. checks if system has any company registered to it. 
 
                  b. False if CEO not present, else True.
                  
                  c. Takes asymptotically constant time (as we use an auxiliary boolean to keep track).
                  
 2. size() --> 
 
               a. Gives current strength of the company including CEO aswell.
 
               b. Takes asymptotically constant time (as we use an auxiliary integer var to keep track).
               
 3. level() --> 
  
                a. Given a valid ID of the employee it will give its current level in the company (Level 1 is CEO).
 
                b. Takes asymptotically logarithmic wrt size() time (as we do a search in the balanced tree).
                
 4. hireOwner --> 
  
                  a. This is the first operation which needs to be done to run the company (Hires CEO).
 
                  b. Takes asymptotically constant time (as we make root of the tree).
                  
 5. hireEmployee --> 
 
                     a. This method takes an employee ID, and boss ID and puts this employee under the boss with boss ID. Both ID's must be valid else we will show an Error.
 
                     b. Takes asymptotically log(size()) time (as we do a search in the balanced tree and then put this employee under the boss).
                     
 6. fireEmployee --> This method has two variants: 
 
                     1. fireEmployee which has no one under. So this is easy deletion in the tree and some rebalancing in the tree. Requires only the ID of the employee getting fired. Requires only logarithmic wrt size() time to search in the tree and constant time to delete using boss method. 
                     
                     2. fireEmployee which has some Employees under. So this a little tricky as this would require two arguments employee ID and colleague ID (to whom the employees under will get shifted). This may take linear wrt size() time as we might require to shift almost every employee in the company except a few(CEO, 1 more).
                                     
 7. boss --> 
 
             a. This method takes in employee ID and tells the boss ID of that employee.
  
             b. Takes asymptotically logarithmic time (as We use refernces to boss during employee addition, so it is essentially finding employee in the tree).
             
 8. LowestCommonBose --> 
  
                         a. This method takes in two employee ID and tells who is the immediate boss of both of them.
  
                         b. This method is Linear wrt size() time (as we used simple reccursion to execute this but can be converted in logarithmic time by technique know as Binary Uplifting).
                         
9. toString --> 
 
               Prints a nice view of the company with each employee at their correct levels and CEO being at the top. Takes lineartime to print as we have to go to each employee. Also does level-wise sorting for better analysis.


Example-
Now I am gonna give a walkthrough of the system with an example- 

Let's say we have a company known "New Age Technologies":

                                                            "New Age Technologies"
                                                                   [Empty]
                                                                   
                                                                   
 1. hireOwner[1]-  Hire CEO with ID=1                                
 
                                                                      1
                                                                      
 2. Bunch of hiring process
  
    1. hireEmployee[3,1] - Hires an employee with  ID=3 under 1
    
    2. hireEmployee[2,1] - Hires an employee with ID=2 under 1
    
    3. hireEmployee[12,1] - Hires an employee with ID=12 under 1
    
    4. hireEmployee[8,3] - Hires an employee with ID=8 under 3
    
    5. hireEmployee[4,3] -  Hires an employee with ID=4 under 3

    6. hireEmployee[7,2] -  Hires an employee with ID=7 under 2
    
    7. hireEmployee[10,12] -  Hires an employee with ID=10 under 12
    
    8. hireEmployee[16,8] -  Hires an employee with ID=16 under 8
    
    9. hireEmployee[5,8] -  Hires an employee with ID=5 under 8
    
    10. hireEmployee[3,2] -  Hires an employee with ID=3 under 2 (throws error message as ID=3 already exists)
   


ORGANISATIONAL TREE note that this not the tree that code represents but this tree is implicitly embedded in more general Tree that code represents. But on using toString() method this will print eaxctly same Tree as below. Just in levelwise ordering. Also in a level it gets sorted by employee ID.

                                                                        1
                                                                     ------- 
                                                                   /    |    \
                                                                 3      2     12
                                                               - -      -     -
                                                              /  |      |     |
                                                             8   4      7     10
                                                            - -
                                                           /   \
                                                          16    5
                                                          
 2. size() - 10 (as 10 employees are in the System including CEO).
 
 3. toString() - 1, 2 3 12, 4 7 8 10, 5 16.

 4. level(5) - 4
 
 5. fireEmployee[7] - Fires employee(7) under employee(2)
 
                                                                        1
                                                                     ------- 
                                                                   /    |    \
                                                                 3      2     12
                                                               - -            -
                                                              /  |            |
                                                             8   4            10
                                                            - -
                                                           /   \
                                                          16    5
 
6. fireEmployee[8,4] - fires employee(8) and change employees under employee(8) (16, 5) to employee(4).

                                                                        1
                                                                     ------- 
                                                                   /    |    \
                                                                 3      2     12
                                                                 -            -
                                                                 |            |
                                                                 4            10
                                                                - -
                                                               /   \
                                                              16    5
                                                              
7. boss(5) - 4 (after above operation employee(5) is under employee(4))

8. lowestCommonBoss(3,10) - 1 (as between ID=3 and ID=10, ID=1 is LCB)

9. lowestCommonBoss(16,5) - 4

If you have anyother doubts then check A2.pdf file as this contains detailed overview of the assignment.
