package com.ats.batch.main;

public interface BatchProccess {
public Integer preProcess();
public void start();
public void process(Integer txId,Integer tagId);
public void postProcess();
}
