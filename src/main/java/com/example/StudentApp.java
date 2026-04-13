package com.example;

import java.util.*;

class Student {
    String name;
    int cat, assignment, fat;
    int total;
    double gpa;
    String grade;

    Student(String name, int cat, int assignment, int fat) {
        this.name = name;
        this.cat = cat;
        this.assignment = assignment;
        this.fat = fat;
        calculate();
    }

    void calculate() {
        total = cat + assignment + fat;
        gpa = total / 10.0;

        if (total >= 90) grade = "A";
        else if (total >= 75) grade = "B";
        else if (total >= 60) grade = "C";
        else grade = "D";
    }
}

public class StudentApp {

    public static Student findTopper(List<Student> students) {
        return Collections.max(students, Comparator.comparingInt(s -> s.total));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("CAT (30): ");
            int cat = sc.nextInt();

            System.out.print("Assignment (20): ");
            int assignment = sc.nextInt();

            System.out.print("FAT (50): ");
            int fat = sc.nextInt();

            students.add(new Student(name, cat, assignment, fat));
        }

        Student topper = findTopper(students);

        System.out.println("\n===== STUDENT RESULTS =====");
        for (Student s : students) {
            System.out.println(
                s.name + " | Total: " + s.total +
                " | GPA: " + s.gpa +
                " | Grade: " + s.grade
            );
        }

        System.out.println("\n🏆 Topper: " + topper.name + " (" + topper.total + ")");
    }
}