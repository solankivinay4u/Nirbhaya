package com.nirbhaya.app.dagger.component;

import android.app.Application;

import com.nirbhaya.app.dagger.module.ApplicationModule;
import com.nirbhaya.app.dagger.scope.AppScope;

import dagger.Component;

/**
 * Created by vinay on 17/01/17.
 */
@AppScope
@Component(modules = {
        ApplicationModule.class,

})
public interface AppComponent extends Injector{
    Application app();
}
