package cn.jinke.peasantcloud.activity;

import java.util.Locale;
import java.util.Set;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Conversation.ConversationType;
import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.R.layout;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ConversationActivity extends FragmentActivity implements OnClickListener{

	private ImageView UserOrGroupInfo;
	private ConversationType mConversationType ;
	private TextView chat_title;
	private RelativeLayout back_btn_conversation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conversation);
		initView();
		Intent intent=getIntent();
		//可以获取targetId title
//		Conversation con=new Conversation();
//		
//		Conversation.ConversationType type=con.getConversationType();
//		if(type==null){
//			System.out.println("type is null");//这句话输出
//		}else{
//			System.out.println(type.getName()+"??????????????");
//		}
		
		System.out.println(intent.getData().getQueryParameter("title")+"-----------");
		chat_title.setText(intent.getData().getQueryParameter("title"));
		mConversationType =Conversation.ConversationType.valueOf(intent.getData()
                .getLastPathSegment().toUpperCase(Locale.getDefault()));
		//private  group
		System.out.println(mConversationType.getName()+"==========================");
	}

	private void initView() {
		// TODO Auto-generated method stub
		chat_title=(TextView)findViewById(R.id.chat_title);
		UserOrGroupInfo=(ImageView) findViewById(R.id.UserOrGroupInfo);
		back_btn_conversation=(RelativeLayout)findViewById(R.id.back_btn_conversation);
		back_btn_conversation.setOnClickListener(this);
		UserOrGroupInfo.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId()==R.id.UserOrGroupInfo){
			if("private".equals(mConversationType.getName())){
				Intent intent=new Intent(ConversationActivity.this,FriendInfoActivity.class);
				startActivity(intent);
			}else if("group".equals(mConversationType.getName())){
				System.out.println("wo shi qunzu");
				Intent intent=new Intent(ConversationActivity.this,GroupInfoActivity.class);
				startActivity(intent);
			}
			
		}else if(arg0.getId()==R.id.back_btn_conversation){
			finish();
		}
		
		
	}

	

}
