import java.util.Scanner;

static int fib(int n){
        if (n <= 1)
            return n;

        return fib(n - 1) + fib(n - 2);
}

public static void main(String args[]){
    Scanner myObj = new Scanner(System.in);

    int n = myObj.nextInt();

    System.out.println("The " + n + "th term of the Fibonacci sequence is: " + fib(n));
}