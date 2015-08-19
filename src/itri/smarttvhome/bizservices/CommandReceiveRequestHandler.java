package itri.smarttvhome.bizservices;

import android.content.Context;

import org.apache.http.HttpException;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

import java.io.IOException;
import java.net.InetAddress;

import itri.smarttvsdk.broadcastSenders.IBroadcastSender;
import itri.smarttvsdk.broadcastSenders.commands.CmdAdBroadcastSender;
import itri.smarttvsdk.broadcastSenders.commands.CmdAppBottomBroadcastSender;
import itri.smarttvsdk.broadcastSenders.commands.CmdAppRightBroadcastSender;
import itri.smarttvsdk.broadcastSenders.commands.CmdBackBroadcastSender;
import itri.smarttvsdk.broadcastSenders.commands.CmdDownBroadcastSender;
import itri.smarttvsdk.broadcastSenders.commands.CmdHomeBroadcastSender;
import itri.smarttvsdk.broadcastSenders.commands.CmdLeftBroadcastSender;
import itri.smarttvsdk.broadcastSenders.commands.CmdModeFullBroadcastSender;
import itri.smarttvsdk.broadcastSenders.commands.CmdModeSmallBroadcastSender;
import itri.smarttvsdk.broadcastSenders.commands.CmdOkBroadcastSender;
import itri.smarttvsdk.broadcastSenders.commands.CmdRightBroadcastSender;
import itri.smarttvsdk.broadcastSenders.commands.CmdUpBroadcastSender;
import itri.smarttvsdk.defines.Command;

//import org.itri.icl.droptv.sharetvhome.contract.defines.Command;

public class CommandReceiveRequestHandler implements HttpRequestHandler {
    private Context context = null;

    public CommandReceiveRequestHandler(Context context) {
        this.context = context;
    }

    @Override
    public void handle(HttpRequest request, HttpResponse response,
                       HttpContext httpContext) throws HttpException, IOException {
        if (request.getRequestLine().getUri().contains("/command.html?")) {
            String instruction = request.getRequestLine().getUri()
                    .replace("/command.html?", "");

            String[] instructs = instruction.split(";");

            HttpInetConnection connection = (HttpInetConnection) httpContext
                    .getAttribute(ExecutionContext.HTTP_CONNECTION);
            InetAddress ia = connection.getRemoteAddress();

            ia.getHostAddress().toString();

            String cmd = instructs[0].replace("CMD=", "");
            IBroadcastSender sender = null;
            if (cmd.equals(Command.COMMAND_UP)) {
                sender = new CmdUpBroadcastSender(this.context);
            }
            if (cmd.equals(Command.COMMAND_DOWN)) {
                sender = new CmdDownBroadcastSender(this.context);
            }
            if (cmd.equals(Command.COMMAND_LEFT)) {
                sender = new CmdLeftBroadcastSender(this.context);
            }
            if (cmd.equals(Command.COMMAND_RIGHT)) {
                sender = new CmdRightBroadcastSender(this.context);
            }
            if (cmd.equals(Command.COMMAND_BACK)) {
                sender = new CmdBackBroadcastSender(this.context);
            }
            if (cmd.equals(Command.COMMAND_HOME)) {
                sender = new CmdHomeBroadcastSender(this.context);
            }
            if (cmd.equals(Command.COMMAND_OK)) {
                sender = new CmdOkBroadcastSender(this.context);
            }
            if (cmd.equals(Command.COMMAND_AD)) {
                sender = new CmdAdBroadcastSender(this.context);
            }
            if (cmd.equals(Command.COMMAND_MODEFULL)) {
                sender = new CmdModeFullBroadcastSender(this.context);
            }
            if (cmd.equals(Command.COMMAND_MODESMALL)) {
                sender = new CmdModeSmallBroadcastSender(this.context);
            }
            if (cmd.equals(Command.COMMAND_APPRIGHT)) {
                sender = new CmdAppRightBroadcastSender(this.context);
            }
            if (cmd.equals(Command.COMMAND_APPBOTTOM)) {
                sender = new CmdAppBottomBroadcastSender(this.context);
            }
            if (sender != null)
                sender.send();

        }
    }
}
