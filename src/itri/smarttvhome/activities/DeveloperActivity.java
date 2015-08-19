package itri.smarttvhome.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import tw.futureInsighters.Tv.R;
import itri.smarttvhome.broadcastSenders.DeveloperCommandBroadcastSender;
//import itri.smarttvsdk.broadcastReceivers.DeveloperCommandBroadcastReceiver;
import itri.smarttvsdk.broadcastSenders.BroadcastSenderBase;

/**
 * Created by mimi on 15/4/24.
 */
public class DeveloperActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developeractivity);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==8) {
            Toast.makeText(DeveloperActivity.this, "Reload data",
                    Toast.LENGTH_LONG).show();
//            BroadcastSenderBase sender=new DeveloperCommandBroadcastSender(this, DeveloperCommandBroadcastReceiver.RELOADDATA_COMMAND);
//            sender.send();
        }
        if(keyCode==9) {
            Toast.makeText(DeveloperActivity.this, "Read remote data",
                    Toast.LENGTH_LONG).show();
//            BroadcastSenderBase sender=new DeveloperCommandBroadcastSender(this, DeveloperCommandBroadcastReceiver.READREMOTEDATA_COMMAND);
//            sender.send();
        }
        if(keyCode==10) {
            Toast.makeText(DeveloperActivity.this, "Local simulate data",
                    Toast.LENGTH_LONG).show();
//            BroadcastSenderBase sender=new DeveloperCommandBroadcastSender(this, DeveloperCommandBroadcastReceiver.LOCALSIMULATEDATA_COMMAND);
//            sender.send();
        }
        this.finish();
        return true;
    }
}
