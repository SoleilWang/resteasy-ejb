package com.alex.wang.databasemanager;
import javax.ejb.Stateless;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.alex.wang.data.NameEntity;
import com.alex.wang.database.util.DbManager;
import com.alex.wang.log.util.LoggerManager;

@Stateless
@Local(DbManager.Local.class)
@Remote(DbManager.Remote.class)
public class NameDbManager implements DbManager{
    
    @PersistenceContext(unitName = "NameDbManager")
    EntityManager entityManager;

    public String storeIntoDB(String msg) {
        // TODO Auto-generated method stub
        NameEntity entity = new NameEntity();
        entity.setName(msg);
        entityManager.persist(entity);
        LoggerManager.info("I have persistent the message");
        return new String("Finished");
    }

}
