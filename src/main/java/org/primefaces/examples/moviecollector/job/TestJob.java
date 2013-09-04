package org.primefaces.examples.moviecollector.job;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Test Job
 * 
 * @author dersteppenwolf
 * 
 */
public class TestJob extends QuartzJobBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestJob.class);

	/*
	 * (non-Javadoc)
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		try {
			LOGGER.info("test cron...");
			System.out.println("this is a test cron....");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

	}

}
