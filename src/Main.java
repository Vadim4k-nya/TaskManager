import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Task task = new Task();

        String command;
        Scanner in = new Scanner(System.in);
        do {
            command = in.nextLine();
            if (command.equals("add")) {
                task.addTask();
            } else if (command.equals("get")) {
                task.getTaskMaxPriority();
            } else if (command.equals("next")) {
                task.nextTask();
            } else if (command.equals("list")) {
                task.listTasks();
            } else if (!command.equals("exit")) {
                System.err.println("Can not foud this command!!");
            }
        } while (!command.equals("exit"));
    }
}