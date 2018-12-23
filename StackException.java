//Name: Haleigh Jayde Doetschman
//Date: 11/18/2018
//Class: CMIS 350
//Purpose: Custom exception

package binarysearchtreesort;


import javax.swing.JOptionPane;

public class StackException extends Exception {
   
    public StackException() {   
    }
    
    //custom StackException
    public StackException (String message) {
        System.out.println(message);
        JOptionPane.showMessageDialog(null, message);
    }
}
