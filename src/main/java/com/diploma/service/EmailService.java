package com.diploma.service;

public interface EmailService {
     void sendEmail(String emailTo, String text);
     String makeMessage(String text);
}
