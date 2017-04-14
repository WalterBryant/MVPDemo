package com.example.firstmvpdemo.presenter;

import android.os.Handler;

import com.example.firstmvpdemo.bean.User;
import com.example.firstmvpdemo.biz.IUserBiz;
import com.example.firstmvpdemo.biz.OnLoginListener;
import com.example.firstmvpdemo.biz.UserBiz;
import com.example.firstmvpdemo.view.IUserLoginView;

/**
 * Created by Walter on 2017/4/14.
 */

public class UserLoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login() {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
//                    userBiz.login("123", "123", new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
