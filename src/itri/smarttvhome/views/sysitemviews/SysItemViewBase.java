package itri.smarttvhome.views.sysitemviews;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;

import tw.futureInsighters.Tv.R;

/**
 * Created by mimi on 14/12/25.
 */
public abstract class SysItemViewBase extends Button {
    private boolean isSelected;

    public SysItemViewBase(Context context) {
        super(context);
        this.init();
    }

    public SysItemViewBase(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public SysItemViewBase(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init();
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    protected void init() {
        this.setText("New Button");
        this.setBackgroundResource(R.drawable.item_normal);
        this.setPadding(10, 10, 10, 10);
        this.setTextColor(Color.YELLOW);
    }

    public void itemSelected() {
        this.isSelected = true;
        this.setBackgroundResource(R.drawable.item_selected);
    }

    public void itemUnSelected() {
        this.isSelected = false;
        this.setBackgroundResource(R.drawable.item_normal);
    }

    public void setValue(String value) {
        this.setText(value);
    }

    public void actionExec() {
    }
}
