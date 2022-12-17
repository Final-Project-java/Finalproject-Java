// Mohammed Abdul Sajeel Id: 212256020 email: smohammedabdul1@toromail.csudh.edu
// Lokesh purohit        Id: 212247895 email: lpurohit1@toromail.csudh.edu
// Mohammed Shoaibuddin  Id: 212255734 email: smohammed7@toromail.csudh.edu
import java.io.Serializable;
import java.util.Objects;

public class Member implements Serializable {

    private static int memberCtr = 1001;
    private String firstName;
    private String lastName;
    private String DOB;     // Format "MM/DD/YY"
    private String city;
    private String zipCode;
    private Member adultGuardian;
    private String membershipNumber;

    private boolean isAdult;

    public Member(String firstName, String lastName, String DOB,String city, String zipCode, Member adultGuardian) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.DOB = DOB;
        this.zipCode = zipCode;
        this.adultGuardian = adultGuardian;
        membershipNumber = "MEM" + memberCtr++;
    }

    public Member() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Member getAdultGuardian() {
        return adultGuardian;
    }

    public void setAdultGuardian(Member adultGuardian) {
        this.adultGuardian = adultGuardian;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public String getMembershipNumber() {
        return this.membershipNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return firstName.equals(member.firstName) && lastName.equals(member.lastName) && DOB.equals(member.DOB) && Objects.equals(city, member.city) && Objects.equals(zipCode, member.zipCode) && adultGuardian.equals(member.adultGuardian) && membershipNumber.equals(member.membershipNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, DOB, city, zipCode, adultGuardian, membershipNumber);
    }

	@Override
	public String toString() {
		return "Member [firstName=" + firstName + ", lastName=" + lastName + ", DOB=" + DOB + ", city=" + city
				+ ", zipCode=" + zipCode + ", adultGuardian=" + adultGuardian + ", membershipNumber=" + membershipNumber
				+ ", isAdult=" + isAdult + "]";
	}

  
}
