package com.nirbhaya.app;

import android.app.Application;

import com.nirbhaya.app.dagger.component.AppComponent;
import com.nirbhaya.app.dagger.component.DaggerAppComponent;
import com.nirbhaya.app.dagger.module.ApplicationModule;
import com.nirbhaya.app.nirbhaya.BuildConfig;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

/**
 * Created by vinay on 17/01/17.
 */

public class NirbhayaApplication extends Application {
    private AppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        setupLeakCanary();

        setComponent(createAppComponent());
    }

    private void setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    private void setComponent(AppComponent component) {
        mComponent = component;
    }

    protected AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }



    public AppComponent getComponent() {
        return mComponent;
    }
}
