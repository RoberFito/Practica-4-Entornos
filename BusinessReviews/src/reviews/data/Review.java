package reviews.data;

public class Review {
    private User user;
    private String comment;
    private int rating;

    public Review(User user, String comment, int rating) {
        this.user = user;
        this.comment = comment;
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if(rating <= 5 && rating >= 0)
            this.rating = rating;
    }

    @Override
    public String toString() {
        return getUser().getLogin() +"\n"+
            getComment() + "\n"+
            getRating() + "/5";
    }
}
