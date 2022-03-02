import java.util.Date;
import java.util.LinkedList;

/**
 * Everything needed for creating a circle
 *
 */

public class Circle {
    private int id;
    private String name;
    private String creator;
    private LinkedList<String> members = new LinkedList<>();
    private String description;
    private Date startTime;
    private Date stopTime;
    private float score = 0;

    public Circle(){

    }

    /**
     * Constructor for Circle
     * @param name Circle name
     * @param creator Creator of circle
     * @param description Description of circle content
     * @param startTime Date when the circle start
     * @param stopTime Date when the circle closes, not possible to join circle after this time
     */
    public Circle(String name, String creator, String description, Date startTime, Date stopTime) {
        this.name = name;
        this.creator = creator;
        this.members.add(creator);
        this.description = description;
        this.startTime = startTime;
        this.stopTime = stopTime;


    }
//----Getters and setters------------------------------------------

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCreator(){
        return this.creator;
    }

    public void setCreator(String creator){
        this.creator = creator;
    }

    public LinkedList<String> getMembers(){
        return this.members;
    }

    public void setMembers(LinkedList<String> members){
        this.members = members;
    }

    public void addMember(String m){
        this.members.add(m);
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Date getStartTime(){
        return this.startTime;
    }

    public void setStartTime(Date startTime){
        this.startTime = startTime;
    }

    public Date getStopTime(){
        return this.stopTime;
    }

    public void setStopTime(Date stopTime){
        this.stopTime = stopTime;
    }

    public float getScore(){
        return this.score;
     }

    public void setScore(float score){
        this.score = score;
     }

}
