import java.util.*;
import java.io.FileWriter;
import java.io.IOException;


public class Task {

    protected Map<Integer, String> tasks = new HashMap<>();
    private int lastTask = 9;
    private static final String fileName = "tasks.txt";

    public void addTask() {
        String task;
        int priority;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the task: ");
        task = in.nextLine();
        System.out.println("Enter the priority: ");
        priority = in.nextInt();
        tasks.put(priority, task);
        saveTaskToFile(task, priority);
        System.out.println("Task added successfully!\n\n\n");
    }

    private void saveTaskToFile(String taskName, int priority) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("Task: " + taskName + ", Priority: " + priority + "\n");
        } catch (IOException e) {
            System.err.println("Error writing task to file: " + e.getMessage());
        }
    }

    public void getTask() {
        for (int i = lastTask; i >= 0; i--) {
            if (tasks.containsKey(i)) {
                System.out.println(tasks.get(i));
                lastTask--;
                return;
            }
        }
    }

    public void getTaskMaxPriority() {
        lastTask = 9;
        getTask();
    }

    public void nextTask() {
        lastTask--;
        getTask();
    }

    public void listTasks() {
        lastTask = 9;
        getTask();
    }
}
