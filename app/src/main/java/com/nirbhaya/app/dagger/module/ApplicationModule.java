package com.nirbhaya.app.dagger.module;

import android.app.Application;
import android.content.Context;

import com.nirbhaya.app.NirbhayaApplication;
import com.nirbhaya.app.dagger.scope.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kevin on 7/6/15.
 */
@Module
public class ApplicationModule {

    private final NirbhayaApplication mApp;

    public ApplicationModule(NirbhayaApplication app) {
        this.mApp = app;
    }

    @Provides
    @AppScope
    Application provideApplication() {
        return mApp;
    }

    @Provides
    @AppScope
    Context provideContext() {
        return mApp;
    }
}
