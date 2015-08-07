package itri.smarttvsdk.interfaces;

/**
 * Created by mimi on 14/12/18.
 */
@org.alljoyn.bus.annotation.BusInterface(name = "itri.smarttvsdk.interfaces.ITVHomeServiceInterface")

public interface ITVHomeServiceInterface {

    @org.alljoyn.bus.annotation.BusMethod
    String ping(String s) throws org.alljoyn.bus.BusException;

    @org.alljoyn.bus.annotation.BusProperty
    String getServiceIP4Address() throws org.alljoyn.bus.BusException;

    @org.alljoyn.bus.annotation.BusProperty
    String getServiceIP6Address() throws org.alljoyn.bus.BusException;
}
