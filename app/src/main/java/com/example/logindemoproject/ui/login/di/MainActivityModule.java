package com.example.logindemoproject.ui.login.di;

import com.example.logindemoproject.data.ApiHelper;
import com.example.logindemoproject.data.preference.PreferenceHelper;
import com.example.logindemoproject.ui.login.MainActivityContract;
import com.example.logindemoproject.ui.login.presenter.MainActivityPresenter;
import com.example.logindemoproject.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class MainActivityModule {

    @Provides
    @MainActivityScope
    CompositeDisposable compositeDisposable() {
        return new CompositeDisposable();
    }


    @Provides
    @MainActivityScope
    MainActivityContract.IMainActivityView mainActivityView(ApiHelper apiHelper, PreferenceHelper preferenceHelper, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        return new MainActivityPresenter(apiHelper, preferenceHelper, schedulerProvider, compositeDisposable);
    }

}
