import java.util.Scanner;
/**
 * Returns the term of the Fibonacci sequence as determined by the number inputed while called.
 * 
 * @param n the sequence number to be printed
 * @return the calculated term is sent
 */
static int fib(int n){
        if (n <= 1)
            return n;

        return fib(n - 1) + fib(n - 2);
}
/**
 * Takes an int input from the user and uses it in a print statement that calls fib being fed n
 * 
 * @param n the int that stores the term dictated by the user for use in the print statement
 */
public static void main(String args[]){
    Scanner myObj = new Scanner(System.in);

    int n = myObj.nextInt();

    System.out.println("The " + n + "th term of the Fibonacci sequence is: " + fib(n));
}