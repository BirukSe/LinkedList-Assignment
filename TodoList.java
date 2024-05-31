package todolist_App;

import java.util.Scanner;

class Task {
    public String title, description;
    public boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        completed = true;
    }

    public String toString() {
        return "Title: " + title + " Description: " + description + " Completed: " + completed;
    }
}

class Node {
    public Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
    }
}

public class TodoList {
    public Node head;

    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void markToDoAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            if (current.task.getTitle().equals(title)) {
                current.task.markCompleted();
                System.out.println("Task \"" + title + "\" marked as completed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found.");
    }

    public void viewToDoList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }
       public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("TASK MANAGER");
            System.out.println("1: Add a task");
            System.out.println("2: View tasks");
            System.out.println("3: Mark task as completed");
            System.out.println("4: Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    todoList.addToDo(new Task(title, description));
                    break;
                case 2:
                    todoList.viewToDoList();
                    break;
                case 3:
                    System.out.print("Enter the title of the task to mark as completed: ");
                    String taskTitle = scanner.nextLine();
                    todoList.markToDoAsCompleted(taskTitle);
                    break;
                case 4:
                    System.out.println("Exiting Task Manager. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println(); // For better readability
        }
    }
}


 

