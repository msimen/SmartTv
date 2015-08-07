package itri.smarttvsdk.bizs.persists;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by mimi on 15/3/9.
 */
public interface IJsonable {
    public boolean isCollection();

    public JSONObject instanceToJSONObject();

    public void jSONObjectToInstance(JSONObject jsonObject);

    public JSONArray instanceToJSONArray();

    public void jSONArrayToInstance(JSONArray jsonArray);
}
