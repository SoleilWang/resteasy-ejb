package com.alex.wang.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.alex.wang.log.util.LoggerManager;
import com.alex.wang.record.util.Record;

@Stateless
public class CountServiceImpl implements CountService {

    @EJB(lookup="java:global/rest-ear/provisioning-0.0.1-SNAPSHOT/RecordImpl!com.alex.wang.record.util.Record$Remote")
    Record record = null;

    public Response count(String number) {
        // TODO Auto-generated method stub
        int realValue= Integer.parseInt(number)*2;
        LoggerManager.info(String.valueOf(realValue));
        String result = record.recordMsg(String.valueOf(realValue));
        LoggerManager.info(result);
        ResponseBuilder builder = Response.status(200);
        builder.entity(realValue);
        return builder.build();
    }

}
