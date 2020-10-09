package com.techdenovo.daoImpl;

import com.techdenovo.dao.StudentDao;
import com.techdenovo.domain.Student;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {

            System.out.println("java programming menu:");
            System.out.println("1.insert value");
            System.out.println("2.update record");
            System.out.println("3.Display value");
            System.out.println("4.Delete record");
            System.out.println("5.Exit");
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch (choice) {

                case 1:
                    StudentOperation so = new StudentOperation();
                    so.studentInsert();
                    System.out.println("Enter all info student");
                    break;
                case 3:
                    StudentOperation so1 = new StudentOperation();
                    so1.studentDisplay();
                    System.out.println("Display all record");

                    break;
                case 2:
                    StudentOperation so2 = new StudentOperation();

                    so2.studentUpdate();
                    System.out.println("Update all record");
                    break;

                case 4:
                    StudentOperation so3 = new StudentOperation();

                    so3.studentDelete();
                    System.out.println("delete record");
                    break;

                case 5:
                    System.exit(1);


            }

        }while(true);



//        List<Student> students = studentDao.getStudents();
//        students.forEach(student -> System.out.println(student.getFirstName()));


    }




    }
