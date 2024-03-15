package com.elif.service;


import com.elif.dto.response.RegisterResponseDto;
import lombok.RequiredArgsConstructor;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderService {
    private final JavaMailSender javaMailSender;

    public void sendMail(RegisterResponseDto dto){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("elifgurmetu@gmail.com");
        mailMessage.setTo(dto.getEmail());
        mailMessage.setSubject("AKTIVASYON KODUNUZ...");
        mailMessage.setText( "Kullanıcı adınız: " + dto.getUsername() + "\n" +
                "Hesabınızı aktifleştirmek için lütfen aşağıdaki linke tıklayın:\n" +
                "http://34.155.65.27:9090/dev/v1/auth/activate-status/" + dto.getActivationCode());
        javaMailSender.send(mailMessage);
    }
}
