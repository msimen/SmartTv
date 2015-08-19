package itri.smarttvhome.bizs.iRs.commandProviders;

/**
 * Created by mimi on 15/2/3.
 */
public class SonyIRCommandProvider implements IIRCommandProvider {
    @Override
    public String getRowCommand(String iRKey) {
        String result = "";
        if (iRKey.equals(IRCommandManager.IR_KEY_POWER)) {
            result = "send() 38 52 2400 600 1200 600 600 600 1200 600 600 600 1200 600 600 600 600 600 1200 600 600 600 600 600 600 600 600 25800 2400 600 1200 600 600 600 1200 600 600 600 1200 600 600 600 600 600 1200 600 600 600 600 600 600 600 600 25800\n";
        }
        return result;
    }
}
