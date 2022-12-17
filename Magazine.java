// Mohammed Abdul Sajeel Id: 212256020 email: smohammedabdul1@toromail.csudh.edu
// Lokesh purohit        Id: 212247895 email: lpurohit1@toromail.csudh.edu
// Mohammed Shoaibuddin  Id: 212255734 email: smohammed7@toromail.csudh.edu
import java.io.Serializable;
import java.util.Objects;

public class Magazine extends ReferenceMaterial implements Serializable {

    private String publicationDate;
    private String issueNum;

    public Magazine(String materialType, String title, Boolean isKidsFriendly, String location, String publicationDate, String issueNum) {
        super(materialType = "Magazine", title, isKidsFriendly, location);
        this.publicationDate = publicationDate;
        this.issueNum = issueNum;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getIssueNum() {
        return issueNum;
    }

    public void setIssueNum(String issueNum) {
        this.issueNum = issueNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magazine)) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return publicationDate.equals(magazine.publicationDate) && issueNum.equals(magazine.issueNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publicationDate, issueNum);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "publicationDate='" + publicationDate + '\'' +
                ", issueNum='" + issueNum + '\'' +
                '}';
    }
}
