// Mohammed Abdul Sajeel Id: 212256020 email: smohammedabdul1@toromail.csudh.edu
// Lokesh purohit        Id: 212247895 email: lpurohit1@toromail.csudh.edu
// Mohammed Shoaibuddin  Id: 212255734 email: smohammed7@toromail.csudh.edu
import java.io.Serializable;
import java.util.Objects;

abstract class ReferenceMaterial implements Serializable {

    private static long referenceCtr = 10000L;
    private String materialType;
    private String title;
    private boolean isKidsFriendly;
    private String itemRefNum;
    private double replacementValue;
    private String location;

    public boolean isAvailable;

    public ReferenceMaterial(String materialType, String title, boolean isKidsFriendly, String location) {
        this.materialType = materialType;
        this.title = title;
        this.isKidsFriendly = isKidsFriendly;
        this.location = location;
        itemRefNum = "Item" + referenceCtr++;
        isAvailable = true;
    }

    public String getMaterialType() {
        return materialType;
    }

    public String getTitle() {
        return title;
    }

    public boolean isKidsFriendly() {
        return isKidsFriendly;
    }

    public String getItemRefNum() {
        return itemRefNum;
    }

    public double getReplacementValue() {
        return replacementValue;
    }

    public String getLocation() {
        return location;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setKidsFriendly(boolean kidsFriendly) {
        this.isKidsFriendly = kidsFriendly;
    }

    public void setReplacementValue(double replacementValue) {
        this.replacementValue = replacementValue;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReferenceMaterial)) return false;
        ReferenceMaterial that = (ReferenceMaterial) o;
        return itemRefNum == that.itemRefNum && materialType.equals(that.materialType) && title.equals(that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materialType, title, itemRefNum);
    }
}
