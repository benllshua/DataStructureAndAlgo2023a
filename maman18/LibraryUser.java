package maman18;

/**
 * the LibraryUser class for "Maman18"
 * 
 * @auther Ben Shua (ID: 315270140)
 */
public class LibraryUser {

    private static String numbersRegex = "[0-9]+";
    private static String numbersAndCharacterRegex = "^[a-zA-Z0-9_.-]*$";

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
        String trimmedLastName = lastName.trim();
        String trimmedId = id.trim().replaceAll("", trimmedLastName);
        if (trimmedLastName.length() == 0) {
            System.out.println("JOB FAILD: invalid last name");
            return;
        }
        if (trimmedId.length() != 9) {
            System.out.println("JOB FAILD: invalid id name");
            return;
        }
        this._lastName = lastName;
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
        return this._books;
    }

    public String toString() {
        String str = this._lastName + " (ID:" + this._id + ")\n Books: [";
        for (int i = 0; i < this._books.length; i++) {
            if (this._books[i] != "") {
                str += _books[i] + ",";
            }
        }
        str += "]";

        return str;
    }

    /**
     * void function that adds a book to a user
     * complexity O(1) - max number of books is 10
     * 
     * @param book
     */
    public void addBook(String book) {

        for (int i = 0; i < this._books.length; i++) {
            if (book == this._books[i]) {
                System.out.println("JOB FAILED: user allready has the book");
                return;
            }
            if (this._books[i] == "") {
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

        for (int i = 0; i < this._books.length; i++) {
            if (book == this._books[i]) {
                this._books[i] = "";
                System.out.println("book removed successfully");
                return;
            }
        }
        System.out.println("JOB FAILED: user doesn't have the book");
    }

    // static methods

    /**
     * bool function that returns true if the given id allreadyExists in a given
     * users array
     * 
     * complexity O(n) - runs throw all given users until founds one
     * 
     * @param users LibraryUser[]
     * @param id    String
     */
    public boolean idExists(LibraryUser[] users, String id) {
        for (int i = 0; i < users.length; i++) {
            if (id == users[i].getId())
                return true;
        }
        return false;
    }

    /**
     * bool function that returns true if the given book allreadyExists in a given
     * users array
     * 
     * complexity O(n) - runs throw all given users & their books (max 10) until
     * founds one
     * 
     * @param users LibraryUser[]
     * @param book  String
     */
    public boolean bookExists(LibraryUser[] users, String book) {
        for (int i = 0; i < users.length; i++) {
            String[] userBooks = users[i].getBooks();
            for (int j = 0; j < userBooks.length; j++) {
                if (book == userBooks[j])
                    return true;
            }
        }
        return false;
    }

}
