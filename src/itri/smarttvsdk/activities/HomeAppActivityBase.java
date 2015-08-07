package itri.smarttvsdk.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import itri.smarttvsdk.bizs.persists.IJsonable;
import itri.smarttvsdk.bizs.persists.PersistManager;
import itri.smarttvsdk.bizs.tVContexts.HLSProtocolPreviewView;
import itri.smarttvsdk.bizs.tVContexts.IIRReceiver;
import itri.smarttvsdk.bizs.tVContexts.IPreviewView;
import itri.smarttvsdk.bizs.tVContexts.IRReceiverType;
import itri.smarttvsdk.bizs.tVContexts.ProgramProviderType;
import itri.smarttvsdk.bizs.tVContexts.iRReceiver.MitraStarIRReceiver;
import itri.smarttvsdk.bizs.tVContexts.iRReceiver.NullIRReceiver;
import itri.smarttvsdk.bizs.tVContexts.iRReceiver.UPMOST_ATV300IRReceiver;
import itri.smarttvsdk.bizs.workItems.IHomeAppActivity;
import itri.smarttvsdk.broadcastReceivers.instructions.IIstAdBroadcastReceiverDelegateListener;
import itri.smarttvsdk.broadcastReceivers.instructions.IIstAppBottomBroadcastReceiverDelegateListener;
import itri.smarttvsdk.broadcastReceivers.instructions.IIstAppRightBroadcastReceiverDelegateListener;
import itri.smarttvsdk.broadcastReceivers.instructions.IIstBackBroadcastReceiverDelegateListener;
import itri.smarttvsdk.broadcastReceivers.instructions.IIstDownBroadcastReceiverDelegateListener;
import itri.smarttvsdk.broadcastReceivers.instructions.IIstHomeBroadcastReceiverDelegateListener;
import itri.smarttvsdk.broadcastReceivers.instructions.IIstLeftBroadcastReceiverDelegateListener;
import itri.smarttvsdk.broadcastReceivers.instructions.IIstModeFullBroadcastReceiverDelegateListener;
import itri.smarttvsdk.broadcastReceivers.instructions.IIstModeSmallBroadcastReceiverDelegateListener;
import itri.smarttvsdk.broadcastReceivers.instructions.IIstOkBroadcastReceiverDelegateListener;
import itri.smarttvsdk.broadcastReceivers.instructions.IIstRightBroadcastReceiverDelegateListener;
import itri.smarttvsdk.broadcastReceivers.instructions.IIstUpBroadcastReceiverDelegateListener;
import itri.smarttvsdk.broadcastReceivers.instructions.IstAdBroadcastReceiver;
import itri.smarttvsdk.broadcastReceivers.instructions.IstAppBottomBroadcastReceiver;
import itri.smarttvsdk.broadcastReceivers.instructions.IstAppRightBroadcastReceiver;
import itri.smarttvsdk.broadcastReceivers.instructions.IstBackBroadcastReceiver;
import itri.smarttvsdk.broadcastReceivers.instructions.IstDownBroadcastReceiver;
import itri.smarttvsdk.broadcastReceivers.instructions.IstHomeBroadcastReceiver;
import itri.smarttvsdk.broadcastReceivers.instructions.IstLeftBroadcastReceiver;
import itri.smarttvsdk.broadcastReceivers.instructions.IstModeFullBroadcastReceiver;
import itri.smarttvsdk.broadcastReceivers.instructions.IstModeSmallBroadcastReceiver;
import itri.smarttvsdk.broadcastReceivers.instructions.IstOkBroadcastReceiver;
import itri.smarttvsdk.broadcastReceivers.instructions.IstRightBroadcastReceiver;
import itri.smarttvsdk.broadcastReceivers.instructions.IstUpBroadcastReceiver;
import itri.smarttvsdk.broadcastSenders.IBroadcastSender;
import itri.smarttvsdk.broadcastSenders.homes.HomeHomeKeyBroadcastSender;
import itri.smarttvsdk.broadcastSenders.tvContexts.TVBottomModeBroadcastSender;
import itri.smarttvsdk.broadcastSenders.tvContexts.TVFreeModeBroadcastSender;
import itri.smarttvsdk.broadcastSenders.tvContexts.TVFreePreviewModeBroadcastSender;
import itri.smarttvsdk.broadcastSenders.tvContexts.TVFullModeBroadcastSender;
import itri.smarttvsdk.broadcastSenders.tvContexts.TVHideModeBroadcastSender;
import itri.smarttvsdk.broadcastSenders.tvContexts.TVPreviewModeBroadcastSender;
import itri.smarttvsdk.broadcastSenders.tvContexts.TVRightModeBroadcastSender;
import itri.smarttvsdk.defines.IntentApp;
import itri.smarttvsdk.interfaces.IIRKeyboardReceiverDelegateListener;
import itri.smarttvsdk.views.HomeAppBottomView;
import itri.smarttvsdk.views.HomeAppFullView;
import itri.smarttvsdk.views.HomeAppRightView;
import itri.smarttvsdk.views.HomeAppViewBase;
import tw.futureInsighters.Tv_bad.R;

/**
 * Created by mimi on 14/12/29.
 */
public class HomeAppActivityBase extends Activity implements IHomeAppActivity {
//    protected MitraStarTVObject tvObject;
    private HomeAppFullView vFullView;
    private HomeAppRightView vRightView;
    private HomeAppBottomView vBottomView;
    private HomeAppViewBase contentView;
    private IstAdBroadcastReceiver istAdBroadcastReceiver;
    private IstAppBottomBroadcastReceiver istAppBottomBroadcastReceiver;
    private IstAppRightBroadcastReceiver istAppRightBroadcastReceiver;
    private IstBackBroadcastReceiver istBackBroadcastReceiver;
    private IstDownBroadcastReceiver istDownBroadcastReceiver;
    private IstHomeBroadcastReceiver istHomeBroadcastReceiver;
    private IstLeftBroadcastReceiver istLeftBroadcastReceiver;
    private IstModeFullBroadcastReceiver istModeFullBroadcastReceiver;
    private IstModeSmallBroadcastReceiver istModeSmallBroadcastReceiver;
    private IstOkBroadcastReceiver istOkBroadcastReceiver;
    private IstRightBroadcastReceiver istRightBroadcastReceiver;
    private IstUpBroadcastReceiver istUpBroadcastReceiver;
    private int badgeNumber;
    private int channelNumber = -1;
    private String userId;
    private ProgramProviderType programProvider;
    private PersistManager persistManager;
    private IIRKeyboardReceiverDelegateListener iRKeyboardReceiverDelegateListener;
    private int screen_width;
    private int screen_height;
    private IIRReceiver iRReceiver;
    private IPreviewView vPreViewView;
    private RelativeLayout container;
    private String channelAddress;
    private IRReceiverType receiverType;
    public int getChannelNumber() {
        return this.channelNumber;
    }

    public String getUserId() {
        return this.userId;
    }

    public ProgramProviderType getProgramProvider()
    {
        return this.programProvider;
    }

    public IIRReceiver getIRReceiver()
    {
        if(this.iRReceiver==null)
        {
            if(this.receiverType==IRReceiverType.MitraStar)
                this.iRReceiver= new MitraStarIRReceiver();
            if(this.receiverType==IRReceiverType.UPMOST_ATV300)
                this.iRReceiver=new UPMOST_ATV300IRReceiver();
            if(this.receiverType==null)
                this.iRReceiver=new NullIRReceiver();
        }
        return this.iRReceiver;
    }
    public void setIRKeyboardReceiverDelegateListener(IIRKeyboardReceiverDelegateListener delegateListener) {
        this.iRKeyboardReceiverDelegateListener = delegateListener;
    }

    private PersistManager getPersistManager() {
        if (this.persistManager == null)
            this.persistManager = new PersistManager(this);
        return this.persistManager;
    }

    private IPreviewView getPreViewView()
    {
        if(this.vPreViewView==null)
        {
            this.vPreViewView=new HLSProtocolPreviewView(this,this.container);
        }
        return this.vPreViewView;
    }
    protected void fillData(IJsonable instance, String key) {

        if (instance.isCollection()) {
            JSONArray array = this.getPersistManager().getJArray(key);
            if (array != null) {
                instance.jSONArrayToInstance(array);
            }
        } else {
            JSONObject object = this.getPersistManager().getJObject(key);
            if (object != null) {
                instance.jSONObjectToInstance(object);
            }
        }
    }

    protected String saveData(IJsonable instance, String key) {
        String result = "-1";
        if (instance.isCollection()) {
            JSONArray array = instance.instanceToJSONArray();
            if (array != null) {
                result = this.getPersistManager().saveJArray(key, array);
            }
        } else {
            JSONObject object = instance.instanceToJSONObject();
            if (object != null) {
                result = this.getPersistManager().saveJObject(key, object);
            }
        }
        return result;
    }

    protected String saveData(IJsonable instance) {
        String result = "-1";
        if (instance.isCollection()) {
            JSONArray array = instance.instanceToJSONArray();
            if (array != null) {
                result = this.getPersistManager().saveJArray(array);
            }
        } else {
            JSONObject object = instance.instanceToJSONObject();
            if (object != null) {
                result = this.getPersistManager().saveJObject(object);
            }
        }
        return result;
    }

    protected boolean removeData(String key) {
        boolean result = this.getPersistManager().removeJObject(key);
        if (result == false)
            result = this.getPersistManager().removeJArray(key);
        return result;
    }

    @Override
    public Context getContext() {
        return this;
    }

    public int getBadgeNumber() {
        return this.badgeNumber;
    }

    public void setBadgeNumber(int badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.homeappactivitybase);
        this.container = (RelativeLayout) this.findViewById(R.id.container);
        Intent incomeItem = this.getIntent();
        if (incomeItem != null) {
            if (incomeItem.hasExtra(IntentApp.NUMBER_KEY)) {
                this.badgeNumber = Integer.valueOf(incomeItem.getStringExtra(IntentApp.NUMBER_KEY));
            }

            if (incomeItem.hasExtra(IntentApp.CHANNEL_KEY)) {
                this.channelNumber = incomeItem.getIntExtra(IntentApp.CHANNEL_KEY, -1);
                this.userId=incomeItem.getStringExtra(IntentApp.USERID_KEY);
                this.channelAddress=incomeItem.getStringExtra(IntentApp.CHANNELADDRESS_KEY);
                Log.e("HomeAppActivityBase","onCreate_channelAddress:"+this.channelAddress);
                this.programProvider=(ProgramProviderType)  incomeItem.getSerializableExtra(IntentApp.PROGRAMPROVIDER_KEY);
                this.receiverType=(IRReceiverType)incomeItem.getSerializableExtra(IntentApp.IRRECEIVERTYPE_KEY);
                this.onCleanTipStatus();
            }
        }
        Point screenSize = new Point();
        this.getWindowManager().getDefaultDisplay().getSize(screenSize);
        this.screen_width = screenSize.x;
        this.screen_height = screenSize.y;
//        this.tvObject = new MitraStarTVObject(this, this.screen_width, this.screen_height, 2000);

        this.vFullView = (HomeAppFullView) this.findViewById(R.id.vFullView);

        this.vRightView = (HomeAppRightView) this.findViewById(R.id.vRightView);
        this.vBottomView = (HomeAppBottomView) this.findViewById(R.id.vBottomView);

        this.istAdBroadcastReceiver = new IstAdBroadcastReceiver(this);
        this.istAdBroadcastReceiver.setDelegateListener(new IIstAdBroadcastReceiverDelegateListener() {
            @Override
            public void onIstReceiver() {
                onAdBroadcastReceiverHandle();
            }
        });

        this.istAppBottomBroadcastReceiver = new IstAppBottomBroadcastReceiver(this);
        this.istAppBottomBroadcastReceiver.setDelegateListener(new IIstAppBottomBroadcastReceiverDelegateListener() {
            @Override
            public void onIstReceiver() {
                onAppBottomBroadcastReceiverHandle();
            }
        });

        this.istAppRightBroadcastReceiver = new IstAppRightBroadcastReceiver(this);
        this.istAppRightBroadcastReceiver.setDelegateListener(new IIstAppRightBroadcastReceiverDelegateListener() {
            @Override
            public void onIstReceiver() {
                onAppRightBroadcastReceiverHandle();
            }
        });

        this.istBackBroadcastReceiver = new IstBackBroadcastReceiver(this);
        this.istBackBroadcastReceiver.setDelegateListener(new IIstBackBroadcastReceiverDelegateListener() {
            @Override
            public void onIstReceiver() {
                onBackBroadcastReceiverHandle();
            }
        });

        this.istDownBroadcastReceiver = new IstDownBroadcastReceiver(this);
        this.istDownBroadcastReceiver.setDelegateListener(new IIstDownBroadcastReceiverDelegateListener() {
            @Override
            public void onIstReceiver() {
                onDownBroadcastReceiverHandle();
            }
        });

        this.istHomeBroadcastReceiver = new IstHomeBroadcastReceiver(this);
        this.istHomeBroadcastReceiver.setDelegateListener(new IIstHomeBroadcastReceiverDelegateListener() {
            @Override
            public void onIstReceiver() {
                onHomeBroadcastReceiverHandle();
            }
        });

        this.istLeftBroadcastReceiver = new IstLeftBroadcastReceiver(this);
        this.istLeftBroadcastReceiver.setDelegateListener(new IIstLeftBroadcastReceiverDelegateListener() {
            @Override
            public void onIstReceiver() {
                onLeftBroadcastReceiverHandle();
            }
        });

        this.istModeFullBroadcastReceiver = new IstModeFullBroadcastReceiver(this);
        this.istModeFullBroadcastReceiver.setDelegateListener(new IIstModeFullBroadcastReceiverDelegateListener() {
            @Override
            public void onIstReceiver() {
                onModeFullBroadcastReceiverHandle();
            }
        });

        this.istModeSmallBroadcastReceiver = new IstModeSmallBroadcastReceiver(this);
        this.istModeSmallBroadcastReceiver.setDelegateListener(new IIstModeSmallBroadcastReceiverDelegateListener() {
            @Override
            public void onIstReceiver() {
                onModeSmallBroadcastReceiverHandle();
            }
        });

        this.istOkBroadcastReceiver = new IstOkBroadcastReceiver(this);
        this.istOkBroadcastReceiver.setDelegateListener(new IIstOkBroadcastReceiverDelegateListener() {
            @Override
            public void onIstReceiver() {
                onOkBroadcastReceiverHandle();
            }
        });

        this.istRightBroadcastReceiver = new IstRightBroadcastReceiver(this);
        this.istRightBroadcastReceiver.setDelegateListener(new IIstRightBroadcastReceiverDelegateListener() {
            @Override
            public void onIstReceiver() {
                onRightBroadcastReceiverHandle();
            }
        });

        this.istUpBroadcastReceiver = new IstUpBroadcastReceiver(this);
        this.istUpBroadcastReceiver.setDelegateListener(new IIstUpBroadcastReceiverDelegateListener() {
            @Override
            public void onIstReceiver() {
                onUpBroadcastReceiverHandle();
            }
        });

//        this.setIRKeyboardReceiverDelegateListener(new IIRKeyboardReceiverDelegateListener(){
//            @Override
//            public boolean otherKeyClick(int keyCode) {
//                Toast.makeText(HomeAppActivityBase.this, "Base_IR_otherKeyClick:"+keyCode,
//                        Toast.LENGTH_LONG).show();
//                return true;
//            }
//
//            @Override
//            public boolean numberKeyClick(int number) {
//                Toast.makeText(HomeAppActivityBase.this, "Base_IR_numberKeyClick:"+number,
//                        Toast.LENGTH_LONG).show();
//                return true;
//            }
//
//            @Override
//            public boolean upKeyClick() {
//                Toast.makeText(HomeAppActivityBase.this, "Base_IR_upKeyClick",
//                        Toast.LENGTH_LONG).show();
//                return true;
//            }
//
//            @Override
//            public boolean downKeyClick() {
//                Toast.makeText(HomeAppActivityBase.this, "Base_IR_downKeyClick",
//                        Toast.LENGTH_LONG).show();
//                return true;
//            }
//
//            @Override
//            public boolean leftKeyClick() {
//                Toast.makeText(HomeAppActivityBase.this, "Base_IR_leftKeyClick",
//                        Toast.LENGTH_LONG).show();
//                return true;
//            }
//
//            @Override
//            public boolean rightKeyClick() {
//                Toast.makeText(HomeAppActivityBase.this, "Base_IR_rightKeyClick",
//                        Toast.LENGTH_LONG).show();
//                return true;
//            }
////
//            @Override
//            public boolean okKeyClick() {
//                Toast.makeText(HomeAppActivityBase.this, "Base_IR_okKeyClick",
//                        Toast.LENGTH_LONG).show();
//                return true;
//            }
//
//            @Override
//            public boolean backKeyClick() {
//                Toast.makeText(HomeAppActivityBase.this, "Base_IR_backKeyClick",
//                        Toast.LENGTH_LONG).show();
//                return true;
//            }
//
//            @Override
//            public boolean homeKeyClick() {
//                Toast.makeText(HomeAppActivityBase.this, "Base_IR_homeKeyClick",
//                        Toast.LENGTH_LONG).show();
//                return true;
//            }
//        });

    }

    protected void onCleanTipStatus()
    {
        //皜Tip�����
        Log.e("HomeAppActivityBase","onCleanTipStatus");
    }

    public void setContentView(int layoutResID) {
    }

    protected void onAdBroadcastReceiverHandle() {
        Toast.makeText(HomeAppActivityBase.this, "onAdBroadcastReceiverHandle",
                Toast.LENGTH_LONG).show();
    }

    protected void onAppBottomBroadcastReceiverHandle() {
        Toast.makeText(HomeAppActivityBase.this, "onAppBottomBroadcastReceiverHandle",
                Toast.LENGTH_LONG).show();
    }

    protected void onAppRightBroadcastReceiverHandle() {
        Toast.makeText(HomeAppActivityBase.this, "onAppRightBroadcastReceiverHandle",
                Toast.LENGTH_LONG).show();
    }

    protected void onBackBroadcastReceiverHandle() {
        Toast.makeText(HomeAppActivityBase.this, "onBackBroadcastReceiverHandle",
                Toast.LENGTH_LONG).show();
        this.finish();
    }

    protected void onDownBroadcastReceiverHandle() {
        Toast.makeText(HomeAppActivityBase.this, "onDownBroadcastReceiverHandle",
                Toast.LENGTH_LONG).show();
    }

    protected void onHomeBroadcastReceiverHandle() {
        Toast.makeText(HomeAppActivityBase.this, "onHomeBroadcastReceiverHandle",
                Toast.LENGTH_LONG).show();
        this.finish();
    }

    protected void onLeftBroadcastReceiverHandle() {
        Toast.makeText(HomeAppActivityBase.this, "onLeftBroadcastReceiverHandle",
                Toast.LENGTH_LONG).show();
    }

    protected void onModeFullBroadcastReceiverHandle() {
        Toast.makeText(HomeAppActivityBase.this, "onModeFullBroadcastReceiverHandle",
                Toast.LENGTH_LONG).show();
    }

    protected void onModeSmallBroadcastReceiverHandle() {
        Toast.makeText(HomeAppActivityBase.this, "onModeSmallBroadcastReceiverHandle",
                Toast.LENGTH_LONG).show();
    }

    protected void onOkBroadcastReceiverHandle() {
        Toast.makeText(HomeAppActivityBase.this, "onOkBroadcastReceiverHandle",
                Toast.LENGTH_LONG).show();
    }

    protected void onRightBroadcastReceiverHandle() {
        Toast.makeText(HomeAppActivityBase.this, "onRightBroadcastReceiverHandle",
                Toast.LENGTH_LONG).show();
    }

    protected void onUpBroadcastReceiverHandle() {
        Toast.makeText(HomeAppActivityBase.this, "onUpBroadcastReceiverHandle",
                Toast.LENGTH_LONG).show();
    }

    protected void toTvBottomMode() {
        new TVBottomModeBroadcastSender(this).send();
    }

    protected void toTvFreeMode(int x, int y, int width, int height) {
        new TVFreeModeBroadcastSender(this, x, y, width, height).send();
    }

    protected void toTvFreePreviewMode(int x, int y, int width, int height) {
        new TVFreePreviewModeBroadcastSender(this, x, y, width, height).send();
    }

    protected void toTvFullMode() {
        new TVFullModeBroadcastSender(this).send();
    }

    protected void toTvHideMode() {
        new TVHideModeBroadcastSender(this).send();
    }

    protected void toTvPreviewMode() {
        new TVPreviewModeBroadcastSender(this).send();
        this.getPreViewView().setLayout(screen_width - screen_width / 4 - screen_width / 24,
                screen_height - screen_height / 4 - screen_height / 24,
                screen_width / 4,
                screen_height / 4 );
        Log.e("HomeAppActivityBase","toTvPreviewMode_channelAddress:"+this.channelAddress);
        this.getPreViewView().channelChange(this.channelAddress);
        this.getPreViewView().bringToFront();


    }

    protected void toTvRightMode() {
        new TVRightModeBroadcastSender(this).send();
    }


    public void setAppContentView(HomeAppViewBase contentView) {
        this.contentView = contentView;
        this.vFullView.removeAllViews();
        this.vRightView.removeAllViews();
        this.vBottomView.removeAllViews();
//        this.tvObject.toHideMode();
        if (this.contentView instanceof HomeAppFullView) {
//            this.home_MS_Notify();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, RelativeLayout.TRUE);

            this.vFullView.addView(this.contentView,layoutParams);

//            this.tvObject.toPreviewMode();
            this.vFullView.bringToFront();
//            this.toTvPreviewMode();

        }

        if (this.contentView instanceof HomeAppRightView) {
//            this.home_AR_Notify();

            this.vRightView.addView(this.contentView);
//            this.tvObject.toRightMode();
            this.toTvRightMode();
            this.vRightView.bringToFront();

        }

        if (this.contentView instanceof HomeAppBottomView) {
//            this.home_AB_Notify();

            this.vBottomView.addView(this.contentView);

//            this.tvObject.toBottomMode();
            this.toTvBottomMode();
            this.vBottomView.bringToFront();

        }
        Log.d("HomeAppActivityBase", "setAppContentView");
//    }
    }

    //    public void home_Up_Notify() {
//        IBroadcastSender sender=new CmdUpBroadcastSender(this);
//        sender.send();
//    }
//
//    public void home_Down_Notify() {
//        IBroadcastSender sender=new CmdDownBroadcastSender(this);
//        sender.send();
//    }
//
//    public void home_Left_Notify() {
//        IBroadcastSender sender=new CmdLeftBroadcastSender(this);
//        sender.send();
//    }
//
//    public void home_Right_Notify() {
//        IBroadcastSender sender=new CmdRightBroadcastSender(this);
//        sender.send();
//    }
//
//    public void home_Back_Notify() {
//        IBroadcastSender sender=new CmdBackBroadcastSender(this);
//        sender.send();
//    }
//
//    public void home_Home_Notify() {
//        IBroadcastSender sender = new CmdHomeBroadcastSender(this);
//        sender.send();
//        this.finish();
//    }
//
//    public void home_Ok_Notify() {
//        IBroadcastSender sender=new CmdOkBroadcastSender(this);
//        sender.send();
//    }
//
//    public void home_AD_Notify() {
//        IBroadcastSender sender=new CmdAdBroadcastSender(this);
//        sender.send();
//    }
//
//    public void home_MF_Notify() {
//        IBroadcastSender sender=new CmdModeFullBroadcastSender(this);
//        sender.send();
//    }
//
//    public void home_MS_Notify() {
//        IBroadcastSender sender=new CmdModeSmallBroadcastSender(this);
//        sender.send();
//    }
//
//    public void home_AR_Notify() {
//        IBroadcastSender sender=new CmdAppRightBroadcastSender(this);
//        sender.send();
//    }
//
//    public void home_AB_Notify() {
//        IBroadcastSender sender=new CmdAppBottomBroadcastSender(this);
//        sender.send();
//    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("HomeAppActivityBase", "onStart");
//        this.istAdBroadcastReceiver.register();
//        this.istAppBottomBroadcastReceiver.register();
//        this.istAppRightBroadcastReceiver.register();
//        this.istBackBroadcastReceiver.register();
//        this.istDownBroadcastReceiver.register();
//        this.istHomeBroadcastReceiver.register();
//        this.istLeftBroadcastReceiver.register();
//        this.istModeFullBroadcastReceiver.register();
//        this.istModeSmallBroadcastReceiver.register();
//        this.istOkBroadcastReceiver.register();
//        this.istRightBroadcastReceiver.register();
//        this.istUpBroadcastReceiver.register();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode >= this.getIRReceiver().getNumberStartCode() && keyCode <= this.getIRReceiver().getNumberStartCode() + 9) {
            int numberCode = keyCode - this.getIRReceiver().getNumberStartCode();
            this.numberKeyClick(numberCode);
        } else {
            boolean keyHandle = false;
            if (keyCode == this.getIRReceiver().getUpCode() && keyHandle == false) {
                this.uPKeyClick();
                keyHandle = true;
            }
            if (keyCode == this.getIRReceiver().getDownCode() && keyHandle == false) {
                this.downKeyClick();
                keyHandle = true;
            }
            if (keyCode == this.getIRReceiver().getLeftCode() && keyHandle == false) {
                this.leftKeyClick();
                keyHandle = true;
            }
            if (keyCode == this.getIRReceiver().getRightCode() && keyHandle == false) {
                this.rightKeyClick();
                keyHandle = true;
            }
            if (keyCode == this.getIRReceiver().getOkCode() && keyHandle == false) {
                this.okKeyClick();
                keyHandle = true;
            }
            if (keyCode == 4 && keyHandle == false) {
                this.backKeyClick();
                keyHandle = true;
            }
            if (keyCode == 183 && keyHandle == false) {
                this.homeKeyClick();
                keyHandle = true;
            }
            if (keyHandle == false) {
                this.otherKeyClick(keyCode);
            }
        }
        return false;
    }

    private void otherKeyClick(int keyCode) {
        if (this.iRKeyboardReceiverDelegateListener != null) {
            boolean handle = this.iRKeyboardReceiverDelegateListener.otherKeyClick(keyCode);
            if (handle == false)
                this.onOtherKey(keyCode);

        } else {
            this.onOtherKey(keyCode);
        }
    }

    private void numberKeyClick(int number) {
        if (this.iRKeyboardReceiverDelegateListener != null) {
            boolean handle = this.iRKeyboardReceiverDelegateListener.numberKeyClick(number);
            if (handle == false)
                this.onNumberKey(number);

        } else {
            this.onNumberKey(number);
        }
    }

    private void uPKeyClick() {
        if (this.iRKeyboardReceiverDelegateListener != null) {
            boolean handle = this.iRKeyboardReceiverDelegateListener.upKeyClick();
            if (handle == false)
                this.onUpKey();

        } else {
            this.onUpKey();
        }
    }

    private void downKeyClick() {
        if (this.iRKeyboardReceiverDelegateListener != null) {
            boolean handle = this.iRKeyboardReceiverDelegateListener.downKeyClick();
            if (handle == false)
                this.onDownKey();

        } else {
            this.onDownKey();
        }
    }

    private void leftKeyClick() {
        if (this.iRKeyboardReceiverDelegateListener != null) {
            boolean handle = this.iRKeyboardReceiverDelegateListener.leftKeyClick();
            if (handle == false)
                this.onLeftKey();

        } else {
            this.onLeftKey();
        }
    }

    private void rightKeyClick() {
        if (this.iRKeyboardReceiverDelegateListener != null) {
            boolean handle = this.iRKeyboardReceiverDelegateListener.rightKeyClick();
            if (handle == false)
                this.onRightKey();

        } else {
            this.onRightKey();
        }
    }

    private void okKeyClick() {
        if (this.iRKeyboardReceiverDelegateListener != null) {
            boolean handle = this.iRKeyboardReceiverDelegateListener.okKeyClick();
            if (handle == false)
                this.onOkKey();

        } else {
            this.onOkKey();
        }
    }

    private void backKeyClick() {
        if (this.iRKeyboardReceiverDelegateListener != null) {
            boolean handle = this.iRKeyboardReceiverDelegateListener.backKeyClick();
            if (handle == false)
                this.onBackKey();

        } else {
            this.onBackKey();
        }
    }

    private void homeKeyClick() {
        if (this.iRKeyboardReceiverDelegateListener != null) {
            boolean handle = this.iRKeyboardReceiverDelegateListener.homeKeyClick();
            if (handle == false)
                this.onHomeKey();

        } else {
            this.onHomeKey();
        }
    }

    protected void onOtherKey(int keyCode) {
//        Toast.makeText(this, "Base_IR_Other:" + keyCode,
//                Toast.LENGTH_LONG).show();
    }

    protected void onNumberKey(int number) {
//        Toast.makeText(this, "Base_IR_Number:" + number,
//                Toast.LENGTH_LONG).show();
    }

    protected void onUpKey() {
//        Toast.makeText(this, "Base_IR_Up",
//                Toast.LENGTH_LONG).show();
    }

    protected void onDownKey() {
//        Toast.makeText(this, "Base_IR_Down",
//                Toast.LENGTH_LONG).show();
    }

    protected void onLeftKey() {
//        Toast.makeText(this, "Base_IR_Left",
//                Toast.LENGTH_LONG).show();
    }

    protected void onRightKey() {
//        Toast.makeText(this, "Base_IR_Right",
//                Toast.LENGTH_LONG).show();
    }

    protected void onOkKey() {
//        Toast.makeText(this, "Base_IR_Ok",
//                Toast.LENGTH_LONG).show();
    }

    protected void onBackKey() {
//        Toast.makeText(this, "Base_IR_Back",
//                Toast.LENGTH_LONG).show();

//        this.tvObject.toHideMode();
//        this.tvObject.toFullMode();
        this.toTvFullMode();
        this.finish();

    }

    //
    protected void onHomeKey() {
        IBroadcastSender sender = new HomeHomeKeyBroadcastSender(this, "itri.smarttvhome.activities.HomeActivity");
        sender.send();

//        this.tvObject.toHideMode();
//        this.tvObject.toFullMode();
        this.toTvFullMode();
        this.finish();
    }

    @Override
    protected void onStop() {
//        this.istAdBroadcastReceiver.unregister();
//        this.istAppBottomBroadcastReceiver.unregister();
//        this.istAppRightBroadcastReceiver.unregister();
//        this.istBackBroadcastReceiver.unregister();
//        this.istDownBroadcastReceiver.unregister();
//        this.istHomeBroadcastReceiver.unregister();
//        this.istLeftBroadcastReceiver.unregister();
//        this.istModeFullBroadcastReceiver.unregister();
//        this.istModeSmallBroadcastReceiver.unregister();
//        this.istOkBroadcastReceiver.unregister();
//        this.istRightBroadcastReceiver.unregister();
//        this.istUpBroadcastReceiver.unregister();
        super.onStop();
    }
}
