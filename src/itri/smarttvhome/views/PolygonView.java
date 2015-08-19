package itri.smarttvhome.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mimi on 15/4/9.
 */
public class PolygonView extends View {

    MyShape myShape;
    float ratioRadius;
    int numberOfPoint = 3; //default

    public PolygonView(Context context) {
        super(context);
        initMyView();
    }

    public PolygonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initMyView();
    }

    public PolygonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initMyView();
    }

    public void initMyView() {
        myShape = new MyShape();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(myShape.getPath(), myShape.getPaint());
    }

}
