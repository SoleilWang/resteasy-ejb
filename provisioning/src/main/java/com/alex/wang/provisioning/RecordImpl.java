package com.alex.wang.provisioning;

import javax.ejb.Stateless;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import com.alex.wang.record.util.Record;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Local;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.naming.InitialContext;

import com.alex.wang.database.util.DbManager;
import com.alex.wang.log.util.LoggerManager;

@Stateless(mappedName=Record.JNDINAME)
@Remote(Record.Remote.class)
@Local(Record.Local.class)
public class RecordImpl implements Record {
    
    @EJB(lookup="java:global/rest-ear/database-0.0.1-SNAPSHOT/NameDbManager!com.alex.wang.database.util.DbManager$Remote")
    DbManager dbManager = null;
    
    
public String recordMsg(String msg) {
    // this file will be generated in the bin directory , since 
    // the start script will call java -jar .../jboss-modules.jar  org.jboss.as.standalone
    //to start jboss,so the current directory is bin directory
    File file = new File("record.log");
    try {
    InitialContext context= new InitialContext();
    QueueConnectionFactory factory= (QueueConnectionFactory) context.lookup("java:/ConnectionFactory");
    QueueConnection connection = factory.createQueueConnection();
    connection.start();
    QueueSession session= connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
    Queue queue = (Queue) context.lookup("java:/queue/MyEventsQueue");
    QueueSender sender= session.createSender(queue);
      LoggerManager.info("get " + msg);
      FileWriter fw = new FileWriter(file);
      fw.write(msg);
      fw.flush();
      fw.close();
      int value = Integer.parseInt(msg);
      for(int i = 0 ; i < value;i++){
          
          sender.send(session.createObjectMessage("jhahahahah"+i));
      }
      session.close();
      connection.close();
      TopicConnectionFactory topicfactory =  (TopicConnectionFactory)context.lookup("java:/ConnectionFactory");
      TopicConnection tc = topicfactory.createTopicConnection();
      tc.start();
      TopicSession ts = (TopicSession) tc.createSession(false, Session.AUTO_ACKNOWLEDGE);
      Topic topic = (Topic) context.lookup("java:/topic/MyEventsTopic");
      MessageProducer producer = ts.createProducer(topic);
      producer.send(ts.createObjectMessage("i sendout message"));
      dbManager.storeIntoDB("i sendout message");
      ts.close();
      tc.close();
      
     
     
      
  } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
  }catch(Exception e){
      LoggerManager.info(e.getMessage());
  }
    return new String("I have get the message: " + msg);
}
}

