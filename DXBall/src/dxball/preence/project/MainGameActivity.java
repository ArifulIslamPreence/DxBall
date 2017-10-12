package dxball.preence.project;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainGameActivity extends View{
	
	
    public static boolean gameOver=false;
    boolean GameBegin=true;
    boolean StartGame;
    
    public static int life = 2;
    public static int score=0;
    int level;
    float Touch;
    
    Canvas canvas;
    Paint paint;
    GameBar bar;
    GameBall ball;
    Score scorelist;
    
    ArrayList<Brick>bricks =new ArrayList<Brick>();
	 Stage stage = new Stage();
    
  
	 @SuppressLint("ClickableViewAccessibility")
	public MainGameActivity(Context context) 
	{
		super(context);
		// TODO Auto-generated constructor stub
		paint=new Paint();
		level=1;
	
		StartGame=true;
		gameOver=false;
		
		
		 bar=new GameBar();
		 ball=new GameBall();
		
		
		
		setOnTouchListener(new OnTouchListener()
		{
			
			
			public boolean onTouch(View v,MotionEvent m)
			{
				if(ball.ballavailable())
				{
					Touch=m.getX();
					if(Touch<v.getWidth()/2 && bar.getBarLeft()>0)
					{
						bar.setBarLeft(bar.getBarLeft()-10);
						bar.setBarRight(bar.getBarRight()-10);
						Touch = -10;
					}
					else if(Touch >= v.getWidth()/2 && bar.getBarRight()<v.getWidth())
					{
						bar.setBarLeft(bar.getBarLeft()+10);
						bar.setBarRight(bar.getBarRight()+10);
						Touch = -10;
					}
					Log.i("Bar Position" , "Left : " + bar.getBarLeft() + "  Right : " + bar.getBarRight());
				}
				return true;
				
			}
		});
		
	}	
	   public void drawLifeText(Canvas canvas) {
	        paint.setColor(Color.BLACK);
	        paint.setColor(Color.WHITE);
	        paint.setTypeface(Typeface.create("Arial",Typeface.NORMAL));
	        paint.setTextSize(30);
	        canvas.drawText("LIFE : " + life,canvas.getWidth() - 160 , 60, paint);
	        canvas.drawText("LEVEL : " + level, canvas.getWidth() / 2 - 60, 60, paint);
	        canvas.drawText("SCORE : " + score,  20, 60, paint); 
	    }
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		if(GameBegin){
		
		GameBegin=false;
		bar.setBar(canvas);
		ball.setBall(canvas,bar);
		}
	
	 canvas.drawRGB(0, 0, 0);
	 paint.setColor(Color.RED);
     paint.setStyle(Paint.Style.FILL);   
     ball.drawBall(canvas,paint);
     paint.setColor(Color.LTGRAY);
     bar.drawBar(canvas,paint);
     ball.nextPos(canvas, bar, paint);
     
     drawLifeText(canvas);
     
     if(StartGame)
     {
    	 StartGame=false;
    	 if(level==1)
    	 {
    		stage.levelOne(canvas,bricks); 
    	 }
    	 
    	 else if(level==2)
    	 {
    		stage.levelTwo(canvas,bricks); 
    	 }
    	 else if(level == 3)
    	 {
    		 stage.levelThree(canvas,bricks);
    	 }
    	 else
    	 {
    		gameOver=true; 
    	 }
    		 
     }
    // this.canvas=canvas;
     
     for(int i = 0; i< bricks.size(); i++)
     {
         canvas.drawRect(bricks.get(i).getLeft(), bricks.get(i).getUp(), bricks.get(i).getRight(), bricks.get(i).getDown(), bricks.get(i).getPaint());
        
     }
     invalidate();
     ball.ballBrickCollision(bricks,ball);
     
     if(ball.ballavailable() == false && gameOver==false)
     {
         ball.setBallAvailable(true);
         GameBegin = true;
         ball.setDX(5);
         ball.setDY(-5);
     }
     
     if(life !=0 && bricks.size()==0)
     {
     	level++;
     	GameBegin=true;
     	StartGame=true;
     }
     
     if(life==0 || gameOver==true)
     {
     	levelComplete();
     }
     
     
	}
	 public void levelComplete() {
         Handler handler = new Handler();
         handler.postDelayed(new Runnable() {
               public void run() {
                   
                    Intent i = new Intent(getContext(), Score.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    String strName = String.valueOf(score);
                    i.putExtra("LEVEL", strName);
                    getContext().startActivity(i);
                    System.exit(0);
      
               }
        }, 5);//action after 5 seconds
   }
	 
	
	
	
}
	
	



	

   


