package com.sai.spring_sec_demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sai.spring_sec_demo.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>(
            List.of(
                    new Student(1, "sai nithin", "java"),
                    new Student(2, "rama", "Cloud Computing")));

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {

        // type casting the Object to CsrfToken
        return (CsrfToken) request.getAttribute("_csrf");
        // Hello
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("students")
    public void addStudent(@RequestBody Student student) {
        students.add(student);
    }
}
