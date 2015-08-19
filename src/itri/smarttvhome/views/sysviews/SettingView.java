package itri.smarttvhome.views.sysviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import tw.futureInsighters.Tv.R;

/**
 * Created by mimi on 14/12/27.
 */
public class SettingView extends SysViewBase {
    public SettingView(Context context) {
        super(context);
        this.init();
    }

    public SettingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public SettingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {
        View content = this.inflate(getContext(), R.layout.settingview, this);
    }

    @Override
    protected void onOkClick() {
        this.saveSetting();
    }

    @Override
    protected void onBackClick() {

    }

    @Override
    protected void onHomeClick() {
        this.saveSetting();
    }

    private void saveSetting() {
        Toast.makeText(this.getContext(), "SettingView_Save",
                Toast.LENGTH_LONG).show();
    }
}
