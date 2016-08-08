package cn.jinke.peasantcloud;

import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.RongIM.GroupInfoProvider;
import io.rong.imkit.widget.provider.InputProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.UserInfo;
import io.rong.push.RongPushClient;
import io.rong.push.common.RongException;
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
            
            String Token="c8puWxMi7dgn0nBjGuzZcs+jNUQ2Y6oq7L3J+tNH8hIFh00dHAsKvZnqPzy0Yem5bLyudbK7d2e/mwy7MGOmRg==";
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
//          if(RongIM.getInstance()!=null){
//        	  RongIM.getInstance().setCurrentUserInfo(new UserInfo("123", "专家", Uri.parse("https://www.baidu.com/img/bd_logo1.png")));
////            RongIM.getInstance().refreshUserInfoCache(new UserInfo("123", "专家", Uri.parse("https://www.baidu.com/img/bd_logo1.png")));
//            RongIM.getInstance().setMessageAttachedUserInfo(true);
//          }
          RongIM.setGroupInfoProvider(new GroupInfoProvider() {
			
			@Override
			public Group getGroupInfo(String id) {
				// TODO Auto-generated method stub
				return new Group(id, "花生病虫害交流群", Uri.parse("http://i0.peopleurl.cn/nmsgimage/20150909/b_4304371_multi_1441763363839.jpg"));
			}
		},true);
          RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() {

        	    @Override
        	    public UserInfo getUserInfo(String userId) {

        	        return findUserById(userId);//根据 userId 去你的用户系统里查询对应的用户信息返回给融云 SDK。
        	    }

				private UserInfo findUserById(String userId) {
					// TODO Auto-generated method stub
					if(userId.equals("123")){
						return new UserInfo(userId, "专家", Uri.parse("http://pic10.nipic.com/20101103/5063545_000227976000_2.jpg"));
					}else{
						return new UserInfo(userId, "农民老李", Uri.parse("http://img1.3lian.com/2015/w7/98/d/22.jpg"));
					}
					
				}

        	}, true);
         
          try {
			RongPushClient.checkManifest(getApplicationContext());
		} catch (RongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
