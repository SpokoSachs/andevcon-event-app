package com.hyperaware.conference.android.dagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Component and Modules used by the andevcon flavor event app.
 */

@Singleton
@Component(
    modules = {
        AndroidModule.class,
        AdjustableClockModule.class,
        AppExecutorsModule.class,
        EventBusModule.class,
    }
)
public interface AdcAppComponent extends AppComponent {
}
