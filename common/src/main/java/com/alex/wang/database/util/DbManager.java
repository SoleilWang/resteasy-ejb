package com.alex.wang.database.util;

public interface DbManager {
    public interface Remote extends DbManager{
        
    }
    public interface Local extends DbManager{
        
    }
    public String storeIntoDB(String msg);

}
