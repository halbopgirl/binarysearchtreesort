//Name: Haleigh Jayde Doetschman
//Date: 11/28/2018
//Class: CMIS 350
//Purpose: Accepts string representations of fractions, compares fractions

package binarysearchtreesort;

public class defineFraction implements Comparable{
  private static String fraction;
  private static double value;
  
    //constructor that accepts a string representation of a fraction
    public defineFraction(String fraction) {
        this.fraction = fraction;
    }
    
    public double fractionValue(String fraction) throws NumberFormatException{
        this.fraction = fraction;
        double value = 0;
        if (fraction.matches("[0-9]+" + "/" + "[0-9]+")) {
        String[] numbers = fraction.split("/");
        value = (Double.valueOf(numbers[0]) / Double.valueOf(numbers[1]));
        } else {
            throw new NumberFormatException();
        }
        return value;
    }
  
    //toString method
    @Override
    public String toString() {
        return fraction;
    }

  @Override
    public int compareTo(Object o) {
      try { 
          value = fractionValue(fraction);
          System.out.println("value: " + value);
          double compareVal2 = fractionValue((String) o);
          System.out.println("value2: " + compareVal2);
          if (value > compareVal2) {
            return 1;
        } else if (value < compareVal2) {
            return -1;
        } 
      } catch (NumberFormatException ex) {
      }
     return 0;   
    }
}
