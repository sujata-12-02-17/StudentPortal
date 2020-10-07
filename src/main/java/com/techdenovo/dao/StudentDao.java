package com.techdenovo.dao;

import com.techdenovo.domain.Student;

import java.util.List;

public interface StudentDao {

    public void saveStudent(Student student);
    public List<Student> getStudents();
    public void update(Student student);
    public Student findById(int id);
}
