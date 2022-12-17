// Mohammed Abdul Sajeel Id: 212256020 email: smohammedabdul1@toromail.csudh.edu
// Lokesh purohit        Id: 212247895 email: lpurohit1@toromail.csudh.edu
// Mohammed Shoaibuddin  Id: 212255734 email: smohammed7@toromail.csudh.edu
import java.io.Serializable;
import java.util.Objects;

public class Loan implements Serializable {

    private static long loanNumCtr = 10000;

    private String loanReferenceNum;

    private ReferenceMaterial item;

    private Member borrower;

    private String issueDate;

    private String returnDate;

    private boolean loanActive;

    String itemReferenceNumber;

    public Loan(ReferenceMaterial item, Member borrower) {
        this.item = item;
        this.borrower = borrower;
        loanReferenceNum = "LN" + loanNumCtr++;
        itemReferenceNumber = item.getItemRefNum();
        loanActive = true;
        item.isAvailable = false;
    }

    public String getLoanReferenceNum() {
        return loanReferenceNum;
    }

    public ReferenceMaterial getItem() {
        return item;
    }

    public Member getBorrower() {
        return borrower;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public boolean isLoanActive() {
        return loanActive;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setLoanActive(boolean loanActive) {
        this.loanActive = loanActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return loanReferenceNum.equals(loan.loanReferenceNum) && item.equals(loan.item) && borrower.equals(loan.borrower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanReferenceNum, item, borrower);
    }

	@Override
	public String toString() {
		return "Loan [loanReferenceNum=" + loanReferenceNum + ", item=" + item + ", borrower=" + borrower
				+ ", issueDate=" + issueDate + ", returnDate=" + returnDate + ", loanActive=" + loanActive
				+ ", itemReferenceNumber=" + itemReferenceNumber + "]";
	}

   
}
