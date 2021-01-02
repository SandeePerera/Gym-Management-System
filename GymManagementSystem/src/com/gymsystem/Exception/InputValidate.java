package com.gymsystem.Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidate {        //this class has been used to validate various user inputs

    public static String stringValidation(Scanner in) {     //String input validation
        while (true) {                                      //while loop to run continuously if the input is wrong
            try {
                String userIn = in.next();
                if (!userIn.matches("[a-zA-Z ]+")) {        //regular expression to validate through numbers
                    System.out.println("Not a valid value..Enter again using only letters!");

                } else if (userIn.length() == 0)  {     //checking whether user input is empty
                    System.out.println("You need to enter a value (not Blank), Enter Again: ");

                } else {
                    return userIn;
                }

            } catch (Exception e) {     //handliing exception
                numValidation(in);
            }
        }
    }

    public static int integerValidation(Scanner in) {       //validation of integer numbers of date
        while (true) {
            try {
                String userIn = in.next();
                return Integer.parseInt(userIn);

            } catch (InputMismatchException | NumberFormatException  exception) {
                System.out.println("The value you entered is wrong..Enter Again: ");
            }
        }
    }

    public static String numValidation(Scanner in){         //validation of integer numbers
        while (true) {
            try {
                String userIn = in.next();
                if (userIn.matches("[^0-9]+")) {    //validation to only allow numbers using REGEX
                    System.out.println("Not a valid value..Enter again using only Numbers!");

                } else if (userIn.length() == 0)  {         //checking the length of the input
                    System.out.println("You need to enter a value (not Blank), Enter Again: ");

                } else {
                    return userIn;
                }

            } catch (Exception e) {
                numValidation(in);
            }
        }
    }
}
