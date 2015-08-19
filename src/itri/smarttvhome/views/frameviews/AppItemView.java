package itri.smarttvhome.views.frameviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.Toast;

import tw.futureInsighters.Tv.R;


/**
 * Created by mimi on 14/12/25.
 */
public class AppItemView extends Button {
    private boolean isSelected;

    public AppItemView(Context context) {
        super(context);
        this.init();
    }

    public AppItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public AppItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init();
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    private void init() {
        this.setText("New Button");
        this.setBackgroundResource(R.drawable.item_normal);
        this.setPadding(10, 10, 10, 10);
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
        Toast.makeText(this.getContext(), "AppItemView_itemActionRun_value:" + this.getText(),
                Toast.LENGTH_LONG).show();
    }
}
