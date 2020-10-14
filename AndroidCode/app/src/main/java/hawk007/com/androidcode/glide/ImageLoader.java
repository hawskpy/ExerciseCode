package hawk007.com.androidcode.glide;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import hawk007.com.androidcode.CodeApplication;


/**
 * Created by hawk on 2017/12/19.
 */

public class ImageLoader {
    @IntDef({Transform.NORMAL, Transform.CIRCLE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Transform {
        int NORMAL = 0;
        int CIRCLE = 1;
    }

    public static void displayImage(Context context, ImageView imageView, String url) {
        displayImage(context, imageView, url, new Options());
    }

    public static void displayImage(Context context, ImageView imageView, String url, @NonNull Options options) {
        displayImage(Glide.with(context), imageView, url, options, Transform.NORMAL);
    }

    public static void displayImage(Activity context, ImageView imageView, String url) {
        displayImage(context, imageView, url, new Options());
    }

    public static void displayImage(Activity context, ImageView imageView, String url, @NonNull Options options) {
        displayImage(Glide.with(context), imageView, url, options, Transform.NORMAL);
    }

    public static void displayImage(android.app.Fragment context, ImageView imageView, String url) {
        displayImage(context, imageView, url, new Options());
    }

    public static void displayImage(android.app.Fragment context, ImageView imageView, String url, @NonNull Options options) {
        displayImage(Glide.with(context), imageView, url, options, Transform.NORMAL);
    }

    public static void displayImage(Fragment context, ImageView imageView, String url) {
        displayImage(context, imageView, url, new Options());
    }

    public static void displayImage(Fragment context, ImageView imageView, String url, @NonNull Options options) {
        displayImage(Glide.with(context), imageView, url, options, Transform.NORMAL);
    }

    public static void displayImage(FragmentActivity context, ImageView imageView, String url) {
        displayImage(context, imageView, url, new Options());
    }

    public static void displayImage(FragmentActivity context, ImageView imageView, String url, @NonNull Options options) {
        displayImage(Glide.with(context), imageView, url, options, Transform.NORMAL);
    }

    public static void displayCircleImage(Context context, ImageView imageView, String url) {
        displayCircleImage(context, imageView, url, new Options());
    }

    public static void displayCircleImage(Context context, ImageView imageView, String url, @NonNull Options options) {
        displayImage(Glide.with(context), imageView, url, options, Transform.CIRCLE);
    }

    public static void displayCircleImage(Activity context, ImageView imageView, String url) {
        displayCircleImage(context, imageView, url, new Options());
    }

    public static void displayCircleImage(Activity context, ImageView imageView, String url, @NonNull Options options) {
        displayImage(Glide.with(context), imageView, url, options, Transform.CIRCLE);
    }

    public static void displayCircleImage(android.app.Fragment context, ImageView imageView, String url) {
        displayCircleImage(context, imageView, url, new Options());
    }

    public static void displayCircleImage(android.app.Fragment context, ImageView imageView, String url, @NonNull Options options) {
        displayImage(Glide.with(context), imageView, url, options, Transform.CIRCLE);
    }

    public static void displayCircleImage(Fragment context, ImageView imageView, String url) {
        displayCircleImage(context, imageView, url, new Options());
    }

    public static void displayCircleImage(Fragment context, ImageView imageView, String url, @NonNull Options options) {
        displayImage(Glide.with(context), imageView, url, options, Transform.CIRCLE);
    }

    public static void displayCircleImage(FragmentActivity context, ImageView imageView, String url) {
        displayCircleImage(context, imageView, url, new Options());
    }

    public static void displayCircleImage(FragmentActivity context, ImageView imageView, String url, @NonNull Options options) {
        displayImage(Glide.with(context), imageView, url, options, Transform.CIRCLE);
    }

    private static void displayImage(RequestManager with, ImageView imageView, String url, @NonNull Options options, @Transform int transform) {
        RequestBuilder<Drawable> requestBuilder = with.load(url);

        RequestOptions tempOptions = new RequestOptions();

        RequestBuilder<Drawable> stringDrawableRequestBuilder = requestBuilder.thumbnail(options.getThumbnail());

        DiskCacheStrategy strategy;
        switch (options.getDiskCacheStrategy()){
            case Options.DiskCacheType.ALL:
                strategy = DiskCacheStrategy.ALL;
                break;
            case Options.DiskCacheType.NONE:
                strategy = DiskCacheStrategy.NONE;
                break;
            case Options.DiskCacheType.RESOURCE:
                strategy = DiskCacheStrategy.RESOURCE;
                break;
            case Options.DiskCacheType.DATA:
                strategy = DiskCacheStrategy.DATA;
                break;
            case Options.DiskCacheType.AUTOMATIC:
                strategy = DiskCacheStrategy.AUTOMATIC;
                break;
            default:
                strategy = DiskCacheStrategy.NONE;
                break;
        }
        tempOptions = tempOptions.diskCacheStrategy(strategy);

        if (options.animate()) {
            stringDrawableRequestBuilder = stringDrawableRequestBuilder.transition(DrawableTransitionOptions.withCrossFade());

        }
        if (options.isDontTransform()) {
            tempOptions = tempOptions.dontTransform();
        }
        if (Options.ScaleType.CENTER_CROP == options.getScaleType()) {
            tempOptions = tempOptions.centerCrop();

        }
        if (Options.ScaleType.FIT_CENTER == options.getScaleType()) {
            tempOptions = tempOptions.fitCenter();
        }

        if (Options.ScaleType.CIRCLE_CROP == options.getScaleType() ){
            tempOptions = tempOptions.circleCrop();
        }
        if (options.getPlaceholderResId() > 0) {
            tempOptions = tempOptions.placeholder(options.getPlaceholderResId());
        }
        if (options.getErrorResId() > 0) {
            tempOptions = tempOptions.error(options.getErrorResId());
        }
        if (options.getPlaceholder() != null) {
            tempOptions = tempOptions.placeholder(options.getPlaceholder());
        }
        if (options.getError() != null) {
            tempOptions = tempOptions.error(options.getError());
        }
        if (Transform.CIRCLE == transform) {
            tempOptions = tempOptions.transform(new GlideCircleTransform());
        }

        displayImage(stringDrawableRequestBuilder.apply(tempOptions) , imageView);
    }

    private static void displayImage(RequestBuilder<Drawable> stringDrawableRequestBuilder, ImageView imageView) {
            stringDrawableRequestBuilder.into(imageView);
    }

//     清除缓存
    public static void clearDiskCache(){
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.get(CodeApplication.getInstance()).clearDiskCache();
                    }
                }).start();
            } else {
                Glide.get(CodeApplication.getInstance()).clearDiskCache();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
