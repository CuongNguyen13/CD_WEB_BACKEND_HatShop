package com.example.demo.controller;

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ContactController {
    @Autowired
    ContactService contactService;
    @PostMapping(value = "/contact")
    public boolean contact(@RequestBody Contact contact){
        Date date = new Date();

        contact.setDateSend(new java.sql.Date(date.getYear(),date.getMonth(), date.getDay()));
        return contactService.saveContact(contact);
    }



}
