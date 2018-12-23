/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtreesort;

public interface Stack <E> {
    public boolean isFull();
    public boolean isEmpty();
    public E peek() throws StackException;
    public void push (E item) throws StackException;
    public E pop() throws StackException;
}

