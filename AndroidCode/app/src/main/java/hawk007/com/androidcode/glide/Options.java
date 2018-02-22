package hawk007.com.androidcode.glide;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by hawk on 2017/12/19.
 */

public class Options {
    private static final boolean DEFAULT_ANIMATE_ENABLE = true;
    private static final @ScaleType int DEFAULT_SCALE_TYPE = ScaleType.CENTER_CROP;
    private static final @DiskCacheType int DEFAULT_DISKCACHE_TYPE = DiskCacheType.NONE;

    private @DrawableRes
    int mErrorResId;
    private @DrawableRes
    int mPlaceholderResId;

    private Drawable mErrorDrawable;
    private Drawable mPlaceholderDrawable;

    private @ScaleType int mScaleType;
    private @DiskCacheType int mDiskCacheType;  //缓存方式
    private boolean mAnimateEnable;
    private boolean mDontTransform;
    private float mSizeMultiplier = 1f;

    @IntDef({ScaleType.CENTER_CROP, ScaleType.FIT_CENTER, ScaleType.CIRCLE_CROP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScaleType {
        int CENTER_CROP = 0;
        int FIT_CENTER  = 1;
        int CIRCLE_CROP = 2;
    }

    @IntDef({DiskCacheType.ALL, DiskCacheType.NONE, DiskCacheType.RESOURCE, DiskCacheType.DATA, DiskCacheType.AUTOMATIC})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DiskCacheType {
        int ALL = 0;
        int NONE  = 1;
        int RESOURCE  = 2;
        int DATA  = 3;
        int AUTOMATIC = 4;
    }

    public Options() {
        mDiskCacheType = DEFAULT_DISKCACHE_TYPE;
        mScaleType = DEFAULT_SCALE_TYPE;
        mAnimateEnable = DEFAULT_ANIMATE_ENABLE;
    }

    public Options placeholder(@DrawableRes int res) {
        mPlaceholderResId = res;
        return this;
    }

    public Options placeholder(Drawable drawable) {
        mPlaceholderDrawable = drawable;
        return this;
    }

    public Options error(@DrawableRes int res) {
        mErrorResId = res;
        return this;
    }

    public Options error(Drawable drawable) {
        mErrorDrawable = drawable;
        return this;
    }

    public Options scaleType(@ScaleType int scaleType) {
        mScaleType = scaleType;
        return this;
    }

    public Options thumbnail(float sizeMultiplier){
        mSizeMultiplier = sizeMultiplier;
        return this;
    }

    public Options crossFade() {
        mAnimateEnable = true;
        return this;
    }

    public Options dontAnimate() {
        mAnimateEnable = false;
        return this;
    }

    public Options dontTransform() {
        mDontTransform = true;
        return this;
    }

    public Options diskCacheStrategy(@DiskCacheType int diskCacheType) {
        mDiskCacheType = diskCacheType;
        return this;
    }

    public @DrawableRes int getPlaceholderResId() {
        return mPlaceholderResId;
    }

    public Drawable getPlaceholder() {
        return mPlaceholderDrawable;
    }

    public @DrawableRes int getErrorResId() {
        return mErrorResId;
    }

    public Drawable getError() {
        return mErrorDrawable;
    }

    public boolean animate() {
        return mAnimateEnable;
    }

    public boolean isDontTransform() {
        return mDontTransform;
    }

    public @ScaleType int getScaleType() {
        return mScaleType;
    }

    public @DiskCacheType int getDiskCacheStrategy() {
        return mDiskCacheType;
    }
    public float getThumbnail(){
        return mSizeMultiplier;
    }
}
