package tw.futureInsighters.Tv;

import itri.smarttvsdk.activities.HomeAppActivityBase;

import java.util.List;

import org.allseenaliance.alljoyn.AllJoynService;
import org.allseenaliance.alljoyn.Observable;
import org.allseenaliance.alljoyn.Observer;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mimi on 15/3/25.
 */
public class MainActivity extends HomeAppActivityBase implements Observer {
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
	/* part2: TV to client CMD */
	private final String TV_RESPONSE_CHANNEL = "SVTSIcurchannel";
	private final String TV_RESPONSE_CHANNEL_INFO = "SVTSIcurchannelinfo";

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
	//private Button sendjson;

	private MainApplication mChatApplication = null;
	//private TextView preview;
	//private EditText edit;

	private static final int HANDLE_APPLICATION_QUIT_EVENT = 0;
	private static final int HANDLE_CHANNEL_STATE_CHANGED_EVENT = 1;
	private static final int HANDLE_ALLJOYN_ERROR_EVENT = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/* channel info */
		curChannelInfo = new ChannelInfo();

		Toast.makeText(this, "Channel:" + this.getChannelNumber(),
				Toast.LENGTH_SHORT).show();

		/* app list initialize */
		getScreenSize();
		// loadApps();
		showAppsList();

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
		//sendjson.setEnabled(false);
		leave.setEnabled(false);

//		sendjson.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View arg0) {
//
//				String s = edit.getText().toString() + "";
//
//				mChatApplication.newLocalUserMessage(s);
//
//				edit.setText("");
//
//			}
//		});

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
				//sendjson.setEnabled(false);

			}
		});

		// Find and join channel
		join.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				final Dialog dialog = new Dialog(MainActivity.this);
				dialog.requestWindowFeature(dialog.getWindow().FEATURE_NO_TITLE);
				dialog.setContentView(R.layout.usejoindialog);

				// Find the channel in the channel list
				ArrayAdapter<String> channelListAdapter = new ArrayAdapter<String>(
						MainActivity.this, android.R.layout.test_list_item);
				final ListView channelList = (ListView) dialog
						.findViewById(R.id.useJoinChannelList);
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
							Toast.makeText(getApplicationContext(), "Initialization failed. Retrying...",
									Toast.LENGTH_SHORT).show();
							join.performClick();
						}
					}, 1000);
					return;
				}
				Toast.makeText(getApplicationContext(), "Initialized. Have a good day!",
						Toast.LENGTH_SHORT).show();

				// Set channel name and join
				mChatApplication.useSetChannelName(name);
				mChatApplication.useJoinChannel();

				start.setEnabled(false);
				stop.setEnabled(false);
				join.setEnabled(false);
				//sendjson.setEnabled(true);
				leave.setEnabled(true);

				Button cancel = (Button) dialog
						.findViewById(R.id.useJoinCancel);
				cancel.setOnClickListener(new View.OnClickListener() {
					public void onClick(View view) {

						dialog.dismiss();
					}
				});

			}
		});

		// Simulate click join button
		new android.os.Handler().postDelayed(new Runnable() {
			public void run() {
				join.performClick();
			}
		}, 6000);

		leave.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				mChatApplication.useLeaveChannel();
				mChatApplication.useSetChannelName("Not set");
				leave.setEnabled(false);
				//sendjson.setEnabled(false);

				// start.setEnabled(true);
				stop.setEnabled(true);
				join.setEnabled(true);

			}
		});

		mChatApplication = (MainApplication) getApplication();
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
	}

	private void startBookmarkView() {
		// bookmarkViewStatus = UIStatus.OPEN;
		appsListStatus = UIStatus.CLOSED;
		BookmarkView fv = new BookmarkView(this);
		this.setAppContentView(fv);
	}

	private void startHistoryView() {
		// historyViewStatus = UIStatus.OPEN;
		appsListStatus = UIStatus.CLOSED;
		HistoryView fv = new HistoryView(this);
		this.setAppContentView(fv);
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

		Toast.makeText(MainActivity.this, "Session Name " + name,
				Toast.LENGTH_SHORT).show();

		switch (channelState) {
		case IDLE:

			Toast.makeText(MainActivity.this, "Session Status idle",
					Toast.LENGTH_SHORT).show();

			break;
		case NAMED:

			Toast.makeText(MainActivity.this, "Session status named" + name,
					Toast.LENGTH_SHORT).show();
			break;
		case BOUND:

			Toast.makeText(MainActivity.this, "Session status bound" + name,
					Toast.LENGTH_SHORT).show();

			break;
		case ADVERTISED:

			Toast.makeText(MainActivity.this,
					"Session status advertised" + name, Toast.LENGTH_SHORT)
					.show();
			break;
		case CONNECTED:

			Toast.makeText(MainActivity.this, "Session status connected",
					Toast.LENGTH_SHORT).show();

			break;
		default:

			Toast.makeText(MainActivity.this, "Session status unknown",
					Toast.LENGTH_SHORT).show();

			break;
		}

		if (channelState == AllJoynService.HostChannelState.IDLE) {

		}

	}

	private void updateHistory() {

		String messager = mChatApplication.getHistoryMessage();
		Toast.makeText(MainActivity.this, "msg got! - " + messager,
				Toast.LENGTH_SHORT).show();

		//preview.setText(messager);

		// TV Control Command Handler Goes Here

		if (messager.contains(CONTROLLER_CMD_UI_LEFT)) {
			if (appsListStatus == UIStatus.OPEN) {
				appListMove(Direction.RIGHT);
			}
		} else if (messager.contains(CONTROLLER_CMD_UI_RIGHT)) {
			if (appsListStatus == UIStatus.OPEN) {
				appListMove(Direction.LEFT);
			}
		} else if (messager.contains(CONTROLLER_CMD_UI_OK)) {
			DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
			if (appsListStatus == UIStatus.OPEN) {
				runApp();
			} else if (!(drawerLayout.isDrawerOpen(GravityCompat.START) || drawerLayout
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
						.indexOf(CONTROLLER_CMD_VOLUME) + 8));
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
						.indexOf(CONTROLLER_CMD_CHANNEL) + 8));
			} catch (NumberFormatException e) {
				Toast.makeText(MainActivity.this, e.toString(),
						Toast.LENGTH_SHORT).show();
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
					.loadIcon(getPackageManager())); // setImagerResource用於圖片是R.drawable內容時
			thisApp.setTag("app" + Integer.toString(count));

			appsList.addView(thisApp, new LinearLayout.LayoutParams(
					appIconWidth, appIconWidth));
			count++;
		}
		totalApp = count;
		Toast.makeText(this, Integer.toString(count), Toast.LENGTH_SHORT)
				.show();

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
		String result = "nothing!";
		HttpsRequest https = new HttpsRequest();
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
			Toast.makeText(getApplicationContext(), e.toString(),
					Toast.LENGTH_SHORT).show();
			return;
		}
	}

	/* get the current channel that is playing (from SDK) */
	private void curChannel() {
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
		Toast.makeText(getApplicationContext(), Integer.toString(newCn),
				Toast.LENGTH_SHORT).show();
	}

	private void setVolume(int newVl) {
		Toast.makeText(getApplicationContext(), Integer.toString(newVl),
				Toast.LENGTH_SHORT).show();
	}
}