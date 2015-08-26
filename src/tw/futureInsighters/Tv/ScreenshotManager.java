package tw.futureInsighters.Tv;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.Date;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ScreenshotManager {
	private Activity mActivity;
	public ScreenshotManager(Activity activity){
		this.mActivity = activity;
	}
	public String screenshot(){
		Date now = new Date();
	    android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

	    try {
	        // image naming and path  to include sd card  appending name you choose for file
//	        String mPath = mActivity.getFileDir().toString() + "/" + now + ".jpg";

	        // create bitmap screen capture
	        View v1 = mActivity.getWindow().getDecorView().getRootView();
	        v1.setDrawingCacheEnabled(true);
	        Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
	        v1.setDrawingCacheEnabled(false);

	        //File imageFile = new File(mActivity.getFilesDir() + "/data/files/", "sample.jpg");
	        
//	        FileOutputStream outputStream = new FileOutputStream(imageFile);
	        int quality = 100;
//	        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
//	        outputStream.flush();
//	        outputStream.close();
	        
//	        Intent intent = new Intent();
//		    intent.setAction(Intent.ACTION_VIEW);
//		    Uri uri = Uri.fromFile(imageFile);
//		    intent.setDataAndType(uri, "image/*");
//		    mActivity.startActivity(intent);
	        
		    Log.d("screenshot manager","handsome shot!!");
	        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
	        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, byteArrayOutputStream);
	        byte[] b = byteArrayOutputStream.toByteArray();
	        String encodedImage = Base64.encodeToString(b,Base64.DEFAULT);
	        
	        final ImageView programStartTimeIcon = (ImageView)mActivity.findViewById(R.id.bookmark_img);
	        programStartTimeIcon.setImageBitmap(bitmap);
//	        byte[] decodedString = Base64.decode(bitmap.getPhoto(),Base64.NO_WRAP);
//	        InputStream inputStream  = new ByteArrayInputStream(decodedString);
//	        Bitmap bitmap  = BitmapFactory.decodeStream(inputStream);
//	        user_image.setImageBitmap(bitmap);
	        
	        return encodedImage;

//	        openScreenshot(imageFile);
	    } catch (Throwable e) {
	        // Several error may come out with file handling or OOM
	    	Log.d("screfhermanetoghe",e.toString());
	    	return e.toString();
	    }
//	    return "";
	}
}
