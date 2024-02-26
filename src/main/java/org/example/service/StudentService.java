package org.example.service;

import org.example.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private final Map<Long, Student> studentMap = new HashMap<>();
    private long lastId = 0;

    public Student createStudent(Student student) {
        student.setId((++lastId));
        studentMap.put(lastId, student);
        return student;
    }

    public Student findStudent(long lastId) {
        return studentMap.get(lastId);
    }

    public Student editStudent(Student student) {
        if (studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student deleteStudent(long id) {
        return studentMap.remove(id);
    }

    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }

    /*public Collection<Student> getFilteredStudentsByAge(String age) {
        if () {
            return studentMap.values();
        }
        return null;
    }*/
}
