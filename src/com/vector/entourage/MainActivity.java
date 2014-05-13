package com.vector.entourage;

import android.os.Bundle;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	//Test Animation
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TextView numericE = (TextView) findViewById(R.id.numericE); 
        TextView N = (TextView) findViewById(R.id.N);
        TextView T = (TextView) findViewById(R.id.T);
       // TextView O = (TextView) findViewById(R.id.O);
        TextView U = (TextView) findViewById(R.id.U);
        TextView r = (TextView) findViewById(R.id.R);
        TextView A = (TextView) findViewById(R.id.A);
        TextView G = (TextView) findViewById(R.id.G);
        TextView E = (TextView) findViewById(R.id.E);
        
        ObjectAnimator neAnimation = ObjectAnimator.ofFloat(numericE, View.ALPHA, 0, 1); 
        ObjectAnimator nAnimation = ObjectAnimator.ofFloat(N, View.ALPHA, 0, 1); 
        ObjectAnimator tAnimation = ObjectAnimator.ofFloat(T, View.ALPHA, 0, 1); 
     // ObjectAnimator oAnimation = ObjectAnimator.ofFloat(O, View.ALPHA, 1); 
        ObjectAnimator uAnimation = ObjectAnimator.ofFloat(U, View.ALPHA, 0, 1); 
        ObjectAnimator rAnimation = ObjectAnimator.ofFloat(r, View.ALPHA, 0, 1); 
        ObjectAnimator aAnimation = ObjectAnimator.ofFloat(A, View.ALPHA, 0, 1); 
        ObjectAnimator gAnimation = ObjectAnimator.ofFloat(G, View.ALPHA, 0, 1); 
        ObjectAnimator eAnimation = ObjectAnimator.ofFloat(E, View.ALPHA, 0, 1);
        
        AnimatorSet titleSet = new AnimatorSet(); 
        
        //titleSet.play(neAnimation).before(nAnimation).before(tAnimation).before(uAnimation).before(rAnimation).before(aAnimation).before(gAnimation).before(eAnimation); 
        
        
       // Animator[] animations = new Array(neAnimation, nAnimation, tAnimation, uAnimation, rAnimation, aAnimation, gAnimation, eAnimation); 
        
        titleSet.playSequentially(neAnimation, nAnimation, tAnimation, uAnimation, rAnimation, aAnimation, gAnimation, eAnimation); 
         
        
        titleSet.setDuration(500); 
        //property values holder (x and fade) 
        
        titleSet.start(); 
        
        
        
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
