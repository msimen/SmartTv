package itri.smarttvhome.views.frameviews;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import tw.futureInsighters.Tv.R;
import itri.smarttvhome.views.FloatViewBase;
//import itri.smarttvsdk.broadcastSenders.dropTips.DropTipOnBroadcastSender;
import itri.smarttvsdk.defines.IntentApp;

/**
 * Created by mimi on 15/4/9.
 */
public class DrowTipFloatView extends FloatViewBase {
    private IDrowTipFloatViewDelegateListener mDelegateListener;
    private boolean isShow;
    private ImageView imDropTip;
    private String dropTipId;
    private Bundle backActionBundle;
    private ObjectAnimator translationXShowAnimator;
    private ObjectAnimator translationXHideAnimator;
    private Activity host;
    private String backAction;
    private boolean isAnimalate;
    private boolean delayIntentApp;
    private int channel;
    private String userId;
    private int msoid;
    private String channelAddress;
    public DrowTipFloatView(Activity host) {
        super(host);
        this.host = host;
    }

    public void setDelegateListener(
            IDrowTipFloatViewDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    public boolean isShow() {
        return this.isShow;
    }

    protected void onInit() {
        View content = this.inflate(getContext(), R.layout.drowtipflowview, this);
        this.imDropTip = (ImageView) content.findViewById(R.id.imDropTip);
        this.translationXShowAnimator = ObjectAnimator.ofFloat(this.imDropTip,
                "translationX", 60);
        this.translationXShowAnimator.setDuration(2000);
        this.translationXShowAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                isAnimalate = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
//                Animation animation2 = AnimationUtils.loadAnimation(DrowTipFloatView.this.getContext(), R.anim.clockwise);
//                animation2.setAnimationListener(new Animation.AnimationListener() {
//                    @Override
//                    public void onAnimationStart(Animation animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animation animation) {
//                        isAnimalate = false;
//                        if (delayIntentApp == true) {
//                            intentApp();
//                        }
//                        delayIntentApp = false;
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animation animation) {
//
//                    }
//                });
//
//                imDropTip.startAnimation(animation2);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        this.translationXHideAnimator = ObjectAnimator.ofFloat(this.imDropTip,
                "translationX", -60);
        this.translationXHideAnimator.setDuration(2000);
        this.translationXHideAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                isAnimalate = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                removeView(DrowTipFloatView.this);
//                Animation animation2 = AnimationUtils.loadAnimation(DrowTipFloatView.this.getContext(), R.anim.clockwise);
//                animation2.setAnimationListener(new Animation.AnimationListener() {
//                    @Override
//                    public void onAnimationStart(Animation animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animation animation) {
//                        isAnimalate = false;
//                        if (delayIntentApp == true) {
//                            intentApp();
//                        }
//                        delayIntentApp = false;
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animation animation) {
//
//                    }
//                });
//
//                imDropTip.startAnimation(animation2);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    public void showWithAnimal(Bitmap bitmap, String backAction, String dropTipId, Bundle backActionBundle,int channel, String userId, int msoid,String channelAddress) {

        this.hide();
        this.backAction = backAction;
        this.dropTipId = dropTipId;
        this.backActionBundle = backActionBundle;
        this.channel=channel;
        this.userId=userId;
        this.msoid=msoid;
        this.channelAddress=channelAddress;
        WindowManager.LayoutParams wmParams = this.getWindowParams();
        wmParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        wmParams.format = PixelFormat.RGBA_8888;
        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        wmParams.gravity = Gravity.LEFT | Gravity.TOP;
        Resources r = getResources();
        float px60 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, r.getDisplayMetrics());
        float px285 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 285, r.getDisplayMetrics());
        float px500 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 500, r.getDisplayMetrics());

        wmParams.y = (int) px60;
        wmParams.width = (int) px285;
        wmParams.height = (int) px500;
        this.imDropTip.setImageBitmap(bitmap);
        this.addView(this, wmParams);
        this.isShow = true;

        this.translationXShowAnimator.start();
    }

    public void showNonAnimal(Bitmap bitmap, String backAction, String dropTipId, Bundle backActionBundle,int channel, String userId, int msoid,String channelAddress) {
        this.hide();
        this.backAction = backAction;
        this.dropTipId = dropTipId;
        this.backActionBundle = backActionBundle;
        this.channel=channel;
        this.userId=userId;
        this.msoid=msoid;
        this.channelAddress=channelAddress;
        WindowManager.LayoutParams wmParams = this.getWindowParams();
        wmParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        wmParams.format = PixelFormat.RGBA_8888;
        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        wmParams.gravity = Gravity.LEFT | Gravity.TOP;
        Resources r = getResources();
        float px60 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, r.getDisplayMetrics());
        float px285 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 285, r.getDisplayMetrics());
        float px500 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 500, r.getDisplayMetrics());

        wmParams.y = (int) px60;
        wmParams.width = (int) px285;
        wmParams.height = (int) px500;
        this.imDropTip.setImageBitmap(bitmap);
        this.addView(this, wmParams);
        this.imDropTip.setTranslationX(60);
        this.isShow = true;
    }

    public void hide() {
        if (this.isShow == true) {
            this.removeView(this);
        }
        this.isShow = false;
    }

    public void hideAnimal() {
        if (this.isShow == true) {
            this.translationXHideAnimator.start();
        }
        isShow = false;
    }

    public void exec() {
        if (this.isShow) {
//            if (this.isAnimalate == false) {
                this.intentApp();
//            } else {
//                this.delayIntentApp = true;
//            }

        }
    }

    private void intentApp() {
        Intent i = new Intent();
        i.setAction(backAction);
//        i.putExtra(DropTipOnBroadcastSender.DROPTIPID_KEY, this.dropTipId);
//        i.putExtra(DropTipOnBroadcastSender.BUNDLE_KEY, this.backActionBundle);
        i.putExtra(IntentApp.CHANNEL_KEY, channel);
        i.putExtra(IntentApp.USERID_KEY, userId);
        i.putExtra(IntentApp.CHANNELADDRESS_KEY,channelAddress);
        Bundle bud = new Bundle();
//        bud.putSerializable(IntentApp.MSOID_KEY, msoid);
        i.putExtras(bud);
        this.getContext().startActivity(i);

        HideTimerTask myTask = new HideTimerTask();
        Timer myTimer = new Timer();
        myTimer.schedule(myTask, 500);
    }

    private class HideTimerTask extends TimerTask {
        public void run() {
            host.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    hide();
                }
            });
        }
    }
}
