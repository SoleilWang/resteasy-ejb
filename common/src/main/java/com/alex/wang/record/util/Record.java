package com.alex.wang.record.util;

public interface Record {
   public interface Local extends Record{
       
   }
   public interface Remote extends Record{
       
   }
   public void recordMsg(String msg);
}
