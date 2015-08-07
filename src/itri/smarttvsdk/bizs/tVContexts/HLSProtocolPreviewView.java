package itri.smarttvsdk.bizs.tVContexts;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.VideoView;

/**
 * Created by mimi on 15/3/23.
 */
public class HLSProtocolPreviewView extends VideoView implements IPreviewView {
//    private MediaPlayer mediaPlayer;
//    private String httpLiveUrl;
    protected RelativeLayout layout;
    public HLSProtocolPreviewView(Context context,RelativeLayout layout) {
        super(context);
        this.layout=layout;
        this.onInit();
    }

    private void onInit() {

        this.layout.addView(this);
        this.setBackgroundColor(Color.BLACK);
    }

    public void setLayout(int x,int y,int width,int height)
    {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        layoutParams.leftMargin=x;
        layoutParams.topMargin=y;
        layoutParams.width=width;
        layoutParams.height = height;
        this.setLayoutParams(layoutParams);
    }

    public void channelChange(String channel)
    {
        if(channel==null || channel.equals("")==true) {
            this.hide();
        }else {
            this.setVisibility(View.VISIBLE);
            this.setVideoPath(channel);
            this.start();
            this.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    public void hide()
    {
        this.setVisibility(View.INVISIBLE);
    }
}
