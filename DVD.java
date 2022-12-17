// Mohammed Abdul Sajeel Id: 212256020 email: smohammedabdul1@toromail.csudh.edu
// Lokesh purohit        Id: 212247895 email: lpurohit1@toromail.csudh.edu
// Mohammed Shoaibuddin  Id: 212255734 email: smohammed7@toromail.csudh.edu
import java.io.Serializable;
import java.util.Objects;

public class DVD extends ReferenceMaterial implements Serializable {

    private String releaseDate;
    private double runDuration;         // in minutes

    public DVD(String materialType, String title, boolean isKidsFriendly, String location, String releaseDate, double runDuration) {
        super(materialType = "DVD", title, isKidsFriendly, location);
        this.releaseDate = releaseDate;
        this.runDuration = runDuration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRunDuration() {
        return runDuration;
    }

    public void setRunDuration(double runDuration) {
        this.runDuration = runDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DVD)) return false;
        if (!super.equals(o)) return false;
        DVD dvd = (DVD) o;
        return Double.compare(dvd.runDuration, runDuration) == 0 && releaseDate.equals(dvd.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), releaseDate, runDuration);
    }

    @Override
    public String toString() {
        return "DVD{" +
                "releaseDate='" + releaseDate + '\'' +
                ", runDuration=" + runDuration +
                '}';
    }
}
