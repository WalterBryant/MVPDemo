package com.example.firstmvpdemo.biz;

/**
 * Created by Walter on 2017/4/14.
 */

public interface IUserBiz {
    public void login(String username, String password, OnLoginListener loginListener);
}
