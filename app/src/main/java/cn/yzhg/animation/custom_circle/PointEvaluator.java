package cn.yzhg.animation.custom_circle;

import android.animation.TypeEvaluator;

/**
 * Created by $(剪刀手--yzhg) on 2018/8/10 0010.
 * 用一句话描述该类的用处:
 */
public class PointEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        /**
         * 圆的开始半径
         */
        int start = startValue.getRadius();
        /**
         * 圆的结束半径
         */
        int end = endValue.getRadius();
        int curValue = (int) (start + (end - start) * fraction);
        return new Point(curValue);
    }
}
