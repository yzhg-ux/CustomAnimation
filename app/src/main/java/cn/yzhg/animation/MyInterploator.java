package cn.yzhg.animation;

import android.animation.TimeInterpolator;

/**
 * Created by $(剪刀手--yzhg) on 2018/8/10 0010.
 * 用一句话描述该类的用处:
 *
 *      自定义插值器
 *
 */
public class MyInterploator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        //input  表示当前动画的进度值
        return 1 - input;
    }
}
