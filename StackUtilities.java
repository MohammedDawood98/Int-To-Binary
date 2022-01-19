package programs;
/**
 * This is the StackUtilities class for Assignment 1.
 * this class contain methods that will ask the user to enter a positive integer
 * and will return a string represntation of the binary equivilance of this integer
 * @author mdawood
 * @version Spring_21
 */

import java.util.Scanner;

import structures.ArrayStack;


public final class StackUtilities {
    
    /**
     * A scanner to take the user's input (positive int).
     * and convert it to binary.
     */
    private static Scanner myInfo = new Scanner(System.in);
    
    /**
     * a private constructor with no defination to avoid having default constructors.
     * having this constructor will avoid having warning about the utility class
     */
    private StackUtilities() {
    }
    
    /**
     * the Main method.
     * @param theArgs
     */
    public static void main(final String[] theArgs) {
        
        System.out.println("This program converts positive integers to binary numbers."
                 + "\nThe program will repeat until you choose to exit.");
        for (;;) {
            System.out.println("Please enter a positive integer to convert :");
            final String m = myInfo.next();
            int number = 0;
            try {
                number = Integer.parseInt(m);
            } catch (final NumberFormatException e) {
                System.out.println("Not an integer; try again");
                continue;
            }
            if (number < 1) {
                System.out.println("The value must be positive. Please try again ");
                continue;
            } 
            final String rt = decimalToBinary(number);
            System.out.println("Result = " + rt);
            if (!goAgain(myInfo)) {
                break;
            }
        }
    }
    
    /**
     * This method will compute the integer given by the user.
     * Using stack implemnation, the integer will go through a mathmatic algorithm which 
     * add the binary equivilance into a stack.
     * @param theNum
     * @return a string representation of the binary equivilance.
     */
    public static String decimalToBinary(final int theNum) {
        final ArrayStack<Integer> s = new ArrayStack<Integer>();
        if (theNum < 1) {
            throw new IllegalArgumentException("The value must be positive. Please try again");
        } 
        /**
         * this is the algorithm used to convert a positive integer to binary.
         */
        int n = theNum;
        while (n > 0) {
            final int r = n % 2;
            s.push(r);
            n = n / 2;
        }
        String p = "";
        while (!(s.isEmpty())) {
            p += s.pop();
        }
        return p;
    }
    
/**
 * this method asks the user if he wants to convert abother number or not.
 * by answering yes, or no using loops and if, else statements
 * @param theInfo
 * @return the result whether the user want to convert again or not.
 */
    public static Boolean goAgain(final Scanner theInfo) {
        Boolean result = false;
        /**
         * While loop to ask the user whether he wants to convert another number.
         * the loop will break if a proper input is given by the user.
         */
        while (true) {
            System.out.println("\nDo you want to convert another number? Y/N:");
            final String another = theInfo.next();
            if ("Y".equalsIgnoreCase(another) || "yes".equalsIgnoreCase(another)) {
                result = true;
                break;
            } else if ("N".equalsIgnoreCase(another) || "no".equalsIgnoreCase(another)) {
                System.out.println("Thanks for trying this program." + "\nHave a great day!");
                result = false;
                break;
            } else {
                System.out.println("\nI did not understand your answer.");
            }
        }
        return result;
    }
}
