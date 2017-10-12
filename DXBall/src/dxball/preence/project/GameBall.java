package dxball.preence.project;

import android.graphics.Canvas;
import android.graphics.Paint;

import android.util.Log;

import java.util.ArrayList;

public class GameBall
{
	private boolean ballavailable=true;
	private float x,y;
	private float dx=5;
	private float dy=-5;
	private float rad=25;
	
	//constructor for object
	public GameBall()
	{
		//auto generate
		
	}
	 public boolean ballavailable() 
	 {
	        return ballavailable;
	 }
	 
	 
	 
	//settting values
	 
	 public void setBall(Canvas canvas,GameBar bar)
	 {
		 float BarMid=(bar. getBarRight()-bar.getBarLeft())/2;
		 x=bar.getBarLeft()+BarMid;
		 y=bar.getBarTop()-rad;
	 }
	 
	 public void setBallAvailable(boolean BallAvailable) {
	        this.ballavailable = BallAvailable;
	    }
	 
	 public void setX(float x)
	 	{ 
	    	this.x = x; 
	 	}
	 
	 public void setY(float y)
	 	{
	        this.y = y;
	 	}
	 
	 public void setDX(float dx) 
	 	{ 
	    	this.dx = dx; 
	 	}
	    
	 public void setDY(float dy)
	    { 
	    	this.dy = dy; 
	    }
	    
	 public void setRadius(float radius) 
	    { 
	    	this.rad = radius; 
	    }
	    
	    //getting values
	 public float getX() 
	    { 
	    	return this.x; 
	    }

	   

	 public float getY() 
	    {
	        return this.y;
	    }
   

	 public float getDX() 
	    {
	        return this.dx;
	    }

	   

	 public float getDY()
	    {
	        return this.dy;
	    }

	  
	    
	  public float getRadius()
	    { 
	    	return this.rad; 
	    }
	  
	  
	  public void drawBall(Canvas canvas, Paint paint)
	  {
		  Log.d("Drawing ball"," Ball in Ball Class");
	        canvas.drawCircle(x,y,rad,paint);
	  }
	  public void nextPos(Canvas canvas, GameBar bar, Paint paint) 
	  {
	    	if(x < rad || x > (canvas.getWidth() - rad)){
	    		dx =-dx;
	    		
	    	}
	    	
	    	if(y < rad|| y > (canvas.getHeight() - rad)){
	    		dy=-dy;
	    	}
	    	
	    	else if (y + rad > bar.getBarTop() && x > bar.getBarLeft() && x < bar.getBarRight()) { 
	    		 dy = -dy; 
	    	}
	    	else if(x+rad == bar.getBarLeft()-20 && y>=bar.getBarTop()){
	            dx = - dx;
	        }
	    	else if(x+rad == bar.getBarRight() +20 && y >= bar.getBarTop()){
	            dy = - dy;
	        }
	    
	    	else if(y>bar.getBarBottom()-rad)
	    	{
	    		dx=0;
	    		dy=0;
	    		MainGameActivity.life--;
	    		ballavailable=false;
	    	}
	    	else
	    	{
	    		x += dx;
	    		y += dy;
	    	}
	    
	    }
	  
	  public void ballBrickCollision(ArrayList<Brick> br, GameBall ball){
	        for(int i=0;i<br.size();i++) {
	            if (((ball.getY() - ball.getRadius()) <= br.get(i).getDown()) && ((ball.getY() + ball.getRadius()) >= br.get(i).getUp()) && ((ball.getX()) >= br.get(i).getLeft()) && ((ball.getX()) <= br.get(i).getRight())) {
	                br.remove(i); 
	                MainGameActivity.score +=1;
	                ball.setDY(-(ball.getDY()));
	            }
	            else if(((ball.getY()) <= br.get(i).getDown()) && ((ball.getY()) >= br.get(i).getUp()) && ((ball.getX() + ball.getRadius()) >= br.get(i).getLeft()) && ((ball.getX() - ball.getRadius()) <= br.get(i).getRight())) {
	                br.remove(i);
	                MainGameActivity.score +=1;
	                ball.setDX(-(ball.getDX()));
	            }
	        }
	    }
	

}
