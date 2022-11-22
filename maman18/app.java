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
        Boolean closed = false;
        Library library = new Library();

        System.out
                .println("Welcome to Ben's librery, here you can add/remove users & books, for help - enter \"help\"");

        while (!closed) {
            System.out.print("> ");
            String userInput = scan.nextLine().trim().toLowerCase();
            switch (userInput) {
                case "close":
                    closed = true;
                    System.out.println("Goodbye :) hope you had fun reading");
                    break;
                case "help":
                    System.out.println("commands run by numbers:");
                    System.out.println("1) for printing the library");
                    System.out.println("2) for finding user By Id");
                    System.out.println("3) for finding book and it's user");
                    System.out.println("4) for finding users with most books");
                    System.out.println("5) for adding / removing users");
                    System.out.println("6) for adding / removing books");
                    System.out.println("");
                    System.out.println("Some rules:");
                    System.out.println("*book format is 2 Letters 4 numbers (example: AB1132)");
                    System.out.println("*users Id's and book codes cannot repeat");
                    System.out.println("*users can have max of 10 books");
                    System.out.println("*please be quiet, it's a liberary!");
                    System.out.println("");
                    System.out.println("to close the library type \"close\" (be careful, data is not saved)");
                    System.out.println("for more help type \"help\" again");
                    break;

                case "1":
                    System.out.println(library);
                    break;
                case "2":
                    System.out.println("finding user By Id");
                    System.out.print("userId:");
                    String id = scan.nextLine().trim().toLowerCase();
                    LibraryUser userById = library.getUserById(id);
                    if (userById != null)
                        System.out.println(userById);
                    break;

                case "3":
                    System.out.println("finding which user hase certain book");
                    System.out.print("bookCode:");
                    String bookCode = scan.nextLine().trim().toLowerCase();
                    LibraryUser userBybook = library.getUserByBook(bookCode);
                    if (userBybook != null)
                        System.out.println(userBybook);
                    break;
                case "4":
                    System.out.println("users with most books:");
                    LibraryUser[] users = library.getUserWithMostBooks();
                    if (users.length == 0)
                        System.out.println("no users");
                    else
                        System.out.println(
                                "found " + users.length + " users with " + users[0].getBooks().length + " books:");
                    for (LibraryUser libraryUser : users) {
                        System.out.println(libraryUser);
                    }
                    break;
                case "5":
                    System.out.println("adding / removing users by format:");
                    System.out.println("operator(+/-) lastName id");
                    String[] userParams = scan.nextLine().split(" ");
                    if (userParams.length != 3) {
                        System.out.println("invalid input");
                        break;
                    }
                    String userOperator = userParams[0].trim();
                    String userLastName = userParams[1].trim();
                    String userId = userParams[2].trim();
                    if (userOperator.equals("+")) {
                        library.addUser(userLastName, userId);
                    } else if (userOperator.equals("-")) {
                        library.removeUser(userLastName, userId);
                    } else {
                        System.out.println("invalid operator");
                    }
                    break;

                case "6":
                    System.out.println("adding / removing books by format:");
                    System.out.println("lastName id bookCode operator(+/-)");
                    String[] bookParams = scan.nextLine().split(" ");
                    if (bookParams.length != 4) {
                        System.out.println("invalid input");
                        break;
                    }
                    String bookUserLastName = bookParams[0].trim();
                    String bookUserId = bookParams[1].trim();
                    String bookCodeParam = bookParams[2].trim();
                    String bookUserOperator = bookParams[3].trim();
                    if (bookUserOperator.equals("+")) {
                        library.addBookToUser(bookUserLastName, bookUserId, bookCodeParam);
                    } else if (bookUserOperator.equals("-")) {
                        library.removeBookToUser(bookUserLastName, bookUserId, bookCodeParam);
                    } else {
                        System.out.println("invalid operator");
                    }
                    break;
                // NOT DONE

                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("");
        }

        scan.close();
    }

}
