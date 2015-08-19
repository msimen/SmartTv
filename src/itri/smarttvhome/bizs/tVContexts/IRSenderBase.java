package itri.smarttvhome.bizs.tVContexts;

import android.app.Activity;
import android.util.Log;

import itri.smarttvhome.androidservices.IRSenderService;
import itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager;
//import itri.usbserialportdriver.drivers.UsbSerialDriver;
//import itri.usbserialportdriver.drivers.UsbSerialPort;

/**
 * Created by mimi on 15/3/13.
 */
//public abstract class IRSenderBase implements IIRSender {
//    protected Activity host;
//    private UsbSerialDriver driver;
//    private UsbSerialPort port;
//
//    public IRSenderBase(Activity host) {
//        this.host = host;
//    }
//
//    public UsbSerialDriver getUsbSerialDriver() {
//        return this.driver;
//    }
//
//    public void setUsbSerialDriver(UsbSerialDriver driver) {
//        this.driver = driver;
//    }
//
//    public UsbSerialPort getUsbSerialPort() {
//        return this.port;
//    }
//
//    public void setUsbSerialPort(UsbSerialPort port) {
//        this.port = port;
//    }
//
//    public void iRServerStart() {
//        Log.e("IRSenderBase", "iRServerStart");
//        IRSenderService.serviceGo(this.host, this.port);
//    }
//
//    public boolean sendIRCommand(String command) {
//        return this.onSendIRCommand(command);
//    }
//
//    protected boolean onSendIRCommand(String command) {
//        boolean result = false;
//        Log.e("IRSenderBase", "onSendIRCommand");
//        return result;
//    }
//
//    public boolean sendIRNumberCommand(int number) {
//        boolean result = true;
//        String numberStr = String.valueOf(number);
//        char[] digits1 = numberStr.toCharArray();
//        StringBuilder sb = new StringBuilder();
//        for (char current : digits1) {
//            if (current == '0')
//                result = this.sendIRCommand(IRCommandManager.IR_KEY_NUMBER0);
//            if (current == '1')
//                result = this.sendIRCommand(IRCommandManager.IR_KEY_NUMBER1);
//            if (current == '2')
//                result = this.sendIRCommand(IRCommandManager.IR_KEY_NUMBER2);
//            if (current == '3')
//                result = this.sendIRCommand(IRCommandManager.IR_KEY_NUMBER3);
//            if (current == '4')
//                result = this.sendIRCommand(IRCommandManager.IR_KEY_NUMBER4);
//            if (current == '5')
//                result = this.sendIRCommand(IRCommandManager.IR_KEY_NUMBER5);
//            if (current == '6')
//                result = this.sendIRCommand(IRCommandManager.IR_KEY_NUMBER6);
//            if (current == '7')
//                result = this.sendIRCommand(IRCommandManager.IR_KEY_NUMBER7);
//            if (current == '8')
//                result = this.sendIRCommand(IRCommandManager.IR_KEY_NUMBER8);
//            if (current == '9')
//                result = this.sendIRCommand(IRCommandManager.IR_KEY_NUMBER9);
//
//            sb.append(current);
//            sb.append(",");
//
////            if(result==false)
////                return result;
//        }
//
//        Log.e("IRSenderBase", "sendIRNumberCommand_digt:" + sb.toString());
//        return result;
//    }
//}
