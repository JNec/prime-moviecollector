package org.primefaces.examples.moviecollector.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ExampleJob extends QuartzJobBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestJob.class);

	private int timeout;

	/**
	 * Setter called after the ExampleJob is instantiated with the value from
	 * the JobDetailBean (5)
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		// do the actual work
		LOGGER.info("test cron...");
		LOGGER.info("timeout:"+timeout);
		//System.out.println("executeInternal....");
		//System.out.println("timeout:"+timeout);
	}
}
