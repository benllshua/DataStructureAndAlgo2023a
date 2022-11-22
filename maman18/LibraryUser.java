package maman18;

import java.util.ArrayList;

/**
 * the LibraryUser class for "Maman18"
 * 
 * @auther Ben Shua (ID: 315270140)
 */
public class LibraryUser {

    private static final String numbersRegex = "[0-9]+";
    private static final String characterRegex = "[a-zA-Z]+";

    // variables
    private String _lastName;
    private String[] _books;
    private String _id;

    // constractors

    /**
     * there is only one constructor intentionaly, for no confusion
     * constractor using 2 params - string 'lastName' & string 'id', resets books to
     * string array with 10 empty strings
     * 
     * complexity O(1)
     * 
     * @param lastName
     * @param id
     */
    public LibraryUser(String lastName, String id) {

        if (!isLastNameValid(lastName)) {
            System.out.println("JOB FAILD: invalid last name");
            return;
        }
        if (!isIdValid(id)) {
            System.out.println("JOB FAILD: invalid id name");
            return;
        }
        this._lastName = lastName.trim();
        this._id = id;
        this._books = new String[10];
        for (int i = 0; i < this._books.length; i++) {
            this._books[i] = "";
        }
        System.out.println("User created successfully");
    }

    // methods

    public String getLastName() {
        return this._lastName;
    }

    public String getId() {
        return this._id;
    }

    public String[] getBooks() {
        ArrayList<String> books = new ArrayList<String>();

        for (String bookCode : this._books) {
            if (bookCode != "") {
                books.add(bookCode);
            }
        }

        String[] arr = new String[books.size()];
        return books.toArray(arr);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final LibraryUser other = (LibraryUser) obj;
        return this._id.equals(other._id);
    }

    public String toString() {
        String str = this._id + " " + this._lastName + " Books: [";
        String[] books = this.getBooks();
        for (String bookCode : books) {
            str += bookCode + ",";
        }
        return str + "]";
    }

    /**
     * void function that adds a book to a user
     * complexity O(1) - max number of books is 10
     * 
     * @param book
     */
    public void addBook(String book) {
        if (!isBookValid(book)) {
            System.out.println("JOB FAILED: invalid book code");
            return;
        }

        for (int i = 0; i < this._books.length; i++) {
            if (book.equals(this._books[i])) {
                System.out.println("JOB FAILED: user allready has the book");
                return;
            }
            if (this._books[i].equals("")) {
                this._books[i] = book;
                System.out.println("book added successfully");
                return;
            }
        }
        System.out.println("JOB FAILED: user can't have more then 10 books");
    }

    /**
     * void function that removes a book from a user
     * 
     * complexity O(1) - max number of books is 10
     * 
     * @param book
     */
    public void removeBook(String book) {
        if (!isBookValid(book)) {
            System.out.println("JOB FAILED: invalid book code");
            return;
        }

        for (int i = 0; i < this._books.length; i++) {
            if (book.equals(this._books[i])) {
                this._books[i] = "";
                System.out.println("book removed successfully");
                return;
            }
        }
        System.out.println("JOB FAILED: user doesn't have the book");
    }

    /**
     * checks if param id is valid
     * complexity: O(1)
     * 
     * @param id
     * @return boolen
     */
    public static boolean isIdValid(String id) {
        return (id.matches(numbersRegex) && id.length() == 9);
    }

    /**
     * checks if param lastName is valid
     * complexity: O(1)
     * 
     * @param lastName
     * @return boolen
     */
    public static boolean isLastNameValid(String lastName) {
        return (lastName.matches(characterRegex) && lastName.trim().length() != 0);
    }

    /**
     * checks if param bookCode is valid
     * complexity: O(1)
     * 
     * @param bookCode
     * @return boolen
     */
    public static boolean isBookValid(String bookCode) {
        if (bookCode.length() != 6)
            return false;
        String[] chars = bookCode.split("");

        for (int i = 0; i < 2; i++) {
            if (!chars[i].matches(characterRegex))
                return false;
        }
        for (int i = 2; i < 6; i++) {
            if (!chars[i].matches(numbersRegex))
                return false;
        }
        return true;
    }

}
