package com.henorek.plantit.ui.utils;

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