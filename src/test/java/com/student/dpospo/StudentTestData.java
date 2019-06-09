package com.student.dpospo;

import com.student.dpospo.model.Student;

public class StudentTestData {

    public static final Integer HIBERNATE_SEQUENCE = 100000;

    public static final Student STUDENT_1 = new Student("19-40-0001", "Petya", "Petrov",
            "Petrovich", "petrov@gmail.com", "+7(401)200-70-60", "+7(900)800-70-60",
            "English");
    public static final Student STUDENT_2 = new Student("19-40-0002", "Ivan", "Ivanov",
            "Ivanovich", "ivanov@gmail.com", "+7(401)900-80-70", "+7(900)500-40-30",
            "German");

    public static Student getStudent1() {
        return STUDENT_1;
    }
}
