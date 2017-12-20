package hawk007.com.androidcode.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import hawk007.com.androidcode.R;
import hawk007.com.androidcode.glide.ImageLoader;
import hawk007.com.androidcode.glide.Options;

public class GlideLoadImageActivity extends Activity {

    @Bind(R.id.normal_img)
    ImageView normalImg;
    @Bind(R.id.circle_img)
    ImageView circleImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_load_image);
        ButterKnife.bind(this);

        initView();
    }

    private void initView(){
        Options options = new Options().error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).crossFade().dontAnimate().thumbnail(0.5f).scaleType(Options.ScaleType.CENTER_CROP);
        ImageLoader.displayImage(this,normalImg,"http://img3.duitang.com/uploads/item/201605/27/20160527205144_8Kh3w.jpeg",options);
        ImageLoader.displayCircleImage(this,circleImg,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513752895969&di=f4c069b3d19179cfb99a4597eac18fd3&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201606%2F18%2F20160618213955_4FzUX.jpeg",options);
    }

}
