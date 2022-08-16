package co.pivoterra.sendemail.controller;

import co.pivoterra.sendemail.bean.MailInfo;
import co.pivoterra.sendemail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api")
public class MailController {

    @Autowired
    MailService mailService;

    @PostMapping(value = "/send-text", produces = MediaType.APPLICATION_JSON_VALUE)
    public String send(@RequestBody MailInfo mailInfo) throws IOException {
        return mailService.sendTextEmail(mailInfo.getTo());
    }

    @PostMapping(value = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendWithTemplate(@RequestBody MailInfo mailInfo) throws IOException {
        return mailService.send(mailInfo.getTo());
    }
}
