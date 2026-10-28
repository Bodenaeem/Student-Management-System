
/*
 * File: Student.java
 * Purpose: Represents a student and their academic marks.
 */

public class Student extends Person {

    // Private attribute specific to Student
    private double marks;

    // Constructor
    public Student(String name, String id, double marks) {
        super(name, id);
        setMarks(marks);
    }

    // Getter for marks
    public double getMarks() {
        return marks;
    }

    // Setter for marks with validation
    public void setMarks(double marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            throw new IllegalArgumentException(
                "Marks must be between 0 and 100."
            );
        }
    }

    // Calculate the student's grade
    public String calculateGrade() {
        if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    // Override the abstract method from Person
    @Override
    public void displayInfo() {
        System.out.println("--------------------------------");
        System.out.println("Student ID : " + getId());
        System.out.println("Name       : " + getName());
        System.out.printf("Marks      : %.2f%n", getMarks());
        System.out.println("Grade      : " + calculateGrade());
        System.out.println("--------------------------------");
    }
}
