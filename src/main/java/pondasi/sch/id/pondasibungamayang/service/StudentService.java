/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pondasi.sch.id.pondasibungamayang.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pondasi.sch.id.pondasibungamayang.model.Student;
import pondasi.sch.id.pondasibungamayang.repository.StudentRepository;

/**
 *
 * @author Asus VivoBook
 */
@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(Long id) {
        return studentRepository
                .findById(id)
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found")
                );
    }

    public Student create(Student student) {
        if (student.getId() != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Student already exists"
            );
        }
        if (studentRepository.existsByName(student.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Student name already exists");
        }
        return studentRepository.save(student);
    }

    public Student update(Long id, Student student) {
        getById(id);
        student.setId(id);
        return studentRepository.save(student);
    }

    public Student delete(Long id) {
        Student student = getById(id);
        studentRepository.delete(student);
        return student;
    }
}
