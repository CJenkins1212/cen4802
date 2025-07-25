import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;
import java.sql.*;

public class main {
    static double res;

    private static Logger logger = Logger.getLogger(main.class.getName());

    public static double method(double var) {
        logger.log(Level.FINE, "Starting method");
        if (var < 0) {
            logger.log(Level.INFO, "Multiplying by two");
            var *= 2;
            logger.log(Level.INFO, "Dividing by seven");
            var /= 7;
        } else if (var > 0) {
            logger.log(Level.INFO, "Multiplying by four");
            var *= 4;
            logger.log(Level.INFO, "Dividing by three");
            var /= 3;
        } else {
            logger.log(Level.INFO, "Since zero, nothing happens");
            System.out.print("Zero entered");
        }
        logger.log(Level.INFO, "Returning" + var);
        return var;
    }

    public static double member(double var) {
        logger.log(Level.FINE, "Starting member");
        if (var < 0) {
            logger.log(Level.INFO, "Squaring var");
            var *= var;
        } else if (var > 0) {
            logger.log(Level.INFO, "Squaring var and revering its sign");
            var *= -var;
        } else {
            logger.log(Level.INFO, "Since zero, nothing happens");
            System.out.print("Zero entered");
        }
        method(var);
        logger.log(Level.INFO, "Returning" + var);
        return var;
    }

    public static void main(String[] args) throws IOException {
        Handler handler = new FileHandler("logger.txt");
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);

        Scanner myObj = new Scanner(System.in);
        int hold = 0;
        int stand = 0;
        double var = 0;
        logger.log(Level.INFO, "Working as intended, infinite loop entered");
        while(stand == 0){
            logger.log(Level.INFO, "In infinite loop, asking for user input");
            System.out.print("Enter an number between 1 and 4 (0 is exit): ");
            hold = myObj.nextInt();
            try{
                hold = myObj.nextInt();
            } catch (Exception e){
                logger.log(Level.SEVERE, "Not a viable number");
            }
            if(hold == 1){
                System.out.println("Enter a double: ");
                logger.log(Level.INFO, "In first option, asking for user input");
                try{
                    var = myObj.nextDouble();
                } catch (Exception e){
                    logger.log(Level.SEVERE, "Not a viable number");
                    break;
                }
                res = method(var);
                System.out.println(res);
                try{
                    logger.log(Level.INFO, "Starting database insert");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dev_ops.db", "root", "1212");
                    Statement s = con.createStatement();
                    System.out.println("Connection extablished Successfully!");
                    String sql = "INSERT INTO work_table(countid, result) VALUES(?, ?);";
                    PreparedStatement ps = con.prepareStatement(sql);
                    Random r= new Random();
                    ps.setInt(1, r.nextInt(100));
                    ps.setDouble(2, res);
                    logger.log(Level.INFO, "Inserting into database");
                    ps.executeUpdate();
                    System.out.println("Update executed Successfully!");
                }
                catch(Exception e){
                    logger.log(Level.WARNING, "Something went wrong with the insert");
                    System.out.println(e.toString());
                }
            }
            else if(hold == 2){
                System.out.println("Enter a double: ");
                logger.log(Level.INFO, "In second option, asking for user input");
                try{
                    var = myObj.nextDouble();
                } catch (Exception e){
                    logger.log(Level.SEVERE, "Not a viable number");
                    break;
                }
                System.out.println(member(var));
            }
            else if(hold == 3){
                System.out.println("Enter a double: ");
                logger.log(Level.INFO, "In third option, asking for user input");
                try{
                    var = myObj.nextDouble();
                } catch (Exception e){
                    logger.log(Level.SEVERE, "Not a viable number");
                    break;
                }
                System.out.print(method(member(var)));
            }
            else if(hold == 4){
                System.out.println("Enter a double: ");
                logger.log(Level.INFO, "In fourth option, asking for user input");
                try{
                    var = myObj.nextDouble();
                } catch (Exception e){
                    logger.log(Level.SEVERE, "Not a viable number");
                    break;
                }
                System.out.println(member(method(var)));
            }
            else if(hold == 0){
                logger.log(Level.INFO, "0 entered, shutting program down");
                System.exit(0);
            }
            if(hold != 1 && hold != 2 && hold != 3 && hold != 4 && hold != 0){
                logger.log(Level.WARNING, "Invalid number");
                System.out.println("Please choose a suggested integer");
            }
        }
    }
}