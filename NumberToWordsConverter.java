import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * <h1>Number To Word conversion!</h1>
 * This program does the conversions of the number
 * into words up to max 999,999,9999
 *
 * @author  Ratnakrnati Silla
 * @version 1.0
 * @since   2019-08-25
 */

public class NumberToWordsConverter {

    /* Defining the basic elements in conversion of numbers to words */
    /* Leaving first elements as blank to maintain the one to nineteen
     * based on the array position */
    public static final String[] basics = {
            "",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen" };

    /* Defining the doubles in conversion of numbers to words */
    /* Leaving the first and second elements as blank
     * to capture from twenty to ninety */
    public static final String[] doubles = {
            "",
            "",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
    };
    /*****************************************************************
     * Method Name  : numberToWord - conerts the number into words
     * @param       : Integer Number
     * @return      : String - converted into words from given number
     *****************************************************************/
    private static String numberToWord(final int number) {
        /* CReturning Zero in case provided number is 0 */
        if (0 == number ){
            return "Zero";
        }
        /* Indicating Minus for negative numbers */
        if (0 > number ) {
            return "Minus " + numberToWord(-number);
        }
        /* Handling number from basics range */
        if (20 > number ) {
            return basics[number];
        }
        /* Handling number from doubles range */
        if (100 > number ) {
            return doubles[number / 10] + ((number % 10 != 0) ? " " : "") +
                    basics[number % 10];
        }
        /* Handling numbers less than thousand */
        else if (1000 > number) {
            return basics[number / 100] + " Hundred" +
                    ((number % 100 != 0) ? " " : "") +
                    numberToWord(number % 100);
        }
        /* Handling numbers lesthan million */

        else if (1000000 > number) {
            return numberToWord(number / 1000) + " Thousand" +
                    ((number % 1000 != 0) ? " " : "") +
                    numberToWord(number % 1000);
        }
        /* Handling numbers lessthan Trillion */
        else if (1000000000 > number) {
            return numberToWord(number / 1000000) + " Million" +
                    ((number % 1000000 != 0) ? " " : "") +
                    numberToWord(number % 1000000);
        }
        /* Provided number is not with in the range of 1 to 999,999,999 */
        else
            return "Error : Entered number max up to 999,999,999";
    } // End of numberToWord method

    public static void main(String[] args) {

        int number;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter a number(max up to 999,999,999) : ");
        try {
            /* Reading the number as input */
            number = scanner.nextInt();
            /* Validating number for Zero and Errors */
            if(0 == number){
                System.out.println(number + " = Zero");
            } else if (numberToWord(number).contains("Error")) {
                System.out.println(numberToWord(number));
            } else {
                System.out.println(number + " = " + numberToWord(number));
            }
        } catch (InputMismatchException ime){
            System.out.println("Please enter valid numer max up to 999,999,999");
        } catch (Exception e){
            System.out.println("Please enter valid numer max up to 999,999,999");
            e.printStackTrace();
        }finally {
            /* Closing user input scanner */
            if (null != scanner )
                scanner.close();
        } // End of try - catch - finally
    } // End of main method
} // End of NumberToWordsConverter
