package com.kelaniya.backend.utils.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class GmailSMTP {
  public static void sendEmail(String Email, String otp){

    // enter your email and password
    final String username = "";
    final String password = "";
    String fromEmail = username;
    String toEmail = Email;

    String host = "smtp.gmail.com";
    String port = "587";
    Properties properties = System.getProperties();
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", port);
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.ssl.trust","*");

    Session session = Session.getInstance(properties,
            new Authenticator() {
              protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
              }
            });

    try {
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(username));
      message.addRecipient(
              Message.RecipientType.TO,
              new InternetAddress(toEmail)
      );
      message.setSubject("User email confirmation - University of Kelaniya");
      String htmlCode =
              "<img src='https://kln.ac.lk/images/kelaniyauni-b-01.png' "
                      + "alt='Logo' style='display: block; margin-left: auto; margin-right: auto;  width: 20%;'/><br><br>"
                      + "<h1 style='text-align: center;'><strong>University of Kelaniya</strong></h1>"
                      + "<p>Please note that this email is associated with the account of LMS of university of Kelaniya."
                      + "<p>your otp is : <b>"+otp+"</b></p>"
                      + "<p>Thank you</p><br><br>"
                      + "<img src='https://ik.imagekit.io/lfdg74akzjt/LMS/uokFull_QNYwi8MZP.webp?ik-sdk-version=javascript-1.4.3&updatedAt=1651675642179' "
                      + "style='width: 100%;'/><br><br>";
      message.setContent(htmlCode, "text/html");
      Transport.send(message);

      System.out.println("Sended email");

    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }

}
