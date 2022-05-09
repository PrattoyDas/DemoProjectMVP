package com.example.logindemoproject.ui.base;

import androidx.annotation.StringRes;

public interface BaseMvpView {
    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showSuccessMessage(String message);

    void showErrorMessage(String message);


    void showMessage(@StringRes int resId);

    void showSuccessMessage(@StringRes int resId);

    void showErrorMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();

}
