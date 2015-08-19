package tw.futureInsighters.Tv;

import tw.futureInsighters.Tv.R;

import itri.smarttvhome.activities.DeveloperActivity;
//import itri.smarttvhome.activities.HomeActivity;
//import itri.smarttvhome.activities.HomeActivity.NetworkAvaiableTimerTask;
//import itri.smarttvhome.activities.HomeActivity.ToChannelHitInVisibleTimerTask;
//import itri.smarttvhome.activities.HomeActivity.ToChannelTimerTask;
import itri.smarttvhome.androidservices.HTTPService;
import itri.smarttvhome.bizs.tVContexts.BoxType;
import itri.smarttvhome.bizs.tVContexts.ChannelFailEventArgs;
import itri.smarttvhome.bizs.tVContexts.IRSenderType;
import itri.smarttvhome.bizs.tVContexts.ITVPlayerDelegateListener;
import itri.smarttvhome.bizs.tVContexts.ModeChangedEventArgs;
import itri.smarttvhome.bizs.tVContexts.SourceType;
import itri.smarttvhome.bizs.tVContexts.TVContextFactory;
import itri.smarttvhome.bizs.tVContexts.tVPlayer.ChannelChangedEventArgs;
import itri.smarttvhome.broadcastReceivers.AppChangeBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.IAppChangeBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.ISetBadgeBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.ITipStatusChangeBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.IWorkItemIntentBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.SetBadgeBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.TipStatusChangeBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.TipStatusEventArgs;
import itri.smarttvhome.broadcastReceivers.WorkItemIntentBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.commands.CmdAdReceiveBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.commands.CmdAppBottomReceiveBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.commands.CmdAppRightReceiveBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.commands.CmdBackReceiveBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.commands.CmdDownReceiveBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.commands.CmdHomeReceiveBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.commands.CmdLeftReceiveBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.commands.CmdModeFullReceiveBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.commands.CmdModeSmallReceiveBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.commands.CmdOkReceiveBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.commands.CmdRightReceiveBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.commands.CmdUpReceiveBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.commands.ICmdAdReceiveBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.commands.ICmdAppRightReceiveBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.commands.ICmdBackReceiveBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.commands.ICmdDownReceiveBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.commands.ICmdHomeReceiveBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.commands.ICmdLeftReceiveBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.commands.ICmdModeFullReceiveBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.commands.ICmdModeSmallReceiveBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.commands.ICmdOkReceiveBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.commands.ICmdRightReceiveBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.commands.ICmdUpReceiveBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.dropTips.DropTipOffBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.dropTips.DropTipOffBroadcastReceiverEventArgs;
import itri.smarttvhome.broadcastReceivers.dropTips.DropTipOnBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.dropTips.DropTipOnBroadcastReceiverEventArgs;
import itri.smarttvhome.broadcastReceivers.dropTips.IDropTipOffBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.dropTips.IDropTipOnBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.homes.HomeBackKeyBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.homes.HomeDownKeyBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.homes.HomeHomeKeyBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.homes.HomeLeftKeyBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.homes.HomeNumberKeyBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.homes.HomeOkKeyBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.homes.HomeOtherKeyBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.homes.HomeRightKeyBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.homes.HomeUpKeyBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.homes.IHomeBackKeyBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.homes.IHomeDownKeyBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.homes.IHomeHomeKeyBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.homes.IHomeLeftKeyBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.homes.IHomeNumberKeyBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.homes.IHomeOkKeyBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.homes.IHomeOtherKeyBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.homes.IHomeRightKeyBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.homes.IHomeUpKeyBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.sysitems.ISysItemAllAppReceiveBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.sysitems.ISysItemCallBackReceiveBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.sysitems.ISysItemSettingReceiveBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.sysitems.SysItemAllAppReceiveBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.sysitems.SysItemCallBackReceiveBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.sysitems.SysItemSettingReceiveBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.tVContexts.FreeModeEventArgs;
import itri.smarttvhome.broadcastReceivers.tVContexts.ITVBottomModeBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.tVContexts.ITVFreeModeBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.tVContexts.ITVFreePreviewModeBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.tVContexts.ITVFullModeBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.tVContexts.ITVHideModeBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.tVContexts.ITVPreviewModeBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.tVContexts.ITVRightModeBroadcastReceiverDelegateListener;
import itri.smarttvhome.broadcastReceivers.tVContexts.TVBottomModeBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.tVContexts.TVFreeModeBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.tVContexts.TVFreePreviewModeBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.tVContexts.TVFullModeBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.tVContexts.TVHideModeBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.tVContexts.TVPreviewModeBroadcastReceiver;
import itri.smarttvhome.broadcastReceivers.tVContexts.TVRightModeBroadcastReceiver;
import itri.smarttvhome.broadcastSenders.ChannelChangeBroadcastSender;
import itri.smarttvhome.broadcastSenders.HomeCompletedSender;
import itri.smarttvhome.views.frameviews.ChannelView;
import itri.smarttvhome.views.frameviews.DrowTipFloatView;
import itri.smarttvhome.views.frameviews.SysTrayFloatView;
import itri.smarttvhome.views.screenmodeappviews.ScreenModeAppHostViewBase;
import itri.smarttvhome.views.sysviews.AllAppFloatView;
import itri.smarttvhome.views.sysviews.ISysFloatViewDelegateListener;
import itri.smarttvhome.views.sysviews.SysViewBase;
import itri.smarttvhome.views.sysviews.SysViewFloatBase;
import itri.smarttvsdk.activities.HomeAppActivityBase;
import itri.smarttvsdk.bizs.EventArgs;
import itri.smarttvsdk.bizs.persists.PersistManager;
import itri.smarttvsdk.bizs.tVContexts.IRReceiverType;
import itri.smarttvsdk.bizs.workItems.IWorkItem;
import itri.smarttvsdk.broadcastSenders.IBroadcastSender;
import itri.smarttvsdk.broadcastSenders.commands.CmdUpBroadcastSender;
import itri.smarttvsdk.broadcastSenders.instructions.IstAppBottomBroadcastSender;
import itri.smarttvsdk.broadcastSenders.instructions.IstAppRightBroadcastSender;
import itri.smarttvsdk.broadcastSenders.instructions.IstBackBroadcastSender;
import itri.smarttvsdk.broadcastSenders.instructions.IstDownBroadcastSender;
import itri.smarttvsdk.broadcastSenders.instructions.IstHomeBroadcastSender;
import itri.smarttvsdk.broadcastSenders.instructions.IstLeftBroadcastSender;
import itri.smarttvsdk.broadcastSenders.instructions.IstModeFullBroadcastSender;
import itri.smarttvsdk.broadcastSenders.instructions.IstModeSmallBroadcastSender;
import itri.smarttvsdk.broadcastSenders.instructions.IstOkBroadcastSender;
import itri.smarttvsdk.broadcastSenders.instructions.IstRightBroadcastSender;
import itri.smarttvsdk.broadcastSenders.instructions.IstUpBroadcastSender;

import java.io.DataOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.allseenaliance.alljoyn.AllJoynService;
import org.allseenaliance.alljoyn.Observable;
import org.allseenaliance.alljoyn.Observer;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mimi on 15/3/25.
 */
public class MainActivity extends HomeAppActivityBase implements Observer,
		ISysFloatViewDelegateListener {

	/* SDK - smarttvhome variables */
	private final String HDMI_CLOSE_SCALE = "com.mitrastar.intent.closescale.action";
	private final String HDMI_SET_SCALE = "com.mitrastar.intent.setscale.action";

	/* control CMD */
	private final int appIconWidth = 100;
	/* part1: client to TV CMD */
	private final String CONTROLLER_CMD_UI_LEFT = "ISTVSgoleft";
	private final String CONTROLLER_CMD_UI_RIGHT = "ISTVSgoright";
	private final String CONTROLLER_CMD_UI_OK = "ISTVSok";
	private final String CONTROLLER_CMD_UI_RETURN = "ISTVSreturn";
	private final String CONTROLLER_CMD_UI_SHOW_HISTORY = "ISTVSsh";
	private final String CONTROLLER_CMD_UI_SHOW_BOOKMARK = "ISTVSsb";
	private final String CONTROLLER_CMD_UI_HIDE_HISTORY = "ISTVShh";
	private final String CONTROLLER_CMD_UI_HIDE_BOOKMARK = "ISTVShb";
	private final String CONTROLLER_CMD_VOLUME = "ISTVSvl";
	private final String CONTROLLER_CMD_CHANNEL = "ISTVScn";
	private final String CONTROLLER_CMD_GET_CUR_CHANNEL = "ISTVScurchannelinfo";
	private final String CONTROLLER_CMD_HOME = "ISTVShome";
	final private String CONTROLLER_NOTIFICATION_SYSNOTI = "ISTVSsysnoti";
	final private String CONTROLLER_CMD_HIDE_APPSLIST = "ISTVShal";
	/* part2: TV to client CMD */
	private final String TV_RESPONSE_CHANNEL = "SVTSIcurchannel";
	private final String TV_RESPONSE_CHANNEL_INFO = "SVTSIcurchannelinfo";
	private final String TV_RESPONSE_APPSLISTON = "SVTSIappsliston";
	private final String TV_RESPONSE_APPSLISTOFF = "SVTSIappslistoff";

	private enum Direction {
		LEFT, RIGHT
	};

	private enum UIStatus {
		OPEN, CLOSED
	}

	/* channel info */
	private ChannelInfo curChannelInfo;

	private class ChannelInfo {
		String name = "No Channel Name";
		int number = 0;
		String intro = "No Introduction";
		Boolean isAds = false;
	}

	/* App List (the same with launcher */
	private List<ResolveInfo> apps;
	private int totalApp;

	private boolean scrollAllowed = true;
	private int curFocusApp = 5;
	private int screenWidth;

	private UIStatus appsListStatus = UIStatus.CLOSED;

	/* views */
	// private UIStatus bookmarkViewStatus = UIStatus.CLOSED;
	// private UIStatus historyViewStatus = UIStatus.CLOSED;

	/* alljoyn */
	private Button join;
	private Button stop;
	private Button start;
	private Button leave;
	// private Button sendjson;

	private MainApplication mChatApplication = null;
	// private TextView preview;
	// private EditText edit;

	private static final int HANDLE_APPLICATION_QUIT_EVENT = 0;
	private static final int HANDLE_CHANNEL_STATE_CHANGED_EVENT = 1;
	private static final int HANDLE_ALLJOYN_ERROR_EVENT = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homeactivity);

		/* SDK - smarttvhome */

		// hdmi signal
//		Intent ic = new Intent(HDMI_CLOSE_SCALE);
//		MainActivity.this.sendBroadcast(ic);
		 fullHandle();
		// previewHandle();

		this.container = (RelativeLayout) this.findViewById(R.id.container);

		this.tVContextFactory = new TVContextFactory(this,
				BoxType.UPMOST_ATV300, IRReceiverType.UPMOST_ATV300,
				IRSenderType.Null, SourceType.RTSP,
				// MSO 1
				1, this.container);

//		this.tVContextFactory = new TVContextFactory(this, BoxType.MitraStar,
//				IRReceiverType.MitraStar, IRSenderType.TBC,
//				SourceType.MitraStarHdmiIn, 1,
//				this.container);
		
		/* turn on channel player at the beginning by turn one channel */
		this.tVContextFactory.getTvPlayer().toNextChannel();

		
//		this.tVContextFactory = new TVContextFactory(this, BoxType.MitraStar,
//				IRReceiverType.MitraStar, IRSenderType.TBC,
//				SourceType.MitraStarHdmiIn, ProgramProviderType.TBC,
//				this.container);

		// Toast.makeText(MainActivity.this, "onPower_Channel:" +
		// this.tVContextFactory.getTvPlayer().getChannel(),
		// Toast.LENGTH_LONG).show();

		// this.imageView = (ImageView) this.findViewById(R.id.imageView);
		// this.tvHomeService = new TVHomeService(this.uiHandler);

		// this.tvvTV = new MitraStarTVView(this);

		// this.tvTip = (TextView) this.findViewById(R.id.tvTip);
		// this.tvTip.setVisibility(View.INVISIBLE);

		// this.apPlaceHoldFull = (FullScreenModeAppHostView)
		// this.findViewById(R.id.apPlaceHoldFull);
		// this.apPlaceHoldBottom = (BottomScreenModeAppHostView)
		// this.findViewById(R.id.apPlaceHoldBottom);
		// this.apPlaceHoldRight = (RightScreenModeAppHostView)
		// this.findViewById(R.id.apPlaceHoldRight);

		this.cmdHomeReceiveBroadcastReceiver = new CmdHomeReceiveBroadcastReceiver(
				this);
		this.cmdHomeReceiveBroadcastReceiver
				.setDelegateListener(new ICmdHomeReceiveBroadcastReceiverDelegateListener() {
					@Override
					public void onCmdReceiver() {
						IBroadcastSender sender = new IstHomeBroadcastSender(
								MainActivity.this);
						sender.send();
						homeKeyHandle();
					}
				});

		this.cmdBackReceiveBroadcastReceiver = new CmdBackReceiveBroadcastReceiver(
				this);
		this.cmdBackReceiveBroadcastReceiver
				.setDelegateListener(new ICmdBackReceiveBroadcastReceiverDelegateListener() {
					@Override
					public void onCmdReceiver() {
						IBroadcastSender sender = new IstBackBroadcastSender(
								MainActivity.this);
						sender.send();
						backKeyHandle();
					}
				});

		this.cmdUpReceiveBroadcastReceiver = new CmdUpReceiveBroadcastReceiver(
				this);
		this.cmdUpReceiveBroadcastReceiver
				.setDelegateListener(new ICmdUpReceiveBroadcastReceiverDelegateListener() {
					@Override
					public void onCmdReceiver() {
						IBroadcastSender sender = new IstUpBroadcastSender(
								MainActivity.this);
						sender.send();
						upKeyHandle();
					}
				});

		this.cmdDownReceiveBroadcastReceiver = new CmdDownReceiveBroadcastReceiver(
				this);
		this.cmdDownReceiveBroadcastReceiver
				.setDelegateListener(new ICmdDownReceiveBroadcastReceiverDelegateListener() {
					@Override
					public void onCmdReceiver() {
						IBroadcastSender sender = new IstDownBroadcastSender(
								MainActivity.this);
						sender.send();
						downKeyHandle();
					}
				});

		this.cmdLeftReceiveBroadcastReceiver = new CmdLeftReceiveBroadcastReceiver(
				this);
		this.cmdLeftReceiveBroadcastReceiver
				.setDelegateListener(new ICmdLeftReceiveBroadcastReceiverDelegateListener() {
					@Override
					public void onCmdReceiver() {
						IBroadcastSender sender = new IstLeftBroadcastSender(
								MainActivity.this);
						sender.send();
						leftKeyHandle();
					}
				});

		this.cmdRightReceiveBroadcastReceiver = new CmdRightReceiveBroadcastReceiver(
				this);
		this.cmdRightReceiveBroadcastReceiver
				.setDelegateListener(new ICmdRightReceiveBroadcastReceiverDelegateListener() {
					@Override
					public void onCmdReceiver() {
						IBroadcastSender sender = new IstRightBroadcastSender(
								MainActivity.this);
						sender.send();
						rightKeyHandle();
					}
				});

		this.cmdOkReceiveBroadcastReceiver = new CmdOkReceiveBroadcastReceiver(
				this);
		this.cmdOkReceiveBroadcastReceiver
				.setDelegateListener(new ICmdOkReceiveBroadcastReceiverDelegateListener() {
					@Override
					public void onCmdReceiver() {
						IBroadcastSender sender = new IstOkBroadcastSender(
								MainActivity.this);
						sender.send();
						okKeyHandle();
					}
				});

		this.cmdModeFullReceiveBroadcastReceiver = new CmdModeFullReceiveBroadcastReceiver(
				this);
		this.cmdModeFullReceiveBroadcastReceiver
				.setDelegateListener(new ICmdModeFullReceiveBroadcastReceiverDelegateListener() {
					@Override
					public void onCmdReceiver() {
						IBroadcastSender sender = new IstModeFullBroadcastSender(
								MainActivity.this);
						sender.send();
						// tvvTV.toFullMode();
						tVContextFactory.getTvPlayer().toFullMode();
					}
				});

		this.cmdModeSmallReceiveBroadcastReceiver = new CmdModeSmallReceiveBroadcastReceiver(
				this);
		this.cmdModeSmallReceiveBroadcastReceiver
				.setDelegateListener(new ICmdModeSmallReceiveBroadcastReceiverDelegateListener() {
					@Override
					public void onCmdReceiver() {
						IBroadcastSender sender = new IstModeSmallBroadcastSender(
								MainActivity.this);
						sender.send();
						// tvvTV.toPreviewMode();
						tVContextFactory.getTvPlayer().toPreviewMode();
					}
				});

		this.cmdAppRightReceiveBroadcastReceiver = new CmdAppRightReceiveBroadcastReceiver(
				this);
		this.cmdAppRightReceiveBroadcastReceiver
				.setDelegateListener(new ICmdAppRightReceiveBroadcastReceiverDelegateListener() {
					@Override
					public void onCmdReceiver() {
						IBroadcastSender sender = new IstAppRightBroadcastSender(
								MainActivity.this);
						sender.send();
						// tvvTV.toRightMode();
						tVContextFactory.getTvPlayer().toRightMode();
					}
				});

		this.cmdAppBottomReceiveBroadcastReceiver = new CmdAppBottomReceiveBroadcastReceiver(
				this);
		this.cmdAppBottomReceiveBroadcastReceiver
				.setDelegateListener(new ICmdAdReceiveBroadcastReceiverDelegateListener() {
					@Override
					public void onCmdReceiver() {
						IBroadcastSender sender = new IstAppBottomBroadcastSender(
								MainActivity.this);
						sender.send();
						// tvvTV.toBottomMode();
						tVContextFactory.getTvPlayer().toBottomMode();

					}
				});

		this.cmdAdReceiveBroadcastReceiver = new CmdAdReceiveBroadcastReceiver(
				this);
		this.cmdAdReceiveBroadcastReceiver
				.setDelegateListener(new ICmdAdReceiveBroadcastReceiverDelegateListener() {
					@Override
					public void onCmdReceiver() {
						try {
							Process process = Runtime.getRuntime().exec("su");
							DataOutputStream os = new DataOutputStream(process
									.getOutputStream());

							os.writeBytes("/system/bin/screencap -p /sdcard/screen.png\n");
							os.writeBytes("exit\n");
							os.flush();
							os.close();

							process.waitFor();
							Toast.makeText(MainActivity.this, "Ad_Screenshot",
									Toast.LENGTH_LONG).show();
						} catch (Exception e) {
							// e.printStackTrace();

							Toast.makeText(MainActivity.this,
									"Ad_Screenshot_ex:" + e.getMessage(),
									Toast.LENGTH_LONG).show();
						}
					}
				});

		this.sysItemAllAppReceiveBroadcastReceiver = new SysItemAllAppReceiveBroadcastReceiver(
				this);
		this.sysItemAllAppReceiveBroadcastReceiver
				.setDelegateListener(new ISysItemAllAppReceiveBroadcastReceiverDelegateListener() {

					@Override
					public void onActionExecReceiver() {
						AllAppFloatView allAppFloatView = new AllAppFloatView(
								MainActivity.this);
						runSysView = allAppFloatView;
						runSysView.setDelegateListener(MainActivity.this);
					}
				});

		this.sysItemSettingReceiveBroadcastReceiver = new SysItemSettingReceiveBroadcastReceiver(
				this);
		this.sysItemSettingReceiveBroadcastReceiver
				.setDelegateListener(new ISysItemSettingReceiveBroadcastReceiverDelegateListener() {

					@Override
					public void onActionExecReceiver() {

					}
				});

		this.sysItemCallBackReceiveBroadcastReceiver = new SysItemCallBackReceiveBroadcastReceiver(
				this);
		this.sysItemCallBackReceiveBroadcastReceiver
				.setDelegateListener(new ISysItemCallBackReceiveBroadcastReceiverDelegateListener() {

					@Override
					public void onActionExecReceiver() {
						Intent i = new Intent();
						i.setAction("org.itri.icl.droptv.sharetvhome.facebookapp.activities.MainActivity");
						startActivity(i);
					}
				});

		this.appChangeBroadcastReceiver = new AppChangeBroadcastReceiver(this);
		this.appChangeBroadcastReceiver
				.setDelegateListener(new IAppChangeBroadcastReceiverDelegateListener() {
					@Override
					public void appChange() {
						// atvApps.appRefresh();
						// atvApps.hide();
						// if(channel.equals("")==false) {
						// tVContextFactory.getTvPlayer().toChannel(Integer.parseInt(channel));
						// tVContextFactory.getTvPlayer().toChannel(55);
						// }

						channel = getPersistManager().getValue("channel");
						if (channel.equals("") == false) {
							channelPressCount++;
							// tVContextFactory.getTvPlayer().toChannel(Integer.parseInt(channel));
							ToChannelTimerTask myTask = new ToChannelTimerTask();
							Timer myTimer = new Timer();
							// myTimer.schedule(myTask, 5000);
							myTimer.schedule(myTask, 2000);
						}
					}
				});

		this.setBadgeBroadcastReceiver = new SetBadgeBroadcastReceiver(this);
		this.setBadgeBroadcastReceiver
				.setDelegateListener(new ISetBadgeBroadcastReceiverDelegateListener() {
					@Override
					public void setBadge(String packageName, int number) {
					}
				});

		this.workItemIntentBroadcastReceiver = new WorkItemIntentBroadcastReceiver(
				this);
		this.workItemIntentBroadcastReceiver
				.setDelegateListener(new IWorkItemIntentBroadcastReceiverDelegateListener() {
					@Override
					public void workItemIncome(IWorkItem workItem) {
						workItem.execAction();
					}
				});

		this.homeHomeKeyBroadcastReceiver = new HomeHomeKeyBroadcastReceiver(
				this);
		this.homeHomeKeyBroadcastReceiver
				.setDelegateListener(new IHomeHomeKeyBroadcastReceiverDelegateListener() {
					@Override
					public void contextNameAccept(String name) {
						homeKeyHandle();
					}
				});

		this.homeUpKeyBroadcastReceiver = new HomeUpKeyBroadcastReceiver(this);
		this.homeUpKeyBroadcastReceiver
				.setDelegateListener(new IHomeUpKeyBroadcastReceiverDelegateListener() {
					@Override
					public void contextNameAccept(String name) {
						Toast.makeText(MainActivity.this,
								"up_source_Context_Name:" + name,
								Toast.LENGTH_LONG).show();

					}

				});

		this.homeDownKeyBroadcastReceiver = new HomeDownKeyBroadcastReceiver(
				this);
		this.homeDownKeyBroadcastReceiver
				.setDelegateListener(new IHomeDownKeyBroadcastReceiverDelegateListener() {
					@Override
					public void contextNameAccept(String name) {
						Toast.makeText(MainActivity.this,
								"down_source_Context_Name:" + name,
								Toast.LENGTH_LONG).show();

					}

				});

		this.homeLeftKeyBroadcastReceiver = new HomeLeftKeyBroadcastReceiver(
				this);
		this.homeLeftKeyBroadcastReceiver
				.setDelegateListener(new IHomeLeftKeyBroadcastReceiverDelegateListener() {
					@Override
					public void contextNameAccept(String name) {
						Toast.makeText(MainActivity.this,
								"left_source_Context_Name:" + name,
								Toast.LENGTH_LONG).show();
					}

				});

		this.homeRightKeyBroadcastReceiver = new HomeRightKeyBroadcastReceiver(
				this);
		this.homeRightKeyBroadcastReceiver
				.setDelegateListener(new IHomeRightKeyBroadcastReceiverDelegateListener() {
					@Override
					public void contextNameAccept(String name) {
						Toast.makeText(MainActivity.this,
								"right_source_Context_Name:" + name,
								Toast.LENGTH_LONG).show();

					}

				});

		this.homeOkKeyBroadcastReceiver = new HomeOkKeyBroadcastReceiver(this);
		this.homeOkKeyBroadcastReceiver
				.setDelegateListener(new IHomeOkKeyBroadcastReceiverDelegateListener() {
					@Override
					public void contextNameAccept(String name) {
						Toast.makeText(MainActivity.this,
								"ok_source_Context_Name:" + name,
								Toast.LENGTH_LONG).show();

					}

				});

		this.homeBackKeyBroadcastReceiver = new HomeBackKeyBroadcastReceiver(
				this);
		this.homeBackKeyBroadcastReceiver
				.setDelegateListener(new IHomeBackKeyBroadcastReceiverDelegateListener() {
					@Override
					public void contextNameAccept(String name) {
						Toast.makeText(MainActivity.this,
								"back_source_Context_Name:" + name,
								Toast.LENGTH_LONG).show();

					}

				});

		this.homeNumberKeyBroadcastReceiver = new HomeNumberKeyBroadcastReceiver(
				this);
		this.homeNumberKeyBroadcastReceiver
				.setDelegateListener(new IHomeNumberKeyBroadcastReceiverDelegateListener() {
					@Override
					public void numberAccept(int number) {
						// channel = channel + number;
						// channel = right(channel, 3);
						// channelView.setText(channel);
						// channelView.setVisibility(View.VISIBLE);
						// channelPressCount++;
						// ToChannelTimerTask myTask = new ToChannelTimerTask();
						// Timer myTimer = new Timer();
						// myTimer.schedule(myTask, 5000);

					}

					@Override
					public void contextNameAccept(String name) {
						Toast.makeText(MainActivity.this,
								"number_source_Context_Name:" + name,
								Toast.LENGTH_LONG).show();
					}
				});

		this.homeOtherKeyBroadcastReceiver = new HomeOtherKeyBroadcastReceiver(
				this);
		this.homeOtherKeyBroadcastReceiver
				.setDelegateListener(new IHomeOtherKeyBroadcastReceiverDelegateListener() {
					@Override
					public void otherAccept(int keycode) {
						Toast.makeText(MainActivity.this,
								"other_keycode:" + keycode, Toast.LENGTH_LONG)
								.show();
					}

					@Override
					public void contextNameAccept(String name) {

						// Toast.makeText(MainActivity.this,
						// "other_source_Context_Name:"+name,
						// Toast.LENGTH_LONG).show();
					}
				});

		// this.channelView=new ChannelView(this);
		this.stvSyses = new SysTrayFloatView(this);
		// this.atvApps = new AppTrayFloatView(this);
		this.drowTipFlowView = new DrowTipFloatView(this);
		// this.atvApps.setDelegateListener(new IAppTrayViewDelegateListener() {
		// @Override
		// public void showBack() {
		// tvTip.setVisibility(View.INVISIBLE);
		// }
		//
		// @Override
		// public void hideBack() {
		// if (MainActivity.this.tipNumber > 0) {
		// // tvvTV.toHideMode();
		// tVContextFactory.getTvPlayer().toHideMode();
		// tvTip.setVisibility(View.VISIBLE);
		// }
		// }

		// @Override
		// public void itemActionRun() {
		// // tvvTV.toHideMode();
		// tVContextFactory.getTvPlayer().toHideMode();
		// MainActivity.this.tipNumber = atvApps.getTotalBadgeNumber();
		// if (MainActivity.this.tipNumber > 0) {
		// tvTip.setVisibility(View.VISIBLE);
		// } else {
		// tvTip.setVisibility(View.INVISIBLE);
		// }
		//
		// tvTip.setText(MainActivity.this.tipNumber + "");
		// }
		// });

		this.tVBottomModeBroadcastReceiver = new TVBottomModeBroadcastReceiver(
				this);
		this.tVBottomModeBroadcastReceiver
				.setDelegateListener(new ITVBottomModeBroadcastReceiverDelegateListener() {
					@Override
					public void receive(Object sender, EventArgs args) {
						// Log.e("HomeActivity", "BottomReceiveHanlde");
						tVContextFactory.getTvPlayer().toBottomMode();
					}
				});

		this.tVFreeModeBroadcastReceiver = new TVFreeModeBroadcastReceiver(this);
		this.tVFreeModeBroadcastReceiver
				.setDelegateListener(new ITVFreeModeBroadcastReceiverDelegateListener() {
					@Override
					public void receive(Object sender, FreeModeEventArgs args) {
						// Log.e("HomeActivity",
						// "FreeReceiveHanlde_x:"+args.getX()+"_y:"+args.getY()+"_width:"+args.getWidth()+"_height:"+args.getHeight());
						tVContextFactory.getTvPlayer().toFreeMode(args.getX(),
								args.getY(), args.getWidth(), args.getHeight());
					}

					@Override
					public void receive(Object sender, EventArgs args) {
						Log.e("HomeActivity", "FreeReceiveHanlde");
					}
				});
		this.tVFreePreviewModeBroadcastReceiver = new TVFreePreviewModeBroadcastReceiver(
				this);
		this.tVFreePreviewModeBroadcastReceiver
				.setDelegateListener(new ITVFreePreviewModeBroadcastReceiverDelegateListener() {
					@Override
					public void receive(Object sender, FreeModeEventArgs args) {
						// Log.e("HomeActivity",
						// "FreePreviewReceiveHanlde_x:"+args.getX()+"_y:"+args.getY()+"_width:"+args.getWidth()+"_height:"+args.getHeight());
						tVContextFactory.getTvPlayer().toFreePreviewMode(
								args.getX(), args.getY(), args.getWidth(),
								args.getHeight());
					}

					@Override
					public void receive(Object sender, EventArgs args) {
						Log.e("HomeActivity", "FreePreviewReceiveHanlde");
					}
				});
		this.tVFullModeBroadcastReceiver = new TVFullModeBroadcastReceiver(this);
		this.tVFullModeBroadcastReceiver
				.setDelegateListener(new ITVFullModeBroadcastReceiverDelegateListener() {
					@Override
					public void receive(Object sender, EventArgs args) {
						// Log.e("HomeActivity", "FullReceiveHanlde");
						tVContextFactory.getTvPlayer().toFullMode();
					}
				});
		this.tVHideModeBroadcastReceiver = new TVHideModeBroadcastReceiver(this);
		this.tVHideModeBroadcastReceiver
				.setDelegateListener(new ITVHideModeBroadcastReceiverDelegateListener() {
					@Override
					public void receive(Object sender, EventArgs args) {
						// Log.e("HomeActivity", "HideReceiveHanlde");
						tVContextFactory.getTvPlayer().toHideMode();
					}
				});
		this.tVPreviewModeBroadcastReceiver = new TVPreviewModeBroadcastReceiver(
				this);
		this.tVPreviewModeBroadcastReceiver
				.setDelegateListener(new ITVPreviewModeBroadcastReceiverDelegateListener() {
					@Override
					public void receive(Object sender, EventArgs args) {
						Log.e("HomeActivity", "PreviewReceiveHanlde");
						tVContextFactory.getTvPlayer().toPreviewMode();
					}
				});
		this.tVRightModeBroadcastReceiver = new TVRightModeBroadcastReceiver(
				this);
		this.tVRightModeBroadcastReceiver
				.setDelegateListener(new ITVRightModeBroadcastReceiverDelegateListener() {
					@Override
					public void receive(Object sender, EventArgs args) {
						// Log.e("HomeActivity", "RightReceiveHanlde");
						tVContextFactory.getTvPlayer().toRightMode();
					}
				});

		this.tipStatusBroadcastReceiver = new TipStatusChangeBroadcastReceiver(
				this);

		this.tipStatusBroadcastReceiver
				.setDelegateListener(new ITipStatusChangeBroadcastReceiverDelegateListener() {
					@Override
					public void receive(Object sender, TipStatusEventArgs args) {
						Log.e("HomeActivity",
								"receive_serviceName:" + args.getServiceName()
										+ "_TipStatus:" + args.getTipStatus());
						// Toast.makeText(MainActivity.this,
						// "receive_serviceName:" +
						// args.getServiceName()+"_TipStatus:"+args.getTipStatus(),
						// Toast.LENGTH_LONG).show();

					}
				});

		this.dropTipOnBroadcastReceiver = new DropTipOnBroadcastReceiver(this);

		this.dropTipOnBroadcastReceiver
				.setDelegateListener(new IDropTipOnBroadcastReceiverDelegateListener() {
					@Override
					public void onReceiver(Object sender,
							DropTipOnBroadcastReceiverEventArgs eventArgs) {
						System.gc();
						dropTipOnData = eventArgs;
						drowTipFlowViewShow(true);
					}
				});

		this.dropTipOffBroadcastReceiver = new DropTipOffBroadcastReceiver(this);

		this.dropTipOffBroadcastReceiver
				.setDelegateListener(new IDropTipOffBroadcastReceiverDelegateListener() {

					@Override
					public void onReceiver(Object sender,
							DropTipOffBroadcastReceiverEventArgs eventArgs) {
						if (dropTipOnData != null) {
							if (dropTipOnData.getDropTipId().equals(
									eventArgs.getDropTipId())) {
								drowTipFlowView.hideAnimal();
								dropTipOnData = null;
							}
						} else {
							drowTipFlowView.hideAnimal();
							dropTipOnData = null;
						}
					}
				});
		this.onCreateIRSender();

		this.tVContextFactory.getTvPlayer().setDelegateListener(
				new ITVPlayerDelegateListener() {
					@Override
					public void channelChanged(Object sender,
							ChannelChangedEventArgs args) {
						Log.e("HomeActivity",
								"channelChanged:" + args.getChannel());
						// Log.e("HomeActivity", "ChannelAddress:" +
						// tVContextFactory.getTvPlayer().getChannelAddress());
						// tVContextFactory.getSender().sendIRNumberCommand(args.getChannel());
						new ChannelChangeBroadcastSender(MainActivity.this,
								args.getChannel(), USERID, tVContextFactory
										.getMsoid(), tVContextFactory
										.getTvPlayer().getChannelAddress())
								.send();

					}

					@Override
					public void channelFail(Object sender,
							ChannelFailEventArgs args) {
						Log.e("HomeActivity",
								"channelFail_message:" + args.getMessage());
						Toast.makeText(MainActivity.this, args.getMessage(),
								Toast.LENGTH_LONG).show();
					}

					@Override
					public void modeChanged(Object sender,
							ModeChangedEventArgs args) {
					}
				});

		// ä¸€èˆ¬App å�¯ä»¥ç›´æŽ¥é–‹å•“AllJoyn ç¶²è·¯æŽ¢ç´¢åŠŸèƒ½
		// ç•¶Launcher æ™‚ä¸�èƒ½ç›´æŽ¥é–‹å•“,å› ç‚ºReboot è·‘ Launcher
		// æ™‚,ç¶²è·¯æœªå¿…Ready,éœ€ç­‰ä¸€æ®µæ™‚é–“ç¶²è·¯æ‰�Avaiable,é€™æ™‚æ‰�èƒ½åŸ·è¡Œ
		// AllJoynç¶²è·¯æŽ¢ç´¢åŠŸèƒ½,è®“å…¶ä»–Dervices çŸ¥é�“æ­¤ä¸»æ©Ÿå­˜åœ¨
		TimerTask networkAvaiableTimerTask = new NetworkAvaiableTimerTask();
		networkAvaiableTimerTask.run();

		new HomeCompletedSender(this).send();

		Intent intentHTTPService;
		intentHTTPService = new Intent(this, HTTPService.class);
		this.startService(intentHTTPService);

		/******************** End of SDK - smarttvhome **********************/

		/* get alljoyn service */
		mChatApplication = (MainApplication) getApplication();

		/* channel info */
		curChannelInfo = new ChannelInfo();

		Toast.makeText(this, "Channel:" + this.getChannelNumber(),
				Toast.LENGTH_SHORT).show();

		/* app list initialize */
		getScreenSize();
		// showAppsList();

		// startNotificationView();

		// new android.os.Handler().postDelayed(new Runnable() {
		// public void run() {
		//
		// }
		// }, 4000);

		// Alljoyn
		start = new Button(getApplicationContext());
		stop = new Button(getApplicationContext());
		join = new Button(getApplicationContext());

		leave = new Button(getApplicationContext());

		stop.setEnabled(false);
		// sendjson.setEnabled(false);
		leave.setEnabled(false);

		// sendjson.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View arg0) {
		//
		// String s = edit.getText().toString() + "";
		//
		// mChatApplication.newLocalUserMessage(s);
		//
		// edit.setText("");
		//
		// }
		// });

		// Start channel
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				mChatApplication.hostSetChannelName("FutureInsighters");
				mChatApplication.hostInitChannel();
				mChatApplication.hostStartChannel();

				start.setEnabled(false);

				stop.setEnabled(true);

			}
		});

		// Simulate click start button
		// new android.os.Handler().postDelayed(new Runnable() {
		// public void run() {
		// start.performClick();
		// }
		// }, 3000);

		// Stop server (Useless)
		stop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mChatApplication.hostStopChannel();

				stop.setEnabled(false);
				start.setEnabled(true);
				leave.setEnabled(false);
				// sendjson.setEnabled(false);

			}
		});

		// Find and join channel
		join.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// final Dialog dialog = new Dialog(MainActivity.this);
				// dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
				// dialog.setContentView(R.layout.usejoindialog);

				// Find the channel in the channel list
				ArrayAdapter<String> channelListAdapter = new ArrayAdapter<String>(
						MainActivity.this, android.R.layout.test_list_item);
				final ListView channelList = new ListView(
						getApplicationContext());
				channelList.setAdapter(channelListAdapter);

				List<String> channels = mChatApplication.getFoundChannels();

				for (String channel : channels) {
					int lastDot = channel.lastIndexOf('.');
					if (lastDot < 0) {
						continue;
					}
					channelListAdapter.add(channel.substring(lastDot + 1));
				}
				channelListAdapter.notifyDataSetChanged();

				String name = "";
				boolean found = false;
				// We find the channel named "FutureInsighters"
				for (int i = 0; i < channels.size(); i++) {
					name = channelList.getItemAtPosition(i).toString();
					if (name.equals("FutureInsighters")) {
						found = true;
					}
				}
				// If not found, retry
				if (!found) {
					new android.os.Handler().postDelayed(new Runnable() {
						public void run() {
							Toast.makeText(getApplicationContext(),
									"Initialization failed. Retrying...",
									Toast.LENGTH_SHORT).show();
							join.performClick();
						}
					}, 1000);
					return;
				}
				Toast.makeText(getApplicationContext(),
						"Initialized. Have a good day!", Toast.LENGTH_SHORT)
						.show();

				// Set channel name and join
				mChatApplication.useSetChannelName(name);
				mChatApplication.useJoinChannel();

				start.setEnabled(false);
				stop.setEnabled(false);
				join.setEnabled(false);
				// sendjson.setEnabled(true);
				leave.setEnabled(true);

				// Button cancel = (Button) dialog
				// .findViewById(R.id.useJoinCancel);
				// cancel.setOnClickListener(new View.OnClickListener() {
				// public void onClick(View view) {
				//
				// dialog.dismiss();
				// }
				// });

			}
		});

		// Simulate click join button
		new android.os.Handler().postDelayed(new Runnable() {
			public void run() {
				join.performClick();
			}
		}, 3000);

		leave.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				mChatApplication.useLeaveChannel();
				mChatApplication.useSetChannelName("Not set");
				leave.setEnabled(false);
				// sendjson.setEnabled(false);

				// start.setEnabled(true);
				stop.setEnabled(true);
				join.setEnabled(true);

			}
		});

		mChatApplication.checkin();

		// updateChannelState();

		mChatApplication.addObserver(this);

		updateChannelState();
	}

	/* view control */

	private void showAppsList() {
		appsListStatus = UIStatus.OPEN;
		BottomView bv = new BottomView(this);
		setAppContentView(bv);
		loadApps();

		mChatApplication.newLocalUserMessage(TV_RESPONSE_APPSLISTON);

	}

	private void startBookmarkView() {
		// bookmarkViewStatus = UIStatus.OPEN;
		appsListStatus = UIStatus.CLOSED;
		mChatApplication.newLocalUserMessage(TV_RESPONSE_APPSLISTOFF);
		BookmarkView fv = new BookmarkView(this);
		this.setAppContentView(fv);
	}

	private void startHistoryView() {
		// historyViewStatus = UIStatus.OPEN;
		appsListStatus = UIStatus.CLOSED;
		mChatApplication.newLocalUserMessage(TV_RESPONSE_APPSLISTOFF);
		HistoryView fv = new HistoryView(this);
		this.setAppContentView(fv);
	}

	private void startNotificationView(String msg) {
		appsListStatus = UIStatus.CLOSED;
		mChatApplication.newLocalUserMessage(TV_RESPONSE_APPSLISTOFF);
		NotificationView nv = new NotificationView(this);
		this.setAppContentView(nv);

		String packageName = msg.substring(0, msg.indexOf(" --"));
		String msgTitle = msg.substring(msg.indexOf(" --") + 3,
				msg.indexOf(" ---"));
		String msgContext = msg.substring(msg.indexOf(" ---") + 4);

		// determine notification image
		final LinearLayout notificationWrapper = (LinearLayout) findViewById(R.id.notificationWrapper);
		final ImageView notificationImage = (ImageView) findViewById(R.id.notificationImage);
		notificationWrapper.setBackgroundColor(0xDD777777);
		if (packageName.equals("com.facebook.orca")) { // facebook
			notificationImage.setImageResource(R.drawable.fb_icon);
		} else if (packageName.equals("jp.naver.line.android")) { // line
			notificationImage.setImageResource(R.drawable.line_icon);
		} else if (packageName.equals("com.twitter.android")) { // twitter
			notificationImage.setImageResource(R.drawable.twitter_icon);
		} else if (packageName.equals("com.skype.android")) { // Skype
			notificationImage.setImageResource(R.drawable.skype_icon);
		} else if (packageName.equals("com.google.android.talk")) { // Hangout
			notificationImage.setImageResource(R.drawable.hangout_icon);
		} else if (packageName.equals("com.google.android.gm")) { // gmail
			notificationImage.setImageResource(R.drawable.gmail_icon);
		} else if (packageName.equals("com.whatsapp")) { // whatsApp
			notificationImage.setImageResource(R.drawable.whatsapp_icon);
		} else if (packageName.equals("com.linkedin.android")) { // linkedIn
			notificationImage.setImageResource(R.drawable.linkedin_icon);
		} else { // other
		}

		final TextView notificationTitle = (TextView) findViewById(R.id.notificationTitle);
		notificationTitle.setText(msgTitle);
		final TextView notificationContext = (TextView) findViewById(R.id.notificationContext);
		notificationContext.setText(msgContext);
	}

	private void hideBottomView() {
		appsListStatus = UIStatus.CLOSED;
		final HorizontalScrollView appsLayout = (HorizontalScrollView) findViewById(R.id.appsLayout);
		appsLayout.animate().translationY(450);
	}

	private void hideBookmarkView() {
		// bookmarkViewStatus = UIStatus.CLOSED();
		final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawerLayout.closeDrawer(Gravity.START);
	}

	private void hideHistoryView() {
		final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawerLayout.closeDrawer(Gravity.END);
	}

	/* IR control handler */

	@Override
	protected void onOtherKey(int keyCode) {
		Toast.makeText(this, "stepbystep_IR_Other:" + keyCode,
				Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onNumberKey(int number) {
		Toast.makeText(this, "stepbystep_IR_Number:" + number,
				Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onUpKey() {
		Toast.makeText(this, "stepbystep_IR_Up", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onDownKey() {
		Toast.makeText(this, "stepbystep_IR_Down", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onLeftKey() {
		Toast.makeText(this, "stepbystep_IR_Left", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onRightKey() {
		Toast.makeText(this, "stepbystep_IR_Right", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onOkKey() {
		Toast.makeText(this, "stepbystep_IR_Ok", Toast.LENGTH_SHORT).show();
	}

	/* Alljoyn */

	private void updateChannelState() {
		AllJoynService.HostChannelState channelState = mChatApplication
				.hostGetChannelState();
		String name = mChatApplication.hostGetChannelName();
		// boolean haveName = true;
		if (name == null) {
			// haveName = false;
			name = "Not set";
		}

		// Toast.makeText(MainActivity.this, "Session Name " + name,
		// Toast.LENGTH_SHORT).show();

		switch (channelState) {
		case IDLE:

			// Toast.makeText(MainActivity.this, "Session Status idle",
			// Toast.LENGTH_SHORT).show();

			break;
		case NAMED:

			// Toast.makeText(MainActivity.this, "Session status named" + name,
			// Toast.LENGTH_SHORT).show();
			break;
		case BOUND:

			// Toast.makeText(MainActivity.this, "Session status bound" + name,
			// Toast.LENGTH_SHORT).show();

			break;
		case ADVERTISED:

			// Toast.makeText(MainActivity.this,
			// "Session status advertised" + name, Toast.LENGTH_SHORT)
			// .show();
			break;
		case CONNECTED:

			// Toast.makeText(MainActivity.this, "Session status connected",
			// Toast.LENGTH_SHORT).show();

			break;
		default:

			// Toast.makeText(MainActivity.this, "Session status unknown",
			// Toast.LENGTH_SHORT).show();

			break;
		}

		if (channelState == AllJoynService.HostChannelState.IDLE) {

		}

	}

	private void updateHistory() {

		String messager = mChatApplication.getHistoryMessage();
//		Toast.makeText(MainActivity.this, "msg got! - " + messager,
//				Toast.LENGTH_SHORT).show();

		// preview.setText(messager);

		// TV Control Command Handler Goes Here

		if (messager.contains(CONTROLLER_CMD_UI_LEFT)) {
			// runSysView.downClick(); // update UI ?
			if (appsListStatus == UIStatus.OPEN) {
				appListMove(Direction.RIGHT);
			} else {
				// channel down
				this.tVContextFactory.getTvPlayer().toPreChannel();

			}
		} else if (messager.contains(CONTROLLER_CMD_UI_RIGHT)) {
			// runSysView.upClick(); // update UI ?
			if (appsListStatus == UIStatus.OPEN) {
				appListMove(Direction.LEFT);
			} else {
				// channel up
				this.tVContextFactory.getTvPlayer().toNextChannel();

			}
		} else if (messager.contains(CONTROLLER_CMD_UI_OK)) {
			DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
			if (appsListStatus == UIStatus.OPEN) {
				runApp();
			} else if (drawerLayout == null
					|| !(drawerLayout.isDrawerOpen(GravityCompat.START) || drawerLayout
							.isDrawerOpen(GravityCompat.END))) {
				// Applist will be opened if only if no other views are opened.
				// (make sure server and client work synchronously)
				showAppsList();
			} else {
				// do nothing
			}

		} else if (messager.contains(CONTROLLER_CMD_UI_RETURN)) {
			hideBottomView();
		} else if (messager.contains(CONTROLLER_CMD_UI_SHOW_BOOKMARK)) {
			startBookmarkView();
		} else if (messager.contains(CONTROLLER_CMD_UI_SHOW_HISTORY)) {
			startHistoryView();
		} else if (messager.contains(CONTROLLER_CMD_UI_HIDE_BOOKMARK)) {
			hideBookmarkView();
		} else if (messager.contains(CONTROLLER_CMD_UI_HIDE_HISTORY)) {
			hideHistoryView();
		} else if (messager.contains(CONTROLLER_CMD_VOLUME)) {
			int newVl = -1;
			try {
				newVl = Integer.parseInt(messager.substring(messager
						.indexOf(CONTROLLER_CMD_VOLUME) + 9));
			} catch (NumberFormatException e) {
				Toast.makeText(MainActivity.this, e.toString(),
						Toast.LENGTH_SHORT).show();
				return;
			}
			setVolume(newVl);

		} else if (messager.contains(CONTROLLER_CMD_CHANNEL)) {
			int newCn = -1;
			try {
				newCn = Integer.parseInt(messager.substring(messager
						.indexOf(CONTROLLER_CMD_CHANNEL) + 9));
			} catch (NumberFormatException e) {
				// Toast.makeText(MainActivity.this, e.toString(),
				// Toast.LENGTH_SHORT).show();
				return;
			}
			setChannel(newCn);
		} else if (messager.contains(CONTROLLER_CMD_GET_CUR_CHANNEL)) {
			// get information from server
			getChannelInfo();

			// prepare information
			String name = curChannelInfo.name;
			int number = curChannelInfo.number;
			String intro = curChannelInfo.intro;
			Boolean isAds = curChannelInfo.isAds;

			// pack the message and response to client
			String response = TV_RESPONSE_CHANNEL_INFO + " --" + number
					+ " ---" + name + " ----" + intro + " -----"
					+ String.valueOf(isAds);
			mChatApplication.newLocalUserMessage(response);

		} else if (messager.contains(CONTROLLER_CMD_HOME)) {
			backToHome();
		} else if (messager.contains(CONTROLLER_NOTIFICATION_SYSNOTI)) {
			startNotificationView(messager.substring(messager
					.indexOf(CONTROLLER_NOTIFICATION_SYSNOTI + " -") + 14));
		} else if(messager.contains(CONTROLLER_CMD_HIDE_APPSLIST)){
			if(appsListStatus == UIStatus.OPEN){
				hideBottomView();
			}
		}

	}

	private static final int HANDLE_HISTORY_CHANGED_EVENT = 3;

	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {

			case HANDLE_HISTORY_CHANGED_EVENT: {
				Log.i("",
						"mHandler.handleMessage(): HANDLE_HISTORY_CHANGED_EVENT");
				updateHistory();
				break;
			}

			case HANDLE_APPLICATION_QUIT_EVENT: {

				finish();
			}
				break;
			case HANDLE_CHANNEL_STATE_CHANGED_EVENT: {

				updateChannelState();
			}
				break;
			case HANDLE_ALLJOYN_ERROR_EVENT: {

			}
				break;
			default:
				break;
			}
		}
	};

	public synchronized void update(Observable o, Object arg) {

		String qualifier = (String) arg;

		if (qualifier.equals(MainApplication.APPLICATION_QUIT_EVENT)) {
			Message message = mHandler
					.obtainMessage(HANDLE_APPLICATION_QUIT_EVENT);
			mHandler.sendMessage(message);
		}

		if (qualifier.equals(MainApplication.HISTORY_CHANGED_EVENT)) {
			Message message = mHandler
					.obtainMessage(HANDLE_HISTORY_CHANGED_EVENT);
			mHandler.sendMessage(message);
		}

		if (qualifier.equals(MainApplication.HOST_CHANNEL_STATE_CHANGED_EVENT)) {
			Message message = mHandler
					.obtainMessage(HANDLE_CHANNEL_STATE_CHANGED_EVENT);
			mHandler.sendMessage(message);
		}

		if (qualifier.equals(MainApplication.ALLJOYN_ERROR_EVENT)) {
			Message message = mHandler
					.obtainMessage(HANDLE_ALLJOYN_ERROR_EVENT);
			mHandler.sendMessage(message);
		}
	}

	/* AppsList */

	private void loadApps() {
		Intent getAppsIntent = new Intent(Intent.ACTION_MAIN, null);
		getAppsIntent.addCategory(Intent.CATEGORY_LAUNCHER);

		apps = getPackageManager().queryIntentActivities(getAppsIntent, 0);
		updateAppsList();
	}

	private void updateAppsList() {
		final LinearLayout appsList = (LinearLayout) findViewById(R.id.appsList); // find
																					// wrapper
		final HorizontalScrollView appsLayout = (HorizontalScrollView) findViewById(R.id.appsLayout); // find
																										// outer
																										// wrapper

		View padding = new View(this);
		appsList.addView(padding, new LinearLayout.LayoutParams(
				((screenWidth - appIconWidth) / 2), appIconWidth)); // append
																	// left
																	// padding

		int count = 0;
		for (ResolveInfo info : apps) {
			ImageView thisApp = new ImageView(this);
			thisApp.setImageDrawable(info.activityInfo
					.loadIcon(getPackageManager())); // setImagerResource¥Î©ó¹Ï¤ù¬OR.drawable¤º®e®É
			thisApp.setTag("app" + Integer.toString(count));

			appsList.addView(thisApp, new LinearLayout.LayoutParams(
					appIconWidth, appIconWidth));
			count++;
		}
		totalApp = count;
		// Toast.makeText(this, Integer.toString(count), Toast.LENGTH_SHORT)
		// .show();

		// scroll to the initial position
		appsLayout.postDelayed(new Runnable() { // horizontal scroll view is
					// buggy and it must be
					// implemented this way to
					// "scrollTo" or
					// "smoothScrollBy"
					@Override
					public void run() {
						// hsv.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
						appsLayout
								.smoothScrollBy(curFocusApp * appIconWidth, 0);
					}
				}, 30);
		appsList.findViewWithTag("app" + Integer.toString(curFocusApp))
				.startAnimation(
						AnimationUtils.loadAnimation(this, R.anim.applarge));

		padding = new View(this);
		appsList.addView(padding, new LinearLayout.LayoutParams(
				((screenWidth - appIconWidth) / 2), appIconWidth)); // append
																	// right
																	// padding
	}

	private void appListMove(Direction direction) {
		if (!scrollAllowed)
			return;
		else
			scrollAllowed = false;

		final LinearLayout appsList = (LinearLayout) findViewById(R.id.appsList); // find
																					// wrapper
		final HorizontalScrollView appsLayout = (HorizontalScrollView) findViewById(R.id.appsLayout); // find
																										// outer
																										// wrapper
		final Animation appLarge = AnimationUtils.loadAnimation(this,
				R.anim.applarge);
		final Animation appSmall = AnimationUtils.loadAnimation(this,
				R.anim.appsmall);

		if (direction == Direction.LEFT) {
			if (curFocusApp + 1 >= totalApp) {
				scrollAllowed = true;
				return;
			}
			curFocusApp++;
			// scroll
			appsLayout.postDelayed(new Runnable() { // horizontal scroll view is
													// buggy and it must be
													// implemented this way to
													// "scrollTo" or
													// "smoothScrollBy"
						@Override
						public void run() {
							// hsv.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
							appsLayout.smoothScrollBy(appIconWidth, 0);
						}
					}, 30);
			// icon scale
			appsList.findViewWithTag("app" + Integer.toString(curFocusApp - 1))
					.startAnimation(appSmall);
			appsList.findViewWithTag("app" + Integer.toString(curFocusApp))
					.startAnimation(appLarge);

		} else if (direction == Direction.RIGHT) {
			if (curFocusApp <= 0) {
				scrollAllowed = true;
				return;
			}
			curFocusApp--;
			// scroll
			appsLayout.postDelayed(new Runnable() { // horizontal scroll view is
													// buggy and it must be
													// implemented this way to
													// "scrollTo" or
													// "smoothScrollBy"
						@Override
						public void run() {
							// hsv.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
							appsLayout.smoothScrollBy(-appIconWidth, 0);
						}
					}, 30);
			// icon scale
			appsList.findViewWithTag("app" + Integer.toString(curFocusApp + 1))
					.startAnimation(appSmall);
			appsList.findViewWithTag("app" + Integer.toString(curFocusApp))
					.startAnimation(appLarge);

		} else {
			Log.d("launcher_main", "undefined direction");
		}

		scrollAllowed = true;
	}

	private void runApp() {
		String appPackage = apps.get(curFocusApp).activityInfo.packageName;
		String appClass = apps.get(curFocusApp).activityInfo.name;
		ComponentName componet = new ComponentName(appPackage, appClass);
		Intent intent = new Intent();
		intent.setComponent(componet); // the function that specifies an
										// application to run
		startActivity(intent);
	}

	/* responsive UI */

	private void getScreenSize() {
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		screenWidth = size.x;
	}

	/* channel Info */

	/* get channel info from remote server (ITRI) */

	private void getChannelInfo() {
		// to syn with SDK - smarttvhome
		//curChannelInfo.number = Integer.parseInt(channel); // crashes
		//curChannelInfo.number = this.getChannelNumber(); // useless
		
		Toast.makeText(getApplicationContext(), "going to request channel info! channl:" + curChannelInfo.number,Toast.LENGTH_SHORT);

		String result = "nothing!";
		HttpsRequest https = new HttpsRequest(curChannelInfo.number);
		try {
			result = https.execute().get();
		} catch (Exception e) {
			result = e.toString();
			Toast.makeText(
					getApplicationContext(),
					"Something went wrong! Please check your Internet connection",
					Toast.LENGTH_SHORT).show();
			Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT)
					.show();
			return;
		}
		JSONObject JSONResult;
		try {
			JSONResult = new JSONObject(result);
			// String responseCode = JSONResult.getString("responsecode");
			String channelName = JSONResult.getString("channelname");
			// Boolean isProgram = JSONResult.getBoolean("isprogram");
			Boolean isAds = JSONResult.getBoolean("isads");
			curChannelInfo.name = channelName;
			curChannelInfo.intro = "No Intro from server!";
			curChannelInfo.isAds = isAds;
		} catch (JSONException e) {
			Toast.makeText(
					getApplicationContext(),
					"Something went wrong! Please check your Internet connection",
					Toast.LENGTH_SHORT).show();
			// Toast.makeText(getApplicationContext(), e.toString(),
			// Toast.LENGTH_SHORT).show();
			return;
		}
	}

	/* get the current channel that is playing (from SDK) */

	private void getCurChannel() {
		// Not done yet
	}

	// private boolean tickTock = false;
	//
	// private void startClock() {
	// Time today = new Time(Time.getCurrentTimezone());
	// today.setToNow();
	// TextView clock = (TextView) findViewById(R.id.clock);
	// if (tickTock) {
	// clock.setText(today.format("%k:%M"));
	// } else {
	// clock.setText(today.format("%k %M"));
	// }
	// tickTock = !tickTock;
	//
	// new android.os.Handler().postDelayed(new Runnable() {
	// public void run() {
	// startClock();
	// }
	// }, 1000);
	// }

	/* TV control */

	private void setChannel(int newCn) {
		Toast.makeText(getApplicationContext(),
				"Channel : " + Integer.toString(newCn), Toast.LENGTH_SHORT)
				.show();
		curChannelInfo.number = newCn;
		this.tVContextFactory.getTvPlayer().toChannel(newCn);

	}

	private void setVolume(int newVl) {
		if (newVl > 100 || newVl < 0)
			return;
		// Toast.makeText(getApplicationContext(),
		// "音量調整!!"+Integer.toString(newVl), Toast.LENGTH_SHORT).show();;
		AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, newVl, 0);
	}

	/* go back to launcher */
	private void backToHome() {
		this.onDestroy();
		finish();
		System.exit(0);
	}

	/******* SDK - smarttvhome functions *******/

	private static final String ACTION_USB_PERMISSION = "com.android.example.USB_PERMISSION";
	// private static final String USERID = "0a3c6bbacc";
	private static final String USERID = "1";
	// private final SerialInputOutputManager.Listener mListener =
	// new SerialInputOutputManager.Listener() {
	//
	// @Override
	// public void onRunError(Exception e) {
	// Log.d("HomeActivity", "Runner stopped.");
	// }
	//
	// @Override
	// public void onNewData(final byte[] data) {
	// MainActivity.this.runOnUiThread(new Runnable() {
	// @Override
	// public void run() {
	// // SerialConsoleActivity.this.updateReceivedData(data);
	// }
	// });
	// }
	// };
	private PersistManager persistManager;
	private RelativeLayout container;
	private ImageView imageView;
	private CmdAdReceiveBroadcastReceiver cmdAdReceiveBroadcastReceiver;
	private CmdAppBottomReceiveBroadcastReceiver cmdAppBottomReceiveBroadcastReceiver;
	private CmdAppRightReceiveBroadcastReceiver cmdAppRightReceiveBroadcastReceiver;
	private CmdBackReceiveBroadcastReceiver cmdBackReceiveBroadcastReceiver;
	private CmdDownReceiveBroadcastReceiver cmdDownReceiveBroadcastReceiver;
	private CmdHomeReceiveBroadcastReceiver cmdHomeReceiveBroadcastReceiver;
	private CmdLeftReceiveBroadcastReceiver cmdLeftReceiveBroadcastReceiver;
	private CmdModeFullReceiveBroadcastReceiver cmdModeFullReceiveBroadcastReceiver;
	private CmdModeSmallReceiveBroadcastReceiver cmdModeSmallReceiveBroadcastReceiver;
	private CmdOkReceiveBroadcastReceiver cmdOkReceiveBroadcastReceiver;
	private CmdRightReceiveBroadcastReceiver cmdRightReceiveBroadcastReceiver;
	private CmdUpReceiveBroadcastReceiver cmdUpReceiveBroadcastReceiver;
	private SysItemAllAppReceiveBroadcastReceiver sysItemAllAppReceiveBroadcastReceiver;
	private SysItemSettingReceiveBroadcastReceiver sysItemSettingReceiveBroadcastReceiver;
	private SysItemCallBackReceiveBroadcastReceiver sysItemCallBackReceiveBroadcastReceiver;
	private AppChangeBroadcastReceiver appChangeBroadcastReceiver;
	private SetBadgeBroadcastReceiver setBadgeBroadcastReceiver;
	private WorkItemIntentBroadcastReceiver workItemIntentBroadcastReceiver;
	private HomeHomeKeyBroadcastReceiver homeHomeKeyBroadcastReceiver;
	private HomeUpKeyBroadcastReceiver homeUpKeyBroadcastReceiver;
	private HomeDownKeyBroadcastReceiver homeDownKeyBroadcastReceiver;
	private HomeLeftKeyBroadcastReceiver homeLeftKeyBroadcastReceiver;
	private HomeRightKeyBroadcastReceiver homeRightKeyBroadcastReceiver;
	private HomeOkKeyBroadcastReceiver homeOkKeyBroadcastReceiver;
	private HomeBackKeyBroadcastReceiver homeBackKeyBroadcastReceiver;
	private HomeNumberKeyBroadcastReceiver homeNumberKeyBroadcastReceiver;
	private HomeOtherKeyBroadcastReceiver homeOtherKeyBroadcastReceiver;
	private TVBottomModeBroadcastReceiver tVBottomModeBroadcastReceiver;
	private TVFreeModeBroadcastReceiver tVFreeModeBroadcastReceiver;
	private TVFreePreviewModeBroadcastReceiver tVFreePreviewModeBroadcastReceiver;
	private TVFullModeBroadcastReceiver tVFullModeBroadcastReceiver;
	private TVHideModeBroadcastReceiver tVHideModeBroadcastReceiver;
	private TVPreviewModeBroadcastReceiver tVPreviewModeBroadcastReceiver;
	private TVRightModeBroadcastReceiver tVRightModeBroadcastReceiver;
	private TipStatusChangeBroadcastReceiver tipStatusBroadcastReceiver;
	private DropTipOnBroadcastReceiver dropTipOnBroadcastReceiver;
	private DropTipOffBroadcastReceiver dropTipOffBroadcastReceiver;
	// private AppTrayFloatView atvApps;
	private SysTrayFloatView stvSyses;
	private ScreenModeAppHostViewBase apPlaceHoldFull;
	private ScreenModeAppHostViewBase apPlaceHoldBottom;
	private ScreenModeAppHostViewBase apPlaceHoldRight;
	private SysViewFloatBase runSysView;
	private TextView tvTip;
	private ChannelView channelView;
	private int tipNumber;
	private String channel = "0";

	private int channelPressCount = 0;
	private Map<String, SysViewBase> sysSysViewDict;
	// private UsbSerialDriver usbSerialDriver;
	// private UsbSerialPort iRUSBPort=null;
	private long networkAvailableCheckTime = 10000;
	private HandlerThread allJoynbusThread;
	private boolean isStratToFull = false;
	private boolean needIRPermission = false;
	// private int viewChennel;
	private TVContextFactory tVContextFactory;
	private DrowTipFloatView drowTipFlowView;

	private PersistManager getPersistManager() {
		if (this.persistManager == null)
			this.persistManager = new PersistManager(this);
		return this.persistManager;
	}

	// private Handler uiHandler = new Handler() {
	// @Override
	// public void handleMessage(Message msg) {
	// switch (msg.what) {
	// case MESSAGE_PING:
	// String ping = (String) msg.obj;
	// Toast.makeText(MainActivity.this, "ping:" + ping,
	// Toast.LENGTH_LONG).show();
	// break;
	// case MESSAGE_PING_REPLY:
	// String reply = (String) msg.obj;
	// Toast.makeText(MainActivity.this, "reply:" + reply,
	// Toast.LENGTH_LONG).show();
	// break;
	// case GET_IP4_ADDRESS:
	// String ip4Address = (String) msg.obj;
	// Toast.makeText(MainActivity.this, "ip4Address:" + ip4Address,
	// Toast.LENGTH_LONG).show();
	// break;
	// case GET_IP6_ADDRESS:
	// String ip6Address = (String) msg.obj;
	// Toast.makeText(MainActivity.this, "ip6Address:" + ip6Address,
	// Toast.LENGTH_LONG).show();
	// break;
	// default:
	// break;
	// }
	// }
	// };
	// private BusObject tvHomeService;
	// private AllJoynBusHandler allJoynBusHandler;
	// private boolean isAd;
	private UsbDevice iRDevice;

	private DropTipOnBroadcastReceiverEventArgs dropTipOnData;

	// private VideoView videoView;
	private final BroadcastReceiver mUsbReceiver = new BroadcastReceiver() {

		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			Log.e("HomeActivity", "mUsbReceiver");
			// tvvTV.toFullMode();
			tVContextFactory.getTvPlayer().toFullMode();
			if (ACTION_USB_PERMISSION.equals(action)) {
				synchronized (this) {
					UsbDevice device = (UsbDevice) intent
							.getParcelableExtra(UsbManager.EXTRA_DEVICE);

					if (intent.getBooleanExtra(
							UsbManager.EXTRA_PERMISSION_GRANTED, false)) {
						if (device != null) {
							iRDevice = device;
							// UsbSerialPort iRUSBPort = null;
							// Log.e("HomeActivity", "have ir sender_ports:" +
							// usbSerialDriver.getPorts().size());
							// Log.e("HomeActivity", "have ir sender_ports:" +
							// tVContextFactory.getSender().getUsbSerialDriver().getPorts().size());
							// if
							// (tVContextFactory.getSender().getUsbSerialDriver().getPorts().size()
							// > 0)
							// iRUSBPort =
							// tVContextFactory.getSender().getUsbSerialDriver().getPorts().get(0);
							// tVContextFactory.getSender().setUsbSerialPort(iRUSBPort);
							// tVContextFactory.getSender().iRServerStart();
							// IRSenderService.serviceGo(MainActivity.this,
							// iRUSBPort);
							isStratToFull = true;

							needIRPermission = false;
						}
					} else {
						Log.d("HomeActivity", "permission denied for device "
								+ device);
					}
				}
			}
		}
	};

	private Map<String, SysViewBase> getSysSysViewDict() {
		if (sysSysViewDict == null) {
			this.sysSysViewDict = new HashMap<String, SysViewBase>();
		}

		return this.sysSysViewDict;
	}

	private SysViewBase getSysView(String key) {
		return this.getSysSysViewDict().get(key);
	}

	private void putSysView(String key, SysViewBase view) {
		this.getSysSysViewDict().put(key, view);
	}

	/* Load the native alljoyn_java library. */
	static {
		System.loadLibrary("alljoyn_java");
	}

	private void drowTipFlowViewShow(boolean withAnimal) {
		if (dropTipOnData != null) {
			if (withAnimal == true) {
				// drowTipFlowView.hide();
				drowTipFlowView.showWithAnimal(dropTipOnData.getBitmap(),
						dropTipOnData.getDropAction(), dropTipOnData
								.getDropTipId(), dropTipOnData.getBundle(),
						tVContextFactory.getTvPlayer().getChannel(), USERID,
						tVContextFactory.getMsoid(), tVContextFactory
								.getTvPlayer().getChannelAddress());
			} else {
				drowTipFlowView.showNonAnimal(dropTipOnData.getBitmap(),
						dropTipOnData.getDropAction(), dropTipOnData
								.getDropTipId(), dropTipOnData.getBundle(),
						tVContextFactory.getTvPlayer().getChannel(), USERID,
						tVContextFactory.getMsoid(), tVContextFactory
								.getTvPlayer().getChannelAddress());
			}
		}
	}

	private boolean isOnline() {
		ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		return (networkInfo != null && networkInfo.isConnected());
	}

	private void onCreateIRSender() {
		Log.e("HomeActivity", "onCreateIRSender0");
		UsbManager manager = (UsbManager) getSystemService(Context.USB_SERVICE);

		PendingIntent mPermissionIntent = PendingIntent.getBroadcast(this, 0,
				new Intent(ACTION_USB_PERMISSION), 0);
		IntentFilter filter = new IntentFilter(ACTION_USB_PERMISSION);
		registerReceiver(mUsbReceiver, filter);

		// List<UsbSerialDriver> drivers =
		// UsbSerialProber.getDefaultProber().findAllDrivers(manager);
		//
		// for (UsbSerialDriver current : drivers) {
		// Log.e("HomeActivity", "onCreateIRSender1");
		// String title = String.format("Vendor %s Product %s",
		// HexDump.toHexString((short) current.getDevice().getVendorId()),
		// HexDump.toHexString((short) current.getDevice().getProductId()));
		//
		//
		// Log.e("HomeActivity", "Usb_Title:" + title);
		//
		// if (HexDump.toHexString((short)
		// current.getDevice().getVendorId()).equals("2341") &&
		// HexDump.toHexString((short)
		// current.getDevice().getProductId()).equals("0043")) {
		// if(HexDump.toHexString((short)
		// current.getDevice().getVendorId()).equals("0403")&&
		// HexDump.toHexString((short)
		// current.getDevice().getProductId()).equals("6001")) {
		// manager.requestPermission(current.getDevice(), mPermissionIntent);
		// Log.e("HomeActivity", "onCreateIRSender2");
		// this.usbSerialDriver =current;
		// this.tVContextFactory.getSender().setUsbSerialDriver(current);
		// needIRPermission = true;
		// isStratToFull = true;
		// }
		// }

		if (needIRPermission == false)
			tVContextFactory.getTvPlayer().toFullMode();
	}

	@Override
	protected void onStart() {
		super.onStart();
		this.channel = getPersistManager().getValue("channel");
		if (this.channel.equals("") == false) {
			channelPressCount++;
			this.tVContextFactory.getTvPlayer().toChannel(
					Integer.parseInt(channel));
			ToChannelTimerTask myTask = new ToChannelTimerTask();
			Timer myTimer = new Timer();
			// myTimer.schedule(myTask, 5000);
			myTimer.schedule(myTask, 2000);
		}
		this.cmdAdReceiveBroadcastReceiver.register();
		this.cmdAppBottomReceiveBroadcastReceiver.register();
		this.cmdAppRightReceiveBroadcastReceiver.register();
		this.cmdBackReceiveBroadcastReceiver.register();
		this.cmdDownReceiveBroadcastReceiver.register();
		this.cmdHomeReceiveBroadcastReceiver.register();
		this.cmdLeftReceiveBroadcastReceiver.register();
		this.cmdModeFullReceiveBroadcastReceiver.register();
		this.cmdModeSmallReceiveBroadcastReceiver.register();
		this.cmdOkReceiveBroadcastReceiver.register();
		this.cmdRightReceiveBroadcastReceiver.register();
		this.cmdUpReceiveBroadcastReceiver.register();
		this.sysItemAllAppReceiveBroadcastReceiver.register();
		this.sysItemSettingReceiveBroadcastReceiver.register();
		this.sysItemCallBackReceiveBroadcastReceiver.register();
		this.appChangeBroadcastReceiver.register();
		this.setBadgeBroadcastReceiver.register();
		this.workItemIntentBroadcastReceiver.register();
		this.homeHomeKeyBroadcastReceiver.register();
		this.homeUpKeyBroadcastReceiver.register();
		this.homeDownKeyBroadcastReceiver.register();
		this.homeLeftKeyBroadcastReceiver.register();
		this.homeRightKeyBroadcastReceiver.register();
		this.homeOkKeyBroadcastReceiver.register();
		this.homeBackKeyBroadcastReceiver.register();
		this.homeNumberKeyBroadcastReceiver.register();
		this.homeOtherKeyBroadcastReceiver.register();

		this.tVBottomModeBroadcastReceiver.register();
		this.tVFreeModeBroadcastReceiver.register();
		this.tVFreePreviewModeBroadcastReceiver.register();
		this.tVFullModeBroadcastReceiver.register();
		this.tVHideModeBroadcastReceiver.register();
		this.tVPreviewModeBroadcastReceiver.register();
		this.tVRightModeBroadcastReceiver.register();
		this.tipStatusBroadcastReceiver.register();
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (needIRPermission == false) {
			if (this.isStratToFull == true) {
				// this.tvvTV.toFullMode();
				tVContextFactory.getTvPlayer().toFullMode();
			}
			this.isStratToFull = true;
		}

		this.dropTipOnBroadcastReceiver.register();
		this.dropTipOffBroadcastReceiver.register();
		Log.e("HomeActivity", "onResume");
		drowTipFlowViewShow(false);
	}

	private void upKeyHandle() {
		if (runSysView != null) {
			runSysView.upClick();
		} else {
			// if (atvApps.isShow() == true) {
			// atvApps.toPreviousItem();
			// }
			if (stvSyses.isShow() == true) {
				stvSyses.toPreviousItem();
			}
		}
	}

	private void downKeyHandle() {
		if (runSysView != null) {
			runSysView.downClick();
		} else {
			// if (atvApps.isShow() == true) {
			// atvApps.toNextItem();
			// }
			if (stvSyses.isShow() == true) {
				stvSyses.toNextItem();
			}
		}
	}

	private void leftKeyHandle() {
		if (runSysView != null) {
			runSysView.leftClick();
		} else {
			boolean needShow = true;
			// if (atvApps.isShow() == true) {
			// atvApps.hide();
			// needShow = false;
			// }
			if (stvSyses.isShow() == true) {
				stvSyses.hide();
				needShow = false;
			}

			if (needShow == true) {
				// drowTipFlowView.exec();
				// atvApps.show();
				// this.drowTipFlowView.show();
			}
		}
	}

	private void rightKeyHandle() {
		if (runSysView != null) {
			Log.d("runSysView", "rightKeyHandle");
			runSysView.rightClick();
		} else {
			boolean needShow = true;
			// if (atvApps.isShow() == true) {
			// atvApps.hide();
			// needShow = false;
			// }
			if (stvSyses.isShow() == true) {
				stvSyses.hide();
				needShow = false;
				Log.d("HomeActivity", "rightKeyHandle");
			}

			if (needShow == true)
				stvSyses.show();
		}
	}

	private void powerClick() {
		// if(this.iRUSBPort!=null)
		// {
		// final Intent intentService = new Intent(this, IRSenderService.class);
		// intentService.putExtra(IRSenderService.IR_KEY,IRCommandManager.IR_KEY_CHANNELMINUS);
		// intentService.putExtra(IRSenderService.PRODUCT_KEY,
		// IRCommandManager.PRODUCT_KEY_TBC);
		// this.startService(intentService);
		// }
		// this.sendIRCommand(IRCommandManager.IR_KEY_CHANNELMINUS);
		// this.tVContextFactory.getSender().sendIRCommand(IRCommandManager.IR_KEY_CHANNELMINUS);
	}

	private void homeKeyHandle() {
		if (runSysView != null) {
			runSysView.homeClick();
		} else {
			// if (atvApps.isShow() == true)
			// atvApps.hide();
			if (stvSyses.isShow() == true)
				stvSyses.hide();

			// apPlaceHoldFull.removeAllViews();
			// apPlaceHoldBottom.removeAllViews();
			// apPlaceHoldRight.removeAllViews();
			runSysView = null;
		}

		stvSyses.setFunctionRun(false);
		// tvvTV.toFullMode();
		tVContextFactory.getTvPlayer().toFullMode();
	}

	// private boolean sendIRCommand(String command)
	// {
	// boolean reslut=false;
	// if(this.tVContextFactory.getSender().getUsbSerialPort()!=null)
	// {
	// final Intent intentService = new Intent(this, IRSenderService.class);
	// intentService.putExtra(IRSenderService.IR_KEY,command);
	// intentService.putExtra(IRSenderService.PRODUCT_KEY,
	// IRCommandManager.PRODUCT_KEY_TBC);
	// this.startService(intentService);
	// reslut=true;
	// }
	// return reslut;
	// }

	private void okKeyHandle() {
		if (runSysView != null) {
			runSysView.okClick();
		} else {
			// if (atvApps.isShow() == true) {
			// atvApps.itemActionRun(
			// this.tVContextFactory.getTvPlayer().getChannel(),
			// USERID,
			// this.tVContextFactory.getTvPlayer().getChannelAddress(),
			// tVContextFactory.getMsoid(),tVContextFactory.getReceiverType());
			// }

			if (stvSyses.isShow() == true) {
				stvSyses.itemActionRun();
			} else {
				drowTipFlowView.exec();
			}
		}
	}

	private void backKeyHandle() {
		if (runSysView != null) {
			runSysView.backClick();
		} else {
			// if (atvApps.isShow() == true)
			// atvApps.hide();
			if (stvSyses.isShow() == true)
				stvSyses.hide();
			// tvvTV.toFullMode();
			tVContextFactory.getTvPlayer().toFullMode();

			// apPlaceHoldFull.removeAllViews();
			// apPlaceHoldBottom.removeAllViews();
			// apPlaceHoldRight.removeAllViews();
			runSysView = null;
		}

		stvSyses.setFunctionRun(false);
	}

	@Override
	public boolean upClickEvent(Object sender, Object args) {
		return false;
	}

	@Override
	public boolean downClickEvent(Object sender, Object args) {
		return false;
	}

	@Override
	public boolean okClickEvent(Object sender, Object args) {
		return false;
	}

	@Override
	public boolean leftClickEvent(Object sender, Object args) {
		return false;
	}

	@Override
	public boolean rightClickEvent(Object sender, Object args) {
		return false;
	}

	@Override
	public boolean backClickEvent(Object sender, Object args) {
		runSysView = null;
		return false;
	}

	@Override
	public boolean homeClickEvent(Object sender, Object args) {
		// tvvTV.toFullMode();
		tVContextFactory.getTvPlayer().toFullMode();
		runSysView = null;
		return false;
	}

	@Override
	public boolean disposeEvent(Object sender, Object args) {
		runSysView = null;
		return false;
	}

	@Override
	protected void onPause() {
		super.onPause();
		this.dropTipOnBroadcastReceiver.unregister();
		this.dropTipOffBroadcastReceiver.unregister();
		Log.e("HomeActivity", "onPause");
	}

	@Override
	protected void onStop() {
		this.cmdAdReceiveBroadcastReceiver.unregister();
		this.cmdAppBottomReceiveBroadcastReceiver.unregister();
		this.cmdAppRightReceiveBroadcastReceiver.unregister();
		this.cmdBackReceiveBroadcastReceiver.unregister();
		this.cmdDownReceiveBroadcastReceiver.unregister();
		this.cmdHomeReceiveBroadcastReceiver.unregister();
		this.cmdLeftReceiveBroadcastReceiver.unregister();
		this.cmdModeFullReceiveBroadcastReceiver.unregister();
		this.cmdModeSmallReceiveBroadcastReceiver.unregister();
		this.cmdOkReceiveBroadcastReceiver.unregister();
		this.cmdRightReceiveBroadcastReceiver.unregister();
		this.cmdUpReceiveBroadcastReceiver.unregister();
		this.sysItemAllAppReceiveBroadcastReceiver.unregister();
		this.sysItemSettingReceiveBroadcastReceiver.unregister();
		this.sysItemCallBackReceiveBroadcastReceiver.unregister();
		this.appChangeBroadcastReceiver.unregister();
		this.setBadgeBroadcastReceiver.unregister();
		this.workItemIntentBroadcastReceiver.unregister();
		this.homeHomeKeyBroadcastReceiver.unregister();
		this.homeUpKeyBroadcastReceiver.unregister();
		this.homeDownKeyBroadcastReceiver.unregister();
		this.homeLeftKeyBroadcastReceiver.unregister();
		this.homeRightKeyBroadcastReceiver.unregister();
		this.homeOkKeyBroadcastReceiver.unregister();
		this.homeBackKeyBroadcastReceiver.unregister();
		this.homeNumberKeyBroadcastReceiver.unregister();
		this.homeOtherKeyBroadcastReceiver.unregister();

		this.tVBottomModeBroadcastReceiver.unregister();
		this.tVFreeModeBroadcastReceiver.unregister();
		this.tVFreePreviewModeBroadcastReceiver.unregister();
		this.tVFullModeBroadcastReceiver.unregister();
		this.tVHideModeBroadcastReceiver.unregister();
		this.tVPreviewModeBroadcastReceiver.unregister();
		this.tVRightModeBroadcastReceiver.unregister();
		this.tipStatusBroadcastReceiver.unregister();
		// this.dropTipOnBroadcastReceiver.unregister();
		// this.dropTipOffBroadcastReceiver.unregister();

		// hdmi
		Intent i = new Intent(HDMI_CLOSE_SCALE);
		this.sendBroadcast(i);

		super.onStop();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// Toast.makeText(HomeActivity.this, "IR_onKeyDown:"+keyCode,
		// Toast.LENGTH_LONG).show();

		Log.e("HomeActivity", "onKeyDown:" + keyCode);
		Log.e("HomeActivity", "onKeyDown_tVContextFactory:" + tVContextFactory);
		// Log.e("HomeActivity", "onKeyDown_tVContextFactory.getReceiver():" +
		// tVContextFactory.getReceiver());
		// Log.e("HomeActivity", "onKeyDown_getNumberStartCode:" +
		// this.tVContextFactory.getReceiver().getNumberStartCode());
		// if (keyCode >= this.keyCode.getNumberStartCode() && keyCode <=
		// this.keyCode.getNumberStartCode() + 9) {
		if (keyCode >= this.tVContextFactory.getReceiver().getNumberStartCode()
				&& keyCode <= this.tVContextFactory.getReceiver()
						.getNumberStartCode() + 9) {
			int numberCode = keyCode
					- this.tVContextFactory.getReceiver().getNumberStartCode();

			// if(keyCode==7)
			// {
			// if(this.sendIRNumber(IRCommandManager.IR_KEY_NUMBER0)==true)
			// {
			// //do channel change logic
			// }
			// }
			// if(keyCode==8)
			// {
			// if(this.sendIRNumber(IRCommandManager.IR_KEY_NUMBER1)==true)
			// {
			// //do channel change logic
			// }
			// }
			// if(keyCode==9)
			// {
			// if(this.sendIRNumber(IRCommandManager.IR_KEY_NUMBER2)==true)
			// {
			// //do channel change logic
			// }
			// }
			// if(keyCode==10)
			// {
			// if(this.sendIRNumber(IRCommandManager.IR_KEY_NUMBER3)==true)
			// {
			// //do channel change logic
			// }
			// }
			// if(keyCode==11)
			// {
			// if(this.sendIRNumber(IRCommandManager.IR_KEY_NUMBER4)==true)
			// {
			// //do channel change logic
			// }
			// }
			// if(keyCode==12)
			// {
			// if(this.sendIRNumber(IRCommandManager.IR_KEY_NUMBER5)==true)
			// {
			// //do channel change logic
			// }
			// }
			// if(keyCode==13)
			// {
			// if(this.sendIRNumber(IRCommandManager.IR_KEY_NUMBER6)==true)
			// {
			// //do channel change logic
			// }
			// }
			// if(keyCode==14)
			// {
			// if(this.sendIRNumber(IRCommandManager.IR_KEY_NUMBER7)==true)
			// {
			// //do channel change logic
			// }
			// }
			// if(keyCode==15)
			// {
			// if(this.sendIRNumber(IRCommandManager.IR_KEY_NUMBER8)==true)
			// {
			// //do channel change logic
			// }
			// }
			// if(keyCode==16)
			// {
			// if(this.sendIRNumber(IRCommandManager.IR_KEY_NUMBER9)==true)
			// {
			// //do channel change logic
			// }
			// }

			this.channel = channel + numberCode;
			this.channel = this.right(channel, 3);
			Toast.makeText(MainActivity.this, "channel:" + channel,
					Toast.LENGTH_SHORT).show();
			// this.channelView.setText(channel);
			// this.channelView.setVisibility(View.VISIBLE);
			this.channelPressCount++;
			ToChannelTimerTask myTask = new ToChannelTimerTask();
			Timer myTimer = new Timer();
			// myTimer.schedule(myTask, 5000);
			myTimer.schedule(myTask, 2000);

			// this.channelView.bringToFront();
		} else {
			// if (keyCode == this.keyCode.getUpCode())
			if (keyCode == this.tVContextFactory.getReceiver().getUpCode()) {
				// if(this.atvApps.isShow() || this.stvSyses.isShown() ||
				// this.stvSyses.isFunctionRun() ) {
				// this.upKeyHandle();
				// }else {
				// this.tVContextFactory.getTvPlayer().toNextChannel();
				// }

				if (this.stvSyses.isShown() || this.stvSyses.isFunctionRun()) {
					this.upKeyHandle();
				} else {
					this.tVContextFactory.getTvPlayer().toNextChannel();
				}
			}
			// if (keyCode == this.tVContextFactory.getReceiver().getDownCode())
			// {
			// if (this.atvApps.isShow() || this.stvSyses.isShown()||
			// this.stvSyses.isFunctionRun()) {
			// this.downKeyHandle();
			// } else {
			// this.tVContextFactory.getTvPlayer().toPreChannel();
			// }
			// }

			if (keyCode == this.tVContextFactory.getReceiver().getDownCode()) {
				if (this.stvSyses.isShown() || this.stvSyses.isFunctionRun()) {
					this.downKeyHandle();
				} else {
					this.tVContextFactory.getTvPlayer().toPreChannel();
				}
			}

			if (keyCode == this.tVContextFactory.getReceiver().getLeftCode()) {
				// Toast.makeText(HomeActivity.this, "leftKeyHandle",
				// Toast.LENGTH_LONG).show();
				leftKeyHandle();
			}
			if (keyCode == this.tVContextFactory.getReceiver().getRightCode()) {
				rightKeyHandle();
			}
			if (keyCode == this.tVContextFactory.getReceiver().getOkCode()) {
				// if (this.sendIRCommand(IRCommandManager.IR_KEY_OK) == true) {
				// //do channel change logic
				// }

				// if
				// (this.tVContextFactory.getSender().sendIRCommand(IRCommandManager.IR_KEY_OK)
				// == true) {
				// //do channel change logic
				// }
				okKeyHandle();
			}
			if (keyCode == 4) {
				// if (this.sendIRNumber(IRCommandManager.IR_KEY_BACK) == true)
				// {
				// //do channel change logic
				// }

				backKeyHandle();
			}
			if (keyCode == 183)
				homeKeyHandle();
			if (keyCode == 166) {
				// if
				// (this.tVContextFactory.getSender().sendIRCommand(IRCommandManager.IR_KEY_CHANNEPLUS)
				// == true) {
				// //do channel change logic
				// }
			}

			if (keyCode == 167) {
				// if
				// (this.tVContextFactory.getSender().sendIRCommand(IRCommandManager.IR_KEY_CHANNELMINUS)
				// == true) {
				// //do channel change logic
				// }
			}
			if (keyCode == 184) {
				// if
				// (this.tVContextFactory.getSender().sendIRCommand(IRCommandManager.IR_KEY_POWER)
				// == true) {
				// //do power status save
				// }
			}

			if (keyCode == 186) {
				// if
				// (this.tVContextFactory.getSender().sendIRCommand(IRCommandManager.IR_KEY_INFORMATION)
				// == true) {
				// //do power status save
				// }
			}
		}

		// startActivityForResult(new
		// Intent(android.provider.Settings.ACTION_SETTINGS), 0);

		// hdmi
		if (keyCode == 66)
			fullHandle();

		if (keyCode == 183)
			previewHandle();

		return false;
	}

	public String right(String str, int len) {
		if (str == null) {
			return null;
		}
		if (len < 0) {
			return "";
		}
		if (str.length() <= len) {
			return str;
		}
		return str.substring(str.length() - len);
	}

	@Override
	protected void onDestroy() {
		// if(this.allJoynBusHandler!=null)
		// this.allJoynBusHandler.sendEmptyMessage(AllJoynBusHandler.DISCONNECT);
		super.onDestroy();
	}

	private class NetworkAvaiableTimerTask extends TimerTask {
		public void run() {
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					if (isOnline() == true) {
						// allJoynBusHandler = new
						// AllJoynBusHandler(HomeActivity.this,
						// allJoynbusThread.getLooper(), tvHomeService);
						// allJoynBusHandler.sendEmptyMessage(AllJoynBusHandler.CONNECT);
						// Log.e("HomeActivity", "networkAvailable");
						// Toast.makeText(HomeActivity.this, "networkAvailable",
						// Toast.LENGTH_LONG).show();
					} else {
						Log.e("HomeActivity", "networkfail");
						Timer myTimer = new Timer();
						TimerTask networkAvaiableTimerTask = new NetworkAvaiableTimerTask();
						myTimer.schedule(networkAvaiableTimerTask,
								networkAvailableCheckTime);
						networkAvailableCheckTime *= 2;
					}
				}
			});
		}
	}

	private class ToChannelTimerTask extends TimerTask {
		public void run() {
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					channelPressCount--;
					if (channelPressCount == 0) {
						if (channel.equals("000") == false) {
							// viewChennel=Integer.parseInt(channel);
							tVContextFactory.getTvPlayer().toChannel(
									Integer.parseInt(channel));
							getPersistManager().saveValue("channel",
									Integer.parseInt(channel) + "");

							//
							// Toast.makeText(HomeActivity.this, "to:" +
							// viewChennel,
							// Toast.LENGTH_LONG).show();
						}
						ToChannelHitInVisibleTimerTask myTask = new ToChannelHitInVisibleTimerTask();
						Timer myTimer = new Timer();
						// myTimer.schedule(myTask, 3500);
						myTimer.schedule(myTask, 2000);
					}
				}
			});
		}
	}

	private class ToChannelHitInVisibleTimerTask extends TimerTask {
		public void run() {
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					// channelView.setVisibility(View.INVISIBLE);
					channel = "000";
				}
			});
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Intent i = new Intent(this, DeveloperActivity.class);
		startActivity(i);
		return false;
	}

	/* hdmi */
	private void fullHandle() {
//		Intent ic = new Intent(HDMI_CLOSE_SCALE);
//		MainActivity.this.sendBroadcast(ic);
//		// Handler handler = new Handler();
		// Runnable r = new Runnable() {
		// public void run() {
		Intent i = new Intent(HDMI_SET_SCALE);
		Bundle bundle = new Bundle();
		bundle.putInt("Locate_x", 0);
		bundle.putInt("Locate_y", 0);
		bundle.putInt("Window_w", 900);
		bundle.putInt("Window_h", 800);
		i.putExtras(bundle);
		MainActivity.this.sendBroadcast(i);
		// }
		// };
		// handler.postDelayed(r, 2000);
	}

	private void previewHandle() {
		Intent ic = new Intent(HDMI_CLOSE_SCALE);
		MainActivity.this.sendBroadcast(ic);
		//
		// Handler handler = new Handler();
		// Runnable r = new Runnable() {
		// public void run() {
		Intent i = new Intent(HDMI_SET_SCALE);
		Bundle bundle = new Bundle();
		bundle.putInt("Locate_x", 1);
		bundle.putInt("Locate_y", 1);
		bundle.putInt("Window_w", 451);
		bundle.putInt("Window_h", 300);
		i.putExtras(bundle);
		MainActivity.this.sendBroadcast(i);
		// }
		// };
		// handler.postDelayed(r, 2000);
	}
}