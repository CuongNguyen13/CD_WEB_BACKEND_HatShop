package com.example.demo.controller;

import com.example.demo.entity.Contact;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @PostMapping(value = "/contact")
    public String contact(@RequestBody Contact contact){
        System.out.printf("contact: "+ contact.toString());
        return contact.toString();
    }



}
