package itri.smarttvhome.bizs.tVContexts.iRSender;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import itri.smarttvhome.androidservices.IRSenderService;
import itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager;
//import itri.smarttvhome.bizs.tVContexts.IRSenderBase;

/**
 * Created by mimi on 15/3/12.
 */
//public class TBCIRSender extends IRSenderBase {
//    public TBCIRSender(Activity host) {
//        super(host);
//    }
//
//    @Override
//    protected boolean onSendIRCommand(String command) {
//        boolean result = false;
//        Log.e("TBCIRSender", "sendIRCommand:" + command);
//        if (this.getUsbSerialPort() != null) {
//            final Intent intentService = new Intent(this.host, IRSenderService.class);
//            intentService.putExtra(IRSenderService.IR_KEY, command);
//            intentService.putExtra(IRSenderService.PRODUCT_KEY, IRCommandManager.PRODUCT_KEY_TBC);
//            this.host.startService(intentService);
//            result = true;
//        }
//        return result;
//    }
//}
