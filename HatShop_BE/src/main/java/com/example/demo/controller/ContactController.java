package com.example.demo.controller;

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ContactController {
    @Autowired
    ContactService contactService;
    @PostMapping(value = "/contact")
    public boolean contact(@RequestBody Contact contact){
        Date date = new Date();

        contact.setDateSend(new java.sql.Date(date.getYear(),date.getMonth(), date.getDay()));
        contact.setStatus(1);
        return contactService.saveContact(contact);
    }

    @GetMapping(value = "/admin/contact")
    public List<Contact> getListContact(){
        return contactService.listContact("email");
    }




}
