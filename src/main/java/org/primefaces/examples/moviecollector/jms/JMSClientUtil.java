package org.primefaces.examples.moviecollector.jms;

import java.lang.reflect.Method;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.naming.InitialContext;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.core.remoting.impl.netty.NettyConnectorFactory;
import org.hornetq.jms.client.HornetQJMSConnectionFactory;
import org.hornetq.jms.client.HornetQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  
 * 
 * @author dersteppenwolf
 * @version 2.0
 */
public class JMSClientUtil {

	public static Logger LOGGER = LoggerFactory.getLogger(JMSClientUtil.class);

	private static final String DEFAULT_DESTINATION_QUEUE_JNDI = "IperQueue";
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static ConnectionFactory getConnectionFactory() throws Exception {
		InitialContext context = null;
		ConnectionFactory connectionFactory = null;

		try {
			LOGGER.debug("Creating Netty Based ConnectionFactory.");
			TransportConfiguration config = new TransportConfiguration(NettyConnectorFactory.class.getName());
			connectionFactory = new HornetQJMSConnectionFactory(false, config);

			return connectionFactory;
		} finally {
			closeResources(context);
		}

	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Destination getDestinationQueue() throws Exception {
		InitialContext context = null;
		Destination destination = null;

		try {
			String destName = DEFAULT_DESTINATION_QUEUE_JNDI;
			LOGGER.debug("HornetQ Destination Queue" + destName);
			destination = new HornetQQueue(destName);
			return destination;
		} finally {
			closeResources(context);
		}
	}

	
	/**
	 * 
	 * @param objects
	 */
	public static void closeResources(Object... objects) {
		try {
			for (Object object : objects) {
				Method close = object.getClass().getMethod("close", new Class[] {});
				close.invoke(object, new Object[] {});
			}
		} catch (Exception ignore) {
		}

	}
}
