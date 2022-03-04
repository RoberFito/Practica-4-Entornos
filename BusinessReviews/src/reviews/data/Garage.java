package reviews.data;

public class Garage extends Business{
    private float pricePerHour;

    public Garage(String name, String location,Review[] reviews, float pricePerHour) {
        super(name, location, reviews);
        this.pricePerHour = pricePerHour;
    }

    public float getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public String toString() {
        return getName() + " (" + getLocation() + ")"
            + " - " + getPricePerHour() + " eur/h"+ "\n"+
            "Review average: " + reviewAverage();
    }
}
