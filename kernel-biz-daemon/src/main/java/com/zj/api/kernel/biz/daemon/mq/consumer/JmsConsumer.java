package com.zj.api.kernel.biz.daemon.mq.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.InitializingBean;

import javax.jms.*;


/**
 * Created by js on 2017/1/16.
 */
public class JmsConsumer implements InitializingBean {

    private String queueName;

    private ActiveMQConnectionFactory connectionFactory;

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public ActiveMQConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    public void setConnectionFactory(ActiveMQConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void afterPropertiesSet() throws Exception {
        Connection connection  = connectionFactory.createConnection();
        Session session =  connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = null;
        if(queueName.contains("QUEUE")){
            destination = new ActiveMQQueue(queueName);
        }else if(queueName.contains("TOPIC")) {
            destination = new ActiveMQTopic("testTopic");
        }
        MessageConsumer messageConsumer = session.createConsumer(destination);

    }


}
