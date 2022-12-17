// Mohammed Abdul Sajeel Id: 212256020 email: smohammedabdul1@toromail.csudh.edu
// Lokesh purohit        Id: 212247895 email: lpurohit1@toromail.csudh.edu
// Mohammed Shoaibuddin  Id: 212255734 email: smohammed7@toromail.csudh.edu
import java.io.Serializable;
import java.util.Objects;

public class Book extends ReferenceMaterial implements Serializable {

    private String author;
    private long ISBN;
    private int numPages;

    public Book(String materialType, String title, Boolean isKidsFriendly, String location, String author, long ISBN, int numPages) {
        super(materialType = "Book", title, isKidsFriendly,location);
        this.author = author;
        this.ISBN = ISBN;
        this.numPages = numPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return ISBN == book.ISBN && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, ISBN);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", ISBN=" + ISBN +
                ", numPages=" + numPages +
                '}';
    }
}
