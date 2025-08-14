    package com.sarvesh.notificationservice.service;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.mail.SimpleMailMessage;
    import org.springframework.mail.javamail.JavaMailSender;
    import org.springframework.scheduling.annotation.Async;
    import org.springframework.stereotype.Service;

    @Service
    public class EmailService {

    private final JavaMailSender mailSender;
    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;

    }
    @Async
    public void sendEmail(String to,String Subject,String Body){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("sarveshbh.2022@gmail.com");
        message.setTo(to);
        message.setSubject(Subject);
        message.setText(Body);
        mailSender.send(message);
        try{
            Thread.sleep(3000);
        }catch (InterruptedException ignored){}

        System.out.println("Email sent successfully to :"+to+"in thread:"+Thread.currentThread().getName());
    }



    }
