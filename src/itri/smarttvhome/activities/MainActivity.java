package itri.smarttvhome.activities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//import org.alljoyn.bus.BusObject;

import java.io.File;

import tw.futureInsighters.Tv.R;
//import itri.smarttvhome.alljoynservices.TVHomeService;
import itri.smarttvhome.broadcastReceivers.medias.IMediaReceiveBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.medias.MediaReceiveBroadcastReceiver;
//import itri.smarttvhome.handlers.AllJoynBusHandler;
import itri.smarttvhome.utilities.NetworkHelper;

public class MainActivity extends Activity implements
        IMediaReceiveBroadcastReceiverDelegateListener {
    private MediaReceiveBroadcastReceiver mediaReceiveBroadcastReceiver;
    private TextView tvActivityTitle;
    private ImageView ivReceivePic;

    /* Load the native alljoyn_java library. */
    static {
        System.loadLibrary("alljoyn_java");
    }

//    private Handler uiHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case TVHomeService.MESSAGE_PING:
//                    String ping = (String) msg.obj;
//                    Toast.makeText(MainActivity.this, "ping:" + ping,
//                            Toast.LENGTH_LONG).show();
//                    break;
//                case TVHomeService.MESSAGE_PING_REPLY:
//                    String reply = (String) msg.obj;
//                    Toast.makeText(MainActivity.this, "reply:" + reply,
//                            Toast.LENGTH_LONG).show();
//                    break;
//                case TVHomeService.GET_IP4_ADDRESS:
//                    String ip4Address = (String) msg.obj;
//                    Toast.makeText(MainActivity.this, "ip4Address:" + ip4Address,
//                            Toast.LENGTH_LONG).show();
//                    break;
//                case TVHomeService.GET_IP6_ADDRESS:
//                    String ip6Address = (String) msg.obj;
//                    Toast.makeText(MainActivity.this, "ip6Address:" + ip6Address,
//                            Toast.LENGTH_LONG).show();
//                    break;
//                default:
//                    break;
//            }
//        }
//    };

//    private BusObject shareTVService;
//    private AllJoynBusHandler allJoynBusHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        Log.e("MainActivity", "activityCreate");
        this.tvActivityTitle = (TextView) this
                .findViewById(R.id.tvActivityTitle);
        this.tvActivityTitle
                .setText("IP:" + NetworkHelper.getLocalIp4Address());
        HandlerThread allJoynbusThread = new HandlerThread("AllJoynBusHandler");
        allJoynbusThread.start();

        this.ivReceivePic = (ImageView) this.findViewById(R.id.ivReceivePic);
//        this.shareTVService = new TVHomeService(this.uiHandler);

//        this.allJoynBusHandler = new AllJoynBusHandler(this,
//                allJoynbusThread.getLooper(), this.shareTVService);
//        this.allJoynBusHandler.sendEmptyMessage(AllJoynBusHandler.CONNECT);

        this.mediaReceiveBroadcastReceiver = new MediaReceiveBroadcastReceiver(
                this);
        this.mediaReceiveBroadcastReceiver.setDelegateListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.mediaReceiveBroadcastReceiver.register();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        this.mediaReceiveBroadcastReceiver.unregister();
        super.onStop();
    }

    @Override
    public void onMediaReceiver(String filePath) {
        Toast.makeText(MainActivity.this,
                "onMediaReceiver_filePath:" + filePath, Toast.LENGTH_LONG)
                .show();

        File imgFile = new File(filePath);
        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        this.ivReceivePic.setImageBitmap(myBitmap);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        this.allJoynBusHandler.sendEmptyMessage(AllJoynBusHandler.DISCONNECT);
    }
}
