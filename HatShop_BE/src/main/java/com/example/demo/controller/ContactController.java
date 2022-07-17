package com.example.demo.controller;

import com.example.demo.dto.ContactUpdateDTO;
import com.example.demo.dto.ListPage;
import com.example.demo.dto.SendMailDTO;
import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;
import com.example.demo.utilities.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class ContactController {
    @Autowired
    ContactService contactService;
    @Autowired
    SendEmail sendEmail;

    @PostMapping(value = "/contact")
    public boolean contact(@RequestBody Contact contact){
        LocalDate myObj = LocalDate.now();
        contact.setDateSend(java.sql.Date.valueOf(myObj));
        contact.setStatus(1);
        return contactService.saveContact(contact);
    }

//    @GetMapping(value = "/admin/contact")
//    public List<Contact> getListContact(){
//        return contactService.listContact("dateSend");
//    }

    @GetMapping("/admin/contact")
    public ListPage<Contact> getListContact(@RequestParam(name = "limit",required = false,defaultValue = "5") int limit, @RequestParam(name = "page",required = false,defaultValue = "1") int page){
        return contactService.findAll(page,limit);
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
