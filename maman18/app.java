package maman18;

import java.util.Scanner;

/**
 * the main app class for "Maman18"
 * 
 * @auther Ben Shua (ID: 315270140)
 */

public class app {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out
                .println("Welcome to Ben's librery, here you can add/remove users & books, for help - enter \"help\"");

        while (true) {
            String userInput = scan.nextLine().trim().toLowerCase();
            switch (userInput) {
                case "help":
                    System.out.println("commands run by numbers:");
                    System.out.println("1) for finding user By Id");
                    System.out.println("2) for finding book and it's user");
                    System.out.println("3) for finding users with most books");

                    System.out.println("4) for adding / removing users");
                    System.out.println("5) for adding / removing books");

                    System.out.println("");
                    System.out.println("Some rules:");
                    System.out.println("*book format is 2 Letters 4 numbers (example: AB1132)");
                    System.out.println("*users Id's and book codes cannot repeat");
                    System.out.println("*users can have max of 10 books");
                    System.out.println("*please be quiet, it's a liberary!");
                    System.out.println("");
                    System.out.println("for more help type \"help\" again");
                    break;

                case "1":
                    System.out.println("finding user By Id");
                    System.out.print("userId:");
                    String id = scan.nextLine().trim().toLowerCase();
                    // NOT DONE

                case "2":
                    System.out.println("finding which user hase certain book");
                    System.out.print("bookCode:");
                    String bookCode = scan.nextLine().trim().toLowerCase();
                    // NOT DONE
                case "3":
                    System.out.println("users with most books:");
                    // NOT DONE
                case "4":
                    System.out.println("adding / removing users by format:");
                    System.out.println("operator(+/-) lastName id");
                    String[] userParams = scan.nextLine().trim().toLowerCase().split(" ");
                    // NOT DONE

                case "5":
                    System.out.println("adding / removing books by format:");
                    System.out.println("lastName id bookCode operator(+/-)");
                    String[] bookParams = scan.nextLine().trim().toLowerCase().split(" ");
                    // NOT DONE

                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("");
        }
    }

}
