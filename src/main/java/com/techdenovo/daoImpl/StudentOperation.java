package com.techdenovo.daoImpl;

import com.techdenovo.dao.StudentDao;
import com.techdenovo.domain.Student;

import java.util.List;
import java.util.Scanner;

public class StudentOperation {


    public   void studentInsert () {
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


    public   void studentDisplay() {
        StudentDao studentDao = new StudentDaoImpl();

        List<Student> students = studentDao.getStudents();

        students.forEach(student -> System.out.println(student.getId()+"  "+student.getFirstName()+"  "+student.getLastName()+" "+student.getEmail()));
        //students.forEach(student -> System.out.println(student.getFirstName()));
        //students.forEach(student -> System.out.println(student.getLastName()));
        // students.forEach(student -> System.out.println(student.getEmail()));


    }public  void studentUpdate() {
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
    public void studentDelete() {

        Scanner scanner=new Scanner(System.in);
        StudentDao studentDao = new StudentDaoImpl();
        System.out.println("Enter the id");
        int id = scanner.nextInt();
        Student student = studentDao.findById(id);
        studentDao.deleteStudent(id);
    }
}
