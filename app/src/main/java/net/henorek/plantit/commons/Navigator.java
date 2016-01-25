package net.henorek.plantit.commons;

import android.content.Context;
import android.content.Intent;

import net.henorek.plantit.ui.views.activities.MatchmakingActivity;

public class Navigator {

    public static void navigateToMatchmakingActivity(Context context) {
        Intent intent = new Intent(context, MatchmakingActivity.class);
        context.startActivity(intent);
    }

}
