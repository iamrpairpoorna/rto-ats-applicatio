package com.ats.trailer.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ats.trailer.model.LoginModel;
import com.ats.trailer.model.Person;
import com.ats.trailer.repository.LoginRepository;


@Service
public class NotificationService {

	private JavaMailSender javaMailSender;
	@Autowired
	LoginRepository lrepo;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;
	}
	
	public void sendNotification(Person person) throws Exception {
		
		
		SimpleMailMessage smm = new SimpleMailMessage();
		System.out.println("in service:"+person.getUserEmail());
		smm.setTo(person.getUserEmail());
		//smm.setFrom("chandurapolu@gmail.com");
		smm.setSubject("ATS Account Registration");
		smm.setText(mailContent(person));
		
		javaMailSender.send(smm);
		
	}
	
	public String mailContent(Person person) throws IOException {
		
		LoginModel lm = new LoginModel();
		String line="";
		String oldPut="",outPut=""; 
		String tempPass=getAlphaNumericString(8);
		BufferedReader br=null;
		
		
		try {
			br = new BufferedReader(new FileReader("src/main/resources/success.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			oldPut=oldPut+line+"\n";
		}
		 oldPut=oldPut.replaceAll("email", person.getUserEmail());
		 oldPut=oldPut.replaceAll("FName", person.getFirstName());
		 oldPut=oldPut.replaceAll("LName", person.getLastName());
		 outPut=oldPut.replaceAll("tempPass",tempPass );
		 
		 
		 lm.setUserName(person.getUserEmail());
		 lm.setUserPassword(tempPass);
		 lm.setUserRole(person.getUserRole());
		 lm.setLockUser("lock");
		 lrepo.save(lm);
		 
		 return outPut;

	}

	 public String getAlphaNumericString(int n) 
	    { 
	        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
	        StringBuilder sb = new StringBuilder(n); 
	  	        for (int i = 0; i < n; i++) { 
	            int index 
	                = (int)(AlphaNumericString.length() 
	                        * Math.random()); 
	            sb.append(AlphaNumericString.charAt(index)); 
	        } 
	         return sb.toString(); 
	    }
	
}
