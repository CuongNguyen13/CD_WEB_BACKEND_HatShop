package com.example.demo.service;

import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //danh sách contact sắp xếp theo ngày gửi

    public List<Contact> listContact(String fiel){
        return contactRepository.findByStatus(1,Sort.by(Sort.Direction.ASC,"dateSend"));
    }

        //update status
    public boolean updateStatus(int id, int status){
        try {
         Contact contact =    contactRepository.findById(id);
         contact.setStatus(status);
         contactRepository.save(contact);
            return true;
        }catch (Exception e){
            return  false;
        }
    }
}