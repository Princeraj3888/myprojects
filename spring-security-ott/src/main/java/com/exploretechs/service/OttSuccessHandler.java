package com.exploretechs.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.ott.OneTimeToken;
import org.springframework.security.web.authentication.ott.OneTimeTokenGenerationSuccessHandler;
import org.springframework.security.web.authentication.ott.RedirectOneTimeTokenGenerationSuccessHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class OttSuccessHandler implements OneTimeTokenGenerationSuccessHandler {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    private OneTimeTokenGenerationSuccessHandler redirectHandler = new RedirectOneTimeTokenGenerationSuccessHandler("/ott/sent");
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, OneTimeToken oneTimeToken) throws IOException, ServletException {

        UriComponentsBuilder token = UriComponentsBuilder.fromHttpUrl(UrlUtils.buildFullRequestUrl(request))
                        .replacePath(request.getContextPath())
                                .path("/login/ott")
                .queryParam("token", oneTimeToken.getTokenValue());

        String magicLink = token.toUriString();
        System.out.println("magic link: "+magicLink);

        sendNotification(oneTimeToken, magicLink);

        redirectHandler.handle(request, response, oneTimeToken);
    }

    private void sendNotification(OneTimeToken oneTimeToken, String magicLink){
        try{
            System.out.println("sender email address: "+ sender);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("exploretechs <" + sender + ">");
            message.setTo("emailsforraj@gmail.com");
            message.setSubject("One-Time Password (OTP) Request");

            String messageBody = """
                     Hello %s,
                            \s
                     Use the following link to sign in to the application:
                            \s
                     %s
                            \s
                     This link is valid for a limited time. If you did not request this, please ignore this email.
                            \s
                    \s""".formatted(oneTimeToken.getUsername(), magicLink);

            message.setText(messageBody);
            javaMailSender.send(message);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private Map<String, String> getEmail(){
        Map<String, String> emailMap = new HashMap<>();
        emailMap.put("raj", "emailsforraj@gmail.com");
        return emailMap;
    }
}
