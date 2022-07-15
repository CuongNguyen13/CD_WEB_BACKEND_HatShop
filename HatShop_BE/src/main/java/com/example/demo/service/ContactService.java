package com.example.demo.service;

import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    //lưu contact
    public boolean saveContact(Contact contact){
        try {
            contactRepository.save(contact);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
