import java.awt.*;
import java.io.*;
import java.util.*;

// Tree node
class Node {
    int eId;
    int eLevel;
    Node boss;
    Vector <Node> bossOf;
    Node left;
    Node right;
    int height;
    int balance;
    public Node(int id){
        eId=id;
        left= null;
        right= null;
        balance=0;
        height=0;
        bossOf=new Vector<Node>();
    }
    public Node(int id,int level){
        eId=id;
        eLevel=level;
        left= null;
        right= null;
        balance=0;
        height=0;
        bossOf=new Vector<Node>();
    }
    public int getEId(){
        return eId;
    }
    public int getLevel(){
        return eLevel;
    }
}

class vectorQueue{
    Vector<Node> queue;
    int size;
    public vectorQueue(){
        size = 0;
        queue = new Vector<Node>();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public int size(){
        return size;
    }
    public Vector<Node> enqueue(Node employee){
        queue.add(employee);
        size++;
        return queue;
    }
    public Node dequeue(){
        size--;
        return queue.remove(0);
    }
    public Node peekFront(){
        if(isEmpty()){
            return null;
        }
        else{
            return queue.get(0);
        }
    }
    public Node peekLast(){
        if(isEmpty()){
            return null;
        }
        else{
            return queue.get(size-1);
        }
    }
}

public class OrgHierarchy implements OrgHierarchyInterface{
    //root node
    Node root;
    static boolean hasOwner=false;
    int ownerId;
    int size = 0;

    public boolean isEmpty(){
        return root==null;
    }

    public int size(){
        return size;
    }

    public int level(int id) throws IllegalIDException, EmptyTreeException{
        if(!hasOwner){
            throw new EmptyTreeException("No boss in the organisation");
        }
        if(searching(root,id) == null){
            throw new IllegalIDException("No employee with this ID in the company");
        }
        else{
            return searching(root,id).eLevel;
        }
    }

    public void hireOwner(int id) throws NotEmptyException{
        if(!hasOwner){
            Node ownerNode = new Node(id,1);
            ownerNode.boss = null;
            root = insertion(root,ownerNode);
            ownerId = id;
            size++;
            hasOwner = true;
        }
        else{
            throw new NotEmptyException("Owner Already Exists!!!");
        }

    }

    public void hireEmployee(int id, int bossid) throws IllegalIDException, EmptyTreeException{
        if(!hasOwner){
            throw new EmptyTreeException("Organisation has no CEO!!!");
        }
        else{
            if(searching(root,bossid)==null){
                throw new IllegalIDException("BossId not in organisation!!! Cannot add Employee under non-existent boss");
            }
            if(id == ownerId){
                throw new IllegalIDException("Cannot add more than one CEO!!!");
            }
            else if(searching(root,id)!=null){
                throw new IllegalIDException("EmployeeId already in Organisation!!! Cannot add Employee with same ID");
            }
            else{
                Node bossNode = searching(root,bossid);
                Node newEmployee = new Node(id, bossNode.eLevel+1);
                newEmployee.boss = bossNode;
                bossNode.bossOf.add(newEmployee);
                root = insertion(root,newEmployee);
                size++;
            }
        }
    }

    public void fireEmployee(int id) throws IllegalIDException,EmptyTreeException{
        if(!hasOwner){
            throw new EmptyTreeException("Organisation has no CEO!!!");
        }
        else {
            if (id == ownerId) {
                throw new IllegalIDException("Owner cannot be removed ever!!!");
            }
            if (searching(root, id) == null) {
                throw new IllegalIDException("No Employee with this ID!!!");
            }
            else {
                Node removedEmployee = searching(root,id);
                if(removedEmployee.bossOf.size() != 0){
                    throw new IllegalIDException("Cannot delete an Employee which has employee under it by this method.");
                }
                else{
                    root = deletion(root,removedEmployee);
                    size--;
                    Vector <Node> deletedEmployeeBoss = removedEmployee.boss.bossOf;
                    deletedEmployeeBoss.remove(removedEmployee);
                }
            }
        }
    }

    public void fireEmployee(int id, int manageid) throws IllegalIDException,EmptyTreeException{
        if(!hasOwner){
            throw new EmptyTreeException("No CEO of this Company!!!");
        }
        else{
            if(id == ownerId){
                throw new IllegalIDException("Owner cannot be deleted");
            }if(manageid == ownerId){
                throw new IllegalIDException("Owner cannot have siblings");
            }
            if(searching(root,id) == null){
                throw new IllegalIDException("Employee to be deleted does not exists");
            }if(searching(root,manageid) == null){
                throw new IllegalIDException("New Manager not in organisation");
            }
            else{
                Node oldManager = searching(root,id);
                Node newManager = searching(root,manageid);
                if(oldManager.eLevel != newManager.eLevel){
                    throw new IllegalIDException("Levels of employees cannot be different");
                }
                else{
                    // old managers boss vector
                    Vector<Node> oldManagerManagee = oldManager.bossOf;
                    Vector<Node> newManagerManagee = newManager.bossOf;
                    int n = oldManagerManagee.size();
                    for(int i=0;i<n;i++){
                        Node employee = oldManagerManagee.get(i);
                        employee.boss = newManager;
                        newManagerManagee.add(employee);
                    }
                    Vector<Node> oldManagersBoss = oldManager.boss.bossOf;
                    oldManagersBoss.remove(oldManager);
                    root = deletion(root,oldManager);
                    size--;
                }
            }
        }
    }

    public int boss(int id) throws IllegalIDException,EmptyTreeException{
        if(!hasOwner){
            throw new EmptyTreeException("Organisation has no CEO!!!");
        }
        if(id == ownerId){
            return -1;
        }
        else if(searching(root,id) == null){
            throw new IllegalIDException("No such Employee exists!!!");
        }
        else{
            return searching(root,id).boss.eId;
        }
    }

    public int lowestCommonBoss(int id1, int id2) throws IllegalIDException,EmptyTreeException{
        if(!hasOwner){
            throw new EmptyTreeException("No CEO in the company!!!");
        }
        else{
            Node employee1 = searching(root, id1);
            Node employee2 = searching(root, id2);
            if(employee1 == null){
                throw new IllegalIDException("Id1 does not exists in organisation!!!");
            }
            if(employee2 == null){
                throw new IllegalIDException("Id2 does not exists in organisation!!!");
            }
            else {
                if (id1 == ownerId || id2 == ownerId) {
                    return -1;
                }
                else{
                    if(employee1.eLevel == employee2.eLevel){
                        if(employee1.boss == employee2.boss){
                            return employee1.boss.eId;
                        }
                        else{
                            return lowestCommonBoss(employee1.boss.eId,employee2.boss.eId);
                        }
                    }
                    else{
                        if(employee1.eLevel < employee2.eLevel){
                            return lowestCommonBoss(employee1.eId, employee2.boss.eId);
                        }else{
                            return lowestCommonBoss(employee1.boss.eId, employee2.eId);
                        }
                    }
                }
            }
        }
    }

    public String toString(int id) throws IllegalIDException, EmptyTreeException{
        if(!hasOwner){
            throw new EmptyTreeException("Organisation is Empty!!!");
        }
        else {
            if (searching(root, id) == null) {
                throw new IllegalIDException("No such employee exists !!!");
            } else {
                return bfs(searching(root, id));
            }
        }
    }

    private String vectorToString(Vector<Node> sortedNodes){
        StringBuilder sb = new StringBuilder("");
        int sortedSize = sortedNodes.size();
        for(int i=0;i<sortedSize;i++){
            sb.append(sortedNodes.get(i).eId);
            if(i != sortedSize-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private String bfs(Node node){
        StringBuilder result = new StringBuilder("");
        if(node == null){
            return result.toString();
        }
        vectorQueue traversalQueue = new vectorQueue();
        traversalQueue.enqueue(node);
        Vector<Node> sortedNodes = new Vector<Node>();
        while(!traversalQueue.isEmpty()){
            Node pNode = traversalQueue.dequeue();
            int k = pNode.bossOf.size();
            for(int i=0;i<k;i++) {
                if (pNode.bossOf.get(i) != null) {
                    traversalQueue.enqueue(pNode.bossOf.get(i));
                }
            }
            int j = sortedNodes.size()-1;
            while(j>=0 && pNode.eId < sortedNodes.get(j).eId){
                j--;
            }
            sortedNodes.add(j+1,pNode);
            if(!traversalQueue.isEmpty()){
                if(pNode.eLevel != traversalQueue.peekFront().eLevel){
                    result.append(vectorToString(sortedNodes));
                    result.append(",");
                    sortedNodes.clear();
                }
            }
            else{
                result.append(vectorToString(sortedNodes));
                sortedNodes.clear();
            }
        }
        return result.toString();
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.eId + " ");
        inorder(node.right);
    }

    private Node searching(Node node,int id){
        // If no employee with this id is present then returns null
        // base case
        if(node==null){
            return node;
        }
        else{
            // If id is less than node.eId go to search in left subtree
            if (node.eId>id)
            {
                return searching(node.left,id);
            }
            // If id is more than node.eId got to search in left subtree
            else if(node.eId < id)
            {
                return searching(node.right, id);
            }
            // Condition node.eId == id meaning Found employee with id given and return node
            else {
                return node;
            }
        }
    }

    private Node insertion(Node node,Node employee){
        // Sanitize inputs
        if(employee == null){
            return node;
        }
        // node is null then correct position found
        if (node == null) {
            return employee;
        }
        // Find correct position
        else {
            // insertion in left subtree
            if (node.eId > employee.eId) {
                node.left = insertion(node.left, employee);
            }
            // insertion in right tree
            else {
                node.right = insertion(node.right, employee);
            }
        }
        //Update height and balance of each node in path
        update(node);

        if(node.balance < -1){
            if(employee.eId > node.right.eId){
                return leftRotation(node);
            }
            if(employee.eId < node.right.eId){
                node.right = rightRotation(node.right);
                return leftRotation(node);
            }
        }
        if(node.balance > 1){
            if(employee.eId < node.left.eId)
            {
                return rightRotation(node);
            }
            if(employee.eId > node.left.eId){
                node.left = leftRotation(node.left);
                return rightRotation(node);
            }
        }
        return node;
    }

    private Node deletion(Node node, Node employee){
        if(node == null){
            return node;
        }
        if(node.eId > employee.eId){
            node.left = deletion(node.left,employee);
        }
        else if(node.eId < employee.eId){
            node.right = deletion(node.right,employee);
        }
        else{
            if(node.left == null && node.right == null){
                node = null;
            }
            else if(node.left == null || node.right == null){
                if(node.left == null){
                    node = node.right;
                }
                if(node.right == null){
                    node = node.left;
                }
            }
            else{
                if(node.right.height > node.left.height) {
                    Node successor = findMin(node.right);
                    node.eId = successor.eId;
                    node.eLevel = successor.eLevel;
                    node.boss = successor.boss;
                    node.bossOf = successor.bossOf;
                    node.right = deletion(node.right, successor);
                }else{
                    Node predecessor = findMax(node.left);
                    node.eId = predecessor.eId;
                    node.eLevel = predecessor.eLevel;
                    node.boss = predecessor.boss;
                    node.bossOf = predecessor.bossOf;
                    node.left = deletion(node.left, predecessor);
                }
            }
        }
        // No re-balancing required
        if(node == null){
            return node;
        }
        // Don't update node which is null
        update(node);
        if(node.balance < -1){
            if(node.right.balance <= 0){
                return leftRotation(node);
            }
            if(node.right.balance > 0){
                node.right = rightRotation(node.right);
                return leftRotation(node);
            }
        }
        if(node.balance > 1){
            if(node.left.balance >= 0){
                return rightRotation(node);
            }
            if(node.left.balance < 0){
                node.left = leftRotation(node.left);
                return rightRotation(node);
            }
        }
        return node;
    }

    private Node leftRotation(Node node){
        // if node is null then no rotation is required
        if(node==null){
            return node;
        }
        // Z->Y->X to Z<--Y-->X then change node to Y and Y's left to Z and left-subtree to right-subtree of Z
        Node y = node.right;
        // Changing left subtree of Y to right of Z
        node.right = y.left;
        // Change left of Y to Z
        y.left = node;
        // change height of Z and Y
        update(node);
        update(y);
        // return ref to root of that subtree
        return y;
    }

    private Node rightRotation(Node node) {
        // Node is null already balanced
        if(node ==null){
            return node;
        }
        // X<--Y<--Z to X<--Y-->Z and right subtree of Y to left subtree of Z
        Node y = node.left;
        // Changing subtree
        node.left = y.right;
        // change Y's right to Z
        y.right=node;
        // Update height of X and Y
        update(node);
        update(y);
        // Return ref to new subtrees leading node
        return y;
    }

    private Node findMin(Node node){
        // If node is null then return null as min Node (No use in algorithm)
        if(node == null){return node;}
        // Make a temp such that node reference is not lost
        Node temp=node;
        // Go left till minimum is encountered
        while(temp.left != null){
            temp = temp.left;
        }
        // return min value
        return temp;
    }

    private Node findMax(Node node) {
        // If node is null then return null as max Node
        if (node == null) {
            return node;
        }
        Node temp = node;
        // Go right till you get maximum node
        while (temp.right != null) {
            temp = temp.right;
        }
        // return that node
        return temp;
    }

    private void update(Node node){
        if(node != null) {
            // height of node is decided by its left subtree height and right subtree heights
            // height of left subtree
            int leftH;
            if (node.left == null) {
                leftH = -1;
            } else {
                leftH = node.left.height;
            }
            // height of right subtree
            int rightH;
            if (node.right == null) {
                rightH = -1;
            } else {
                rightH = node.right.height;
            }
            node.height = 1 + Math.max(leftH, rightH);
            // Convention
            node.balance = leftH - rightH;
        }
    }

}