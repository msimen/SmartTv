package tw.futureInsighters.Tv.utilities;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.os.AsyncTask;

public class GetSuggestionHttpsRequest extends AsyncTask<String, Void, String> {
	private Context context;
	private String userName;
	public GetSuggestionHttpsRequest(Context context,String userName){
		super();
		this.context = context;
		this.userName = userName;
	}
	
	@Override
	protected String doInBackground(String... params) {
		try{
			String url = "http://helloworld135.comli.com/suggestion.php";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// add request header
			
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	
			String urlParameters = "username=" + userName + "&mac="
					+ new SoftwareHashIdManager(context).getSoftwareRandomID();
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