package maman18;

import java.util.ArrayList;

public class Library {
    private ArrayList<LibraryUser> _users;

    public Library() {
        this._users = new ArrayList<LibraryUser>();
    }

    public Library(LibraryUser[] users) {
        this._users = new ArrayList<LibraryUser>();
        for (LibraryUser libraryUser : users) {
            addUser(libraryUser);
        }
    }

    // methods

    public LibraryUser[] getUsers() {
        LibraryUser[] arr = new LibraryUser[this._users.size()];
        return this._users.toArray(arr);
    }

    public String toString() {
        if (this._users.size() == 0)
            return "the library is empty right now";
        String str = "";
        for (LibraryUser libraryUser : this._users) {
            str += libraryUser + "\n";
        }
        return str;
    }

    public void addUser(LibraryUser user) {
        if (user == null || user.getId() == null) {
            System.out.println("JOB FAILD: user is null");
            return;
        }
        if (this.getUserById(user.getId()) != null) {
            System.out.println("JOB FAILD: user with that id allready exists");
            return;
        }
        this._users.add(user);
    }

    public void addUser(String lastName, String id) {
        if (this.getUserById(id) != null) {
            System.out.println("JOB FAILD: user with that id allready exists");
            return;
        }
        LibraryUser user = new LibraryUser(lastName, id);
        if (user.getId() != null)
            this._users.add(user);
    }

    public void removeUser(String lastName, String id) {
        LibraryUser user = getUserById(id);
        if (user == null) {
            System.out.println("JOB FAILD: user with that id does not exist");
            return;
        }
        if (!user.getLastName().equals(lastName)) {
            System.out.println("JOB FAILD: user lastName and id does not match");
            return;
        }

        Boolean worked = this._users.remove(user);
        if (!worked) {
            System.out.println("JOB FAILD: no user found");
        }
    }

    public LibraryUser getUserById(String id) {
        for (LibraryUser user : this._users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public LibraryUser getUserByBook(String bookCode) {
        for (LibraryUser user : this._users) {
            for (String book : user.getBooks()) {
                if (book.equals(bookCode)) {
                    return user;
                }
            }
        }
        return null;
    }

    public LibraryUser[] getUserWithMostBooks() {
        int max = 0;
        ArrayList<LibraryUser> users = new ArrayList<LibraryUser>();
        for (LibraryUser user : this._users) {
            int bookAmount = user.getBooks().length;
            if (bookAmount > max) {
                users.clear();
                max = bookAmount;
            }
            if (bookAmount == max) {
                users.add(user);
            }
        }
        LibraryUser[] arr = new LibraryUser[users.size()];
        return users.toArray(arr);
    }

    public void addBookToUser(String lastName, String id, String bookCode) {
        LibraryUser user = getUserById(id);
        if (user == null) {
            System.out.println("JOB FAILD: user with that id does not exist");
            return;
        }
        if (!user.getLastName().equals(lastName)) {
            System.out.println("JOB FAILD: user lastName and id does not match");
            return;
        }
        LibraryUser userWithThisBook = getUserByBook(bookCode);
        if (userWithThisBook != null) {
            String belongs = userWithThisBook.getId().equals(id) ? "this user" : "someome else";
            System.out.println("JOB FAILD: " + belongs + " has the book");
            return;
        }
        user.addBook(bookCode);
    }

    public void removeBookToUser(String lastName, String id, String bookCode) {
        LibraryUser user = getUserById(id);
        if (user == null) {
            System.out.println("JOB FAILD: user with that id does not exist");
            return;
        }
        if (!user.getLastName().equals(lastName)) {
            System.out.println("JOB FAILD: user lastName and id does not match");
            return;
        }

        user.removeBook(bookCode);
    }

}
