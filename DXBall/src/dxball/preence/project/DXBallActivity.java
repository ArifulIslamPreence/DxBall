package dxball.preence.project;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class DXBallActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.main);
    }
    
    @Override
    protected void onResume()
    {
        super.onResume();
        
    }
    
    @Override
    protected void onStop() {
        super.onStop();
       
    }

    
    public void onClickPlay(View view) 
    {
        
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(new MainGameActivity(this));
    }
    
    public void onClickAbout(View view)
 	{
        
    }
    
    public void onClickExit(View view)
    {
        
        this.finish();
        System.exit(0);
     }
    
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        this.finish();
        System.exit(0);
    }
    
}