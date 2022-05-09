package com.example.logindemoproject.ui.base;

import com.example.logindemoproject.data.ApiHelper;
import com.example.logindemoproject.data.preference.PreferenceHelper;
import com.example.logindemoproject.utils.rx.SchedulerProvider;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.HttpException;

public abstract class BasePresenter<V extends BaseMvpView> implements BaseMvpPresenter<V> {

    private final SchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;
    private final ApiHelper apiHelper;
    private final PreferenceHelper preferenceHelper;
    private V mvpView;

    public BasePresenter(ApiHelper apiHelper, PreferenceHelper preferenceHelper, SchedulerProvider mSchedulerProvider, CompositeDisposable mCompositeDisposable) {
        this.apiHelper = apiHelper;
        this.preferenceHelper = preferenceHelper;
        this.mSchedulerProvider = mSchedulerProvider;
        this.mCompositeDisposable = mCompositeDisposable;
    }

    @Override
    public void onAttach(V v) {
        this.mvpView = v;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        this.mvpView = null;
    }


    public boolean isViewAttached() {
        return mvpView != null;
    }

    protected void handleApiError(Throwable throwable) {
        if (throwable instanceof ConnectException) {
            getView().showMessage("Check internet connection");
        } else if (throwable instanceof SocketTimeoutException) {
            getView().showMessage("Check internet connection");
        } else if (throwable instanceof IOException) {
            getView().showMessage("Check internet connection");
        }  else if (throwable instanceof HttpException) {
            JSONObject jObjError = null;
            try {
                jObjError = new JSONObject(((HttpException) throwable).response().errorBody().string());
                getView().showErrorMessage(jObjError.getString("error"));
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            getView().showMessage("Error");
            throwable.printStackTrace();
        }

    }

    @Override
    public void setUserAsLoggedOut() {

    }

    public V getView() {
        return mvpView;
    }

    protected CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }


    protected ApiHelper getApiHelper() {
        return apiHelper;
    }

    protected PreferenceHelper getPreferenceHelper() {
        return preferenceHelper;
    }

    protected SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }
}
