package itri.smarttvsdk.interfaces;

/**
 * Created by mimi on 15/1/12.
 */
public interface IIRKeyboardReceiverDelegateListener {
    public boolean otherKeyClick(int keyCode);

    public boolean numberKeyClick(int number);

    public boolean upKeyClick();

    public boolean downKeyClick();

    public boolean leftKeyClick();

    public boolean rightKeyClick();

    public boolean okKeyClick();

    public boolean backKeyClick();

    public boolean homeKeyClick();
}

