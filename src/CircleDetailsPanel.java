import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.LinkedList;

public class CircleDetailsPanel extends JPanel {

    LinkedList<Movie> moviesInCircle;
    private static MainFrame frame;
    private static User user;
    private static Circle c;

    public CircleDetailsPanel(MainFrame frame, User user, Circle c) {

        this.frame = frame;
        this.user = user;
        this.c = c;

        setLayout(new BorderLayout());
        setBackground(user.getBackgroundColor());
        Color textColor = user.getForegroundColor();

        MovieDates end = new MovieDates(c.getStartTime(), c.getStopTime());

        //NavBar
        if(checkCreator(c, user)) {
            add(new NavigationBar(frame, user, 1, c), BorderLayout.NORTH);
        } else if((!checkMember(c, user)) && (end.getTotalDaysLeft() < 0)) {
            add(new NavigationBar(frame, user, 1, c), BorderLayout.NORTH);
        } else if(checkMember(c, user)){
            add(new NavigationBar(frame, user, 6, c), BorderLayout.NORTH);
        } else {
            add(new NavigationBar(frame, user, 5, c), BorderLayout.NORTH);
        }

        TitledBorder titledBorder = BorderFactory.createTitledBorder(new EmptyBorder(10,5,5,5), c.getName());
        titledBorder.setTitleColor(textColor);
        setBorder(titledBorder);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        moviesInCircle = DatabaseConn.getCircleMovies(c);
        int numberOfMovies = moviesInCircle.size();
        int moviePos = 1;

        if(moviesInCircle != null) {
            for(Movie m : moviesInCircle) {
                MovieDates dates = new MovieDates(c.getStartTime(), c.getStopTime(), moviePos, numberOfMovies);
                content.add(new MovieCard(m, user, c, dates.getMovieDaysLeft()));
                moviePos +=1;
            }
        }
        else {
            content.add(new JLabel("No movies has been added to this circle yet"));
        }

        JScrollPane scrollPane = new JScrollPane(content, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, BorderLayout.CENTER);

    }

    private boolean checkCreator(Circle c, User u){
        return c.getCreator().equals(u.getUsername());
    }


    private boolean checkMember(Circle c, User u){
        for(String m : c.getMembers()){
            if(m.equals(u.getUsername())){
                return true;
            }
        }
        return false;
    }

    public static void updateCircleDetail(){
        frame.navigateTo(k -> new CircleDetailsPanel(k, user, c));
    }

}
