package com.example.logindemoproject.ui.batchdetails.di;

import com.example.logindemoproject.data.ApiHelper;
import com.example.logindemoproject.data.preference.PreferenceHelper;
import com.example.logindemoproject.ui.batchdetails.BatchDetailsContract;
import com.example.logindemoproject.ui.batchdetails.presenter.BatchDetailsPresenter;
import com.example.logindemoproject.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class BatchDetailsActivityModule {

    @Provides
    @BatchDetailsActivityScope
    CompositeDisposable compositeDisposable() {
        return new CompositeDisposable();
    }


    @Provides
    @BatchDetailsActivityScope
    BatchDetailsContract.IBatchDetailsView batchDetailsView(ApiHelper apiHelper, PreferenceHelper preferenceHelper, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        return new BatchDetailsPresenter(apiHelper, preferenceHelper, schedulerProvider, compositeDisposable);
    }

}
