package com.hyperaware.conference.android.dagger;

import android.app.Application;

import com.hyperaware.conference.android.R;
import com.hyperaware.conference.android.logging.Logging;
import com.hyperaware.conference.android.plugin.AssetsSessionFeedbackUrlMapFactory;
import com.hyperaware.conference.android.plugin.SessionFeedbackUrlMap;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * This session feedback module understands how to read the feedback url map
 * from an Android asset file at path feedback_urls.json.
 */

@Module
public class AdcSessionFeedbackModule implements SessionFeedbackModuleInterface {

    private static final Logger LOGGER = Logging.getLogger(AdcSessionFeedbackModule.class);

    private static final String ASSET = "feedback_urls.json";

    @Provides
    @Singleton
    public SessionFeedbackUrlMap provideSessionFeedbackUrlMap(Application context) {
        try {
            return new AssetsSessionFeedbackUrlMapFactory(context, ASSET).newInstance();
        }
        catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Can't load session feedback urls from asset " + ASSET, e);
            return new SessionFeedbackUrlMap();
        }
    }

}
