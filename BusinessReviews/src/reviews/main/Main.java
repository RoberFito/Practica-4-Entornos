package reviews.main;
import java.util.Scanner;
import reviews.data.User;

public class Main
{
    public static void ShowMenu()
    {
        System.out.println("1. My reviews");
        System.out.println("2. Business list");
        System.out.println("3. Top rated businesses");
        System.out.println("4. Edit review");
        System.out.println("5. Quit");
    }

    public static User Login(Management o)
    {
        User user = null;
        Scanner sc = new Scanner(System.in);
        String log, pass;
        do {
            System.out.println("Login:");
            log = sc.nextLine();
            System.out.println("Password:");
            pass = sc.nextLine();
            user = o.login(log, pass);
            if (user == null) {
                System.out.println("Login failed");
            }
        }
        while (user == null);
        return user;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Management o = new Management();
        User user;
        String log, pass, businessName="", userName = "";
        int option = 0, type = 0;
        o.Initialize();
        user = Login(o);
        System.out.println("Login successful");
        do
        {
            ShowMenu();
            System.out.println("Choose the option you want:");
            option = sc.nextInt();
            switch(option)
            {
                case 1:
                    o.showReviews(user);
                    break;
                case 2:
                    o.sortBusinessesByName();
                    break;
                case 3:
                    System.out.println("1 = Garage, 2 = Hairdresser, 3 = Restaurant");
                    type = sc.nextInt();
                    o.sortBusinessesByRating(type);
                    break;
                case 4:
                    System.out.println("Business name");
                    sc.nextLine();
                    businessName = sc.nextLine();
                    if (o.findBussiness(businessName) != null) {
                        String comment = "";
                        int newRating = 0;
                        System.out.println("User name:");
                        userName = sc.nextLine();
                        System.out.println();
                        System.out.println("");
                        System.out.println("New comment:");
                        comment = sc.nextLine();
                        System.out.println("New Rating:");
                        newRating = sc.nextInt();
                        Management.changeReview
                                (o.findReview(o.FindUser(userName),
                                                o.findBussiness(businessName)),
                                        comment, newRating);
                    }
                    break;
                case 5:
                    System.out.println("Program ended");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        while(option != 5);
    }
}
