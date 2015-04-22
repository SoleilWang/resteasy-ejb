package com.alex.wang.provisioning;

import javax.ejb.Stateless;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.alex.wang.record.util.Record;
import javax.ejb.Remote;
import javax.ejb.Local;
import com.alex.wang.log.util.LoggerManager;

@Stateless(mappedName=Record.JNDINAME)
@Remote(Record.Remote.class)
@Local(Record.Local.class)
public class RecordImpl implements Record {

public void recordMsg(String msg) {
    // this file will be generated in the bin directory , since 
    // the start script will call java -jar .../jboss-modules.jar  org.jboss.as.standalone
    //to start jboss,so the current directory is bin directory
    File file = new File("record.log");
    try {
      LoggerManager.info("get " + msg);
      FileWriter fw = new FileWriter(file);
      fw.write(msg);
      fw.flush();
      fw.close();
  } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
  }
}
}
