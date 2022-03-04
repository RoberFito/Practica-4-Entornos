package reviews.main;

import reviews.data.*;

public class Management {
    private User[] users;
    private Business[] businesses;

    public User login(String login, String password)
    {
        boolean found = false;
        int pos = 0, i = 0;
        do {
            if (login.equals(users[i].getLogin())&&
                    password.equals(users[i].getPassword())) {
                found = true;
                pos = i;
            }
            i++;
        }
        while(i < users.length);
        if(found)
        {
            return users[pos];
        }
        else
        {
            return null;
        }
    }

    public User FindUser(String login)
    {
        boolean found = false;
        int pos = 0, i = 0;
        do {
            if (login.equals(users[i].getLogin())) {
                found = true;
                pos = i;
            }
            i++;
        }
        while(i < users.length);
        if(found)
        {
            return users[pos];
        }
        else
        {
            return null;
        }
    }

    public void showReviews(User user)
    {
        for(int i = 0; i < businesses.length; i++)
        {
            for(int j = 0; j < businesses[i].getReviews().length; j++) {
                if (businesses[i].getReviews()[j].getUser() == user) {
                    System.out.println("Review:");
                    System.out.println(businesses[i].getReviews()[j] + "\n");
                }
            }
        }
    }

    public void sortBusinessesByName()
    {
        for(int i = 0; i < businesses.length; i++) {
            for (int j = i+1; j < businesses.length; j++) {
                if (businesses[i].getName().charAt(0) >
                        businesses[j].getName().charAt(0)) {
                    Business aux = businesses[i];
                    businesses[i] = businesses[j];
                    businesses[j] = aux;
                }
            }
        }
        for(int i = 0; i < businesses.length; i++)
        {
            System.out.println(businesses[i]);
        }
    }

    public void sortBusinessesByRating(int type)
    {
        for(int i = 0; i < businesses.length; i++) {
            for (int j = i+1; j < businesses.length; j++) {
                if (businesses[i].reviewAverage() <
                        businesses[j].reviewAverage()) {
                    Business aux = businesses[i];
                    businesses[i] = businesses[j];
                    businesses[j] = aux;
                }
            }
        }
        if(type == 1)
        {
            for(int i = 0; i < businesses.length; i++)
            {
                if(businesses[i] instanceof Garage)
                {
                    System.out.println((Garage)businesses[i]);
                }
            }
        }
        else if(type == 2)
        {
            for(int i = 0; i < businesses.length; i++)
            {
                if(businesses[i] instanceof Hairdresser)
                {
                    System.out.println((Restaurant)businesses[i]);
                }
            }
        }
        else if(type == 3)
        {
            for(int i = 0; i < businesses.length; i++)
            {
                if(businesses[i] instanceof Restaurant)
                {
                    System.out.println((Restaurant)businesses[i]);
                }
            }
        }
        else
        {
            System.out.println("Invalid type");
        }
    }

    public Business findBussiness(String name)
    {
        Business result = null;
        boolean found = false;
        for(int i = 0; i < businesses.length; i++) {
            if (name.equals(businesses[i].getName()))
            {
                result = businesses[i];
                found = true;
            }
        }
        if(!found)
        {
            System.out.println("Business not found");
        }
        return result;
    }

    public Review findReview(User user, Business business) {
        Review result = null;
        for (int i = 0; i < business.getReviews().length; i++) {
            if (business.getReviews()[i].getUser() == user) {
                result = business.getReviews()[i];
            }
        }
        return result;
    }

    static void changeReview(Review r, String comment, int Rating)
    {
        if(r != null) {
            r.setComment(comment);
            r.setRating(Rating);
        }
        else
        {
            System.out.println("Error");
        }
    }

    public void Initialize()
    {
        Review[] reviews1 = new Review[2];
        Review[] reviews2 = new Review[2];
        Review[] reviews3 = new Review[2];
        Review[] reviews4 = new Review[2];
        Review[] reviews5 = new Review[2];
        Review[] reviews6 = new Review[2];
        users = new User[10];
        businesses = new Business[6];

        users[0] = new User("User1", "Pass1");
        users[1] = new User("User2", "Pass2");
        users[2] = new User("User3", "Pass3");
        users[3] = new User("User4", "Pass4");
        users[4] = new User("User5", "Pass5");
        users[5] = new User("User6", "Pass6");
        users[6] = new User("User7", "Pass7");
        users[7] = new User("User8", "Pass8");
        users[8] = new User("User9", "Pass9");
        users[9] = new User("User10", "Pass10");

        businesses[0] = new Restaurant("Res1", "Loc1", reviews1, "FT1");
        businesses[1] = new Restaurant("Res2", "Loc2", reviews2, "FT2");
        businesses[2] = new Hairdresser("Hair1", "Loc3", reviews3, false);
        businesses[3] = new Hairdresser("Hair2", "Loc4", reviews4, true);
        businesses[4] = new Garage("Gar1", "Loc5", reviews5, 50);
        businesses[5] = new Garage("Gar2", "Loc6", reviews6, 60);

        reviews1[0] = new Review(users[0], "Comment1", 3);
        reviews1[1] = new Review(users[1], "Comment2", 4);
        reviews2[0] = new Review(users[2], "Comment3", 1);
        reviews2[1] = new Review(users[3], "Comment4", 2);
        reviews3[0] = new Review(users[4], "Comment5", 5);
        reviews3[1] = new Review(users[5], "Comment6", 0);
        reviews4[0] = new Review(users[6], "Comment7", 2);
        reviews4[1] = new Review(users[7], "Comment8", 3);
        reviews5[0] = new Review(users[6], "Comment9", 1);
        reviews5[1] = new Review(users[8], "Comment10", 4);
        reviews6[0] = new Review(users[9], "Comment11", 2);
        reviews6[1] = new Review(users[9], "Comment12", 5);
    }
}
