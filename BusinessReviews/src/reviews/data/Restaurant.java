package reviews.data;

public class Restaurant extends Business {

    private String foodType;

    public Restaurant(String name, String location,Review[] reviews, String foodType) {
        super(name, location, reviews);
        this.foodType = foodType;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return getName() + " (" + getLocation() + ")"
            + " - " + getFoodType() + "\n"+
            "Review average: " + reviewAverage();
    }
}
