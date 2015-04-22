package com.alex.wang.record.util;

public interface Record {
   public static final String JNDINAME="java:app/provisioning/RecordImpl!com.alex.wang.record.util.Record$Remote";
   public interface Local extends Record{
       
   }
   public interface Remote extends Record{
       
   }
   public void recordMsg(String msg);
}
