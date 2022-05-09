package com.example.logindemoproject.ui.login.di;

import com.example.logindemoproject.common.di.component.WingsAppComponent;
import com.example.logindemoproject.data.preference.PreferenceHelper;
import com.example.logindemoproject.ui.login.MainActivityContract;

import dagger.Component;

@Component(modules = MainActivityModule.class, dependencies = WingsAppComponent.class)
@MainActivityScope
public interface MainActivityComponent {

    MainActivityContract.IMainActivityView getPresenter();

    PreferenceHelper getPreferenceHelper();
}
