package itri.smarttvhome.bizservices;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

import java.io.IOException;

import itri.smarttvhome.activities.StreamPlayerActivity;

public class StreamServerUriRequestHandler implements HttpRequestHandler {
    private Context context = null;

    public StreamServerUriRequestHandler(Context context) {
        this.context = context;
    }

    @Override
    public void handle(HttpRequest request, HttpResponse response,
                       HttpContext httpContext) throws HttpException, IOException {
        Log.e("StreamServerUriRequestHandler", "Uri:"
                + request.getRequestLine().getUri());

        if (request.getRequestLine().getUri().contains("/suri.html?")) {
            String instruction = request.getRequestLine().getUri()
                    .replace("/suri.html?", "");

            String[] instructs = instruction.split(";");
            String streamServerUri = instructs[0].replace("suri=", "");

            Log.e("StreamServerUriRequestHandler", "streamServerUri:"
                    + streamServerUri);

            Intent intent = new Intent(this.context, StreamPlayerActivity.class);
            intent.putExtra("suri", streamServerUri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.context.startActivity(intent);

        }
    }
}
