
package servlets;

import com.sun.mail.util.logging.MailHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


public class SendMail extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
        String from = "kaveeshanadun7@gmail.com";//mail eka yawana email eka
        String to = "kaveefights9@gmail.com";//mail eka yana kena
        String password = "brick34op";//mail eka yawana email eke passwor eka
        String subject = req.getParameter("form-email");
        String msg = req.getParameter("form-message");
        
       Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.enable", true);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });
        
        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText("From Drinks Shop-"+""+msg);
            Transport.send(message);
            
            resp.getWriter().write("1");
            
        } catch (MessagingException e) {
            e.printStackTrace();
            resp.getWriter().write("0");
            throw new RuntimeException(e);
        }
    }

    
}
