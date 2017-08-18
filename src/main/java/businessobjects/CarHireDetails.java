package businessobjects;
/**
 * Created by Maryia_Shynkarenka on 7/13/2017.
 */
public class CarHireDetails {
    private String city;
    private String pickUpDate;
    private String dropOffDate;

    public CarHireDetails(String city) {
        this.city = city;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPickUpDate(){
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getDropOffDate(){
        return dropOffDate;
    }

    public void setDropOffDate(String dropOffDate) {
        this.dropOffDate = dropOffDate;
    }
}
