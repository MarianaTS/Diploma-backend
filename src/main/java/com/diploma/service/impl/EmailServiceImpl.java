package com.diploma.service.impl;

import com.diploma.entity.Coordinate;
import com.diploma.service.EmailService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {
    private final String appEmail = "plot.readre@gmail.com";
    private final String  password = "plot12345";

    public void sendEmail(String emailTo, String text) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(appEmail, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(appEmail));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailTo));
            message.setSubject("PlotReader result");
            message.setText(makeMessage(text));
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public String makeMessage(String text) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        Gson gsonReceiver = new Gson();
        String message = "";
        message+="This is result of your image processing\n";
        message+= dtf.format( LocalDateTime.now())+"\n\n";
        List<Coordinate> listResult = gsonReceiver.fromJson(text, List.class);
        for (Object obj: listResult) {
            message+=obj+"\n";
        }
        return message;
    }
}
