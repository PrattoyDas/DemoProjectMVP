package com.example.logindemoproject.ui.login;

import com.example.logindemoproject.data.model.response.LoginResponse;
import com.example.logindemoproject.ui.base.BaseMvpPresenter;
import com.example.logindemoproject.ui.base.BaseMvpView;

public interface MainActivityContract {

    interface MainActivityView extends BaseMvpView {
        void onLogin(LoginResponse loginResponse);

    }

    interface IMainActivityView extends BaseMvpPresenter<MainActivityView> {
        void api(String username, String password);
    }
}
