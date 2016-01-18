package net.henorek.plantit;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;


import butterknife.Bind;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

public class MainScreenActivity extends FragmentActivity {

    @Bind(R.id.pager)
    ViewPager viewPager;

    @Bind(R.id.fmsc_special_offer_indicator)
    CircleIndicator _specialOfferIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        ButterKnife.bind(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MainScreenAdapter(fragmentManager));
        _specialOfferIndicator.setViewPager(viewPager);

    }

}
