package net.henorek.plantit.ui.utils;

/**
 * Created by Jarek Jankowski on 2016-01-18.
 */
public class ActivityConfigBuilder {
    protected ActivityConfig activityConfig = createConfig();

    public ActivityConfigBuilder(int contentId) {
        activityConfig.layoutId = contentId;
    }

    public ActivityConfig build() {
        return activityConfig;
    }

    protected ActivityConfig createConfig() {
        return new ActivityConfig();
    }

    public ActivityConfigBuilder setContentId(int contentId) {
        activityConfig.layoutId = contentId;
        return this;
    }
}