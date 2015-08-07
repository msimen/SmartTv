package itri.smarttvsdk.bizs;

import android.content.Context;
import android.util.Log;

/**
 * Created by mimi on 15/1/27.
 */
public class MitraStarTVObject {
    private final String HDMI_FULL_SCALE = "com.mitrastar.intent.fullscale.action";
    private final String HDMI_SET_SCALE = "com.mitrastar.intent.setscale.action";
    private final String HDMI_CLOSE_SCALE = "com.mitrastar.intent.closescale.action";
    private Context mContext;

    private int screen_width;
    private int screen_height;

    private int delayTime;

    public MitraStarTVObject(Context ctx, int screen_width, int screen_height, int delayTime) {
        this.mContext = ctx;
        this.screen_width = screen_width;
        this.screen_height = screen_height;
        this.delayTime = delayTime;
    }

    public void toFullMode() {
        this.toHideMode();

//        Handler handler = new Handler();
//        Runnable r = new Runnable() {
//            public void run() {
//                Intent i = new Intent(HDMI_SET_SCALE);
//                Bundle bundle = new Bundle();
//                bundle.putInt("Locate_x", 0);
//                bundle.putInt("Locate_y", 0);
//                bundle.putInt("Window_w", screen_width);
//                bundle.putInt("Window_h", screen_height);
//                i.putExtras(bundle);
//                mContext.sendBroadcast(i);
//            }
//        };
//        handler.postDelayed(r, this.delayTime);
    }

    public void toPreviewMode() {
        this.toHideMode();
        Log.e("MitraStarTVObject", "toPreviewMode");
//        Handler handler = new Handler();
//        Runnable r = new Runnable() {
//            public void run() {
//                Intent i = new Intent(HDMI_SET_SCALE);
//                Bundle bundle = new Bundle();
//                bundle.putInt("Locate_x", screen_width  - screen_width / 4-screen_width / 24);
//                bundle.putInt("Locate_y", screen_height - screen_height / 4-screen_height / 24);
//                bundle.putInt("Window_w", screen_width / 4);
//                bundle.putInt("Window_h", screen_height / 4);
//                i.putExtras(bundle);
//                mContext.sendBroadcast(i);
//            }
//        };
//        handler.postDelayed(r, this.delayTime);
    }

    public void toRightMode() {

        this.toHideMode();
        Log.e("MitraStarTVObject", "toRightMode");
//        Handler handler = new Handler();
//        Runnable r = new Runnable() {
//            public void run() {
//                Intent i = new Intent(HDMI_SET_SCALE);
//                Bundle bundle = new Bundle();
//                bundle.putInt("Locate_x", 0);
//                bundle.putInt("Locate_y", (screen_height - (int) (screen_height * .7)) / 2);
//                bundle.putInt("Window_w", (int) (screen_width * .7));
//                bundle.putInt("Window_h", (int) (screen_height * .7));
//                i.putExtras(bundle);
//                mContext.sendBroadcast(i);


//        Intent i = new Intent(HDMI_SET_SCALE);
//        Bundle bundle = new Bundle();
//        bundle.putInt("Locate_x", 0);
//        bundle.putInt("Locate_y", (screen_height - (int) (screen_height * .8)) / 2);
//        bundle.putInt("Window_w", (int) (screen_width * .8));
//        bundle.putInt("Window_h", (int) (screen_height * .8));
//        i.putExtras(bundle);
//        mContext.sendBroadcast(i);
//            }
//        };
//        handler.postDelayed(r, this.delayTime);
    }

    public void toBottomMode() {
        this.toHideMode();
        Log.e("MitraStarTVObject", "toBottomMode");
//        Handler handler = new Handler();
//        Runnable r = new Runnable() {
//            public void run() {

        //0.9
//                Intent i = new Intent(HDMI_SET_SCALE);
//                Bundle bundle = new Bundle();
//                bundle.putInt("Locate_x", (screen_width - (int) (screen_width * .9) )/ 2);
//                bundle.putInt("Locate_y", 0);
//                bundle.putInt("Window_w", (int) (screen_width * .9));
//                bundle.putInt("Window_h", (int) (screen_height * .9));
//                i.putExtras(bundle);
//                mContext.sendBroadcast(i);
//            }
//        };
//        handler.postDelayed(r, this.delayTime);
    }

    public void toHideMode() {
        Log.e("MitraStarTVObject", "toHideMode");
//        Intent i = new Intent(HDMI_CLOSE_SCALE);
//        mContext.sendBroadcast(i);
    }
}
