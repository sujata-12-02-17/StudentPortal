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
            System.out.println("4.Exit");
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch (choice) {

                case 1:
                    studentInsert();
                    System.out.println("Enter all info student");
                    break;
                case 3:
                    studentDisplay();

                    break;
                case 2:
                    studentUpdate();
                    System.out.println("Update all record");
                    break;

                case 4:
                    studentDelete();
                    System.out.println("delete record");
                    break;

                case 5:
                    System.exit(1);


            }

        }while(true);



//        List<Student> students = studentDao.getStudents();
//        students.forEach(student -> System.out.println(student.getFirstName()));


    }




    private static void studentInsert () {
            Scanner scan = new Scanner(System.in);
            Student student = new Student();

            System.out.println("Enter First Name");
            student.setFirstName(scan.nextLine());

            System.out.println("Enter Last Name");
            student.setLastName(scan.nextLine());

            System.out.println("Enter your email-id");
            student.setEmail(scan.nextLine());

            StudentDao studentDao = new StudentDaoImpl();
            studentDao.saveStudent(student);
        }


    private static  void studentDisplay() {
        StudentDao studentDao = new StudentDaoImpl();

        List<Student> students = studentDao.getStudents();

        students.forEach(student -> System.out.println(student.getId()+"  "+student.getFirstName()+"  "+student.getLastName()+" "+student.getEmail()));
        //students.forEach(student -> System.out.println(student.getFirstName()));
        //students.forEach(student -> System.out.println(student.getLastName()));
       // students.forEach(student -> System.out.println(student.getEmail()));


    }private static void studentUpdate() {
        Scanner scanner = new Scanner(System.in);
        StudentDao studentDao = new StudentDaoImpl();
        System.out.println("Enter the id");
        int id = scanner.nextInt();
        Student student = studentDao.findById(id);
        if(student!= null){
            System.out.println("Enter the new email");

            student.setEmail(scanner.next());  // bufferreader not used unically

            studentDao.update(student);
        } else {
            System.out.println("No Data exist");
        }
    }
    private static void studentDelete() {

        Scanner scanner=new Scanner(System.in);
        StudentDao studentDao = new StudentDaoImpl();
        System.out.println("Enter the id");
        int id = scanner.nextInt();
        Student student = studentDao.findById(id);
        studentDao.delete(student);
    }

    }
