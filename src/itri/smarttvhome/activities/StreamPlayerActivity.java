package itri.smarttvhome.activities;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import tw.futureInsighters.Tv.R;

public class StreamPlayerActivity extends Activity {
    private VideoView vvStreamPlayer;
    private MediaController mediaControls;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.streamplayeractivity);
        Log.e("StreamPlayerActivity", "activityCreate");

        if (this.mediaControls == null) {
            this.mediaControls = new MediaController(this);
        }

        this.vvStreamPlayer = (VideoView) this
                .findViewById(R.id.vvStreamPlayer);

        this.vvStreamPlayer.setMediaController(this.mediaControls);

        // Uri raw_uri = Uri.parse(<package_name>/+R.raw.<video_file_name>);
        // Uri raw_uri = Uri.parse("android.resource://" + this.getPackageName()
        // + "/raw/snowball");
        // this.vvStreamPlayer.setVideoURI(raw_uri);

        // this.vvStreamPlayer
        // .setVideoURI(Uri
        // .parse("http://81310752d5730fb4ef3c-221b4998ec12974102282b6d4a8fafbe.r2.cf1.rackcdn.com/Snowball.mp4"));

        // this.vvStreamPlayer
        // .setVideoURI(Uri
        // .parse("http://download1.mp4mobilemovies.net/Evergreen%20Bollywood/Andaz%20Apna%20Apna%20-%20DvdRip/Andaz%20Apna%20Apna%20-%20DvdRip%201%20(Mp4MobileMovies.Net).mp4"));

        // this.vvStreamPlayer
        // .setVideoURI(Uri
        // .parse("http://qthttp.apple.com.edgesuite.net/1010qwoeiuryfg/sl.m3u8"));

        // this.vvStreamPlayer.setVideoURI(Uri
        // .parse("http://hermes.sprc.samsung.pl/widget/tmp/testh.3gp"));

        // this.vvStreamPlayer.setVideoURI(Uri
        // .parse("http://192.168.1.157:59737/jellies.mp4"));

        Bundle extras = this.getIntent().getExtras();

        if (extras != null) {
            String streamServerUri = extras.getString("suri");
            this.vvStreamPlayer.setVideoURI(Uri.parse(streamServerUri));
        }
        this.vvStreamPlayer.requestFocus();

        this.vvStreamPlayer.setOnPreparedListener(new OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {

                vvStreamPlayer.seekTo(position);

                if (position == 0) {

                    vvStreamPlayer.start();

                } else {
                    vvStreamPlayer.pause();
                }
            }

        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("Position",
                this.vvStreamPlayer.getCurrentPosition());

        this.vvStreamPlayer.pause();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt("Position");

        this.vvStreamPlayer.seekTo(position);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
