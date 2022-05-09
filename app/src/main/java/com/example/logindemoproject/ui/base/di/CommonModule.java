package com.example.logindemoproject.ui.base.di;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class CommonModule {
    @Provides
    @PerActivity
    CompositeDisposable compositeDisposable() {
        return new CompositeDisposable();
    }
}
