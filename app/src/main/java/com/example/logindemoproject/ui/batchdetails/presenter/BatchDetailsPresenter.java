package com.example.logindemoproject.ui.batchdetails.presenter;

import android.util.Log;


import com.example.logindemoproject.data.ApiHelper;
import com.example.logindemoproject.data.preference.PreferenceHelper;
import com.example.logindemoproject.ui.base.BasePresenter;
import com.example.logindemoproject.ui.batchdetails.BatchDetailsContract;
import com.example.logindemoproject.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public class BatchDetailsPresenter extends BasePresenter<BatchDetailsContract.BatchDetailsView> implements BatchDetailsContract.IBatchDetailsView {
    private static final String TAG = "P-Action";

    public BatchDetailsPresenter(ApiHelper apiHelper, PreferenceHelper preferenceHelper, SchedulerProvider mSchedulerProvider, CompositeDisposable mCompositeDisposable) {
        super(apiHelper, preferenceHelper, mSchedulerProvider, mCompositeDisposable);
    }

    @Override
    public void getBatchOrderList(String searchText) {
        Log.v(TAG, "getPointStock");


    }

    @Override
    public void list(String status) {

    }
}
