package cn.yzhg.animation;

import android.animation.TypeEvaluator;

import java.lang.reflect.TypeVariable;

/**
 * Created by $(剪刀手--yzhg) on 2018/8/10 0010.
 * 用一句话描述该类的用处:
 * <p>
 * 自定义Evaluator
 */
public class MyEvaluator implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
      //  return (int) (200 + startValue + fraction * (endValue - startValue));
        /*只通过Evaluator来改变动画的位置*/
        return (int) (endValue - fraction * (endValue - startValue));
    }
}
