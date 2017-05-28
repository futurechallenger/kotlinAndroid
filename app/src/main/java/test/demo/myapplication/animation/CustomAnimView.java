package test.demo.myapplication.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by challenger on 3/4/2017.
 */

public class CustomAnimView extends View {
    private Runnable animator = new Runnable() {
        @Override
        public void run() {
            if (!isStopped()) {
                invalidate();
                postDelayed(this, 20);
            }
        }
    };

    public CustomAnimView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        changeAlpha();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        if (action == MotionEvent.ACTION_DOWN) {
            startAnim();
        }

        return true;
    }

    private boolean isStopped() {
        float currentAlpha = getAlpha();
        if (currentAlpha < 0.01) {
            return true;
        }
        return false;
    }

    private void changeAlpha() {
        float currentAlpha = this.getAlpha();
        this.setAlpha(currentAlpha * 0.9f);
    }

    public void startAnim() {
        post(animator);
    }
}
