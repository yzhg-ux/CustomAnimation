package cn.yzhg.animation;

import android.animation.TypeEvaluator;

/**
 * Created by $(剪刀手--yzhg) on 2018/8/10 0010.
 * 用一句话描述该类的用处:
 * <p>
 * 自定义Char类型转换器
 */
public class CharEvaluator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        /**
         * 拿到的开始char A转成int类型是ASCll表中的数值就是26
         */
        int startInt = (int) startValue;
        /**
         * 拿到结束的char Z转成int类型是ASCll表中的数值就是90
         */
        int endInt = (int) endValue;

        /**
         *  38 = 26 + (90-26) * 0.2
         */
        int curInt = (int) (startInt + fraction * (endInt - startInt));
        /**
         * 将int类型的数字按照ASCll转为char类型的字母,并返回
         */
        return (char) curInt;
    }
}
