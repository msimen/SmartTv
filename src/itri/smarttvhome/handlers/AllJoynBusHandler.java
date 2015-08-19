//package itri.smarttvhome.handlers;
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Handler;
//import android.os.Looper;
//import android.os.Message;
//import android.widget.Toast;
//
//import org.alljoyn.bus.BusAttachment;
//import org.alljoyn.bus.BusListener;
//import org.alljoyn.bus.BusObject;
//import org.alljoyn.bus.Mutable;
//import org.alljoyn.bus.SessionOpts;
//import org.alljoyn.bus.SessionPortListener;
//import org.alljoyn.bus.Status;
//
//import itri.smarttvhome.utilities.NetworkHelper;
//import itri.smarttvsdk.defines.MetaData;
//
//public class AllJoynBusHandler extends Handler {
//    public static final int CONNECT = 1;
//    public static final int DISCONNECT = 2;
//    private Context mContext;
//    private BusObject mBusObject;
//    private BusAttachment mBus;
//
//    public AllJoynBusHandler(Context ctx, Looper looper, BusObject busObject) {
//        super(looper);
//        this.mContext = ctx;
//        this.mBusObject = busObject;
//    }
//
//    @Override
//    public void handleMessage(Message msg) {
//        switch (msg.what) {
//            case CONNECT: {
//                org.alljoyn.bus.alljoyn.DaemonInit.PrepareDaemon(this.mContext);
//                this.mBus = new BusAttachment(this.mContext.getPackageName(),
//                        BusAttachment.RemoteMessage.Receive);
//                this.mBus.registerBusListener(new BusListener());
//
//                Status status = mBus.registerBusObject(this.mBusObject,
//                        MetaData.TVHOMESERVICE_BUSOBJECT_PATH);
//
//                if (status != Status.OK) {
//                    if (AllJoynBusHandler.this.mContext instanceof Activity) {
//                        ((Activity) AllJoynBusHandler.this.mContext).finish();
//                    }
//                    return;
//                }
//
//                status = this.mBus.connect();
//
//                if (status != Status.OK) {
//                    if (AllJoynBusHandler.this.mContext instanceof Activity) {
//                        ((Activity) AllJoynBusHandler.this.mContext).finish();
//                    }
//                    return;
//                }
//
//                Mutable.ShortValue contactPort = new Mutable.ShortValue(
//                        MetaData.TVHOMESERVICE_CONTACT_PORT);
//
//                SessionOpts sessionOpts = new SessionOpts();
//                sessionOpts.traffic = SessionOpts.TRAFFIC_MESSAGES;
//                sessionOpts.isMultipoint = false;
//                sessionOpts.proximity = SessionOpts.PROXIMITY_ANY;
//
//                sessionOpts.transports = SessionOpts.TRANSPORT_ANY
//                        + SessionOpts.TRANSPORT_WFD;
//
//                status = mBus.bindSessionPort(contactPort, sessionOpts,
//                        new SessionPortListener() {
//                            @Override
//                            public boolean acceptSessionJoiner(short sessionPort,
//                                                               String joiner, SessionOpts sessionOpts) {
//                                if (sessionPort == MetaData.TVHOMESERVICE_CONTACT_PORT) {
//                                    return true;
//                                } else {
//                                    return false;
//                                }
//                            }
//                        });
//
//                if (status != Status.OK) {
//                    if (AllJoynBusHandler.this.mContext instanceof Activity) {
//                        ((Activity) AllJoynBusHandler.this.mContext).finish();
//                    }
//                    return;
//                }
//
//                int flag = BusAttachment.ALLJOYN_REQUESTNAME_FLAG_REPLACE_EXISTING
//                        | BusAttachment.ALLJOYN_REQUESTNAME_FLAG_DO_NOT_QUEUE;
//
//                String serviceFullName = MetaData.TVHOMESERVICE_SERVICE_NAME + "_"
//                        + NetworkHelper.getLocalIp4Address().replace(".", "_");
//
//                status = mBus.requestName(serviceFullName, flag);
//
//                if (status == Status.OK) {
//                    status = mBus.advertiseName(serviceFullName,
//                            sessionOpts.transports);
//
//                    if (status != Status.OK) {
//                        Toast.makeText(AllJoynBusHandler.this.mContext,
//                                "advertiseName_fail", Toast.LENGTH_LONG).show();
//                        status = mBus.releaseName(serviceFullName);
//                        if (AllJoynBusHandler.this.mContext instanceof Activity) {
//                            ((Activity) AllJoynBusHandler.this.mContext).finish();
//                        }
//                        return;
//                    } else {
////                        Toast.makeText(AllJoynBusHandler.this.mContext,
////                                "advertiseName_sucess:" + serviceFullName, Toast.LENGTH_LONG).show();
//                    }
//                } else {
//                    Toast.makeText(AllJoynBusHandler.this.mContext,
//                            "requestName_Fail_statusCode:" + status,
//                            Toast.LENGTH_LONG).show();
//
//                }
//
//                break;
//
//            }
//            case DISCONNECT: {
//                mBus.unregisterBusObject(this.mBusObject);
//                mBus.disconnect();
//                this.getLooper().quit();
//                break;
//            }
//            default:
//                break;
//        }
//    }
//}
