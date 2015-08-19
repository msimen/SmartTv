package itri.smarttvhome.bizs.tVContexts;

import android.app.Activity;
import android.util.Log;
import android.widget.RelativeLayout;

//import itri.smarttvhome.bizs.tVContexts.iRSender.NullIRSender;
//import itri.smarttvhome.bizs.tVContexts.iRSender.SonyIRSender;
//import itri.smarttvhome.bizs.tVContexts.iRSender.TBCIRSender;
import itri.smarttvhome.bizs.tVContexts.tVPlayer.HDMI.MitraStar.MitraStarTVPlayer;
import itri.smarttvhome.bizs.tVContexts.tVPlayer.IPStream.HLS.HLSTVPlayer;
import itri.smarttvhome.bizs.tVContexts.tVPlayer.IPStream.RTSP.RTSPTVPlayer;
import itri.smarttvhome.bizs.tVContexts.tVPlayer.Null.NullTVPlayer;
import itri.smarttvsdk.bizs.tVContexts.IIRReceiver;
import itri.smarttvsdk.bizs.tVContexts.IRReceiverType;
import itri.smarttvsdk.bizs.tVContexts.iRReceiver.MitraStarIRReceiver;
import itri.smarttvsdk.bizs.tVContexts.iRReceiver.NullIRReceiver;
import itri.smarttvsdk.bizs.tVContexts.iRReceiver.UPMOST_ATV300IRReceiver;


/**
 * Created by mimi on 15/3/12.
 */
public class TVContextFactory {
    private Activity host;
    private BoxType boxType;
    private IRReceiverType receiverType;
    private IRSenderType senderType;
    private SourceType sourceType;
    private IIRReceiver receiver;
//    private IIRSender sender;
    private ITVPlayer tvPlayer;
    private int msoid;
    private RelativeLayout layout;

    public TVContextFactory(Activity host, BoxType boxType, IRReceiverType receiverType, IRSenderType senderType, SourceType sourceType, int msoid, RelativeLayout layout) {

        Log.e("TVContextFactory", "constructor_receiverType:" + receiverType);
        this.host = host;
        this.boxType = boxType;
        this.receiverType = receiverType;
        this.senderType = senderType;
        this.sourceType = sourceType;
        this.msoid = msoid;
        this.layout = layout;
    }

    public IRReceiverType getReceiverType() {
        return this.receiverType;
    }

    public IIRReceiver getReceiver() {
        Log.e("TVContextFactory", "getReceiver:" + receiverType);
        if (this.receiver == null) {
            if (this.receiverType == IRReceiverType.MitraStar) {
                this.receiver = new MitraStarIRReceiver();
                Log.e("TVContextFactory", "MitraStarIRReceiver()");
            }
            if (this.receiverType == IRReceiverType.UPMOST_ATV300)
                this.receiver = new UPMOST_ATV300IRReceiver();
            if (this.receiver == null)
                this.receiver = new NullIRReceiver();
        }
        return this.receiver;
    }

//    public IIRSender getSender() {
//        if (this.sender == null) {
//            if (this.senderType == IRSenderType.TBC)
//                this.sender = new TBCIRSender(this.host);
//            if (this.senderType == IRSenderType.Sony)
//                this.sender = new SonyIRSender(this.host);
//            if (this.sender == null)
//                this.sender = new NullIRSender(this.host);
//        }
//        return this.sender;
//    }

    public ITVPlayer getTvPlayer() {
        if (this.tvPlayer == null) {
            if (this.sourceType == SourceType.MitraStarHdmiIn)
                this.tvPlayer = new MitraStarTVPlayer(this.host, this.layout);
            if (this.sourceType == SourceType.RTSP)
                this.tvPlayer = new RTSPTVPlayer(this.host, this.layout);
            if (this.sourceType == SourceType.HLS)
                this.tvPlayer = new HLSTVPlayer(this.host, this.layout);
            if (this.tvPlayer == null)
                this.tvPlayer = new NullTVPlayer(this.host, this.layout);
        }
        return this.tvPlayer;
    }

    public int getMsoid() {
        return this.msoid;
    }
}
