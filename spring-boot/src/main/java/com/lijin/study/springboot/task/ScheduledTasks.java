package com.lijin.study.springboot.task;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.lijin.study.springboot.entity.Quote;

/**
 * 定时任务类
 * @author xmlij
 *
 */
@Component
public class ScheduledTasks {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * 每两秒打印一次当前时间
	 */
	@Scheduled(fixedRate = 2000)
	public void currentTime() {
		logger.info("Current time is： {}", dateFormat.format(System.currentTimeMillis()));
		
		Quote quote = restTemplate.getForObject(
				"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		logger.info(quote.toString());
	}
	
}
