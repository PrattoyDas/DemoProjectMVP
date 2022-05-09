package com.example.logindemoproject.ui.batchdetails.di;

import com.example.logindemoproject.common.di.component.WingsAppComponent;
import com.example.logindemoproject.data.preference.PreferenceHelper;
import com.example.logindemoproject.ui.batchdetails.BatchDetailsContract;

import dagger.Component;

@Component(modules = BatchDetailsActivityModule.class, dependencies = WingsAppComponent.class)
@BatchDetailsActivityScope
public interface BatchDetailsComponent {

    BatchDetailsContract.IBatchDetailsView getPresenter();

    PreferenceHelper getPreferenceHelper();
}
