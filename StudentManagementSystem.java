
/*
 * File: StudentManagementSystem.java
 * Purpose: Main class that manages student records.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    // Store Student objects using superclass references.
    // This also allows runtime polymorphism.
    private static ArrayList<Person> students = new ArrayList<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean running = true;

        // Repeat the menu until the user chooses Exit
        while (running) {

            System.out.println("\n====================================");
            System.out.println("      STUDENT MANAGEMENT SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Calculate Average Marks");
            System.out.println("4. Exit");
            System.out.println("====================================");
            System.out.print("Enter your choice: ");

            String menuInput = input.nextLine();

            int choice;

            // Check whether the input is a valid integer
            try {
                choice = Integer.parseInt(menuInput);
            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid input. Please enter a number."
                );
                continue;
            }

            // Process the selected menu option
            switch (choice) {

                case 1:
                    addStudent(input);
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    calculateAverageMarks();
                    break;

                case 4:
                    running = false;
                    System.out.println(
                        "Thank you for using the system!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Please select 1 to 4."
                    );
            }
        }

        input.close();
    }

    // Method to create and add a student
    public static void addStudent(Scanner input) {

        System.out.println("\n--- ADD NEW STUDENT ---");

        System.out.print("Enter student name: ");
        String name = input.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        System.out.print("Enter student ID: ");
        String id = input.nextLine().trim();

        if (id.isEmpty()) {
            System.out.println("Student ID cannot be empty.");
            return;
        }

        // Check for duplicate student IDs
        for (Person person : students) {
            if (person.getId().equalsIgnoreCase(id)) {
                System.out.println(
                    "Error: This student ID already exists."
                );
                return;
            }
        }

        System.out.print("Enter marks (0-100): ");
        String marksInput = input.nextLine();

        double marks;

        try {
            marks = Double.parseDouble(marksInput);
        } catch (NumberFormatException e) {
            System.out.println(
                "Invalid marks. Please enter a number."
            );
            return;
        }

        if (marks < 0 || marks > 100) {
            System.out.println(
                "Marks must be between 0 and 100."
            );
            return;
        }

        // Create a Student object
        Student student = new Student(name, id, marks);

        // Add the object to the collection
        students.add(student);

        System.out.println(
            "Student added successfully!"
        );
    }

    // Method to display all student records
    public static void displayStudents() {

        System.out.println("\n--- ALL STUDENT RECORDS ---");

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        // Runtime polymorphism:
        // Person references call Student's overridden method.
        for (Person person : students) {
            person.displayInfo();
        }
    }

    // Method to calculate the average marks
    public static void calculateAverageMarks() {

        System.out.println("\n--- AVERAGE STUDENT MARKS ---");

        if (students.isEmpty()) {
            System.out.println(
                "No student records available to calculate."
            );
            return;
        }

        double totalMarks = 0;

        for (Person person : students) {

            // Convert the superclass reference to Student
            Student student = (Student) person;

            totalMarks += student.getMarks();
        }

        double average = totalMarks / students.size();

        System.out.printf(
            "Total students : %d%n", students.size()
        );
        System.out.printf(
            "Average marks  : %.2f%n", average
        );
    }
}
