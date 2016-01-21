package net.henorek.plantit.ui.components.controls;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.TextView;

import net.henorek.plantit.R;

/**
 * Created by Jarek Jankowski.
 * jarosz1994@gmail.com
 */
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
