package com.example.logindemoproject.common.di.component;
import com.example.logindemoproject.common.di.ApplicationScope;
import com.example.logindemoproject.common.di.module.DataManagerModule;
import com.example.logindemoproject.common.di.module.PicassoModule;
import com.example.logindemoproject.common.di.module.SchedulerModule;
import com.example.logindemoproject.data.ApiHelper;
import com.example.logindemoproject.data.preference.PreferenceHelper;
import com.example.logindemoproject.utils.rx.SchedulerProvider;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by Jamil on 7/24/2021.
 */
@Component(modules = {DataManagerModule.class, SchedulerModule.class, PicassoModule.class})
@ApplicationScope
public interface WingsAppComponent {

    SchedulerProvider getScheduleProvider();

    ApiHelper getApiHelper();

    PreferenceHelper getPreferenceHelper();

    Picasso getPicasso();
}
