package com.example.logindemoproject.ui.base;

public interface BaseMvpPresenter<V extends BaseMvpView> {
    void onAttach(V v);

    void onDetach();


    void setUserAsLoggedOut();


}
