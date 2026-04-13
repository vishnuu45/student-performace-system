package com.example;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class StudentTest {

    @Test
    public void testTopperCalculation() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("A", 25, 15, 40)); // 80
        students.add(new Student("B", 30, 20, 50)); // 100
        students.add(new Student("C", 20, 10, 30)); // 60

        Student topper = StudentApp.findTopper(students);

        assertEquals("B", topper.name);
    }
}