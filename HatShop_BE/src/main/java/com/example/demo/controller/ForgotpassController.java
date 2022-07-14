package com.example.demo.controller;

import com.example.demo.model.ObjectResponse;
import com.example.demo.model.UserCodeOTP;
import com.example.demo.model.UserModeNamePass;
import com.example.demo.service.UserService;
import com.example.demo.utilities.RenderOTP;
import com.example.demo.utilities.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ForgotpassController {
    @Autowired
    UserService userService;
    @Autowired
    SendEmail mailSender;
    @Autowired
    RenderOTP otp;
    @Autowired
    SendEmail sendEmail;

    @RequestMapping(value = "/forgetpass", method = RequestMethod.GET)
    public ModelAndView forgetPass(ModelMap model) {
        return new ModelAndView("forgetpass", model);

    }

    @RequestMapping(value = "/forgetpass", method = RequestMethod.POST)
    public ModelAndView forgetPass(ModelMap model,
                                   @RequestParam("email") String email,
                                   @RequestParam("pass") String pass
    ) {
        if (!userService.isExistEmail(email)) {
            model.addAttribute("email", false);
            model.addAttribute("email", email);
            return new ModelAndView("forgetpass", model);
        }
        if (!mailSender.sendEmail(email, otp.createOTP()) || !userService.updateCodeAndTimeResetPass(email, otp.getCode())) {
            model.addAttribute("sendMail", false);
            return new ModelAndView("forgetpass", model);
        }

        model.addAttribute("email", email);
        model.addAttribute("pass", pass);
        return new ModelAndView("OTP");
    }

    @RequestMapping(value = "/sendOTP", method = RequestMethod.POST)
    public ModelAndView pageOTP(ModelMap model, @RequestParam("email") String email,
                                @RequestParam("pass") String pass, @RequestParam("otp") String otp) {
        model.addAttribute("email", email);
        model.addAttribute("pass", pass);
        if (!userService.validTimeCode(email)) {
            model.addAttribute("timeCode", false);
            return new ModelAndView("OTP", model);
        }
        if (!userService.validCode(otp)) {
            model.addAttribute("code", false);
            return new ModelAndView("OTP", model);
        }
        model.addAttribute("resetPass", true);
        userService.updatePass(pass);
        return new ModelAndView("redirect:/login", model);
    }

    @RequestMapping(value = "/resetOTP", method = RequestMethod.GET)
//    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ObjectResponse> resetOTP(@RequestParam("email") String email) {

        if (userService.validTimeCode(email)) return ResponseEntity.status(HttpStatus.OK)
                .body(
                        new ObjectResponse("RUNNING", "")
                );
        sendEmail.sendEmail(email, otp.createOTP());
        userService.updateCodeAndTimeResetPass(email, otp.getCode());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ObjectResponse("SUCCESS", ""));
    }


    @PostMapping(value = "/forgetpass2")
    public UserModeNamePass forgetPass2(@RequestBody UserModeNamePass user
    ) {
        if (!userService.isExistEmail(user.getEmail())) {
            return new UserModeNamePass("Email không tồn tại");
        }
        if (!mailSender.sendEmail(user.getEmail(), otp.createOTP()) || !userService.updateCodeAndTimeResetPass(user.getEmail(), otp.getCode())) {
            return new UserModeNamePass("Vui lòng thử lại trong vài phút !");
        }
        return new UserModeNamePass(user.getEmail(), user.getPass(), "Redirect OTP Page");
    }

    @PostMapping(value = "/sendOTP2")
    public UserCodeOTP pageOTP2(@RequestBody UserCodeOTP user) {
        if (!userService.validTimeCode(user.getEmail())) {
            return new UserCodeOTP(user.getEmail(), user.getPass(), "Mã OTP đã quá hạn", user.getOtp());
        }
        // user.getMessage() là otp
        if (!userService.validCode(user.getOtp())) {
            return new UserCodeOTP(user.getEmail(), user.getPass(), "Mã OTP không chính xác", user.getOtp());
        }
        userService.updatePass(user.getPass());
        return new UserCodeOTP(user.getEmail(), user.getPass(), "Update Password Success", user.getOtp());
    }
}
