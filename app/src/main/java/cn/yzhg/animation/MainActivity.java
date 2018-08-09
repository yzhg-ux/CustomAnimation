package cn.yzhg.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.but_scale)
    Button butScale;
    @BindView(R.id.but_alpha)
    Button butAlpha;
    @BindView(R.id.but_rotate)
    Button butRotate;
    @BindView(R.id.but_translate)
    Button butTranslate;
    @BindView(R.id.but_set)
    Button butSet;
    @BindView(R.id.iv_scale_animation)
    ImageView ivScaleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        butScale.setOnClickListener(v -> setScaleAnimation());
        butAlpha.setOnClickListener(v -> setAlphaAnimation());
        butRotate.setOnClickListener(v -> setRotateAnimation());
        butTranslate.setOnClickListener(v -> setTranslateAnimation());
        butSet.setOnClickListener(v -> setSetAnimation());

    }

    /**
     * Android Set(集合) 动画
     */
    private void setSetAnimation() {
        Animation setAnimation = AnimationUtils.loadAnimation(this, R.anim.set_animation);
        ivScaleAnimation.startAnimation(setAnimation);
    }

    /**
     * Android translate(平移) 动画
     */
    private void setTranslateAnimation() {
        Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_animation);
        ivScaleAnimation.startAnimation(translateAnimation);
    }

    /**
     * Android rotate(旋转) 动画
     */
    private void setRotateAnimation() {
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation);
        ivScaleAnimation.startAnimation(rotateAnimation);
    }

    /**
     * Android Alpha(透明度)变化
     */
    private void setAlphaAnimation() {
        Animation alpnaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_animation);
        ivScaleAnimation.startAnimation(alpnaAnimation);
    }

    /**
     * Android Scale(缩放)动画
     */
    private void setScaleAnimation() {
        Animation scaleAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_animation);
        ivScaleAnimation.startAnimation(scaleAnimation);
    }
}
