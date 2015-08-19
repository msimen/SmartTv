package itri.smarttvhome.bizs.tVContexts;

import itri.smarttvsdk.bizs.EventArgs;

/**
 * Created by mimi on 15/3/13.
 */
public class ChannelFailEventArgs extends EventArgs {
    private String message;

    public ChannelFailEventArgs(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
