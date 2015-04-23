package com.alex.wang.message;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.alex.wang.log.util.LoggerManager;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/topic/MyEventsTopic") })

public class SubscriberTwo implements MessageListener {

    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        ObjectMessage realmessage = (ObjectMessage)message;
        
        try {
            String value = (String)realmessage.getObject();
            LoggerManager.info("I am the two, I got the message" + value);
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
