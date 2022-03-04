package reviews.data;

public abstract class Business {
    protected String name;
    protected String location;
    protected Review[] reviews;

    public Business(String name, String location, Review[] reviews) {
        this.name = name;
        this.location = location;
        this.reviews = reviews;
    }

    public float reviewAverage()
    {
        float result = 0;
        for(int i = 0; i < getReviews().length; i++)
        {
            result += getReviews()[i].getRating();
        }
        result /= getReviews().length;
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Review[] getReviews() {
        return reviews;
    }

    @Override
    public String toString() {
        return getName() + " (" + getLocation() + ")" + reviewAverage();
    }
}
