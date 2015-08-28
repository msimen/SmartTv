package tw.futureInsighters.Tv;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

public class CollectUserInfoHttpsRequest extends
		AsyncTask<String, Void, String> {
	private int channel = 0;
	private String programname;
	private String username;
	private Context context;

	public CollectUserInfoHttpsRequest(Context context, int channelIn,
			String programname, String username) {
		super();
		channel = channelIn;
		this.programname = programname;
		this.username = username;
		this.context = context;
	}

	@Override
	protected String doInBackground(String... params) {
		try {
			// POST data to a temporary server!
			String url = "http://helloworld135.comli.com/collect.php";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// add request header

			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			String urlParameters = "channel=" + Integer.toString(this.channel)
					+ "&programname=" + URLEncoder.encode(programname, "utf-8")
					+ "&username=" + URLEncoder.encode(username, "utf-8")
					+ "&mac=" + getSoftwareRandomID();

			// Send post request

			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			// int responseCode = con.getResponseCode();

			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;

			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);

			}

			in.close();

			return response.toString();
		} catch (Exception e) {
			return e.toString();
		}

	}

	protected void onPostExecute(String p) {
		// onPostExecute
		return;
	}

	private String getSoftwareRandomID() {
		// TelephonyManager tManager =
		// (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
		// String uuid = tManager.getDeviceId();
		// return uuid;

		SharedPreferences softwareIDPref = context.getSharedPreferences(
				"softwareID", 0);
		String result = softwareIDPref.getString("softwareID", "");
		if (result.equals("")) {
			SharedPreferences.Editor editor = softwareIDPref.edit();
			String newID = md5(Integer.toString(new Random().nextInt(500)));
			editor.putString("softwareID", newID);
			editor.commit();
			result = newID;
		}
		return result;

	}

	// this function was copied from
	// http://www.mysamplecode.com/2011/10/android-generate-md5-hash.html
	private static String md5(String s) {
		try {

			// Create MD5 Hash
			MessageDigest digest = java.security.MessageDigest
					.getInstance("MD5");
			digest.update(s.getBytes());
			byte messageDigest[] = digest.digest();

			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++)
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";

	}
}
