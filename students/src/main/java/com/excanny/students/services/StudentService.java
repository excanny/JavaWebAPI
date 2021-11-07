package com.excanny.students.services;

import com.excanny.students.models.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentById(int id);
    public Student update(Student params, int id);
    public void delete(int id);
}
