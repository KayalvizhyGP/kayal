package view_the_current_list_of_tasks;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ToDoList {
	private List<String> tasks;
    private Scanner scanner;

    public ToDoList() {
        this.tasks = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addTask() {
        System.out.print("Enter the task to add: ");
        String task = scanner.nextLine();
        this.tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void viewTasks() {
        if (this.tasks.isEmpty()) {
            System.out.println("Your to-do list is empty.");
        } else {
            System.out.println("--- Current Tasks ---");
            for (int i = 0; i < this.tasks.size(); i++) {
                System.out.println((i + 1) + ". " + this.tasks.get(i));
            }
            System.out.println("---------------------");
        }
    }

    public void markAsCompleted() {
        if (this.tasks.isEmpty()) {
            System.out.println("Your to-do list is empty. Nothing to mark as completed.");
            return;
        }
        viewTasks(); // Show the tasks with numbers
        System.out.print("Enter the number of the task to mark as completed: ");
        if (scanner.hasNextInt()) {
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            if (index >= 1 && index <= this.tasks.size()) {
                String completedTask = this.tasks.get(index - 1);
                this.tasks.set(index - 1, "[Completed] " + completedTask);
                System.out.println("Task " + index + " marked as completed.");
            } else {
                System.out.println("Invalid task number.");
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    public void removeTask() {
        if (this.tasks.isEmpty()) {
            System.out.println("Your to-do list is empty. Nothing to remove.");
            return;
        }
        viewTasks(); // Show the tasks with numbers
        System.out.print("Enter the number of the task to remove: ");
        if (scanner.hasNextInt()) {
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            if (index >= 1 && index <= this.tasks.size()) {
                String removedTask = this.tasks.remove(index - 1);
                System.out.println("Task \"" + removedTask + "\" removed.");
            } else {
                System.out.println("Invalid task number.");
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    public void run() {
        int choice;
        do {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark as Completed");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        viewTasks();
                        break;
                    case 3:
                        markAsCompleted();
                        break;
                    case 4:
                        removeTask();
                        break;
                    case 5:
                        System.out.println("Exiting the application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
                choice = -1; // To continue the loop
            }
        } while (choice != 5);
        scanner.close();
    }

    public static void main(String[] args) {
        ToDoList todoApp = new ToDoList();
        todoApp.run();
    }
}