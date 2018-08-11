package cn.yzhg.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.yzhg.animation.custom_circle.MyPointView;

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
    @BindView(R.id.but_set_java)
    Button butSetJava;
    @BindView(R.id.but_scale_java)
    Button butScaleJava;
    @BindView(R.id.but_alpha_java)
    Button butAlphaJava;
    @BindView(R.id.but_rotate_java)
    Button butRotateJava;
    @BindView(R.id.but_translate_java)
    Button butTranslateJava;
    @BindView(R.id.but_OfInt)
    Button butOfInt;
    @BindView(R.id.but_ofFloat)
    Button butOfFloat;
    @BindView(R.id.but_interpolator)
    Button butInterpolator;
    @BindView(R.id.but_interpolator_color)
    Button butInterpolatorColor;
    @BindView(R.id.but_ofObject)
    Button butOfObject;
    @BindView(R.id.tv_setText)
    TextView tvSetText;
    @BindView(R.id.but_money)
    Button butMoney;
    @BindView(R.id.my_point_view)
    MyPointView myPointView;
    @BindView(R.id.but_circle)
    Button butCircle;
    @BindView(R.id.but_jump_custom)
    Button butJumpCustom;
    @BindView(R.id.but_set_animation)
    Button butSetAnimation;

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
        butScaleJava.setOnClickListener(v -> setScaleJavaAnimation());
        butAlphaJava.setOnClickListener(v -> setAlphaJavaAnimation());
        butRotateJava.setOnClickListener(v -> setRotateJavaAnimation());
        butTranslateJava.setOnClickListener(v -> setTransLateJavaAnimation());
        butSetJava.setOnClickListener(v -> setSetJavaAnimation());
        butOfInt.setOnClickListener(v -> setOfIntAnimation());
        butOfFloat.setOnClickListener(v -> setOfFloatAnimation());
        butInterpolator.setOnClickListener(v -> setInterpolatorAnimation());
        butInterpolatorColor.setOnClickListener(v -> setInterpolatorColorAnimation());
        butOfObject.setOnClickListener(v -> setOfObjectAnimator());
        butMoney.setOnClickListener(v -> setMoneyChangeAnimation());
        butCircle.setOnClickListener(v -> myPointView.doPointAnim());
        butJumpCustom.setOnClickListener(v -> CustomAnimation.newInstance(this));
        butSetAnimation.setOnClickListener(v -> SetAnimation.newInstance(MainActivity.this));
    }

    /**
     * Android 值动画, 实现数字的变化
     */
    private void setMoneyChangeAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new CustomMoneyEvaluator(), 0, 8000.60f);
        valueAnimator.addUpdateListener(animation -> {
            float text = (float) animation.getAnimatedValue();
            String valueOf = String.valueOf(text);
            tvSetText.setText(saveString(valueOf));
        });
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.start();
    }

    /**
     * Android 值动画,自定义Evaluator实现TextView 变化
     */
    private void setOfObjectAnimator() {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new CharEvaluator(), 'A', 'Z');
        valueAnimator.addUpdateListener(animation -> {
            char text = (char) animation.getAnimatedValue();
            tvSetText.setText(String.valueOf(text));
        });
        valueAnimator.setDuration(10000);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.start();
    }

    /**
     * Android 值动画 颜色值渐变
     */
    private void setInterpolatorColorAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0xFFFFF00, 0xFF0000FF);
        valueAnimator.setDuration(3000);
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.addUpdateListener(animation -> {
            int colorAnimation = (int) animation.getAnimatedValue();
            ivScaleAnimation.setBackgroundColor(colorAnimation);
        });
        valueAnimator.start();
    }

    /**
     * Android 值动画 插值器
     */
    private void setInterpolatorAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 600);
        valueAnimator.setDuration(1000);
        valueAnimator.setEvaluator(new MyEvaluator());
        /*添加弹跳的插值器*/
        // valueAnimator.setInterpolator(new MyInterploator());
        valueAnimator.addUpdateListener(animation -> {
            int animatedValue = (int) animation.getAnimatedValue();
            ivScaleAnimation.layout(ivScaleAnimation.getLeft(), animatedValue, ivScaleAnimation.getRight(), animatedValue + ivScaleAnimation.getHeight());
        });
        valueAnimator.start();
    }

    /**
     * Android ofFloat 值动画
     */
    private void setOfFloatAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.0f, 400f, 50f, 600f);
        valueAnimator.setDuration(1000);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setRepeatCount(5);
        valueAnimator.addUpdateListener(animation -> {
            Float curValueFloat = (Float) animation.getAnimatedValue();
            int curValue = curValueFloat.intValue();
            ivScaleAnimation.layout(curValue, curValue, curValue + ivScaleAnimation.getWidth(), curValue + ivScaleAnimation.getHeight());
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.i("------动画", "onAnimationEnd: 动画结束");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.i("------动画", "onAnimationEnd: 动画重复执行");
            }

            @Override
            public void onAnimationStart(Animator animation) {
                Log.i("------动画", "onAnimationEnd: 动画开始");
            }
        });
        valueAnimator.start();
    }

    /**
     * Android ofInt值动画
     */
    private void setOfIntAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 400);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(animation -> {
            int curValue = (int) animation.getAnimatedValue();
            Log.d("qijian", "curValue:" + curValue);
            ivScaleAnimation.layout(curValue, curValue, curValue + ivScaleAnimation.getWidth(), curValue + ivScaleAnimation.getHeight());
        });
        valueAnimator.start();
    }

    /**
     * Android java代码生成 Set(动画集合) 动画
     */
    private void setSetJavaAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.setInterpolator(new BounceInterpolator());

        animationSet.setDuration(1000);
        animationSet.setFillAfter(true);
        ivScaleAnimation.startAnimation(animationSet);
    }

    /**
     * Android java代码生成  translate(平移) 动画
     */
    private void setTransLateJavaAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, -80, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, -80);
        translateAnimation.setDuration(1000);
        translateAnimation.setFillBefore(true);
        ivScaleAnimation.startAnimation(translateAnimation);
    }

    /**
     * Android java代码生成 Rotate(旋转) 动画
     */
    private void setRotateJavaAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setFillAfter(true);
        ivScaleAnimation.startAnimation(rotateAnimation);
    }

    /**
     * Android java代码生成 Scale(透明度)  动画
     */
    private void setAlphaJavaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.1f);
        alphaAnimation.setDuration(1000);
        ivScaleAnimation.startAnimation(alphaAnimation);
    }

    /**
     * Android java代码生成 Scale(缩放)  动画
     */
    private void setScaleJavaAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        ivScaleAnimation.startAnimation(scaleAnimation);
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

    /**
     * 保留两位小数
     *
     * @param money
     * @return
     */
    public static String saveString(String money) {
        DecimalFormat df = new DecimalFormat("######0.00");
        return df.format(Double.valueOf(money));
    }
}
