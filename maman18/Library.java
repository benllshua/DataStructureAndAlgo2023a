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
            str += libraryUser.getId() + " " + libraryUser.getLastName() + " [" + libraryUser.getBooks().length + "]\n";
        }
        return str;
    }

    public void addUser(LibraryUser user) {
        if (user == null) {
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
        LibraryUser user = new LibraryUser(lastName, id);
        if (user != null)
            this.addUser(user);
    }

    public LibraryUser getUserById(String id) {
        for (LibraryUser user : this._users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public LibraryUser getUserByBook(String bookCode) {
        if (!LibraryUser.isBookValid(bookCode)) {
            System.out.println("JOB FAILD: invalid bookCode");
            return null;
        }
        for (LibraryUser user : this._users) {
            for (String book : user.getBooks()) {
                if (book == bookCode) {
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
            if (user.getBooks().length > max) {
                users.clear();
                max = user.getBooks().length;
            }
            users.add(user);
        }
        LibraryUser[] arr = new LibraryUser[users.size()];
        return users.toArray(arr);
    }

}
