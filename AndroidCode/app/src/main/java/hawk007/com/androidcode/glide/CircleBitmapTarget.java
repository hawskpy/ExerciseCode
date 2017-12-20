package hawk007.com.androidcode.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.request.target.ImageViewTarget;

/**
 * Created by hawk on 2017/12/20.
 */

public class CircleBitmapTarget  extends ImageViewTarget<Bitmap> {
    public CircleBitmapTarget(ImageView view) {
        super(view);
    }

    /**
     *  从指定路径加载的Bitmap
     * @param resource
     */
    @Override
    protected void setResource(@Nullable Bitmap resource) {
        bindCircleBitmapToImageView(resource);
    }
    /**
     *
     * onLoadFailed()和onLoadStarted调用该方法，用于设置默认的图片和异常图片
     * 设置默认图片
     * @param drawable
     */
    @Override
    public void setDrawable(Drawable drawable) {
        if (drawable instanceof BitmapDrawable){
            Bitmap bitmap1= ((BitmapDrawable) drawable).getBitmap();
            bindCircleBitmapToImageView(bitmap1);
        }else{
            view.setImageDrawable(drawable);
        }
    }

    /**
     * 通过RoundedBitmapDrawable绘制圆形Bitmap,且加载ImageView.
     * @param bitmap
     */
    private void bindCircleBitmapToImageView(Bitmap bitmap){
        RoundedBitmapDrawable bitmapDrawable=  RoundedBitmapDrawableFactory.create(view.getContext().getResources(),bitmap);
        bitmapDrawable.setCircular(true);
        view.setImageDrawable(bitmapDrawable);
    }
}
