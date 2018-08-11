package cn.yzhg.animation.custom_object_circle;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by $(剪刀手--yzhg) on 2018/8/11 0011.
 * 用一句话描述该类的用处:
 */
public class CustomNumChange extends AppCompatTextView {
    public CustomNumChange(Context context) {
        super(context, null);
    }

    public CustomNumChange(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public CustomNumChange(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setCharText(double moneyText) {
        setText(saveString(String.valueOf(moneyText)));
    }

    /**
     * 保留两位小数
     *
     * @param money
     * @return
     */
    public static String saveString(String money) {
        DecimalFormat df = new DecimalFormat("######0.00");
        return df.format(Double.valueOf(money));
    }

}
