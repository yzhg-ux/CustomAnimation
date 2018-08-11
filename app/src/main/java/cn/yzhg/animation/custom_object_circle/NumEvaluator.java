package cn.yzhg.animation.custom_object_circle;

import android.animation.TypeEvaluator;

/**
 * Created by $(剪刀手--yzhg) on 2018/8/11 0011.
 * 用一句话描述该类的用处:
 */
public class NumEvaluator implements TypeEvaluator<Number> {
    @Override
    public Number evaluate(float fraction, Number startValue, Number endValue) {
        double startNum = startValue.doubleValue();
        double endNum = endValue.doubleValue();
        return startNum + (endNum - startNum) * fraction;
    }
}
