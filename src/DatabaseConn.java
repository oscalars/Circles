
import java.sql.*;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.function.Consumer;


public class DatabaseConn {

    private static DatabaseConn instance;
    private Connection c;

    private DatabaseConn() {
        try {
            String url = "jdbc:postgresql://ec2-34-251-245-108.eu-west-1.compute.amazonaws.com/ddc0n5csqqi7j1";
            String username = "pqubleerdfotaw";
            String password = "669355566f42eaf8ccd90c172ce3b3a68a02367ab19babcf61d4d3d63cb99d36";
            this.c = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            System.out.println("Error establishing database connection.");
        }
    }

    private static DatabaseConn getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConn();
        }
        return instance;
    }

    /*
    public static boolean addUser(String username, byte[] obj, byte[] hash, byte[] salt, Consumer<Boolean> lambda){
        try {
            PreparedStatement ps = getInstance().c.prepareStatement("INSERT INTO users VALUES (?,?,?,?)");
            ps.setString(1, username);
            ps.setBytes(2, obj);
            ps.setBytes(3, hash);
            ps.setBytes(4, salt);
            ps.executeUpdate();
                                      ===Sparade en kopia här på det felix gjorde===
            lambda.accept(true);

            return true;
        } catch (SQLException se){

            lambda.accept(false);

            return false;
        }
    }
    */


    /* FUNCTIONS RELATED TO USER DATA */

    /* Work in progress här, svårt att göra innan vi vet vad userklassen ska innehålla.

    public static void addUser(User user, Consumer<Boolean> result) {
        new Thread(() -> {
            try {
                String username = user.getUsername();
                PreparedStatement ps = getInstance().c.prepareStatement("INSERT INTO users VALUES (?,?,?,?)");


                result.accept(true);
            } catch (SQLException se) {
                result.accept(false);
            }
        }).start();
    }
    */

    public static void registerUser(String username, byte[] hash, byte[] salt, Consumer<Boolean> result){
        new Thread(() -> {
            try {
                PreparedStatement ps = getInstance().c.prepareStatement("INSERT INTO login VALUES (?,?,?)");
                ps.setString(1, username);
                ps.setBytes(2, hash);
                ps.setBytes(3, salt);
                ps.executeUpdate();
                result.accept(true);
            } catch (SQLException se){
                result.accept(false);
            }
        }).start();
    }

    public static void getHash(String user){

    }



}


