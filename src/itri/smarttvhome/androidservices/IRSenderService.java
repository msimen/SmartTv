package itri.smarttvhome.androidservices;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager;
//import itri.usbserialportdriver.drivers.UsbSerialPort;
//import itri.usbserialportdriver.utils.SerialInputOutputManager;

/**
 * Created by mimi on 15/2/2.
 */
public class IRSenderService extends Service {
    public static final String IR_KEY = "itri.smarttvhome.androidservices.IRSenderService.IRKey";
    public static final String PRODUCT_KEY = "itri.smarttvhome.androidservices.IRSenderService.ProductKey";
//    private static UsbSerialPort sPort = null;
//    private final String TAG = IRSenderService.class.getSimpleName();
//    private final SerialInputOutputManager.Listener mListener =
//            new SerialInputOutputManager.Listener() {
//
//                @Override
//                public void onRunError(Exception e) {
//                    Log.d(TAG, "Runner stopped.");
//                }
//
//                @Override
//                public void onNewData(final byte[] data) {
////                    SerialConsoleActivity.this.runOnUiThread(new Runnable() {
////                        @Override
////                        public void run() {
////                            SerialConsoleActivity.this.updateReceivedData(data);
////                        }
////                    }
////                );
//                }
//            };
    private final ExecutorService mExecutor = Executors.newSingleThreadExecutor();
    private boolean isStart = true;
//    private SerialInputOutputManager mSerialIoManager;

//    public static void serviceGo(Context context, UsbSerialPort port) {
////        sPort = port;
//        final Intent intent = new Intent(context, IRSenderService.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NO_HISTORY);
//        context.startService(intent);
//    }

    @Override
    public void onCreate() {
        super.onCreate();
//        if (sPort != null) {
//            final UsbManager usbManager = (UsbManager) getSystemService(Context.USB_SERVICE);
//            UsbDeviceConnection connection = usbManager.openDevice(sPort.getDriver().getDevice());
//            if (connection == null) {
//                Log.e(TAG, "onCreate connection null");
//            }
//
//            try {
//                sPort.open(connection);
////                sPort.setParameters(9600, 8, UsbSerialPort.STOPBITS_1, UsbSerialPort.PARITY_NONE);
//                sPort.setParameters(115200, 8, UsbSerialPort.STOPBITS_1, UsbSerialPort.PARITY_NONE);
//
//            } catch (IOException e) {
//                Log.e(TAG, "Error setting up device: " + e.getMessage(), e);
////                mTitleTextView.setText("Error opening device: " + e.getMessage());
//                try {
//                    sPort.close();
//                } catch (IOException e2) {
//                    // Ignore.
//                }
//                sPort = null;
//            }
//        }
        onDeviceStateChange();
    }

    @Override
    public void onDestroy() {
//        this.server.stopThread();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (this.isStart == true) {
            this.isStart = false;
            return START_STICKY;
        }
//        try {
//            if (intent.hasExtra(IR_KEY) && intent.hasExtra(PRODUCT_KEY)) {
//                String productKey = intent.getStringExtra(PRODUCT_KEY);
//                String iRKey = intent.getStringExtra(IR_KEY);
//                Log.e("IRSenderService", "ProductKey:" + productKey + "_IRKey:" + iRKey);
//                String rawCommnad = IRCommandManager.getRawCommand(productKey, iRKey);
//                Log.e("IRSenderService", "rawCommnad:" + rawCommnad);
////                sPort.write("send() 38 52 2400 600 1200 600 600 600 1200 600 600 600 1200 600 600 600 600 600 1200 600 600 600 600 600 600 600 600 25800 2400 600 1200 600 600 600 1200 600 600 600 1200 600 600 600 600 600 1200 600 600 600 600 600 600 600 600 25800\n".getBytes("UTF-8"), 2000);
//                if (rawCommnad.equals("") == false) {
//
////                    Log.e("IRSenderService", "rawCommnad:" + rawCommnad);
////                    sPort.write(rawCommnad.getBytes("UTF-8"), 500);
////                    sPort.write(rawCommnad.getBytes("UTF-8"), 500);
////                    sPort.setRTS(false);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return START_STICKY;
    }

    private void startIoManager() {
//        if (sPort != null) {
//            Log.i(TAG, "Starting io manager ..");
//            mSerialIoManager = new SerialInputOutputManager(sPort, mListener);
//            mExecutor.submit(mSerialIoManager);
//        }
    }

    private void stopIoManager() {
//        if (mSerialIoManager != null) {
//            Log.i(TAG, "Stopping io manager ..");
//            mSerialIoManager.stop();
//            mSerialIoManager = null;
//        }
    }

    private void onDeviceStateChange() {
        stopIoManager();
        startIoManager();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
