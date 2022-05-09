package com.example.logindemoproject.common.di.module;

import android.content.Context;

import com.example.logindemoproject.common.di.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jamil on 7/24/2021.
 */
@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    public Context context(){
        return context;
    }
}
