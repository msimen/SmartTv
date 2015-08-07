package itri.smarttvsdk.bizs.tVContexts;

/**
 * Created by mimi on 15/3/13.
 */
public abstract class IRReceiverBase implements IIRReceiver {
    public int getOkCode() {
        return 66;
    }

    public int getUpCode() {
        return 19;
    }

    public int getDownCode() {
        return 20;
    }

    public int getLeftCode() {
        return 21;
    }

    public int getRightCode() {
        return 22;
    }

    public int getNumberStartCode() {
        return 7;
    }
}
