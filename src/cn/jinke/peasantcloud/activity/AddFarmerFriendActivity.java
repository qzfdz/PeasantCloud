package cn.jinke.peasantcloud.activity;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.R.layout;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/**
 * 添加农友activity
 * @author QZ
 *
 */
public class AddFarmerFriendActivity extends Activity implements
		OnClickListener {

	private RelativeLayout back_btn_addfriend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_farmer_friend);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		back_btn_addfriend = (RelativeLayout) findViewById(R.id.back_btn_addfriend);
		back_btn_addfriend.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.back_btn_addfriend:
			finish();
			break;

		}
	}
}
