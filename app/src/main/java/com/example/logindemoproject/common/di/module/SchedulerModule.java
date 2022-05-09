package com.example.logindemoproject.common.di.module;

import com.example.logindemoproject.common.di.ApplicationScope;
import com.example.logindemoproject.utils.rx.AppSchedulerProvider;
import com.example.logindemoproject.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jamil on 7/24/2021.
 */

@Module
public class SchedulerModule {

    @Provides
    @ApplicationScope
    public SchedulerProvider schedulerProvider(){
        return new AppSchedulerProvider();
    }
}
