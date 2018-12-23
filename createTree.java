 //Name: Haleigh Jayde Doetschman
//Date: 11/28/2018
//Class: CMIS 350
//Purpose: Creates binary search tree and implements related methods
package binarysearchtreesort;


public class createTree {
    //variables
    private static String defaultString = "";
    private Node root;
    private int comparison;

    //method to initialize tree
    public Node initTree(ArrayStack<String> numArray, boolean isInteger) throws StackException, NumberFormatException {
        root = null;
        Node treeNode;

        while (!numArray.isEmpty()) {
            treeNode = new Node(numArray.pop());
            System.out.println("Node created: " + treeNode.value);
            System.out.println("treeNode value: " + treeNode.value);
            root = insertNode(root, treeNode, isInteger);
        }
        System.out.println("Tree initialized: " + root.value);
        return root;
    }

//method to allow new value to be inserted in tree 
    public Node insertNode(Node parent, Node child, boolean isInteger) throws NumberFormatException {
        if (parent == null) {
            System.out.println("Parent null, child value added: " + child.value);
            return child;
        } else {
            if (isInteger == true) {
                System.out.println("Parent Intval: " + (parent.toString()));
                System.out.println("Child Intval: " + (child.toString()));
                if ((parent.toString() != null) && (child.toString() != null)) {
                    if (parent.toString().contains("/") || child.toString().contains("/")) {
                        throw new NumberFormatException("These aren't integers");
                    }
                    if (Integer.valueOf(parent.toString()) > Integer.valueOf(child.toString())) {
                        parent.setLeft(insertNode(parent.getLeft(), child, true));
                    } else {
                        parent.setRight(insertNode(parent.getRight(), child, true));
                    }
                    System.out.println("Value added: " + parent.toString());
                }
                return parent;
            } else {
                if ((parent.toString() != null) && (child.toString() != null)) {
                    defineFraction fraction1 = new defineFraction(parent.toString());
                    comparison = fraction1.compareTo(child.toString());
                    if (comparison > 0) {
                        parent.setLeft(insertNode(parent.getLeft(), child, false));
                    } else {
                        parent.setRight(insertNode(parent.getRight(), child, false));
                    }
                    System.out.println("Value added: " + parent.toString());
                }
                return parent;
            }
        }
    }
    
    //method that performs in order tree traversal and generates/returns string
    //********containing tree elements in sorted order
    public String treeTraversal(Node node) {
        if (!(node == null)) {
            treeTraversal(node.getLeft());
            defaultString += (node.toString() + " ");
            treeTraversal(node.getRight());
        }
        System.out.println("Default String: " + defaultString + " ");
        return defaultString;
    }

    public static String finalOutput(String sortedList, boolean isAscending) throws StackException, NumberFormatException {
        defaultString = "";
        String outputString = sortedList;
        if (isAscending == false) {
            String[] numberArray = sortedList.split(" ");
            int arrayLength = numberArray.length;
            String outString = "";
            for (int i = arrayLength; i > 0; i--) {
                outString += (numberArray[i-1] + " ");
            }
            System.out.println("Output String: " + outString);
            return outString;
        }
        System.out.println("Output String: " + outputString);
        return outputString;
    }

}
