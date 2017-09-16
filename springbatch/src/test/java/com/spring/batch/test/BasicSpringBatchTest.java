/**
 * 
 */
package com.spring.batch.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Siddhant sahu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SpringApplicationContext.xml")
public class BasicSpringBatchTest {
	private final static Logger LOGGER = Logger.getLogger(BasicSpringBatchTest.class);
	@Autowired
	private ApplicationContext context;

	@Test
	public void testBasicSpringBatch() {
		final JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		final Job job = (Job) context.getBean("employeeJob");
		try {
			final JobExecution execution = jobLauncher.run(job, new JobParameters());
			LOGGER.info("Exit Status : " + execution.getStatus());
		} catch (Exception e) {
			LOGGER.error(e);
		}
		LOGGER.info("Done");
	}
}
