package com.example.demo.service;

import com.example.demo.entity.Profile;
import com.example.demo.entity.User;
import com.example.demo.model.UserModel;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.utilities.ConvertUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private User user ;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ConvertUser convertUser;
    @Autowired
    ProfileRepository profileRepository;

    public User findByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }
    public User findById(int id) {return userRepository.findById(id);}
    public boolean isExistEmail(String email) {
        if (findByEmail(email) == null) return false;
        return true;
    }

    public boolean login(String email, String pass) {
        System.out.println("email = " + userRepository.findFirstByEmailAndPassword(email, pass));
        if (userRepository.findFirstByEmailAndPassword(email, pass) == null) return false;
        return true;
    }

    public boolean login1(String email, String pass) {
        System.out.println("CC = ");
        User user = userRepository.findFirstByEmailAndPassword(email, pass);
        if (user == null) return false;
//        UserModeNamePass userModeNamePass = new UserModeNamePass(user.getEmail(), user.getPassword());
//        System.out.println(user.toString());
        return true;
    }

    @Transactional
    public boolean saveUser(UserModel user){
        try{
            User u = convertUser.toEntity(user) ;
            System.out.println("saveUser = " + u);
            userRepository.save(u);
            Profile profile = new Profile("", u.getFistName() + " " + u.getLastName(), 0, "", "Active", u);
            profileRepository.save(profile);
        }catch (Exception e){
            return false ;
        }
        return  true ;
    }

    @Transactional
    public boolean updateCodeAndTimeResetPass(String email , String code){
        try{
            User user = findByEmail(email);
            user.setCodeRecovery(code);
            user.setTimeRecovery(System.currentTimeMillis());
            userRepository.save(user);
            return  true ;
        } catch (Exception exception){
            return  false ;
        }
    }
    @Transactional
    public void updatePass(String pass){
        this.user.setPassword(pass);
        userRepository.save(user);
    }
    public  boolean validTimeCode(String email){
        User user = findByEmail(email);
        if(user==null) return  false ;
        this.user = user ;
        long time = user.getTimeRecovery() ;
        if(((System.currentTimeMillis()-time)/1000)>60){
            return false ;
        }
        return true ;

    }
    public boolean validCode(String otp){
        if(this.user.getCodeRecovery().equals(otp)){
            return true ;
        }
        return false ;
    }

}
