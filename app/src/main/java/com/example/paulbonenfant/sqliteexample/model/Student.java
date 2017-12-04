package com.example.paulbonenfant.sqliteexample.model;

/**
 * Created by bonenfan on 06/04/2016.
 */
public class Student {
    private String name;
    private String email;
    private boolean fullTime;
    private long dbId;

    public Student(String name, String email, boolean fullTime, long dbId) {
        this.name = name;
        this.email = email;
        this.fullTime = fullTime;
        this.dbId = dbId;
    }

    public Student(String name, String email, boolean fullTime) {
        this.name = name;
        this.email = email;
        this.fullTime = fullTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }

    public long getDbId() {
        return dbId;
    }

    public void setDbId(long dbId) {
        this.dbId = dbId;
    }

    @Override
    public String toString(){
        return name + "id: " + dbId;
    }
}

