/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtreesort;

import javax.swing.JOptionPane;

public class NumberFormatException extends Exception {
    public NumberFormatException() {
        JOptionPane.showMessageDialog(null, "Non numeric input");
    }
    
    public NumberFormatException(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
