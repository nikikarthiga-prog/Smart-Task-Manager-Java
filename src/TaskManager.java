import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.time.LocalDate;
public class TaskManager {
    ArrayList<Task> tasks = new ArrayList<>();
//let we add the task
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added successfully!");
    }
//create viewtask method
     public void viewTasks() {
        System.out.println("\n👀 ----- YOUR TASKS -----");
        if(tasks.isEmpty()) {
            System.out.println("📭 No task available.");
            return;
        }
        for(Task task : tasks){
            System.out.println("🆔 ID: " + task.id);
            System.out.println("📝 Title: " + task.title);    
            System.out.println("📄 Description: " + task.description);
            System.out.println("📅 Deadline: " + task.deadline);
            System.out.println("🔥 Priority: " + task.priority);
            if (task.completed) {
              System.out.println("✅ Status: Completed");
        }
        else {
                 System.out.println("⏳ Status: Pending");
}

            System.out.println("------------------------");
        }

     }

     public  void markTaskCompleted(int id){
        for(Task task : tasks) {
            if(task.id == id) {
                task.completed = true;
                System.out.println("🎉 Task marked as completed!");
                return;
            }
        }
        System.out.println("❌ Task not found.");
     }

     public void deleteTask(int id){
        for(Task task : tasks){
            if(task.id == id){
                tasks.remove(task);
                System.out.println(" 🗑️Task deleted successfully!");
                return;

            }
        
            
        }
        System.out.println(" ❌ Task not found.");
     }
     public void searchTask(String keyword){
        boolean found = false;
        for(Task task : tasks){
            if(task.title.toLowerCase().contains(keyword.toLowerCase())){
                System.out.println("ID:" + task.id); 
                System.out.println("Title:" + task.title);
                System.out.println("Description:" + task.description);
                System.out.println("Deadline:" + task.deadline); 
                System.out.println("Priority:" + task.priority); 
                System.out.println("Completed:" + task.completed);

            System.out.println("------------------------");
                found = true;

            }
        }
        if(!found){
            System.out.println("❌No Matching Task Found.");
        }
     }
     public void showStatistics(){
        int total = tasks.size();
        int completedCount = 0;
        System.out.println("\n📊 ----- TASK STATISTICS -----");

        for(Task task:tasks){
            if(task.completed){
                completedCount++;
            }
        }
        int pendingCount = total - completedCount;
       System.out.println("\n----TASK STATISTICS----");
       System.out.println("📌 Total Tasks: " + total);
       System.out.println("✅ Completed Tasks: " + completedCount);
       System.out.println("⏳ Pending Tasks: " + pendingCount);
       System.out.println("---------------------------------");
    
        
     }
     public void savaTasks(){
        try (PrintWriter writer = new PrintWriter(new FileWriter("tasks.txt"))){
            for(Task task : tasks) {
                writer.println(
                    task.id + "|" +
                    task.title + "|" +
                    task.description + "|"+
                    task.deadline + "|" +
                    task.priority + "|" +
                    task.completed
                );
            }
            System.out.println(" 💾Tasks saved successfully!");

        } catch(IOException e) {
            System.out.println("❌Error while saving tasks.");
        }
     }
     public void loadTasks() {

    File file = new File("tasks.txt");

    if (!file.exists()) {
        return;
    }

    try (Scanner fileScanner = new Scanner(file)) {

        while (fileScanner.hasNextLine()) {

            String line = fileScanner.nextLine();

            String[] data = line.split("\\|");

            int id = Integer.parseInt(data[0]);
            String title = data[1];
            String description = data[2];
            LocalDate deadline = LocalDate.parse(data[3]);
            String priority = data[4];
            boolean completed = Boolean.parseBoolean(data[5]);

            Task task = new Task(
                    id,
                    title,
                    description,
                    deadline,
                    priority
            );

            task.completed = completed;

            tasks.add(task);
        }

        System.out.println("📂 Saved tasks loaded successfully!");

    } catch (Exception e) {

        System.out.println("❌ Error while loading tasks.");
    }
}
    }
    

