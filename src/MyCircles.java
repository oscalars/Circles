import java.util.Date;
import java.util.LinkedList;

/**
 * Creates a LinkedList with all circles that belong to a user
 */

public class MyCircles {

    private LinkedList<Circle> userCircles = new LinkedList<Circle>();

    /**
     * Creates a LinkedList with all circles a user is a member in
     *
     * @param user the user you want all circles from
     */
    public MyCircles(User user) {

        this.userCircles = DatabaseConn.getUserCircles(user.getUsername());

        //TODO - ta bort dessa när cirklar finns på en user
        userCircles.add(new Circle("The most captivating Dramas of the 60´s!", "Robert", "A 5 movie best-of-drama from the 60´s", new Date(2022, 02, 02), new Date(2022, 03, 02)));
        userCircles.add(new Circle("Who the hell needs Valentines day..", "Oscar", "Pick me ups for those not ready for a relationship", new Date(2022, 03, 05), new Date(2022, 03, 30)));

    }

//----Getters and setters----------------------------------------------

    public LinkedList<Circle> getUserCircles() {
        return userCircles;
    }

}