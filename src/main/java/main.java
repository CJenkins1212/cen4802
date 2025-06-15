import java.util.Scanner;

public class main {

    public static double method(double var) {
        if (var < 0) {
            var *= 2;
            var /= 7;
        } else if (var > 0) {
            var *= 4;
            var /= 3;
        } else {
            System.out.print("Zero entered");
        }
        return var;
    }

    public static double member(double var) {
        if (var < 0) {
            var *= var;
        } else if (var > 0) {
            var *= -var;
        } else {
            System.out.print("Zero entered");
        }
        method(var);
        return var;
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int hold;
        int stand = 0;
        double var = 0;
        while(stand == 0){
            System.out.print("Enter an number between 1 and 4 (0 is exit): ");
            hold = myObj.nextInt();
            if(hold == 1){
                System.out.print("Enter a float: ");
                var = myObj.nextDouble();
                System.out.print(method(var));
            }
            else if(hold == 2){
                System.out.print("Enter a float: ");
                var = myObj.nextDouble();
                System.out.print(member(var));
            }
            else if(hold == 3){
                System.out.print("Enter a float: ");
                var = myObj.nextDouble();
                System.out.print(method(member(var)));
            }
            else if(hold == 4){
                System.out.print("Enter a float: ");
                var = myObj.nextDouble();
                System.out.print(member(method(var)));
            }
            else if(hold == 0){
                System.exit(0);
            }
        }
    }
}
