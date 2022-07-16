package com.example.demo.controller;

import com.example.demo.dto.ContactUpdateDTO;
import com.example.demo.dto.SendMailDTO;
import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;
import com.example.demo.utilities.SendEmail;
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
    @Autowired
    SendEmail sendEmail;

    @PostMapping(value = "/contact")
    public boolean contact(@RequestBody Contact contact){
        Date date = new Date();

        contact.setDateSend(new java.sql.Date(date.getYear(),date.getMonth(), date.getDay()));
        contact.setStatus(1);
        return contactService.saveContact(contact);
    }

    @GetMapping(value = "/admin/contact")
    public List<Contact> getListContact(){
        return contactService.listContact("dateSend");
    }

    @PostMapping(value = "/admin/contact/update")
    public boolean updateDateContact(@RequestBody ContactUpdateDTO contact){
        return contactService.updateStatus(contact.getId(), contact.getStatus());
    }

    @PostMapping(value = "/admin/contact/send")
    public boolean sendMail(@RequestBody SendMailDTO sendMail){
        try {
            sendEmail.sendContact(sendMail.getEmail(), sendMail.getContent());
            return true;
        }catch (Exception e){
            return  false;
        }
    }


}
