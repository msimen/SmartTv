package itri.smarttvhome.bizs.iRs.commandProviders;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mimi on 15/2/3.
 */
public class IRCommandManager {
    public static final String PRODUCT_KEY_SONY = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.ProductKey_Sony";
    public static final String PRODUCT_KEY_TBC = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.ProductKey_TBC";
    public static final String IR_KEY_CHANNEPLUS = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.IRKey_ChannelPlus";
    public static final String IR_KEY_CHANNELMINUS = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.IRKey_ChannelMinus";
    public static final String IR_KEY_NUMBER0 = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.IRKey_Number0";
    public static final String IR_KEY_NUMBER1 = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.IRKey_Number1";
    public static final String IR_KEY_NUMBER2 = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.IRKey_Number2";
    public static final String IR_KEY_NUMBER3 = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.IRKey_Number3";
    public static final String IR_KEY_NUMBER4 = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.IRKey_Number4";
    public static final String IR_KEY_NUMBER5 = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.IRKey_Number5";
    public static final String IR_KEY_NUMBER6 = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.IRKey_Number6";
    public static final String IR_KEY_NUMBER7 = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.IRKey_Number7";
    public static final String IR_KEY_NUMBER8 = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.IRKey_Number8";
    public static final String IR_KEY_NUMBER9 = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.IRKey_Number9";
    public static final String IR_KEY_INFORMATION = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.IRKey_Information";
    public static final String IR_KEY_BACK = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.IRKey_Back";
    public static final String IR_KEY_OK = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.IRKey_Ok";
    public static final String IR_KEY_POWER = "itri.smarttvhome.bizs.iRs.commandProviders.IRCommandManager.IRKey_Power";

    private static Map<String, IIRCommandProvider> iRCommandProviderDict;

    private static Map<String, IIRCommandProvider> getIRCommandProviderDict() {
        if (iRCommandProviderDict == null) {
            iRCommandProviderDict = new HashMap<String, IIRCommandProvider>();
        }
        return iRCommandProviderDict;
    }

    public static String getRawCommand(String productKey, String iRKey) {
        IIRCommandProvider iRCommandProvider = getIRCommandProviderDict().get(productKey);
        if (iRCommandProvider == null) {
            if (productKey.equals(PRODUCT_KEY_SONY)) {
                iRCommandProvider = new SonyIRCommandProvider();
                getIRCommandProviderDict().put(PRODUCT_KEY_SONY, iRCommandProvider);
            }

            if (productKey.equals(PRODUCT_KEY_TBC)) {
                iRCommandProvider = new TBCIRCommandProvider();
                getIRCommandProviderDict().put(PRODUCT_KEY_TBC, iRCommandProvider);
            }
        }
        return iRCommandProvider.getRowCommand(iRKey);
    }
}
