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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter Name:");
            String name = sc.next();

            System.out.println("Enter CAT (30):");
            int cat = sc.nextInt();

            System.out.println("Enter Assignment (20):");
            int assign = sc.nextInt();

            System.out.println("Enter FAT (50):");
            int fat = sc.nextInt();

            students.add(new Student(name, cat, assign, fat));
        }

        // Find topper
        Student topper = Collections.max(students, Comparator.comparingInt(s -> s.total));

        System.out.println("\n--- Results ---");
        for (Student s : students) {
            System.out.println(s.name + " | Total: " + s.total + " | GPA: " + s.gpa + " | Grade: " + s.grade);
        }

        System.out.println("\nTopper: " + topper.name + " with " + topper.total);
    }
}