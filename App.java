// Mohammed Abdul Sajeel Id: 212256020 email: smohammedabdul1@toromail.csudh.edu
// Lokesh purohit        Id: 212247895 email: lpurohit1@toromail.csudh.edu
// Mohammed Shoaibuddin  Id: 212255734 email: smohammed7@toromail.csudh.edu
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws ParseException, IOException {

        Scanner KB = new Scanner(System.in);

        int choice;
        boolean adult;

        try {
            Library.load();
        }

        catch (Exception ignored) {
            ignored.printStackTrace();
            System.out.println("Warning: Account data could not be loaded!");
        }

        while (true) {

            do {
                System.out.println("1 - New Membership\n" +
                        "2 - Add Material\n" +
                        "3 - Issue Item\n" +
                        "4 - Return Item\n" +
                        "5 - Report Inventory\n" +
                        "6 - Report Loans\n" +
                        "7 - Lookup Membership\n" +
                        "8 - Exit\n" +
                        "Please enter your choice:");

                        choice = KB.nextInt();

            } while (choice < 1 || choice > 8 );

            if (choice == 1) {

                System.out.println("Enter first name: ");
                String firstName = KB.next();

                System.out.println("Enter last name: ");
                String lastName = KB.next();

                System.out.println("Enter date of birth: ");
                String DOB = KB.next();

                System.out.println("Enter city of residence: ");
                String city = KB.next();

                System.out.println("Enter zip code: ");
                String zipCode = KB.next();

                adult = Age.IsAdult(DOB);

                if (adult) {

                    String s = Library.newMembership(firstName, lastName, DOB, city, zipCode, null);
                    System.out.println("Registration successful. Your membership number is " + s);
                } else {

                    System.out.println("Member is under the age of 18.");
                    System.out.println("Please provide the information for an adult guardian: ");

                    System.out.println("Enter first name: ");
                    String fName = KB.next();

                    System.out.println("Enter last name: ");
                    String lName = KB.next();

                    System.out.println("Enter date of birth: ");
                    String dateOfBirth = KB.next();

                    System.out.println("Enter city of residence: ");
                    String town = KB.next();

                    System.out.println("Enter zip code: ");
                    String zip = KB.next();

                    Member a = new Member(fName, lName, dateOfBirth, town, zip, null);
                    String s = Library.newMembership(firstName, lastName, DOB, city, zipCode, a);
                    System.out.println("Registration successful. Your membership number is " + s);

                }

            } else if (choice == 2) {

                System.out.println("Choose the material type: \n" +
                        "1. Book \n" +
                        "2. Magazine \n" +
                        "3. DVD");
                int select = KB.nextInt();

                if (select == 1)
                {

                    System.out.println("Enter the title: ");
                    String title = KB.next();

                    System.out.println("Is it kids friendly?");
                    String ans = KB.next();
                    Boolean kidsFriendly;

                    if (ans.equalsIgnoreCase("Yes"))
                        kidsFriendly = true;
                    else kidsFriendly = false;

                    System.out.println("Enter library location: ");
                    String location = KB.next();

                    System.out.println("Enter author name: ");
                    String name = KB.next();

                    System.out.println("Enter ISBN code ");
                    long ISBN = KB.nextLong();

                    System.out.println("Enter the number of pages book has: ");
                    int numPages = KB.nextInt();

                    String refNum = Library.addBook("Book", title, kidsFriendly, location, name, ISBN, numPages);

                    System.out.println("Book added. Item reference number is: " + refNum);

                } else if (select == 2) {

                    System.out.println("Enter the title: ");
                    String title = KB.next();

                    System.out.println("Is it kids friendly?");
                    String ans = KB.next();
                    Boolean kidsFriendly;


                    if (ans.equalsIgnoreCase("Yes"))
                        kidsFriendly = true;
                    else kidsFriendly = false;

                    System.out.println("Enter library location: ");
                    String location = KB.next();

                    System.out.println("Enter publication date: ");
                    String date = KB.next();

                    System.out.println("Enter issue number: ");
                    String issueNum = KB.next();

                    String s = Library.addMagazine("Magazine", title, kidsFriendly, location, date, issueNum);

                    System.out.println("Magazine added. Item reference number is: " + s);

                } else if (select == 3) {

                    System.out.println("Enter the title: ");
                    String title = KB.next();

                    System.out.println("Is it kids friendly?");
                    String ans = KB.next();
                    Boolean kidsFriendly;


                    if (ans.equalsIgnoreCase("Yes"))
                        kidsFriendly = true;
                    else kidsFriendly = false;

                    System.out.println("Enter library location: ");
                    String location = KB.next();

                    System.out.println("Enter release date: ");
                    String date = KB.next();

                    System.out.println("Enter run duration: ");
                    double runDuration = KB.nextDouble();

                    String s = Library.addDVD("DVD", title, kidsFriendly, location, date, runDuration);
                    System.out.println("DVD added. Item reference number is: " + s);
                }
            } else if (choice == 3) {

                System.out.println("Enter membership number: ");
                String num = KB.next();

                System.out.println("Enter item reference number: ");
                String itemNum = KB.next();

                Library.issueItem(num, itemNum);

            } else if (choice == 4) {

                System.out.println("Enter item reference number: ");
                String itemNum = KB.next();

                Library.returnItem(itemNum);

            } else if (choice == 5) {

                Library.reportInventory();

            } else if (choice == 6) {

                Library.reportLoans();

            } else if (choice == 7) {

                System.out.println("Enter membership number: ");
                String num = KB.next();

                Library.lookupMembership(num);

            } else if (choice == 8) {

                FileOutputStream fos;
                ObjectOutputStream oos = null;

                try {
                    Library.save();
                }

                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                catch (IOException ex) {
                    ex.printStackTrace();
                }

                System.out.println("Thank you for using our service. Goodbye!");
                KB.close();
                System.exit(0);

            }

        }

    }
}

