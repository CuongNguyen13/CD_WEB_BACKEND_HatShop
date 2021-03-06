package com.example.demo.utilities;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class SendEmail {
    @Autowired
    JavaMailSender mailSender ;

    public boolean sendEmail(String to , String code){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setSubject("OTP Reset PassWord");
            helper.setFrom("haphamufc@gmail.com");
            helper.setTo(to);
            String content = "<h1 style= \\n\" +\n" + "font-weight: 300; text-align: center;\\\">"+code+"</h1>";
            helper.setText(content, true);
            mailSender.send(message);
            return  true ;

        } catch (MessagingException e) {
            return  false ;
        }



    }
    public boolean sendContact(String to , String contentContact){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setSubject("HatShop xin chào!!");
            helper.setFrom("haphamufc@gmail.com");
            helper.setTo(to);
            String content = contentContact;
            helper.setText(content, true);
            mailSender.send(message);
            return  true ;

        } catch (MessagingException e) {
            return  false ;
        }
    }
}

