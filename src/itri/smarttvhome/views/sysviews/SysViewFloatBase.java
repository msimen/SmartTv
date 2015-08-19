package itri.smarttvhome.views.sysviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Toast;

import itri.smarttvhome.views.FloatViewBase;

/**
 * Created by mimi on 14/12/26.
 */
public abstract class SysViewFloatBase extends FloatViewBase {
    protected ISysFloatViewDelegateListener mDelegateListener;

    public SysViewFloatBase(Context context) {
        super(context);
    }

    public SysViewFloatBase(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SysViewFloatBase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDelegateListener(
            ISysFloatViewDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    public void upClick() {
        boolean isHandle = false;
        if (this.mDelegateListener != null) {
            isHandle = this.mDelegateListener.upClickEvent(this, null);
        }
        if (isHandle == false)
            this.onUpClick();
    }

    public void downClick() {
        boolean isHandle = false;
        if (this.mDelegateListener != null) {
            isHandle = this.mDelegateListener.downClickEvent(this, null);
        }
        if (isHandle == false)
            this.onDownClick();
    }

    public void okClick() {
        boolean isHandle = false;
        if (this.mDelegateListener != null) {
            isHandle = this.mDelegateListener.okClickEvent(this, null);
        }
        if (isHandle == false)
            this.onOkClick();
    }

    public void leftClick() {
        boolean isHandle = false;
        if (this.mDelegateListener != null) {
            isHandle = this.mDelegateListener.leftClickEvent(this, null);
        }
        if (isHandle == false)
            this.onLeftClick();
    }

    public void rightClick() {
        boolean isHandle = false;
        if (this.mDelegateListener != null) {
            isHandle = this.mDelegateListener.rightClickEvent(this, null);
        }
        if (isHandle == false)
            this.onRightClick();
    }

    public void backClick() {
        boolean isHandle = false;
        if (this.mDelegateListener != null) {
            isHandle = this.mDelegateListener.backClickEvent(this, null);
        }
        if (isHandle == false)
            this.onBackClick();
    }

    public void homeClick() {
        boolean isHandle = false;
        if (this.mDelegateListener != null) {
            isHandle = this.mDelegateListener.homeClickEvent(this, null);
        }
        if (isHandle == false)
            this.onHomeClick();
    }

    protected void onUpClick() {
        Toast.makeText(this.getContext(), "SysViewBase_onUpClick",
                Toast.LENGTH_LONG).show();
    }

    protected void onDownClick() {
        Toast.makeText(this.getContext(), "SysViewBase_onDownClick",
                Toast.LENGTH_LONG).show();
    }

    protected void onOkClick() {
        Toast.makeText(this.getContext(), "SysViewBase_onOkClick",
                Toast.LENGTH_LONG).show();
    }

    protected void onLeftClick() {
        Toast.makeText(this.getContext(), "SysViewBase_onLeftClick",
                Toast.LENGTH_LONG).show();
    }

    protected void onRightClick() {
        Toast.makeText(this.getContext(), "SysViewBase_onRightClick",
                Toast.LENGTH_LONG).show();
    }

    protected void onBackClick() {
        Toast.makeText(this.getContext(), "SysViewBase_onBackClick",
                Toast.LENGTH_LONG).show();
    }

    protected void onHomeClick() {
        Toast.makeText(this.getContext(), "SysViewBase_onHomeClick",
                Toast.LENGTH_LONG).show();
    }
}
