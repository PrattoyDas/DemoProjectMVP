package com.example.logindemoproject.common.di.module;

import com.example.logindemoproject.common.di.ApplicationScope;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class PicassoModule {

    @Provides
    @ApplicationScope
    Picasso picasso() {
        return Picasso.get();
    }
}
