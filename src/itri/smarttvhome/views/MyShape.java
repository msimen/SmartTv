package itri.smarttvhome.views;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by mimi on 15/4/9.
 */
public class MyShape {
    private Paint paint;
    private Path path;

    public MyShape() {
        paint = new Paint();
//        paint.setColor(Color.parseColor("#ffcc00"));
        paint.setColor(Color.RED);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

        path = new Path();

        path.reset();
        path.moveTo(0, 0);
        path.lineTo(130, 50);
        path.lineTo(0, 300);
        path.close();
    }

    public Path getPath() {
        return path;
    }

    public Paint getPaint() {
        return paint;
    }
}
