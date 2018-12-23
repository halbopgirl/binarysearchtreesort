//Name: Haleigh Jayde Doetschman
//Date: 11/28/2018
//Class: CMIS 350
//Purpose: Basic Node interface for use with OperandNode

package binarysearchtreesort;

public class Node {
    public String value;
    private Node left;
    private Node right;
    
    //initializing tree
    public Node(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    
    //getters and setters
    public Node getLeft(){
        return left;
    }
    
    public Node getRight(){
        return right;
    }
    
    public void setLeft(Node left){
        this.left = left;
    }
    
    public void setRight(Node right) {
        this.right = right;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
}
