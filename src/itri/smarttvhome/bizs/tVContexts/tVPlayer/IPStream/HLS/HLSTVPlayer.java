package itri.smarttvhome.bizs.tVContexts.tVPlayer.IPStream.HLS;

import android.app.Activity;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;

import itri.smarttvhome.bizs.tVContexts.tVPlayer.IPStream.IChannelIPStreamMapor;
import itri.smarttvhome.bizs.tVContexts.tVPlayer.IPStream.IPStreamInfo;
import itri.smarttvhome.bizs.tVContexts.tVPlayer.TVPlayerBase;

/**
 * Created by mimi on 15/3/12.
 */
public class HLSTVPlayer extends TVPlayerBase {
    private IChannelIPStreamMapor channelHLSMapor;
    private VideoView standardTV;
    //    private VideoView previewTV;
    private String channelAddress;
    private MediaPlayer mediaPlayer;
    private boolean standardTVAttach = false;
    private boolean previewTVAttach = false;

    public HLSTVPlayer(Activity host, RelativeLayout layout) {
        super(host, layout);
        this.channelHLSMapor = new MOSChannelHLSMapor();

//        Intent i = new Intent(Intent.ACTION_VIEW);
//        i.setPackage("org.videolan.vlc.betav7neon");
//        i.setDataAndType(Uri.parse("http://58.99.33.2:1935/liveedge/live_19_1.stream/playlist.m3u8?checkCode=37050688asdfsdfsadf&aa=ck.chang_1@itri.org.tw&as=2015"), "video/h264");
//        this.host.startActivity(i);
        this.onStandardTVInit();
//        this.onPreviewTVInit();
    }

    private void setStandardMediaPlayer(final MediaPlayer mediaPlayer) {
        if (this.mediaPlayer == null) {
            this.mediaPlayer = mediaPlayer;
            this.mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                @Override
                public void onBufferingUpdate(MediaPlayer mp, int percent) {
                    Log.d("HLSProtocolTVPlayer", "onBufferingUpdate percent:" + percent + "_currentPosition:" + mp.getCurrentPosition());
                }
            });

            this.mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                @Override
                public boolean onInfo(MediaPlayer mp, int what, int extra) {
                    switch (what) {
                        case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                            Log.e("HLSProtocolTVPlayer", "MEDIA_INFO_BUFFERING_START");
//                        System.gc();
//                        mp.start();
//                        vvTV.pause();
//                        if(mp.isPlaying())
//                            mp.stop();
                            //Begin buffer, pause playing
//                        if (isPlaying()) {
//                            stopPlayer();
//                            needResume = true;
//                        }
//                        mLoadingView.setVisibility(View.VISIBLE);
                            break;
                        case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                            Log.e("HLSProtocolTVPlayer", "MEDIA_INFO_BUFFERING_END");
//                        vvTV.resume();
//                        mp.start();
                            //The buffering is done, resume playing
//                        if (needResume)
//                            startPlayer();
//                        mLoadingView.setVisibility(View.GONE);
                            break;
//                    case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                        //Display video download speed
//                        Logger.e("download rate:" + arg2);
//                        break;
                    }
                    return true;
                }
            });

            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    Log.e("HLSProtocolTVPlayer", "MediaPlayer_onError");
                    return false;
                }
            });
        }
    }

    private void setPreviewMediaPlayer(final MediaPlayer mediaPlayer) {
        if (this.mediaPlayer == null) {
            this.mediaPlayer = mediaPlayer;
            this.mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                @Override
                public void onBufferingUpdate(MediaPlayer mp, int percent) {
                    Log.d("HLSProtocolTVPlayer", "onBufferingUpdate percent:" + percent + "_currentPosition:" + mp.getCurrentPosition());
                }
            });

            this.mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                @Override
                public boolean onInfo(MediaPlayer mp, int what, int extra) {
                    switch (what) {
                        case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                            Log.e("HLSProtocolTVPlayer", "MEDIA_INFO_BUFFERING_START");
//                        System.gc();
//                        mp.start();
//                        vvTV.pause();
//                        if(mp.isPlaying())
//                            mp.stop();
                            //Begin buffer, pause playing
//                        if (isPlaying()) {
//                            stopPlayer();
//                            needResume = true;
//                        }
//                        mLoadingView.setVisibility(View.VISIBLE);
                            break;
                        case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                            Log.e("HLSProtocolTVPlayer", "MEDIA_INFO_BUFFERING_END");
//                        vvTV.resume();
//                        mp.start();
                            //The buffering is done, resume playing
//                        if (needResume)
//                            startPlayer();
//                        mLoadingView.setVisibility(View.GONE);
                            break;
//                    case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                        //Display video download speed
//                        Logger.e("download rate:" + arg2);
//                        break;
                    }
                    return true;
                }
            });

            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    Log.e("HLSProtocolTVPlayer", "MediaPlayer_onError");
                    return false;
                }
            });
        }
    }

    private void onPreviewTVInit() {
//        this.previewTV=new VideoView(this.host);
//        this.previewTV.setMediaController(new MediaController(this.host));


//        wManager.addView(this.previewTV, wmParams);

        Log.e("HLSProtocolTVPlayer", "onPreviewTVInit");
//        this.vvTV.requestFocus();
//        this.previewTV.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer pMp) {
//                Log.e("HLSProtocolTVPlayer", "MediaPlayer_onPrepared");
//                setPreviewMediaPlayer(pMp);
//            }
//
//        });
//        this.previewTV.setVisibility(View.INVISIBLE);
    }

    private void onStandardTVInit() {
        this.standardTV = new VideoView(this.host);

//        String httpLiveUrl = "http://58.99.33.2:1935/liveedge/live_7_1.stream/playlist.m3u8?checkCode=37050688asdfsdfsadf&aa=ck.chang_1@itri.org.tw&as=2015";
//        this.vvTV.setVideoURI(Uri.parse(httpLiveUrl));
//        this.standardTV.setMediaController(new MediaController(this.host));

//        this.vvTV.requestFocus();
//        this.onStandardTVShow();

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, RelativeLayout.TRUE);

        this.layout.addView(this.standardTV, layoutParams);

        this.standardTV.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer pMp) {
                Log.e("HLSProtocolTVPlayer", "MediaPlayer_onPrepared");
                setStandardMediaPlayer(pMp);
            }

        });
        this.standardTVAttach = true;
    }

    private void onStandardTVShow() {
        if (this.standardTVAttach == false) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
//            RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            params.addRule(RelativeLayout.ALIGN_BOTTOM, RelativeLayout.TRUE);
//            standardTV.setLayoutParams(params);
//            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
//                    RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
//
//            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
//            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
//            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
//            layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, RelativeLayout.TRUE);
//
            this.layout.addView(this.standardTV, params);
            this.tvPlay(false);
        }
        this.standardTVAttach = true;
    }

    private void onStandardTVHide() {
        if (this.standardTVAttach == true) {
//            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
//                    0, 0);
//            RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

//            standardTV.setLayoutParams(params);
            Log.e("HLSProtocolTVPlayer", "onStandardTVHide");
            this.layout.removeView(this.standardTV);
        }
        this.standardTVAttach = false;
    }

    private void onPreviewTvShow() {
//        if(this.previewTVAttach ==false) {
//            WindowManager wManager = ((Activity) this.host).getWindowManager();
//            WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();
//            wmParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
//            wmParams.format = PixelFormat.TRANSPARENT;
//            wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
//                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
//                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
//            wmParams.gravity = Gravity.LEFT | Gravity.TOP;
//            wmParams.x = screen_width - screen_width / 4 - screen_width / 24;
//            wmParams.y = screen_height - screen_height / 4 - screen_height / 24;
//            wmParams.width = screen_width / 4;
//            wmParams.height = screen_height / 4;
//            wManager.addView(this.previewTV, wmParams);
//            tvPlay(true);
//        }
//        this.previewTVAttach =true;
    }

    private void onPreviewTvHide() {
//        WindowManager wManager = ((Activity) this.host).getWindowManager();
//        if(this.previewTVAttach ==true) {
//            wManager.removeView(this.previewTV);
////            this.previewTV.stopPlayback();
//        }
//        this.previewTVAttach =false;
    }


    @Override
    protected String onChannelHandle(int channel) {
        String result = "";
        Log.e("HLSProtocolTVPlayer", "onChannelHandle_channel:" + channel);


        IPStreamInfo backResult = this.channelHLSMapor.getIPStreamByChannel(channel);

        if (backResult == null) {
            result = "no this channel.";
            return result;
        }

        this.channelAddress = backResult.getChannelUrAddress() + "?checkCode=37050688asdfsdfsadf&aa=ck.chang_1@itri.org.tw&as=2015";
        Log.e("HLSProtocolTVPlayer", "onChannelHandle_channelName:" + backResult.getChannelName());
        this.tvPlay(false);
        return result;
    }

    @Override
    protected String toPreChannelHandle() {
        String result = "";

        IPStreamInfo backResult = this.channelHLSMapor.getPreChannel();

        if (backResult == null) {
            result = "no this channel.";
            return result;
        }

        Toast.makeText(this.host, "toPreChannelHandle_channel:" + backResult.getChannelCode(),
                Toast.LENGTH_SHORT).show();
        this.channelAddress = backResult.getChannelUrAddress() + "?checkCode=37050688asdfsdfsadf&aa=ck.chang_1@itri.org.tw&as=2015";
        Log.e("HLSProtocolTVPlayer", "onChannelHandle_channelName:" + backResult.getChannelName());
        this.tvPlay(false);
        this.channel= Integer.parseInt(backResult.getChannelCode());
//        Log.e("HLSTVPlayer", "toPreChannelHandle:" + channel);
        return result;
    }

    @Override
    protected String toNextChannelHandle() {
        String result = "";

        IPStreamInfo backResult = this.channelHLSMapor.getNextChannel();

        if (backResult == null) {
            result = "no this channel.";
            return result;
        }

        Toast.makeText(this.host, "toNextChannelHandle_channel:" + backResult.getChannelCode(),
                Toast.LENGTH_SHORT).show();
        this.channelAddress = backResult.getChannelUrAddress() + "?checkCode=37050688asdfsdfsadf&aa=ck.chang_1@itri.org.tw&as=2015";
//        Log.e("HLSProtocolTVPlayer", "onChannelHandle_channelName:" + backResult.getChannelName());
        this.tvPlay(false);
        this.channel= Integer.parseInt(backResult.getChannelCode());
        Log.e("HLSTVPlayer", "toNextChannelHandle:" + channel);
        return result;
    }

    private void tvPlay(boolean isPreview) {
        if (!(this.channelAddress == null || this.channelAddress.equals("") == true)) {
            if (isPreview == true) {
//                this.previewTV.setVideoPath(channelAddress);
//                this.previewTV.start();
            } else {
                this.standardTV.setVideoPath(channelAddress);
                Log.e("HLSTVPlayer", "tvPlay:" + channelAddress);
                this.standardTV.start();
            }
        }
    }

    @Override
    public void toFullMode() {
        super.toFullMode();
        this.onStandardTVShow();
        this.onPreviewTvHide();
//        this.standardTV.setVisibility(View.VISIBLE);
//        this.previewTV.setVisibility(View.INVISIBLE);
//        this.tvPlay(false);

//        this.tvPlay();
        Log.e("HLSProtocolTVPlayer", "toFullMode");
    }

    @Override
    public void toRightMode() {
        super.toRightMode();
//        this.onPreviewTvShow();
//        this.onPreviewTvHide();
//        this.standardTV.setVisibility(View.VISIBLE);
//        this.tvPlay(false);
//        this.tvPlay();
        Log.e("HLSProtocolTVPlayer", "toRightMode");
    }

    @Override
    public void toBottomMode() {
        super.toBottomMode();
        this.onPreviewTvHide();
//        this.standardTV.setVisibility(View.VISIBLE);
//        this.standardTV.setVisibility(View.VISIBLE);
//        this.tvPlay(false);
//        this.tvPlay();
        Log.e("HLSProtocolTVPlayer", "toBottomMode");
    }

    @Override
    public void toFreeMode(int x, int y, int width, int height) {
        super.toFreeMode(x, y, width, height);
        this.onPreviewTvHide();
//        this.standardTV.setVisibility(View.VISIBLE);
//        this.standardTV.setVisibility(View.VISIBLE);
//        this.tvPlay(false);
//        this.tvPlay();
        Log.e("HLSProtocolTVPlayer", "toFreeMode");
    }

    @Override
    public void toPreviewMode() {
        super.toPreviewMode();
        this.onStandardTVHide();
        this.onPreviewTvShow();

//        this.previewTV.setVisibility(View.VISIBLE);
//        this.standardTV.setVisibility(View.INVISIBLE);
//        this.standardTV.stopPlayback();
//        this.tvPlay(true);
        Log.e("HLSProtocolTVPlayer", "toPreviewMode");

    }

    @Override
    public void toFreePreviewMode(int x, int y, int width, int height) {
        super.toFreePreviewMode(x, y, width, height);
//        this.previewTV.setVisibility(View.VISIBLE);
//        this.standardTV.setVisibility(View.INVISIBLE);
//        this.standardTV.stopPlayback();
//        this.tvPlay(true);
        Log.e("HLSProtocolTVPlayer", "toFreePreviewMode");
    }

    @Override
    public void toHideMode() {
        super.toHideMode();
//        this.standardTV.setVisibility(View.INVISIBLE);
//        this.previewTV.setVisibility(View.INVISIBLE);
        Log.e("HLSProtocolTVPlayer", "toHideMode");
    }

    @Override
    public String getChannelAddress() {
        return this.channelAddress;
    }
}
