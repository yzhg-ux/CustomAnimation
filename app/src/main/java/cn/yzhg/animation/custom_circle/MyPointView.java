package cn.yzhg.animation.custom_circle;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

/**
 * Created by $(剪刀手--yzhg) on 2018/8/10 0010.
 * 用一句话描述该类的用处:
 */
public class MyPointView extends View {

    private Point mCurrPoint;

    public MyPointView(Context context) {
        super(context, null);
    }

    public MyPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MyPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mCurrPoint != null) {
            Paint paint = new Paint();
            /*设置锯齿*/
            paint.setAntiAlias(true);
            /*设置颜色*/
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            /**
             * 绘制圆
             * 四个参数依次为: 宽高  圆的半径  画笔
             */
            canvas.drawCircle(10, 10, mCurrPoint.getRadius(), paint);
        }
    }

    /**
     * 执行动画
     */
    public void doPointAnim() {
        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(), new Point(20), new Point(200));
        animator.addUpdateListener(animation -> {
            mCurrPoint = (Point) animation.getAnimatedValue();
            /**
             * 调用此方法之后,将会重新绘制View,走onDraw()
             */
            invalidate();
        });
        animator.setDuration(1000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }

}
