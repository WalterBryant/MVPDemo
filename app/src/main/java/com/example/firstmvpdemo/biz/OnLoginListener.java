package com.example.firstmvpdemo.biz;

import com.example.firstmvpdemo.bean.User;

/**
 * Created by Walter on 2017/4/14.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
