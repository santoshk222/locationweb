package com.sk.location.util;

/***********************************************************************
 * History.
 * 
 * 21.12.2019 Created.
 **********************************************************************/
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtilImpl implements EmailUtil {

	@Autowired
	private JavaMailSender sender;

	@Override
	public void sendMail(String to, String subject, String body) {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body);
		} catch (MessagingException e) {

			e.printStackTrace();
		}
		// sender.send(message);
	}

}
