package cn.yzhg.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by $(剪刀手--yzhg) on 2018/8/11 0011.
 * 用一句话描述该类的用处:
 */
public class SetAnimation extends AppCompatActivity {

    @BindView(R.id.button_playSequentially)
    Button buttonPlaySequentially;
    @BindView(R.id.text_demo1)
    TextView textDemo1;
    @BindView(R.id.text_demo2)
    TextView textDemo2;
    @BindView(R.id.but_animation)
    Button butAnimation;

    public static void newInstance(Context context) {
        Intent intent = new Intent(context, SetAnimation.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_set_layout);
        ButterKnife.bind(this);
        buttonPlaySequentially.setOnClickListener(v -> setPlaySequentiallyAnimation());
        butAnimation.setOnClickListener(v -> setBuilderAnimation());
    }

    /**
     * Animation的Builder模式
     */
    private void setBuilderAnimation() {
        ObjectAnimator animator1 = ObjectAnimator.ofInt(textDemo1, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(textDemo1, "translationY", 0, 180f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(textDemo2, "translationY", 0, 180f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator2).with(animator1).before(animator3);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }

    /**
     * playSequentially
     */
    private void setPlaySequentiallyAnimation() {
        ObjectAnimator animator1 = ObjectAnimator.ofInt(textDemo1, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        animator1.setRepeatCount(ValueAnimator.INFINITE);
        animator1.setRepeatMode(ValueAnimator.REVERSE);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(textDemo1, "translationY", 0, 180f);
        animator2.setRepeatCount(ValueAnimator.INFINITE);
        animator2.setRepeatMode(ValueAnimator.REVERSE);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(textDemo2, "translationY", 0, 180f);
        animator3.setRepeatCount(ValueAnimator.INFINITE);
        animator3.setRepeatMode(ValueAnimator.REVERSE);

        AnimatorSet animatorSet = new AnimatorSet();
        //  animatorSet.playSequentially(animator1, animator2, animator3);
        animatorSet.playTogether(animator1, animator2, animator3);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }
}
