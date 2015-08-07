package itri.smarttvsdk.utilities;

import android.content.Context;
import android.util.Log;

import org.itri.icl.droptv.sharetvcore.utilities.HttpClientHelper;

import itri.smarttvsdk.defines.Command;
import itri.smarttvsdk.defines.MetaData;

/**
 * Created by mimi on 14/12/18.
 */
public class SendCommandHelper {
    public static String getServerUri(String ipAddress) {
        return "http://"
                + ipAddress
                + ":"
                + MetaData.DEFAULT_SERVER_PORT
                + "/command.html?";
    }

    public static void sendUpCmd(final Context ctx, final String serverUri) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String commandUri = serverUri + "CMD=" + Command.COMMAND_UP;
                HttpClientHelper.sendCommand(
                        ctx, commandUri);

                Log.e("CommandReceiveRH", "sendUpCmd:"
                        + commandUri);
            }
        });

        thread.start();
    }

    public static void sendDownCmd(final Context ctx, final String serverUri) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String commandUri = serverUri + "CMD=" + Command.COMMAND_DOWN;
                HttpClientHelper.sendCommand(
                        ctx, commandUri);

                Log.e("CommandReceiveRH", "sendDownCmd:"
                        + commandUri);
            }
        });

        thread.start();
    }

    public static void sendLeftCmd(final Context ctx, final String serverUri) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String commandUri = serverUri + "CMD=" + Command.COMMAND_LEFT;
                HttpClientHelper.sendCommand(
                        ctx, commandUri);

                Log.e("CommandReceiveRH", "sendLeftCmd:"
                        + commandUri);
            }
        });

        thread.start();
    }

    public static void sendRightCmd(final Context ctx, final String serverUri) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String commandUri = serverUri + "CMD=" + Command.COMMAND_RIGHT;
                HttpClientHelper.sendCommand(
                        ctx, commandUri);

                Log.e("CommandReceiveRH", "sendRightCmd:"
                        + commandUri);
            }
        });

        thread.start();
    }

    public static void sendBackCmd(final Context ctx, final String serverUri) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String commandUri = serverUri + "CMD=" + Command.COMMAND_BACK;
                HttpClientHelper.sendCommand(
                        ctx, commandUri);

                Log.e("CommandReceiveRH", "sendBackCmd:"
                        + commandUri);
            }
        });

        thread.start();
    }

    public static void sendHomeCmd(final Context ctx, final String serverUri) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String commandUri = serverUri + "CMD=" + Command.COMMAND_HOME;
                HttpClientHelper.sendCommand(
                        ctx, commandUri);

                Log.e("CommandReceiveRH", "sendHomeCmd:"
                        + commandUri);
            }
        });

        thread.start();
    }

    public static void sendOkCmd(final Context ctx, final String serverUri) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String commandUri = serverUri + "CMD=" + Command.COMMAND_OK;
                HttpClientHelper.sendCommand(
                        ctx, commandUri);

                Log.e("CommandReceiveRH", "sendOkCmd:"
                        + commandUri);
            }
        });

        thread.start();
    }

    public static void sendAdCmd(final Context ctx, final String serverUri) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String commandUri = serverUri + "CMD=" + Command.COMMAND_AD;
                HttpClientHelper.sendCommand(
                        ctx, commandUri);

                Log.e("CommandReceiveRH", "sendAdCmd:"
                        + commandUri);
            }
        });

        thread.start();
    }

    public static void sendModeFullCmd(final Context ctx, final String serverUri) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String commandUri = serverUri + "CMD=" + Command.COMMAND_MODEFULL;
                HttpClientHelper.sendCommand(
                        ctx, commandUri);

                Log.e("CommandReceiveRH", "sendModeFullCmd:"
                        + commandUri);
            }
        });

        thread.start();
    }

    public static void sendModeSmallCmd(final Context ctx, final String serverUri) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String commandUri = serverUri + "CMD=" + Command.COMMAND_MODESMALL;
                HttpClientHelper.sendCommand(
                        ctx, commandUri);

                Log.e("CommandReceiveRH", "sendModeSmallCmd:"
                        + commandUri);
            }
        });

        thread.start();
    }

    public static void sendAppRightCmd(final Context ctx, final String serverUri) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String commandUri = serverUri + "CMD=" + Command.COMMAND_APPRIGHT;
                HttpClientHelper.sendCommand(
                        ctx, commandUri);

                Log.e("CommandReceiveRH", "sendAppRightCmd:"
                        + commandUri);
            }
        });

        thread.start();
    }

    public static void sendAppBottomCmd(final Context ctx, final String serverUri) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String commandUri = serverUri + "CMD=" + Command.COMMAND_APPBOTTOM;
                HttpClientHelper.sendCommand(
                        ctx, commandUri);

                Log.e("CommandReceiveRH", "sendAppBottomCmd:"
                        + commandUri);
            }
        });

        thread.start();
    }
}
