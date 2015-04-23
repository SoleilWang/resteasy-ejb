package com.alex.wang.message;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.ejb.ActivationConfigProperty;

import com.alex.wang.log.util.LoggerManager;
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/queue/MyEventsQueue") })
public class MessageMdb implements MessageListener{

    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        ObjectMessage realmessage = (ObjectMessage)message;
        String value;
        try {
            value = (String)(realmessage.getObject());
            LoggerManager.info("get Message" + value + "by " + this);
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }

}
