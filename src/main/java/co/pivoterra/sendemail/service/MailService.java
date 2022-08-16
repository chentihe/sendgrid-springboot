package co.pivoterra.sendemail.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MailService {
    private static final Logger logger = LoggerFactory.getLogger(MailService.class);
    @Autowired
    private co.pivoterra.sendemail.config.SendGrid sendGrid;

    public String sendTextEmail(String replyTo) throws IOException {
        // the sender email should be the same as we used to Create a Single Sender Verification
        Email from = new Email(sendGrid.getFrom());
        String subject = "The subject";
        Email to = new Email(replyTo);
        Content content = new Content("text/plain", "Happy Birthday, Joyce");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(sendGrid.getApikey());
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            logger.info(response.getBody());
            return response.getBody();
        } catch (IOException e) {
            throw e;
        }
    }

    public String send(String replyTo) throws IOException {
        Email from = new Email(sendGrid.getFrom());
        Mail mail = new Mail();
        mail.setFrom(from);
        Personalization personalization = new Personalization();
        personalization.addTo(new Email(replyTo));
        personalization.addDynamicTemplateData("first_name", "Tihe Chen");
        mail.addPersonalization(personalization);
        mail.setTemplateId(sendGrid.getTemplateId());

        SendGrid sg = new SendGrid(sendGrid.getApikey());
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            logger.info(response.getBody());
            return response.getBody();
        } catch (IOException e) {
            throw e;
        }
    }
}
