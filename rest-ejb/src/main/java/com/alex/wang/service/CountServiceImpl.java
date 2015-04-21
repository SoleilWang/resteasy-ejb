package com.alex.wang.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.alex.wang.log.util.LoggerManager;
import com.alex.wang.record.util.Record;

@Stateless
public class CountServiceImpl implements CountService {
    public static final String RECORDER_JNDI_NAME="java:global/provisioning/Record";
    @EJB(lookup="java:global/provisioning/RecordImpl!com.alex.wang.record.util.Record$Local")
    Record record = null;

    public Response count(String number) {
        // TODO Auto-generated method stub
        int realValue= Integer.parseInt(number)*2;
        LoggerManager.info(String.valueOf(realValue));
        record.recordMsg(String.valueOf(realValue));
        ResponseBuilder builder = Response.status(200);
        builder.entity(realValue);
        return builder.build();
    }

}
