package tw.futureInsighters.Tv;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;

public class ChannelInfoHttpsRequest extends AsyncTask<String, Void, String> {
	private int channel = 0;
	public ChannelInfoHttpsRequest(int channelIn){
		super();
		channel = channelIn;
	}
	
	@Override
	protected String doInBackground(String... params) {
		try{
			String url = "http://api.droptv.tv:8088/SmarttvWebServiceApi/GetChannelStatus";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// add request header
			
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	
			String urlParameters = "msoid=1&channelnum="+Integer.toString(channel);

			// Send post request
			
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			
			//int responseCode = con.getResponseCode();
				
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			
			StringBuffer response = new StringBuffer();
	
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
		
			}
	
			in.close();
	
			return response.toString();
		}catch(Exception e){
			return e.toString();
		}
		
	}
	protected void onPostExecute(String p) {
		// onPostExecute
		return ;
	}
}