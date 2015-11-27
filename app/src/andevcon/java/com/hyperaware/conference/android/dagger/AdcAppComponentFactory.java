package com.hyperaware.conference.android.dagger;

import android.app.Application;

public class AdcAppComponentFactory implements AppComponentFactory {

    @Override
    public AppComponent newInstance(final Application context) {
        return DaggerAdcAppComponent.builder()
            .androidModule(new AndroidModule(context))
            .build();
    }

}
