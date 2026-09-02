import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        manager.loadTasks();

        boolean running =true;
        while(running) {
            System.out.println("📝 SMART TASK MANAGER 📝");
            System.out.println("➕ 1. Add Task");
            System.out.println("👀 2. View Tasks"); 
            System.out.println("✅ 3. Mark Task as Completed");
            System.out.println("🗑️ 4. Delete Task");
            System.out.println("🔍 5. Search Task");
            System.out.println("📊 6. View Statistics");
            System.out.println("🚪 7. Exit");
            System.out.println("👉Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("\n➕ ----- ADD NEW TASK -----");

                    System.out.print("🆔 Enter Task ID: ");
                     int id = scanner.nextInt();

                    scanner.nextLine();

                   System.out.print("📝 Task Title: ");
                   String title = scanner.nextLine();

                   System.out.print("📄 Description: ");
                   String description = scanner.nextLine();

                   System.out.print("📅 Deadline (YYYY-MM-DD): ");
                   String dateInput = scanner.nextLine();

                   LocalDate deadline = LocalDate.parse(dateInput);

                   System.out.print("🔥 Priority (HIGH/MEDIUM/LOW): ");
                   String priority = scanner.nextLine().toUpperCase();
                 Task task = new Task(
                 id,title,description,deadline,priority
        );
       manager.addTask(task);

       break;

    case 2:
        manager.viewTasks();
        break;
    case 3:
        System.out.println("Enter Task ID to mark as completed: ");
        int taskID =scanner.nextInt();
        scanner.nextLine();

        manager.markTaskCompleted(taskID);
        break;
    case 4:
        System.out.println("Enter Task ID to delete:");
        int deleteid = scanner.nextInt();
        scanner.nextLine();

        manager.deleteTask(deleteid);
        break;
    case 5:
        System.out.println("Enter keyword to search:");
        String keyword = scanner.nextLine();
        manager.searchTask(keyword);
        break;
    case 6:
        manager.showStatistics();
        break;
    case 7:
        manager.savaTasks();
        System.out.println(" 👋Thank you for using Smart Task Manager!");
        running = false;
        break;
    default:
        System.out.println(" ⚠️Invalid choice. Please try again.");


            }
        }
        scanner.close();
    
    }
}