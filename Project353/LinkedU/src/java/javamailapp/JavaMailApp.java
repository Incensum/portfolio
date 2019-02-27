/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamailapp;

/**
 *
 * @author john
 * Code snippet courtesy of student Dinesh Daultani and Professor BillyLim
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class JavaMailApp {

    public void sendMail(String to, String firstName, String lastName, String userID, String password, String email, String secQuestion, String secAnswer){

        // Recipient's email ID needs to be mentioned.

        // Sender's email ID needs to be mentioned
        String from = "jaowen@ilstu.edu";
        
        // Assuming you are sending email from this host
        String host = "outlook.office365.com";
        
        //Get Message to send from
        String htmlBody = "<!DOCTYPE html>" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\">" +
                "<head>" +
"        <meta charset=\"utf-8\" />" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />" +
"        <link type=\"text/css\" rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" /></head><body>" +
"        <div class=\"container\">" +
"            <div class=\"navbar navbar-inverse\">" +
"                <div class=\"navbar-brand\">" +
"                    John A. Owen Successful Sign Up Confirmation Email" +
"                </div>" +
"            </div>" +
"            <div class=\"row\">" +
"                <div class=\"col-md-4\"></div>" +
"                <div class=\"col-md-4\">" +
"                    <h3 class=\"text-center\">Sign Up Successful</h3>" +
"                    <hr />" +
"<form id=\"j_idt7\" name=\"j_idt7\">" +
"                        <div class=\"form-group\">" +
"                            <label for=\"firstName\">First Name: " +
                            firstName+ "</label>" +
"                        </div>" +
"                        <div class=\"form-group\">" +
"                            <label for=\"lastName\">Last Name: " +
                            lastName + "</label>" +
"                        </div>" +
"                        <div class=\"form-group\">" +
"                            <label for=\"userID\">User ID: " +
                            userID + "</label>" +
"                        </div>" +
"                        <div class=\"form-group\">" +
"                            <label for=\"password\">Password: " +
                            password + "</label>" +
"                        </div>" +
"                        <div class=\"form-group\">" +
"                            <label for=\"email\">Email: " +
                            email + "</label>" +
"                        </div>" +
"                        <div class=\"form-group\">" +
"                            <label for=\"secQuestion\">Security Question: " +
                            secQuestion + "</label>" +
"                        </div>" +
"                        <div class=\"form-group\">" +
"                            <label for=\"secAnswer\">Security Answer: " +
                            secAnswer + "</label>" +
"                        </div>" +
"</form>" +
"                </div>" +
"            </div>" +
"        </div></body>" +
"" +
"</html>";

        
        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "587");
        // Get the default Session object.
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, ""); //TODO: encrypt or string hash password and consume from a config file.
            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Congratulations!");

            // Send the actual HTML message, as big as you like
            message.setContent(htmlBody,
                    "text/html");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
