import java.time.LocalDate;
public class Task{
    int id;
    String title;
    String description;
    LocalDate deadline;
    String priority;
    boolean completed;
//constructors 

public Task( int id,String title,String description, 
    LocalDate deadline,String priority ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.completed = false;
    }
}