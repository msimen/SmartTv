package itri.smarttvhome.bizservices;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.apache.http.HttpException;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.itri.icl.droptv.sharetvcore.utilities.HttpClientHelper;

import java.io.IOException;
import java.net.InetAddress;

import itri.smarttvhome.activities.StreamPlayerActivity;
import itri.smarttvsdk.defines.MetaData;


public class StreamItentRequestHandler implements HttpRequestHandler {
    private Context context = null;

    public StreamItentRequestHandler(Context context) {
        this.context = context;
    }

    @Override
    public void handle(HttpRequest request, HttpResponse response,
                       HttpContext httpContext) throws HttpException, IOException {
        Log.e("StreamItentRH", "Uri:"
                + request.getRequestLine().getUri());
        if (request.getRequestLine().getUri().contains("/stream.html?")) {
            String instruction = request.getRequestLine().getUri()
                    .replace("/stream.html?", "");

            String[] instructs = instruction.split(";");
            String videoFilePath = instructs[1].replace("mediaFile=", "");
            Log.e("StreamItentRH", "VideoFilePath:" + videoFilePath);

            HttpInetConnection connection = (HttpInetConnection) httpContext
                    .getAttribute(ExecutionContext.HTTP_CONNECTION);
            InetAddress ia = connection.getRemoteAddress();

            ia.getHostAddress().toString();

            final String serverUri = "http://" + ia.getHostAddress().toString()
                    + ":" + MetaData.DEFAULT_SERVER_PORT + "/sst.html?"
                    + "mediaFile=" + videoFilePath;

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log.e("StreamItentRH", "http_sendLogic_command:"
                                + serverUri);
                        HttpClientHelper.sendCommand(context, serverUri);
                    } catch (Exception e) {
                        Log.e("StreamItentRH",
                                "http_sendLogic_err:" + e.getMessage());
                    }
                }
            });

            thread.start();

            Intent intent = new Intent(this.context,
                    StreamPlayerActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.context.startActivity(intent);
        }
        Log.e("StreamItentRH", "finish");
    }
}
