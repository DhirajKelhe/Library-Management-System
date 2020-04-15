/*
Write a java program to implement “Library Management System”.
In which you have to include at least three from the given topics
as required: Inheritance, Overriding Methods, Polymorphism,
Abstract Classes, Nested Classes, Interfaces, Lambda Expressions,
Exceptional Handling and I/O Fundamentals.
Used: Exception Handling, Nested Classes, I/O Fundamentals
 */
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class LibrarySystem {
    static class Books {
        String bookName, publisher, writer, bookCategory, isbnNumber;
        int publishedYear;
        static int booksCount = 0;

        void addBook(String bookName, String writer, String publisher, String bookCategory, String isbnNumber, int publishedYear) {
            this.bookName = bookName;
            this.writer = writer;
            this.publisher = publisher;
            this.bookCategory = bookCategory;
            this.isbnNumber = isbnNumber;
            this.publishedYear = publishedYear;
        }
    }

    static Scanner scanner = new Scanner(System.in);
    static boolean loggedIn = false;
    static int libraryID = 100, userID;
    static String libraryPassword = "abc", password;

    static void userLogin() {
        System.out.println("LibrarySystem Login:");
        System.out.print("Enter LibraryID: ");
        try {
            userID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Password: ");
            password = scanner.next();
            scanner.nextLine();
            if (userID == libraryID && password.equals(libraryPassword)) {
                loggedIn = true;
                System.out.println("\nLogged in Successfully");
                TimeUnit.SECONDS.sleep(1);
            } else System.out.println("Wrong Credentials");
        } catch (InputMismatchException | InterruptedException e) {
            System.out.println("Invalid Value!");
        }
    }

    public void viewBooks(LibrarySystem.Books[] books, int j) {
        if (LibrarySystem.Books.booksCount != 0) {
            for (int i = j; i < LibrarySystem.Books.booksCount; i++) {
                System.out.println("< Book " + (i + 1) + " > : " + books[i].bookName);
            }
        } else {
            System.out.println("No books available in Library.\nTry adding some books in Library.");
        }
    }

    public void viewBooksDetailed(LibrarySystem.Books[] books) {
        if (LibrarySystem.Books.booksCount != 0) {
            for (int i = 0; i < LibrarySystem.Books.booksCount; i++) {
                System.out.println("\n< Book " + (i + 1) + " >" +
                        "\nName: \t\t\t" + books[i].bookName +
                        "\nWriter: \t\t" + books[i].writer +
                        "\nPublisher: \t\t" + books[i].publisher +
                        "\nCategory: \t\t" + books[i].bookCategory +
                        "\nISBN number: \t\t" + books[i].isbnNumber +
                        "\nPublished Year: \t" + books[i].publishedYear);
            }
        } else {
            System.out.println("No books available in Library.\nTry adding some books in Library.");
        }
    }

    public void removeBooks(int bookNumber, LibrarySystem.Books[] books) {
        if (LibrarySystem.Books.booksCount - bookNumber >= 0)
            System.arraycopy(books, bookNumber, books, bookNumber - 1, LibrarySystem.Books.booksCount - bookNumber + 1);
    }

    static public void exitProgram() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.print("\nWant to go to home screen? \n1. Yes\t(otherwise No)\n==> ");
            int decision = LibrarySystem.scanner.nextInt();
            if (decision == 1) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.println("\nThank you for using Library Management System");
                System.exit(0);
            }
        } catch (InterruptedException | IOException | InputMismatchException e) {
            System.out.println("Exiting the program...");
            System.exit(0);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("\nWelcome to Library Management System made by Dhiraj Kelhe\n");

        System.out.print("Please Select: \n" +
                "1. Sign Up\t" +
                "2. Exit\n==> ");
        try {
            choice = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Value!");
            choice = 99;
        }
        switch (choice) {
            case 1:
                System.out.print("Your libraryID is " + (++LibrarySystem.libraryID) + "\nEnter Password: ");
                LibrarySystem.libraryPassword = scan.next();
                System.out.println("System Admin created Successfully.\n\nRedirecting to Login...\n");
                TimeUnit.SECONDS.sleep(0);
                LibrarySystem.userLogin();
                break;
            case 2:
                break;
            default:
                System.out.println("Wrong value entered!");
                break;
        }

        if (loggedIn == true) {
            System.out.println("Adding books for demo...");
            TimeUnit.SECONDS.sleep(1);
        }
        LibrarySystem.Books[] books = new LibrarySystem.Books[100];
        books[LibrarySystem.Books.booksCount] = new LibrarySystem.Books();
        books[LibrarySystem.Books.booksCount].addBook("Rich Dad Poor Dad", "Robert T. Kiyosaki", "Business Plus",
                "Psychology", "0446677450", 2000);

        books[LibrarySystem.Books.booksCount + 1] = new LibrarySystem.Books();
        books[LibrarySystem.Books.booksCount + 1].addBook("Deep Learning with Python", "Francois Chollet", "Manning Publications",
                "Programming", "1617294438", 2017);

        books[LibrarySystem.Books.booksCount + 2] = new LibrarySystem.Books();
        books[LibrarySystem.Books.booksCount + 2].addBook("Fluent Python", "Luciano Ramalho", "O'Reilly Media",
                "Programming", "1491946008", 2015);

        books[LibrarySystem.Books.booksCount + 3] = new LibrarySystem.Books();
        books[LibrarySystem.Books.booksCount + 3].addBook("How To Win Friends & Influence People", "Dale Carnegie", "Manning Publications",
                "Education", "067142517X", 1981);

        books[LibrarySystem.Books.booksCount + 4] = new LibrarySystem.Books();
        books[LibrarySystem.Books.booksCount + 4].addBook("The Courage to be Disliked", "Ichiro Kishimi, Fumitake Koga", "Allen & Unwin",
                "Psychology", "1760630497", 2017);

        LibrarySystem.Books.booksCount += 5;
        while (LibrarySystem.loggedIn) {
            System.out.print("\nPlease select: \n" +
                    "1. View All Book Details\n" +
                    "2. View Books Names Only\n" +
                    "3. Add Books In Library\n" +
                    "4. Remove Books From Library \n" +
                    "5. Logout & Exit\n==> ");
            int selection;
            try {
                selection = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Value!");
                selection = 99;
            }
            LibrarySystem user = new LibrarySystem();
            switch (selection) {
                case 1:
                    user.viewBooksDetailed(books);
                    LibrarySystem.exitProgram();
                    break;
                case 2:
                    user.viewBooks(books, 0);
                    LibrarySystem.exitProgram();
                    break;
                case 3:
                    int count = 1;
                    System.out.print("How many books you want to add? => ");
                    int limit = scan.nextInt();
                    try {
                        for (int i = LibrarySystem.Books.booksCount; i < (LibrarySystem.Books.booksCount + limit); i++) {
                            scan.nextLine();
                            System.out.println("Enter Details of Book " + count + ":");
                            System.out.print("Name: ");
                            String name = scan.nextLine();
                            System.out.print("Writer: ");
                            String writer = scan.nextLine();
                            System.out.print("Publisher: ");
                            String publisher = scan.nextLine();
                            System.out.print("Category: ");
                            String category = scan.nextLine();
                            System.out.print("ISBN number: ");
                            String isbn = scan.nextLine();
                            System.out.print("Published Year: ");
                            int year = scan.nextInt();
                            books[i] = new LibrarySystem.Books();
                            books[i].addBook(name, writer, publisher, category, isbn, year);
                            count++;
                        }
                        System.out.println("\n" + limit + " Books added successfully");
                        LibrarySystem.Books.booksCount += limit;
                        System.out.println("\nAdded Books are: ");
                        user.viewBooks(books, LibrarySystem.Books.booksCount - limit);
                    } catch (NullPointerException e) {
                        System.out.println("Something went Wrong!");
                    }
                    LibrarySystem.exitProgram();
                    break;
                case 4:
                    if (LibrarySystem.Books.booksCount != 0) {
                        user.viewBooks(books, 0);
                        System.out.print("Enter the NUMBER of book from given above to remove:\n==> ");
                        int bookNumber = scan.nextInt();
                        if (bookNumber <= LibrarySystem.Books.booksCount) {
                            user.removeBooks(bookNumber, books);
                            System.out.println("\nBook removed successfully");
                            LibrarySystem.Books.booksCount--;
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println("\nRemaining Books: ");
                            user.viewBooks(books, 0);
                        } else {
                            System.out.println("No book found with this number");
                        }
                    } else {
                        System.out.println("No books available in Library.\nTry adding some books in Library.");
                    }
                    LibrarySystem.exitProgram();
                    break;
                case 5:
                    LibrarySystem.loggedIn = false;
                    break;
                default:
                    System.out.println("Invalid Value!");
                    break;
            }
        }
        System.out.println("\nThank you for using Library Management System");
    }
}