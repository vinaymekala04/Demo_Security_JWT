package com.demosecurity.demosecurity.controller;

import com.demosecurity.demosecurity.model.Student;
import com.demosecurity.demosecurity.model.User;
import com.demosecurity.demosecurity.service.MyUserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> list=new ArrayList<>(List.of(
            new Student(101,"vinay",99),
            new Student(101,"mallesh",89)
    ));

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return list;
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student)
    {
        list.add(student);
    }

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
