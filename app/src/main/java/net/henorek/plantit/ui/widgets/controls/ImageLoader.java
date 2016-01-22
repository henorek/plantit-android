package net.henorek.plantit.ui.widgets.controls;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;


//TODO dostowwac i zaimplementowac cache
public class ImageLoader {

    static volatile Picasso singleton = null;
    private boolean _inited = false;
    private Picasso _piccasso = null;
    private int _drawableLoading;
    private int _drawableBroken;
    private ArrayList<Target> _targets = new ArrayList<>();//referencja do targetow

    public ImageLoader(Context context) {
//        init(context, R.drawable.cover_loading, R.drawable.cover_broken);
    }

    private static Picasso with(Context context) {
        if (singleton == null) {
            synchronized (Picasso.class) {
                if (singleton == null) {
                    Picasso.Builder builder = new Picasso.Builder(context);
//                    builder.memoryCache(new AudiotekaBitmapCache(BLLFactory.getInstance().getMainManager().getResManager()));
                    singleton = builder.build();
                }
            }
        }
        return singleton;
    }

    public void init(Context context, int drawableLoading, int drawableBroken) {
        if (context != null) {
            _piccasso = with(context);
            _drawableBroken = drawableBroken;
            _drawableLoading = drawableLoading;
            _inited = true;
        }
    }

    public void displayImage(String url, ImageView imageView) {
        _piccasso.load(url).placeholder(_drawableLoading).error(_drawableBroken).into(imageView);
    }

    public void displayImageWithoutPlaceholder(String url, ImageView imageView) {
        _piccasso.load(url).noFade().into(imageView);
    }

    public void displayImage(String url, ImageLoadingListener listener) {
        displayImage(url, null, listener);
    }

    public void displayImage(final String url, final ImageView imageView, final ImageLoadingListener listener) {
        Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
                listener.onLoadingComplete(url, imageView, bitmap);
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
                _targets.remove(this);
            }

            @Override
            public void onBitmapFailed(Drawable drawable) {
                if (imageView != null) imageView.setImageResource(_drawableBroken);
                _targets.remove(this);
            }

            @Override
            public void onPrepareLoad(Drawable drawable) {
            }
        };
        _targets.add(target);
        _piccasso.load(url).error(_drawableBroken).into(target);
    }

    public void loadBitmap(String url, boolean roundedCorner, ImageView imageView) {
        if (roundedCorner) {
            _piccasso.load(url).transform(new RoundedTransformation(30, 0)).into(imageView);
        } else {
            displayImage(url, imageView);
        }
    }

    public interface ImageLoadingListener {
        void onLoadingComplete(String s, View view, Bitmap bitmap);
    }
//
//    private static class AudiotekaBitmapCache implements Cache {
//
//        private IResManager _resManager;
//
//        public AudiotekaBitmapCache(IResManager resManager) {
//            _resManager = resManager;
//        }
//
//        @Override
//        public Bitmap get(String s) {
//            try {
//                return _resManager.getImageResManager().getImage(s);
//            } catch (AudiotekaException ae) {
//                //nie wyrzucamy błędu
//            }
//            return null;
//        }
//
//        @Override
//        public void set(String s, Bitmap bitmap) {
//            try {
//                _resManager.getImageResManager().saveImage(bitmap, s);
//            } catch (AudiotekaException ae) {
//                BugsenseHelper.throwException(ae);
//            }
//        }
//
//        @Override
//        public int size() {
//            return 0;
//        }
//
//        @Override
//        public int maxSize() {
//            return 0;
//        }
//
//        @Override
//        public void clear() {
//            try {
//                _resManager.getImageResManager().clearImageCache();
//            } catch (AudiotekaException ae) {
//                BugsenseHelper.throwException(ae);
//            }
//        }
//
//        @Override
//        public void clearKeyUri(String keyPrefix) {
//            // Remove items whose key is prefixed with keyPrefix.
//        }
//    }

    private class RoundedTransformation implements com.squareup.picasso.Transformation {
        private final int radius;
        private final int margin;  // dp

        // radius is corner radii in dp
        // margin is the board in dp
        public RoundedTransformation(final int radius, final int margin) {
            this.radius = radius;
            this.margin = margin;
        }

        @Override
        public Bitmap transform(final Bitmap source) {
            final Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));

            Bitmap output = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);
            canvas.drawRoundRect(new RectF(margin, margin, source.getWidth() - margin, source.getHeight() - margin), radius, radius, paint);

            if (source != output) {
                source.recycle();
            }

            return output;
        }

        @Override
        public String key() {
            return "rounded";
        }
    }
}
