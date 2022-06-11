package com.goldenspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.goldenspace.entity.Mail;
import com.goldenspace.service.MailService;

@SpringBootApplication
public class GoldenSpaceApplication {

	public static void main(String[] args) {
		Mail mail = new Mail();
        mail.setMailFrom("fatjonrami@gmail.com");
        mail.setMailTo("fatjonrami@gmail.com");
        mail.setMailSubject("Thanks!");
        mail.setMailContent("Thank you for reading my blogs!");

        ApplicationContext ctx = SpringApplication.run(GoldenSpaceApplication.class, args);
        MailService mailService = (MailService) ctx.getBean("mailServiceImpl");
        mailService.sendEmail(mail);
	}

}
