package net.henorek.plantit.ui.widgets.controls;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class LoadedImageView extends ImageView {

    private ImageLoader _imageLoader;

    public LoadedImageView(Context context) {
        super(context);
    }

    public LoadedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void loadBitmap(String url) {
        if(_imageLoader==null) createImageLoader(getContext());
        _imageLoader.displayImage(url, this);
    }

    public void loadBitmap(String url, boolean roundedCorner) {
        if(_imageLoader==null) createImageLoader(getContext());
        _imageLoader.loadBitmap(url,roundedCorner,this);
    }


    public void loadBitmap(String url, ImageLoader.ImageLoadingListener listener) {
        if(_imageLoader==null) createImageLoader(getContext());
        _imageLoader.displayImage(url, this, listener);
    }

    private void createImageLoader(Context context){
        _imageLoader=new ImageLoader(context);
    }

    public void loadBitmapWithoutPlaceholder(String url) {
        if(_imageLoader==null) createImageLoader(getContext());
        _imageLoader.displayImageWithoutPlaceholder(url, this);
    }
}
