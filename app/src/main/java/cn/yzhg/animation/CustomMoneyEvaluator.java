package cn.yzhg.animation;

import android.animation.TypeEvaluator;
import android.util.Log;

/**
 * Created by $(剪刀手--yzhg) on 2018/8/10 0010.
 * 用一句话描述该类的用处:
 * <p>
 * 自定义数字变化
 */
public class CustomMoneyEvaluator implements TypeEvaluator<Number> {

    @Override
    public Number evaluate(float fraction, Number startValue, Number endValue) {
        Log.i("-------", "evaluate: " + fraction);
        float startMoney = startValue.floatValue();
        float endMoney = endValue.floatValue();
        float resultMoney = (endMoney - startMoney) * fraction;
        return resultMoney;
    }
}
