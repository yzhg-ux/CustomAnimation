package cn.yzhg.animation;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.yzhg.animation.custom_object_circle.CustomNumChange;
import cn.yzhg.animation.custom_object_circle.MyPointView;
import cn.yzhg.animation.custom_object_circle.NumEvaluator;

/**
 * Created by $(剪刀手--yzhg) on 2018/8/11 0011.
 * 用一句话描述该类的用处:
 */
public class CustomAnimation extends AppCompatActivity {

    @BindView(R.id.but_object)
    Button butObject;
    @BindView(R.id.but_scale)
    Button butScale;
    @BindView(R.id.but_translate)
    Button butTranslate;
    @BindView(R.id.but_rotationX)
    Button butRotationX;
    @BindView(R.id.iv_custom_layout)
    ImageView ivCustomLayout;
    @BindView(R.id.my_point_view)
    MyPointView myPointView;
    @BindView(R.id.but_custom_circle)
    Button butCustomCircle;
    @BindView(R.id.but_PropertyValuesHolder)
    Button butPropertyValuesHolder;
    @BindView(R.id.but_cs)
    Button butCs;
    @BindView(R.id.tv_custom_text)
    CustomNumChange tvCustomText;
    @BindView(R.id.but_phone)
    Button butPhone;
    @BindView(R.id.tv_phone)
    ImageView tvPhone;
    @BindView(R.id.phone_vibration)
    Button phoneVibration;

    public static void newInstance(Context context) {
        Intent intent = new Intent(context, CustomAnimation.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custon_layout);
        ButterKnife.bind(this);
        butObject.setOnClickListener(v -> setObjectAnimation());
        butScale.setOnClickListener(v -> setScaleAnimation());
        butTranslate.setOnClickListener(v -> setTranslateAnimation());
        butRotationX.setOnClickListener(v -> setRotationXAnimation());
        butCustomCircle.setOnClickListener(v -> setCustomCircleAnimation());
        butPropertyValuesHolder.setOnClickListener(v -> setPropertyValuesHolderAnimation());
        butCs.setOnClickListener(v -> setCsAnimation());
        butPhone.setOnClickListener(v -> setPhoneAnimation());
        phoneVibration.setOnClickListener(v -> setPhoneVibrationAnimation());
    }

    /**
     * Android keyFrame 实现来电显示图
     */
    private void setPhoneVibrationAnimation() {
        Keyframe form0 = Keyframe.ofFloat(0f, 0);
        Keyframe form1 = Keyframe.ofFloat(0.1f, 60f);
        Keyframe form2 = Keyframe.ofFloat(0.2f, -60f);
        Keyframe form3 = Keyframe.ofFloat(0.3f, 60f);
        Keyframe form4 = Keyframe.ofFloat(0.4f, -60f);
        Keyframe form5 = Keyframe.ofFloat(0.5f, 60f);
        Keyframe form6 = Keyframe.ofFloat(0.6f, -60f);
        Keyframe form7 = Keyframe.ofFloat(0.7f, 60f);
        Keyframe form8 = Keyframe.ofFloat(0.8f, -60f);
        Keyframe form9 = Keyframe.ofFloat(0.9f, 60f);
        Keyframe form10 = Keyframe.ofFloat(1f, 0);
        PropertyValuesHolder rotationHolder = PropertyValuesHolder.ofKeyframe("rotation", form0, form1, form2, form3, form4, form5, form6, form7, form8, form9, form10);

        Keyframe formScale0 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formScale1 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formScale2 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formScale3 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formScale4 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formScale5 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formScale6 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formScale7 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formScale8 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formScale9 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formScale10 = Keyframe.ofFloat(0f, 1.2f);
        PropertyValuesHolder scaleHolder = PropertyValuesHolder.ofKeyframe("ScaleX", formScale0, formScale1, formScale2, formScale3, formScale4, formScale5, formScale6, formScale7, formScale8, formScale9, formScale10);

        Keyframe formYScale0 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formYScale1 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formYScale2 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formYScale3 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formYScale4 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formYScale5 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formYScale6 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formYScale7 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formYScale8 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formYScale9 = Keyframe.ofFloat(0f, 1.2f);
        Keyframe formYScale10 = Keyframe.ofFloat(0f, 1.2f);
        PropertyValuesHolder scaleYHolder = PropertyValuesHolder.ofKeyframe("ScaleY", formYScale0, formYScale1, formYScale2, formYScale3, formYScale4, formYScale5, formYScale6, formYScale7, formYScale8, formYScale9, formYScale10);

        ValueAnimator animator = ObjectAnimator.ofPropertyValuesHolder(tvPhone, rotationHolder, scaleHolder, scaleYHolder);
        animator.setDuration(1000);
        animator.setRepeatCount(5);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();
    }

    /**
     * 设置手机振动 的图片
     */
    private void setPhoneAnimation() {
        Keyframe form0 = Keyframe.ofFloat(0f, 0);
        Keyframe form1 = Keyframe.ofFloat(0.1f, 60f);
        Keyframe form2 = Keyframe.ofFloat(0.2f, -60f);
        Keyframe form3 = Keyframe.ofFloat(0.3f, 60f);
        form3.setValue(0f);
        form3.setInterpolator(new BounceInterpolator());
        Keyframe form4 = Keyframe.ofFloat(0.4f, -60f);
        Keyframe form5 = Keyframe.ofFloat(0.5f, 60f);
        Keyframe form6 = Keyframe.ofFloat(0.6f, -60f);
        form3.setValue(0f);
        form6.setInterpolator(new AccelerateDecelerateInterpolator());
        Keyframe form7 = Keyframe.ofFloat(0.7f, 60f);
        Keyframe form8 = Keyframe.ofFloat(0.8f, -60f);
        Keyframe form9 = Keyframe.ofFloat(0.9f, 60f);
        form3.setValue(0f);
        form6.setInterpolator(new AnticipateInterpolator());
        Keyframe form10 = Keyframe.ofFloat(1f, 0);
        PropertyValuesHolder fromeHolder = PropertyValuesHolder.ofKeyframe("rotation", form0, form1, form2, form3, form4, form5, form6, form7, form8, form9, form10);
        ValueAnimator animator = ObjectAnimator.ofPropertyValuesHolder(tvPhone, fromeHolder);
        animator.setDuration(1000);
        animator.start();
    }

    /**
     * Android 自定义控件使用,变动的TextView
     */
    private void setCsAnimation() {
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofObject("CharText", new NumEvaluator(), 0, 185253.26);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(tvCustomText, propertyValuesHolder);
        animator.setDuration(1000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }

    /**
     * Android 实现自定义控件 左右摇摆的控件
     */
    private void setPropertyValuesHolderAnimation() {
        PropertyValuesHolder rotationHolder = PropertyValuesHolder.ofFloat("Rotation", 60f, -60f, 40f, -40f, 20f, -20f, 10f, -10f);
        PropertyValuesHolder colorHolder = PropertyValuesHolder.ofInt("BackgroundColor", 0xffffffff, 0xffff00ff, 0xffffff00, 0xffffffff);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(ivCustomLayout, rotationHolder, colorHolder);
        animator.setDuration(2000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();
    }

    /**
     * Android 实现自定义控件实现
     */
    private void setCustomCircleAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofInt(myPointView, "pointRadius", 0, 300, 100);
        animator.setDuration(2000);
        animator.start();
    }

    /**
     * Android  ObjectAnimation 旋转动画
     */
    private void setRotationXAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(ivCustomLayout, "scaleY", 0, 3, 1, 2, 0);
        animator.setDuration(2000);
        animator.start();
    }

    /**
     * Android ObjectAnimation 平移动画
     */
    private void setTranslateAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(ivCustomLayout, "rotation", 0, 180, 0, 180, 0);
        animator.setDuration(2000);
        animator.start();
    }

    /**
     * Android  ObjectAnimation 缩放 动画
     */
    private void setScaleAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(ivCustomLayout, "scaleX", 1.0f, 1.5f);
        animator.setDuration(2000);
        animator.start();
    }

    /**
     * ObjectAnimation  为 ValueAnimation的派生类
     * Android  ObjectAnimation 动画
     */
    private void setObjectAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(ivCustomLayout, "alpha", 0.0f, 1.0f);
        animator.setDuration(2000);
        animator.start();
    }
}
