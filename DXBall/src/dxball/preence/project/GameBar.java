package dxball.preence.project;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

public class GameBar
{
	 private float barLeft, barTop, barRight, barBottom;
	    private float barWidth;
	    
	    //setting bar features
	    public  void setBar(Canvas canvas) 
	    {
	    	barLeft= (canvas.getWidth()/2)-(canvas.getWidth()/8);
	        barRight = barLeft + (canvas.getWidth()/3);
	        barBottom = canvas.getHeight()-30;
	        barTop = barBottom - 35;
	        barWidth= barLeft+barRight;
	     }
	    public void drawBar(Canvas canvas, Paint paint)
	    {
	        canvas.drawRect(barLeft, barTop, barRight, barBottom, paint);
	    }
	    
	    //setting bar values
	    public void setBarBottom(float barBottom) 
	    {
	        this.barBottom = barBottom;
	    }

	    public void setBarTop(float barTop)
	    {
	        this.barTop = barTop;
	    }

	    public void setBarLeft(float barLeft)
	    {
	        this.barLeft = barLeft;
	    }

	    public void setBarRight(float barRight)
	    {
	        this.barRight = barRight;
	    }
	    //get values
	    
	    public float getBarWidth()
	    {
	    	return this.barWidth;
	    }
	    
	    public float getBarLeft()
	    {
	        return barLeft;
	    }
	    public float getBarBottom()
	    {
	        return barBottom;
	    }
	    public float getBarRight()
	    {
	        return barRight;
	    }
	    public float getBarTop()
	    {
	        return barTop;
	    }

	   

}
