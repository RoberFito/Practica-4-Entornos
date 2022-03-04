package reviews.data;

import javax.swing.*;

public class Hairdresser extends Business{
    private boolean unisex;
    public Hairdresser(String name, String location,Review[] reviews, boolean unisex) {
        super(name, location, reviews);
        this.unisex = unisex;
    }

    public boolean isUnisex() {
        return unisex;
    }

    public void setUnisex(boolean unisex) {
        this.unisex = unisex;
    }

    @Override
    public String toString() {
        String result = "";
        if(isUnisex())
        {
            result = "unisex";
        }
        else
        {
            result = "not unisex";
        }
        return getName() + " (" + getLocation() + ")"
            + " - " + result+ "\n"+
            "Review average: " + reviewAverage();
    }
}
