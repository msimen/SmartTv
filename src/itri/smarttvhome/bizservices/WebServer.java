package itri.smarttvhome.bizservices;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.apache.http.HttpException;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.impl.DefaultHttpServerConnection;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpRequestHandlerRegistry;
import org.apache.http.protocol.HttpService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import itri.smarttvsdk.defines.MetaData;

public class WebServer extends Thread {
    private static final String SERVER_NAME = "MediaReceiveWebServer";
    // private static final String ALL_PATTERN = "*";
    private static final String MEDIARECEIVE_PATTEN = "/pic.html*";
    private static final String STREAMITENT_PATTEN = "/stream.html*";
    private static final String SURI_PATTEN = "/suri.html*";
    private static final String COMMAND_PATTEN = "/command.html*";
    private boolean isRunning = false;
    private Context context = null;
    private int serverPort = 0;
    private BasicHttpProcessor httpproc = null;
    private BasicHttpContext httpContext = null;
    private HttpService httpService = null;
    private HttpRequestHandlerRegistry registry = null;

    public WebServer(Context context) {
        super(SERVER_NAME);
        this.setContext(context);
    }

    @Override
    public void run() {
        super.run();

        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);

            serverSocket.setReuseAddress(true);
            while (isRunning) {
                try {
                    final Socket socket = serverSocket.accept();

                    DefaultHttpServerConnection serverConnection = new DefaultHttpServerConnection();

                    serverConnection.bind(socket, new BasicHttpParams());

                    httpService.handleRequest(serverConnection, httpContext);

                    serverConnection.shutdown();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (HttpException e) {
                    e.printStackTrace();
                }
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void startThread() {
        this.isRunning = true;

        super.start();
    }

    public synchronized void stopThread() {
        this.isRunning = false;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(context);
        this.serverPort = Integer.parseInt(pref.getString(
                MetaData.PREF_SERVER_PORT, "" + MetaData.DEFAULT_SERVER_PORT));
        this.httpproc = new BasicHttpProcessor();
        this.httpContext = new BasicHttpContext();
        this.httpService = new HttpService(httpproc,
                new DefaultConnectionReuseStrategy(),
                new DefaultHttpResponseFactory());
        this.registry = new HttpRequestHandlerRegistry();
        this.registry.register(MEDIARECEIVE_PATTEN,
                new MediaReceiveRequestHandler(context));
        this.registry.register(STREAMITENT_PATTEN,
                new StreamItentRequestHandler(context));
        this.registry.register(SURI_PATTEN, new StreamServerUriRequestHandler(
                context));
        this.registry.register(COMMAND_PATTEN, new CommandReceiveRequestHandler(
                context));
        // registry.register(MESSAGE_PATTERN, new MessageCommandHandler(context,
        // notifyManager));
        // registry.register(FOLDER_PATTERN, new FolderCommandHandler(context,
        // serverPort));
        this.httpService.setHandlerResolver(registry);
    }
}
