package tw.futureInsighters.Tv.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.content.Context;
import android.content.SharedPreferences;

public class SoftwareHashIdManager {
	private Context context;
	public SoftwareHashIdManager(Context context){
		this.context = context;
	}
	public String getSoftwareRandomID() {
		// TelephonyManager tManager =
		// (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
		// String uuid = tManager.getDeviceId();
		// return uuid;

		SharedPreferences softwareIDPref = context.getSharedPreferences(
				"softwareID", 0);
		String result = softwareIDPref.getString("softwareID", "");
		if (result.equals("")) {
			SharedPreferences.Editor editor = softwareIDPref.edit();
			String newID = md5(Long.toString(System.currentTimeMillis()));
			editor.putString("softwareID", newID);
			editor.commit();
			result = newID;
		}
		return result;

	}

	// this function was copied from
	// http://www.mysamplecode.com/2011/10/android-generate-md5-hash.html
	private String md5(String s) {
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
