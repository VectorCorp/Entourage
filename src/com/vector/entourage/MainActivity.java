package com.vector.entourage;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity{
	//Test Animation
	
	Context context; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        context = getApplicationContext(); 
        
        ViewGroup container = (ViewGroup) findViewById(R.id.container); 
        
        
        // Views for the individual title characters 
        TextView numericE = (TextView) findViewById(R.id.numericE); 
        TextView N = (TextView) findViewById(R.id.N);
        TextView T = (TextView) findViewById(R.id.T);
       // TextView O = (TextView) findViewById(R.id.O);
        TextView U = (TextView) findViewById(R.id.U);
        TextView r = (TextView) findViewById(R.id.R);
        TextView A = (TextView) findViewById(R.id.A);
        TextView G = (TextView) findViewById(R.id.G);
        TextView E = (TextView) findViewById(R.id.E);
        
        // Views for the login labels/fields
        TextView loginLabel = (TextView) findViewById(R.id.login_label); 
        TextView loginField = (TextView) findViewById(R.id.login);
        
        //Views for the password labels/fields
        TextView passwordLabel = (TextView) findViewById(R.id.password_label); 
        TextView passwordField = (TextView) findViewById(R.id.password);
        
        //Views for the login button 
        Button loginButton = (Button) findViewById(R.id.loginButton); 
        loginButton.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		URL url = null; 
				try {
					url = new URL("http://10.0.0.107:9000/rest/ping");
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		new EntourageAsyncTask().execute(url); 
        		
        	}
        }); 
        
        // Animations for the individual title characters 
        ObjectAnimator neAnimation = ObjectAnimator.ofFloat(numericE, View.ALPHA, 0, 1); 
        ObjectAnimator nAnimation = ObjectAnimator.ofFloat(N, View.ALPHA, 0, 1); 
        ObjectAnimator tAnimation = ObjectAnimator.ofFloat(T, View.ALPHA, 0, 1); 
     // ObjectAnimator oAnimation = ObjectAnimator.ofFloat(O, View.ALPHA, 1); 
        ObjectAnimator uAnimation = ObjectAnimator.ofFloat(U, View.ALPHA, 0, 1); 
        ObjectAnimator rAnimation = ObjectAnimator.ofFloat(r, View.ALPHA, 0, 1); 
        ObjectAnimator aAnimation = ObjectAnimator.ofFloat(A, View.ALPHA, 0, 1); 
        ObjectAnimator gAnimation = ObjectAnimator.ofFloat(G, View.ALPHA, 0, 1); 
        ObjectAnimator eAnimation = ObjectAnimator.ofFloat(E, View.ALPHA, 0, 1);

        //titleSet.play(neAnimation).before(nAnimation).before(tAnimation).before(uAnimation).before(rAnimation).before(aAnimation).before(gAnimation).before(eAnimation);
       // Animator[] animations = new Array(neAnimation, nAnimation, tAnimation, uAnimation, rAnimation, aAnimation, gAnimation, eAnimation); 
        
        //titleSet.setDuration(500); 
        //property values holder (x and fade) 
        //titleSet.start(); 
        
        
        //LOGIN X POSITION 
        ObjectAnimator loginLabelXAnimation = ObjectAnimator.ofFloat(loginLabel, "x", 400f, 40f); 
        loginLabelXAnimation.setDuration(600); 
        ObjectAnimator loginXAnimation = ObjectAnimator.ofFloat(loginField, "x", 400f, 280f);
        loginXAnimation.setDuration(600); 
        
        // LOGIN FADE ANIMATIONS 
        ObjectAnimator loginFadeAnimation = ObjectAnimator.ofFloat(loginField, "alpha", 0, 1); 
        ObjectAnimator loginLabelFadeAnimation = ObjectAnimator.ofFloat(loginLabel, "alpha", 0, 1); 
        
        
        //PASSWORD X ANIMATIONS 
        ObjectAnimator passwordLabelXAnimation = ObjectAnimator.ofFloat(passwordLabel, "x", 400f, 40f); 
        passwordLabelXAnimation.setDuration(600); 
        ObjectAnimator passwordXAnimation = ObjectAnimator.ofFloat(passwordField, "x", 400f, 280f);
        passwordXAnimation.setDuration(600); 
        
        //PASSWORD FADE ANIMATIONS
        
        ObjectAnimator passwordFadeAnimation = ObjectAnimator.ofFloat(passwordField, "alpha", 0, 1); 
        ObjectAnimator passwordLabelFadeAnimation = ObjectAnimator.ofFloat(passwordLabel, "alpha", 0, 1); 
        

       // ObjectAnimator loginFade = ObjectAnimator.ofFloat(loginField, "alpha", 0, 1); 
       // ObjectAnimator loginFade = ObjectAnimator.ofFloat(loginField, "alpha", 0, 1); 
        
        
        AnimatorSet titleAndFields = new AnimatorSet(); 
        AnimatorSet loginLabelSet = new AnimatorSet(); 
        AnimatorSet loginFieldSet = new AnimatorSet();
        
        AnimatorSet passwordLabelSet = new AnimatorSet(); 
        AnimatorSet passwordFieldSet = new AnimatorSet(); 
        
        AnimatorSet titleSet = new AnimatorSet();
        
        
       // loginFadeSet.play(loginFade).with(loginLabelFade);
        loginLabelSet.play(loginLabelXAnimation).with(loginLabelFadeAnimation); 
        loginFieldSet.play(loginXAnimation).with(loginFadeAnimation); 
        titleSet.playSequentially(neAnimation, nAnimation, tAnimation, uAnimation, rAnimation, aAnimation, gAnimation, eAnimation); 
        
        
        passwordLabelSet.play(passwordLabelXAnimation).with(passwordLabelFadeAnimation); 
        passwordFieldSet.play(passwordXAnimation).with(passwordFadeAnimation);
        
        //for the desired effect it may be necessary to set a duration for each of the title characters 
        //titleSet.play(neAnimation).with(nAnimation).with(tAnimation).with(uAnimation).with(rAnimation).with(aAnimation).with(gAnimation).with(eAnimation); 
         
        titleAndFields.playSequentially(titleSet, loginLabelSet, loginFieldSet, passwordLabelSet, passwordFieldSet);
        
        titleAndFields.start(); 
       
        
         
        
        
        // Only for android 4.4 (can we find a use for this now or in the forseeable future? perhaps in a revision of the app aimed at optimization...)
        //Scene login_scene1 = Scene.getSceneForLayout(container, R.layout.login_scene1, context); 
        
        // TransitionManager transitionManager = new TransitionManager(); 
       // transitionManager.transitionTo(login_scene1); 
        
        
        
        // actually we will need to use both: 
        // property animatin for the title, and transitions for the login/signup shitcanoni
        
        //Add code for custom animation that drops to the top of the screen and fades the view in 
        
        //layout transition may not be the way to go for this, as we really just want to 
        //animate the exisiting layout, we are not ammending it
//        LayoutTransition trans = new LayoutTransition()	; 
//       trans.enableTransitionType(LayoutTransition.CHANGING);
//        viewGroup = (ViewGroup) findViewById(R.id.container);
//        viewGroup.setLayoutTransition(trans);
        
       // TextView e = (TextView) findViewById(R.id.numericE); 
       // e.animate() pass the animator object to this object 
        //viewGroup.addView(e);  
        
    }


    
    
    public void addView(View v){
    	
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }





	
	private class EntourageAsyncTask  extends AsyncTask<URL, Void, String> {
		//Test Animation
		
		@Override
		protected String doInBackground(URL... urls) {
			// TODO Auto-generated method stub
			try {
				return urlRequest(urls[0]); 
			}catch (IOException e){
				return "Error. URL may be invalid"; 
			}
			
		} 
		
	   @Override
	   protected void onPostExecute(String result){
		   Log.d("SERVER RESPONSE", result); 
		   
	   }
	   
	   private String urlRequest(URL myurl) throws IOException{
		   
		   InputStream is = null; 
		   
		   int length; 
		   
		   try{
			   HttpURLConnection conn = (HttpURLConnection) myurl.openConnection(); 
			   conn.setReadTimeout(10000); 
			   conn.setConnectTimeout(15000); 
			   conn.setRequestMethod("GET");
			   conn.setDoInput(true); 
			   conn.connect(); 
			   
			   int response = conn.getResponseCode(); 
			   Log.d("HTTP RESPONSE", "The response is : " + response); 
			   
			   
		   }finally {
			   if (is != null){
				   is.close(); 
			   }
		   }
		   
		   return ""; 
	   }
	   

	    
	}
    
}
