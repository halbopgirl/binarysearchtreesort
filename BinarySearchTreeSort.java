//Name: Haleigh Jayde Doetschman
//Date: 11/28/2018
//Class: CMIS 350
//Purpose: Define the GUI and implement methods 
package binarysearchtreesort;

//imports 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class BinarySearchTreeSort {
    
    
//user panel elements

    private final JLabel originalListLabel = new JLabel("Original List ");
    private final JLabel sortedListLabel = new JLabel("Sorted List ");
    private final JLabel sortOrder = new JLabel("Sort Order");
    private final JLabel numericType = new JLabel("   Numeric Type");
    private JTextField originalList = new JTextField();
    private JTextField sortedList = new JTextField();
    private final JButton evalButton = new JButton("Perform Sort");
    private final JRadioButton ascending = new JRadioButton("Ascending");
    private final JRadioButton descending = new JRadioButton("Descending");
    private final JRadioButton integer = new JRadioButton("Integer");
    private final JRadioButton fraction = new JRadioButton("Fraction");
    private static String output;
    private static createTree binaryTree;
    private static ArrayStack myArrayStack;
    

    //create interface
    public BinarySearchTreeSort() {
        
        //create radio button groups
        ButtonGroup sortedListButtons = new ButtonGroup();
        sortedListButtons.add(ascending);
        sortedListButtons.add(descending);
        ButtonGroup numericTypeButtons = new ButtonGroup();
        numericTypeButtons.add(integer);
        numericTypeButtons.add(fraction);

        //nested panels
        JPanel sortOrderPanel = new JPanel();
        sortOrderPanel.setBorder(new LineBorder(java.awt.Color.darkGray, 1));
        GroupLayout sortOrderLayout = (new GroupLayout(sortOrderPanel));
        sortOrderPanel.setLayout(sortOrderLayout);
        sortOrderPanel.add(sortOrder);
        sortOrderPanel.add(ascending);
        sortOrderPanel.add(descending);

        //layout for sortOrder
        sortOrderLayout.setHorizontalGroup(sortOrderLayout
                .createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGap(20, 20, 20)
                .addComponent(sortOrder)
                .addComponent(ascending)
                .addComponent(descending)
                .addGap(20, 20, 20)
        );
        sortOrderLayout.setVerticalGroup(sortOrderLayout.createSequentialGroup()
                .addGap(4)
                .addComponent(sortOrder)
                .addGap(10)
                .addComponent(ascending)
                .addGap(10)
                .addComponent(descending)
                .addGap(10)
        );

        JPanel numericTypePanel = new JPanel();
        GroupLayout numericTypeLayout = (new GroupLayout(numericTypePanel));
        numericTypePanel.setBorder(new LineBorder(java.awt.Color.darkGray, 1));
        numericTypePanel.setLayout(numericTypeLayout);
        numericTypePanel.add(numericType);
        numericTypePanel.add(integer);
        numericTypePanel.add(fraction);

        //layout for numericTypePanel
        numericTypeLayout.setHorizontalGroup(numericTypeLayout
                .createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGap(20, 20, 20)
                .addComponent(numericType)
                .addComponent(integer)
                .addComponent(fraction)
                .addGap(20, 20, 20)
        );
        numericTypeLayout.setVerticalGroup(numericTypeLayout.createSequentialGroup()
                .addGap(4)
                .addComponent(numericType)
                .addGap(10)
                .addComponent(integer)
                .addGap(10)
                .addComponent(fraction)
                .addGap(10)
        );

        //big panel
        JPanel guiPanel = new JPanel();
        GroupLayout layout = (new GroupLayout(guiPanel));
        guiPanel.setLayout(layout);
        guiPanel.add(originalListLabel);
        guiPanel.add(sortedListLabel);
        guiPanel.add(originalList);
        guiPanel.add(sortedList);
        guiPanel.add(evalButton);
        guiPanel.add(sortOrderPanel);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGap(20, 20, 20)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(originalListLabel, 100, 400, 400)
                        .addComponent(originalList, 100, 400, 400))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(sortedListLabel, 100, 400, 400)
                        .addComponent(sortedList, 200, 400, 400))
                .addComponent(evalButton, 200, 200, 200)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(sortOrderPanel, 200, 400, 400)
                        .addComponent(numericTypePanel, 200, 400, 400))
                .addGap(20, 20, 20)
        );
        //layout for GUI
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGap(20, 20, 20)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(originalListLabel, 100, 400, 400)
                        .addComponent(originalList, 100, 400, 400))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(sortedListLabel, 100, 400, 400)
                        .addComponent(sortedList, 200, 400, 400))
                .addComponent(evalButton, 200, 200, 200)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(sortOrderPanel, 200, 400, 400)
                        .addGap(20)
                        .addComponent(numericTypePanel, 200, 400, 400))
                .addGap(20, 20, 20)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(originalListLabel)
                        .addComponent(originalList)
                )
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(sortedListLabel)
                        .addComponent(sortedList))
                .addGap(20)
                .addComponent(evalButton)
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(sortOrderPanel)
                        .addComponent(numericTypePanel))
        );

        //frame for panel
        JFrame panelFrame = new JFrame("Binary Search Tree Sort");
        panelFrame.add(guiPanel);
        panelFrame.setSize(600, 350);
        panelFrame.setVisible(true);
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        guiPanel.setBorder(padding);
        panelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Refine Panel Elements
        evalButton.setSize(50, 20);
        sortedList.setEditable(false);
        ascending.setSelected(true);
        integer.setSelected(true);
        
        

        //action listener for evalButton
        evalButton.addActionListener((ActionEvent f) -> {
            String expression = originalList.getText();
            sortedList.setText("");
            if (expression != null) {
                //causes all numbers in the original list to be added to a binary search tree
                //inorder traversal of tree should be performed to generate list in sorted order
                //display in sorted list text field
                //check for non-numeric input including improperly formatted fractions- throw numberFormatException
                //display error message "Non numeric input"
                try {
                    binaryTree = new createTree();
                    myArrayStack = new ArrayStack();
                    myArrayStack = myArrayStack.createArray(expression);
                    if (integer.isSelected()) {
                        if (ascending.isSelected()) {
                            Node tree = binaryTree.initTree(myArrayStack, true);
                            expression = binaryTree.treeTraversal(tree);
                            output = createTree.finalOutput(expression, true);
                            sortedList.setText(output);
                        } else {
                            Node tree = binaryTree.initTree(myArrayStack, true);
                            expression = binaryTree.treeTraversal(tree);
                            output = createTree.finalOutput(expression, false);
                            sortedList.setText(output); 
                        }
                        
                    } else {
                        if (ascending.isSelected()) {
                            Node tree = binaryTree.initTree(myArrayStack, false);
                            expression = binaryTree.treeTraversal(tree);
                            output = createTree.finalOutput(expression, true);
                            sortedList.setText(output);
                        } else {
                            Node tree = binaryTree.initTree(myArrayStack, false);
                            expression = binaryTree.treeTraversal(tree);
                            output = createTree.finalOutput(expression, false);
                            sortedList.setText(output);
                        }
                    }
                } catch (StackException | NumberFormatException e) {
                    
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "No input");
            }
        });
    }

    public static void main(String[] args) {
        BinarySearchTreeSort project3 = new BinarySearchTreeSort();
    }
    
    

}
