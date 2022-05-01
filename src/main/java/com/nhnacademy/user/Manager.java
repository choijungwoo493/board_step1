package com.nhnacademy.user;

public class Manager implements User{
    String id;
    String pwd;
    String name;

    public Manager(String id, String pwd, String name) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {

    }

    @Override
    public String getPassword() {
        return this.pwd;
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getProfileFileName() {
        return null;
    }

    @Override
    public void setProfileFileName(String profileFileName) {

    }
}
