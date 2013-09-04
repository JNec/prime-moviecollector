package org.primefaces.examples.moviecollector.jms;

import java.util.Random;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.hornetq.jms.client.HornetQQueue;
import org.hornetq.jms.client.HornetQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author juan.mendez
 * 
 */
public class JMSClient {
	public static Logger LOGGER = LoggerFactory.getLogger(JMSClient.class);

	private static final String DEFAULT_USER = "myJmsUser";
	private static final String DEFAULT_PWD = "myJmsUserPwd2013.,";
	private static int messageCounter = 0;
	
	/**
	 * 
	 * @throws Exception
	 */
	public static void sendTextMessage(String message) throws Exception {
		LOGGER.debug("sendTextMessages...");
		Connection connection = null;
		Session session = null;
		ConnectionFactory connectionFactory = null;
		MessageProducer producer = null;

		try {
			connectionFactory = JMSClientUtil.getConnectionFactory();

			// connection = connectionFactory.createConnection();
			connection = connectionFactory.createConnection(DEFAULT_USER, DEFAULT_PWD);
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = new HornetQTopic("TestTopic");
			producer = session.createProducer(destination);
			connection.start();

			TextMessage textMessage = session.createTextMessage();
			LOGGER.debug("sending...");
			textMessage.setText(message + " (" + messageCounter++ + " ) ");
			producer.send(textMessage);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			try {
				producer.close();
				connection.close();
				session.close();
			} catch (JMSException e) {
				LOGGER.error(e.getMessage(), e);
			}

		}
	}

	public static void sendTextMessageToQueue(String message) throws Exception {
		LOGGER.debug("testSendTextMessagesToQueue...");
		Connection connection = null;
		Session session = null;
		ConnectionFactory connectionFactory = null;
		MessageProducer producer = null;

		try {

			connectionFactory = JMSClientUtil.getConnectionFactory();

			// connection = connectionFactory.createConnection();
			connection = connectionFactory.createConnection(DEFAULT_USER, DEFAULT_PWD);
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = new HornetQQueue("TestQueue");
			producer = session.createProducer(destination);
			connection.start();

			TextMessage textMessage = session.createTextMessage();
			LOGGER.debug("sending...");
			textMessage.setText(message + " (" + messageCounter++ + " ) ");
			producer.send(textMessage);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			try {
				producer.close();
				connection.close();
				session.close();
			} catch (JMSException e) {
				LOGGER.error(e.getMessage(), e);
			}

		}
	}

}
