package net.henorek.plantit.ui.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.henorek.plantit.R;

/**
 * Created by Jarek Jankowski.
 * jarosz1994@gmail.com
 */
public class StartGameViewFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start_game_view, container, false);
    }
}
