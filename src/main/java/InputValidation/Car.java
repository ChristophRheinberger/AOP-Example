package InputValidation;

/**
 * Created by Christoph on 07.04.2018.
 */
public class Car {

    public String manufacturer;
    public String type;
    public String constructionYear;
    public String color;
    public int mileage;
    public int horsepower;

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setConstructionYear(String constructionYear) {
        this.constructionYear = constructionYear;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
}
