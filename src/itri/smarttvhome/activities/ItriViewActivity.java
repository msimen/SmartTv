package itri.smarttvhome.activities;

import android.os.Bundle;

import tw.futureInsighters.Tv.R;
import itri.smarttvsdk.activities.HomeAppActivityBase;

/**
 * Created by mimi on 14/12/29.
 */
public class ItriViewActivity extends HomeAppActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itriviewactivity);

//        WindowManager.LayoutParams params = getWindow().getAttributes();
//        params.x = -100;
//        params.height = 70;
//        params.width = 1000;
//        params.y = -50;
//
//        this.getWindow().setAttributes(params);
    }
}
