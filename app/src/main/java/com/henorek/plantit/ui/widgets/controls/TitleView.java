package com.henorek.plantit.ui.widgets.controls;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.TextView;
import com.henorek.plantit.R;

public class TitleView extends TextView {

  public TitleView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    initialize();
  }

  public TitleView(Context context, AttributeSet attrs) {
    super(context, attrs);
    initialize();
  }

  public TitleView(Context context) {
    super(context);
    initialize();
  }

  private void initialize() {
    Spanned logo = Html.fromHtml(getResources().getString(R.string.logo));
    setText(logo);
    Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "Raleway-Bold.ttf");
    setTypeface(typeface);
  }
}
