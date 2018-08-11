package cn.yzhg.animation.custom_object_circle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import cn.yzhg.animation.custom_circle.Point;

/**
 * Created by $(剪刀手--yzhg) on 2018/8/11 0011.
 * 用一句话描述该类的用处:
 */
public class MyPointView extends View {

    private Point mPoint = new Point(100);

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
        if (mPoint != null) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(10, 10, mPoint.getRadius(), paint);
        }
        super.onDraw(canvas);
    }

    void setPointRadius(int radius) {
        mPoint.setRadius(radius);
        invalidate();
    }
}
