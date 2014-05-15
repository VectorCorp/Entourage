package com.vector.entourage.utils;


public class GlobalData {

//we may want to refactor this code.. ive seen some shit advising against singletons. but being that we are only using this for 'flagging' it should be fine...
	// the actual strings will not be saved here but in the user preferences 
private static final GlobalData instance = new GlobalData(); 

public static String username; 

public static String password; 

public static boolean validated; 



static GlobalData getInstance(){


//this block is only for lazy loading, as it stands this class never has to be instantiated

if(instance == null){


}

return instance; 

}


private GlobalData(){

//should i be setting instance.password or GlobalData.password 

GlobalData.password = ""; 

GlobalData.username = ""; 

GlobalData.validated = false; 

}


public static void setUsername(String user){

GlobalData.username = user; 

}


public static void setPassword(String pass){

GlobalData.password = pass; 

}



public static String getUsername(){

return GlobalData.username; 

}


public static String getPassword(){

return GlobalData.password; 

}


//preferences code to implement: not actually a part of this class. must be edited to conform to our code and placed in the login activity 

//Button btn_login = (Button)findViewById(R.id.btn_login);
//
//Bundle extras = getIntent().getExtras();
//
//if (extras != null) {
//
//    logout_label = extras.getBoolean("logout");
//
//    if(logout_label){
//
//    btn_login.setText("Logout"); 
//
//    }
//
//    
//
//}
//
//
//
//txt_uname = (EditText)findViewById(R.id.txt_uname);
//
//txt_passwd = (EditText)findViewById(R.id.txt_upasswd);
//
////  sw_save = (Switch)findViewById(R.id.sw_save);
//
//if (AppUtil.checkSession()) {
//
//  tv_status.setText("Logged in");
//
//}
//
//
//
//login_prefs = getSharedPreferences("loginPrefs", MODE_PRIVATE);
//
//login_prefsed = login_prefs.edit();
//
//
//
//save_login = login_prefs.getBoolean("saveLogin", false);
//
//
//
//if (save_login == true) {
//
//  txt_uname.setText(login_prefs.getString("username", ""));
//
//  txt_passwd.setText(login_prefs.getString("password", ""));
//
////  sw_save.setChecked(true);
//
//}
//
//
//
//btn_login.setOnClickListener(new View.OnClickListener() {
//
//public void onClick(View v) {
//
//
//if(logout_label){
//
//login_prefsed.clear();
//
//login_prefsed.commit();
//
//txt_uname.setText(login_prefs.getString("username", ""));
//
//txt_passwd.setText(login_prefs.getString("password", ""));
//
//GlobalData.validated = false; 
//
//GlobalData.setPassword(""); 
//
//Log.i("KEON_____ preGLOBALDATA", GlobalData.username); 
//
//GlobalData.setUsername(""); 
//
//
//
//Log.i("KEON_____ preGLOBALDATA", GlobalData.password); 
//
//Log.i("KEON_____ preGLOBALDATA", GlobalData.username); 
//
//
//
//
//
//AppUtil.deleteSession(); 
//
//
//
//Intent i = new Intent(LoginActivity.this, PdsaActivity.class);
//
//startActivity(i);
//
//
//
//
//
//
//
//}else{
//
//
//InputMethodManager imm = (InputMethodManager)
//
//getSystemService(Context.INPUT_METHOD_SERVICE);
//
//imm.hideSoftInputFromWindow(txt_uname.getWindowToken(), 0);
//
//
//
//u_name = txt_uname.getText().toString();
//
//u_passwd = txt_passwd.getText().toString();
//
//
//
//Log.i("KEON_____ preGLOBALDATA", GlobalData.username); 
//
//
//
//GlobalData.setPassword(u_passwd); 
//
//GlobalData.setUsername(u_name);
//
//
//
//Log.i("KEON_____ GLOBALDATA", GlobalData.password); 
//
//Log.i("KEON_____ GLOBALDATA", GlobalData.username); 
//
//
//
//login_error = false;
//
//
//
////if (sw_save.isChecked()) {
//
//login_prefsed.putBoolean("saveLogin", true);
//
//login_prefsed.putString("username", u_name);
//
//login_prefsed.putString("password", u_passwd);
//
//login_prefsed.commit();
//
////  } else {
//
////    login_prefsed.clear();
//
////    login_prefsed.commit();
//
////  }
//
//if (AppUtil.checkSession()) {
//
//Toast.makeText(LoginActivity.this, "Already Logged in",
//
//Toast.LENGTH_SHORT).show();
//
//return;
//
//} 

}