package cn.jinke.peasantcloud;

import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.widget.provider.InputProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.UserInfo;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import cn.jinke.peasantcloud.provider.ContactsProvider;

public class MyApplication extends Application{
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext())) ||
                "io.rong.push".equals(getCurProcessName(getApplicationContext()))) {

            /**
             * IMKit SDK调用第一步 初始化
             */
            RongIM.init(this);
            
            String Token="M7nJDk9/Ksp72dcoqeFr0M+jNUQ2Y6oq7L3J+tNH8hIlZetPSwZj6gd+yK9yLncePCxdKv8c2iG/mwy7MGOmRg==";
//          String Token="qW3nbCCBOLm9UYKiEZieV0AyjF3YK/g/g0Tuv9xBL7v64qEj9tXpMs+RHrKQK4kWZUMy+BDGgFLdwObcF5b7dA==";
          RongIM.connect(Token, new RongIMClient.ConnectCallback(){
              @Override
              public void onSuccess(String s) {
            	  
            	  
           	 
              }

              @Override
              public void onError(RongIMClient.ErrorCode errorCode) {

              }

              @Override
              public void onTokenIncorrect() {

              }
          });
          RongIM.getInstance().setCurrentUserInfo(new UserInfo("123", "专家", Uri.parse("https://www.baidu.com/img/bd_logo1.png")));
          RongIM.getInstance().refreshUserInfoCache(new UserInfo("123", "专家", Uri.parse("https://www.baidu.com/img/bd_logo1.png")));
          //RongIM.getInstance().setMessageAttachedUserInfo(true);
         
        }
		
	}
	
	 public static String getCurProcessName(Context context) {

	        int pid = android.os.Process.myPid();

	        ActivityManager activityManager = (ActivityManager) context
	                .getSystemService(Context.ACTIVITY_SERVICE);

	        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
	                .getRunningAppProcesses()) {

	            if (appProcess.pid == pid) {
	                return appProcess.processName;
	            }
	        }
	        return null;
	    }

}
