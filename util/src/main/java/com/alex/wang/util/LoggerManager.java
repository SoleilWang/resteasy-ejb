package com.alex.wang.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LoggerManager {
   public static Logger logger = LoggerFactory.getLogger("AccessLog");
   public static void info(String msg){
       logger.info(msg);
   }
}
