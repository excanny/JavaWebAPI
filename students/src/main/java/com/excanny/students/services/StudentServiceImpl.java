package com.excanny.students.services;

import com.excanny.students.models.Student;
import com.excanny.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
       return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student update(Student params, int id) {

        Optional<Student> students = studentRepository.findById(id);
        if(students.isPresent()){
            Student student =  studentRepository.findById(id).get();
            student.setName(params.getName());
            student.setAddress(params.getAddress());
            return studentRepository.save(student);
        }else{
            return null;
        }
    }

    @Override
    public void delete(int id)
    {
        studentRepository.deleteById(id);
    }
}
