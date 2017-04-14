package com.example.firstmvpdemo.view;

import com.example.firstmvpdemo.bean.User;

/**
 * Presenter与View之间的交互是通过接口的
 *
 * Created by Walter on 2017/4/14.
 */

public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
