package com.his.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.his.model.User;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmailUtils {

	@Autowired
	private JavaMailSender javaMailSender;

	@Async
	public void sendUserAccountUnlockEmail(User user) {
		try {
			MimeMessage mimeMsg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);
			helper.setTo(user.getUserEmail());
			helper.setSubject("Unlock Account");
			helper.setText(getUnlockEmailBody(user), true);
			javaMailSender.send(mimeMsg);
			log.info("Mail Sent");

			javaMailSender.send(mimeMsg);
			log.info("<---------Mail sent--------->");
		} catch (Exception e) {
			log.info("Exception occur while sending mail" + e.getMessage());
		}
	}

	private String getUnlockEmailBody(User user) throws IOException {
		StringBuffer sb = new StringBuffer("");
		FileReader fr = new FileReader("UserLockTemplate.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while (line != null) {
			sb.append(line);
			line = br.readLine();
		}
		br.close();
		// format mail body
		String mailBody = sb.toString();
		mailBody = mailBody.replace("{FNAME}", user.getFirstName());
		mailBody = mailBody.replace("{LNAME}", user.getLastName());
		mailBody = mailBody.replace("{TEMP-PWD}", user.getUserPWD());
		mailBody = mailBody.replace("{EMAIL}", user.getUserEmail());
		return mailBody;
	}

}
