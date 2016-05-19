package com.henorek.plantit.commons;

import android.content.Context;
import android.content.Intent;
import com.henorek.plantit.ui.main_screen.MainScreenActivity;
import com.henorek.plantit.ui.main_screen.activities_screen.matchmaking_screen.MatchmakingActivity;

public class Navigator {

  public static void navigateToMainScreenActivity(Context context) {
    Intent intent = new Intent(context, MainScreenActivity.class);
    context.startActivity(intent);
  }

  public static void navigateToMatchmakingActivity(Context context) {
    Intent intent = new Intent(context, MatchmakingActivity.class);
    context.startActivity(intent);
  }
}
