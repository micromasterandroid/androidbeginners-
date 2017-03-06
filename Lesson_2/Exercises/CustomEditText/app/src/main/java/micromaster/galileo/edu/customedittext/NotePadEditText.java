package micromaster.galileo.edu.customedittext;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.EditText;

public class NotePadEditText extends EditText {

    private Rect rect;
    private Paint paint;

    public NotePadEditText(Context context) {
        super(context);
        initialize();
    }

    public NotePadEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public NotePadEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ContextCompat.getColor(getContext(), R.color.colorLineNote));
        paint.setStrokeWidth(6);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //width line
        float startPointX = getPaddingLeft();
        float finishPointX = getWidth() - getPaddingRight();
        //initial Y position
        float startPositionY = getPaddingTop() + getLineHeight();

        // for every line on EditText we draw a line
        for (int i = 0; i < getLineCount(); ++i) {
            float offsetY = startPositionY + getLineHeight() * i;
            canvas.drawLine(startPointX, offsetY, finishPointX, offsetY, paint);
        }

        super.onDraw(canvas);
    }
}
