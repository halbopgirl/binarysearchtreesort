//Name: Haleigh Jayde Doetschman
//Date: 11/18/18
//Class: CMIS 350 Fall 2018
//Purpose: Implements abstract classes defined in Stack.java

package binarysearchtreesort;

import java.util.StringTokenizer;


public class ArrayStack <E> implements Stack <E> {
  private static int DEFAULT_SIZE = 10;
    private E elements[];
    private static int numberOfElements = 0;

    
    public ArrayStack() {
        this(DEFAULT_SIZE);
    }
    
    @SuppressWarnings({"unchecked", "deprecated"})
    public ArrayStack(int size) {
        elements = (E[])(new Object[size]);
    }
    
  @Override
    public boolean isFull() {
        if (numberOfElements == elements.length)
            return true;
        else
            return false;
    }
    
  @Override
    public boolean isEmpty() {
        if (numberOfElements == 0)
            return true;
        else
            return false;
    }
    
  @Override
    public E peek() throws StackException {
        if (numberOfElements == 0)
            throw new StackException("Stack is Empty!");
        return elements[numberOfElements -1];
    }
    
  @Override
    public void push(E item) throws StackException {
        if (numberOfElements == 10) {
        throw new StackException("Stack is Full!");
        } else {
        elements[numberOfElements] = item;
        numberOfElements++;
        }
    }
    
  @Override
    public E pop() throws StackException {
        if (numberOfElements == 0)
            throw new StackException("Stack is Empty.");
        E elementToReturn = elements[numberOfElements - 1];
        numberOfElements--;
        System.out.println("Popped: " + elementToReturn);
        return elementToReturn;
    }
    
    //create array from input
    public ArrayStack<String> createArray(String expression) throws StackException, NumberFormatException {
        StringTokenizer tokenizer = new StringTokenizer(expression, " ", true);
        ArrayStack<String> numbers = new ArrayStack<>();
        String token;

        //tokenizer must cycle until entire expression has been read
        while ((tokenizer.hasMoreTokens())) {
            token = tokenizer.nextToken();
            if (token.matches("[0-9]+")) {
                numbers.push(token);
                System.out.println(token + "pushed");
            } else if (token.matches("[0-9]+" + "/" + "[0-9]+")) {
                numbers.push(token);
                System.out.println(token + "pushed");
            } else if (token.equals(" ")) {
                //do nothing
            } else {
                throw new NumberFormatException();
            }
        }
        return numbers;
    }
}
