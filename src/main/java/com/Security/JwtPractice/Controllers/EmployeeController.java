package com.Security.JwtPractice.Controllers;

import jakarta.persistence.Tuple;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

    @GetMapping("/getAll")
    public List<String> getAll(){

        List<String> list = new ArrayList<>();

        list.add("John");
        list.add("Jane");
        list.add("Mary");
        list.add("Bob");

        return list;
    }

    @GetMapping("/get")
    public String getEmployee(){
        return "John";
    }

    @GetMapping("/update")
    public String updateEmployee(){
        return "this action updates employee";
    }

    @DeleteMapping("/delete")
    public String deleteEmployee(){
        return "this action deletes employee";
    }
}
