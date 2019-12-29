package com.ats.batch;

import org.apache.tomcat.util.net.ApplicationBufferHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ats.batch.main.LowBalanceRemainderJob;

@SpringBootApplication
public class AtsbatchApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AtsbatchApplication.class, args);
		LowBalanceRemainderJob job = context.getBean(LowBalanceRemainderJob.class);
		job.test();
	}

}
