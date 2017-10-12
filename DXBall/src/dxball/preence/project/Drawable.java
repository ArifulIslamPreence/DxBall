package dxball.preence.project;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Drawable 
{
	float x;
    float y;
    Paint paint;

    public float getX() {
        return this.x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public float getY() {
        return this.y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public abstract void onDraw(Canvas canvas,Paint paint);
}