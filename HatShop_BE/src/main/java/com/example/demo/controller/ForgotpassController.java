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
            return new UserModeNamePass("Email kh??ng t???n t???i");
        }
        if (!mailSender.sendEmail(user.getEmail(), otp.createOTP()) || !userService.updateCodeAndTimeResetPass(user.getEmail(), otp.getCode())) {
            return new UserModeNamePass("Vui l??ng th??? l???i trong v??i ph??t !");
        }
        return new UserModeNamePass(user.getEmail(), user.getPass(), "Redirect OTP Page");
    }

    @PostMapping(value = "/sendOTP2")
    public UserCodeOTP pageOTP2(@RequestBody UserCodeOTP user) {
        if (!userService.validTimeCode(user.getEmail())) {
            return new UserCodeOTP(user.getEmail(), "M?? OTP ???? qu?? h???n", user.getOtp1(), user.getOtp2(), user.getOtp3(), user.getOtp4(), user.getOtp5(), user.getOtp6());
        }
        String otp = "" + user.getOtp1() + user.getOtp2() + user.getOtp3() + user.getOtp4() + user.getOtp5() + user.getOtp6();
        if (!userService.validCode(otp.trim())) {
            System.out.println("otp = " + otp.trim());
            return new UserCodeOTP(user.getEmail(), "M?? OTP kh??ng ch??nh x??c", user.getOtp1(), user.getOtp2(), user.getOtp3(), user.getOtp4(), user.getOtp5(), user.getOtp6());
        }
        userService.updatePass(user.getNewPass());
        return new UserCodeOTP(user.getEmail(), "Update Password Success", user.getOtp1(), user.getOtp2(), user.getOtp3(), user.getOtp4(), user.getOtp5(), user.getOtp6());
    }

    @PostMapping(value = "/resetOTP2")
//    @PreAuthorize("isAuthenticated()")
    public String resetOTP2(@RequestParam("email") String email) {
        if (userService.validTimeCode(email)) return "?????i email h???t th???i gian c???p 2 ph??t";
        sendEmail.sendEmail(email, otp.createOTP());
        userService.updateCodeAndTimeResetPass(email, otp.getCode());
        return "G???i l???i th??nh c??ng h??y ki???m tra email";
    }
}