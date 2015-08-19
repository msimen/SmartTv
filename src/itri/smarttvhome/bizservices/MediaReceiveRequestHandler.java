package itri.smarttvhome.bizservices;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

import itri.smarttvhome.broadcastReceivers.medias.MediaReceiveBroadcastReceiver;

public class MediaReceiveRequestHandler implements HttpRequestHandler {
    private Context context = null;

    public MediaReceiveRequestHandler(Context context) {
        this.context = context;
    }

    @Override
    public void handle(HttpRequest request, HttpResponse response,
                       HttpContext httpContext) throws HttpException, IOException {
        if (request.getRequestLine().getUri().contains("/pic.html?")) {
            String instruction = request.getRequestLine().getUri()
                    .replace("/pic.html?", "");

            String[] instructs = instruction.split(";");

            HttpInetConnection connection = (HttpInetConnection) httpContext
                    .getAttribute(ExecutionContext.HTTP_CONNECTION);
            InetAddress ia = connection.getRemoteAddress();

            ia.getHostAddress().toString();

            Log.e("MediaReceiveRequestHandler", "caller_IP:"
                    + ia.getHostAddress().toString());

            if (request instanceof HttpEntityEnclosingRequest) {

                HttpEntityEnclosingRequest entityRequest = (HttpEntityEnclosingRequest) request;
                HttpEntity entity = entityRequest.getEntity();
                if (entity != null) {
                    InputStream instream = entity.getContent();
                    int bufferSize = 1024;

                    byte[] buffer = new byte[bufferSize];
                    // File fTargetFolder = new File(this.context.getFilesDir()
                    // + "/shareTV/"
                    // + instructs[0].replace("deviceId=", ""));
                    File fTargetFolder = new File(this.context.getFilesDir()
                            + "/shareTV/");
                    if (fTargetFolder.exists() == false) {
                        fTargetFolder.mkdir();
                    }
                    String path = fTargetFolder.getAbsolutePath() + "/"
                            + instructs[1].replace("imgFile=", "");
                    // String path = fTargetFolder.getAbsolutePath() + "/a.png";
                    FileOutputStream output = new FileOutputStream(path);
                    Log.e("MediaReceiveRequestHandler", "filePath:" + path);
                    int len = 0;
                    while ((len = instream.read(buffer)) != -1) {
                        output.write(buffer, 0, len);
                    }
                    output.close();

                    Intent intent = new Intent();
                    intent.setAction(MediaReceiveBroadcastReceiver.ACTION_BROADCAST_MEDIARECEIVE);
                    intent.putExtra("filePath", path);
                    this.context.sendBroadcast(intent);
                }
            }
            Log.e("MediaReceiveRequestHandler", "finish");
        }
    }

    public byte[] toByteArrayUsingJava(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int reads = is.read();
        while (reads != -1) {
            baos.write(reads);
            reads = is.read();
        }
        return baos.toByteArray();
    }
}
