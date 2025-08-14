package com.sarvesh.notificationservice.controller;

import com.sarvesh.notificationservice.DTO.NotificationRequest;
import com.sarvesh.notificationservice.DTO.NotificationResponse;
import com.sarvesh.notificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

   private final EmailService emailService;
    @Autowired
    public NotificationController(EmailService emailService) {
        this.emailService = emailService;
    }
    @PostMapping("/send-email")
    public NotificationResponse sendMail(@RequestBody NotificationRequest request) {

    try{emailService.sendEmail(request.getTo().trim(),request.getSubject(),request.getBody());
return new NotificationResponse(true,"email queued for sending!!");
        }catch(Exception e){
        return new NotificationResponse(false,"Failed, "+e.getMessage());
    }
    }


    @PostMapping("/testmail")
    public String sendEmail(@RequestParam String to) {
        emailService.sendEmail(to,"TestEmail","This is a test notification from Sarvesh.Please ignore!!");
        return "Email sent to "+to;
    }


}
