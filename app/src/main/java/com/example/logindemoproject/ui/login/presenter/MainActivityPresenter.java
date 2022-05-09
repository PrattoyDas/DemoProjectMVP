package com.example.logindemoproject.ui.login.presenter;

import com.example.logindemoproject.data.ApiHelper;
import com.example.logindemoproject.data.model.request.LoginRequest;
import com.example.logindemoproject.data.preference.PreferenceHelper;
import com.example.logindemoproject.ui.login.MainActivityContract;
import com.example.logindemoproject.ui.base.BasePresenter;
import com.example.logindemoproject.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivityPresenter extends BasePresenter<MainActivityContract.MainActivityView> implements MainActivityContract.IMainActivityView {

    public MainActivityPresenter(ApiHelper apiHelper, PreferenceHelper preferenceHelper, SchedulerProvider mSchedulerProvider, CompositeDisposable mCompositeDisposable) {
        super(apiHelper, preferenceHelper, mSchedulerProvider, mCompositeDisposable);
    }

    @Override
    public void api(String username, String password) {
        LoginRequest loginRequest = new LoginRequest(username, password);
        getCompositeDisposable().add(
                getApiHelper().login(loginRequest)
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(data -> {
                            if (isViewAttached()) {
                                getView().onLogin(data);
                            }
                        }, throwable -> {
                            if (isViewAttached()) {
                                handleApiError(throwable);
                            }
                        })
        );
    }
}
