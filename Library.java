// Mohammed Abdul Sajeel Id: 212256020 email: smohammedabdul1@toromail.csudh.edu
// Lokesh purohit        Id: 212247895 email: lpurohit1@toromail.csudh.edu
// Mohammed Shoaibuddin  Id: 212255734 email: smohammed7@toromail.csudh.edu
import java.io.*;
import java.util.ArrayList;

public class Library implements Serializable {

    private static String file="Library.dat";


    private static ArrayList<Member> members = new ArrayList<Member>();

    private static ArrayList<ReferenceMaterial> items = new ArrayList<ReferenceMaterial>();

    private static ArrayList<Loan> loans = new ArrayList<Loan>();

    public static String newMembership(String firstName, String lastName, String DOB, String city, String zipCode, Member adultGuardian) {

        Member m = new Member(firstName, lastName, DOB, city, zipCode, adultGuardian);
        members.add(m);
        return m.getMembershipNumber();
    }

    public static String addBook(String materialType, String title, Boolean isKidsFriendly,
                                  String location, String author, long ISBN, int numPages) {

        ReferenceMaterial item = new Book(materialType, title, isKidsFriendly, location, author, ISBN, numPages);
        items.add(item);
        return item.getItemRefNum();
    }

    public static String addMagazine(String materialType, String title, Boolean isKidsFriendly,
                                      String location, String publicationDate, String issueNum) {

        ReferenceMaterial item = new Magazine(materialType, title, isKidsFriendly, location, publicationDate, issueNum);
        items.add(item);
        return item.getItemRefNum();
    }

    public static String addDVD(String materialType, String title, boolean isKidsFriendly,
                                 String location, String releaseDate, double runDuration) {

        ReferenceMaterial item = new DVD(materialType,title, isKidsFriendly, location, releaseDate, runDuration);
        items.add(item);
        return item.getItemRefNum();
    }

    public static Member lookupMember(String membershipNum) {
        for(Member m:members) {

            if (m.getMembershipNumber().equals(membershipNum))
                return m;
        }
        return null;
    }

    public static ReferenceMaterial lookupItem(String itemRefnum) {
        for(ReferenceMaterial i:items) {

            if (i.getItemRefNum().equals(itemRefnum))
                return i;
        }
        return null;
    }

    public static Loan lookupLoan(String itemRefNumber) {
        for(Loan l:loans) {

            if (l.itemReferenceNumber.equals(itemRefNumber))
                return l;
        }
        return null;
    }


    public static void issueItem(String membershipNum, String itemRefnum) {

        Member m = lookupMember(membershipNum);

        if (m == null) {

            System.out.println("This membership number doesn't exist!");
        }

        ReferenceMaterial r = lookupItem(itemRefnum);

        if (r == null) {

            System.out.println("This item doesn't exist!");
        }

        if (!r.isAvailable) {

            System.out.println("Item on loan!");
        }

        if (r.isAvailable) {

            Loan l = new Loan(r, m);
            loans.add(l);
            System.out.println("Loan Successful. \nLoan Reference Number: " + l.getLoanReferenceNum());
        }
    }

    public static void returnItem(String itemRefNum) {

        ReferenceMaterial r = lookupItem(itemRefNum);
        Loan l = lookupLoan(itemRefNum);
        r.setAvailable(true);
        l.setLoanActive(false);

    }

    public static void reportInventory() {

        for (ReferenceMaterial i:items) {

            System.out.println(i);
        }
    }

    public static void reportLoans() {

        for (Loan l:loans) {

            System.out.println(l);
        }
    }

    public static void lookupMembership(String memberNum) {

        Member m = lookupMember(memberNum);

        if (m == null) {

            System.out.println("This membership number doesn't exist!");
        } else {

            if (m.isAdult()) {

                System.out.println(m);

            } else if (!m.isAdult()) {

                System.out.println(m.toString());
                System.out.println("The adult guardian details are:");
                System.out.println(m.getAdultGuardian().toString());

            }
        }
    }

    public static void save() throws IOException {
        ObjectOutputStream oos=null;
        FileOutputStream fos=null;
        try {

            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(Library.members);
            oos.writeObject(Library.items);
            oos.writeObject(Library.loans);


        }
        finally{
            if(oos!=null)oos.close();
            if(fos!=null)fos.close();

        }
    }

    public static void load() throws IOException, ClassNotFoundException {
        ObjectInputStream ois=null;
        FileInputStream fis=null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            members = (ArrayList<Member>) ois.readObject();
            items = (ArrayList<ReferenceMaterial>) ois.readObject();
            loans = (ArrayList<Loan>) ois.readObject();


            ois.close();
            fis.close();
        }
        catch(Exception e) {
        	
        }
        finally{
            if(ois!=null)ois.close();
            if(fis!=null)fis.close();
        }
    }


}
