package cn.jinke.peasantcloud.fragment;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.activity.HomeSearchActivity;
import cn.jinke.peasantcloud.activity.MainActivity;
import cn.jinke.peasantcloud.adapter.ConsultLvAdapter;

/**
 * 农技咨询fragment
 */

public class ConsultFragment extends BaseFragment implements OnClickListener{

	private ImageView consult_left_user,consult_img_search;
	private SlidingMenu slidingMenu;
	private View view;
	

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.fragment_consult, null);
		return view;
	}

	@Override
	public void initData() {
		ListView listView = (ListView) view.findViewById(R.id.consult_lv);
		consult_left_user = (ImageView)view.findViewById(R.id.consult_img_user);
		consult_img_search = (ImageView)view.findViewById(R.id.consult_img_search);
		MainActivity main = (MainActivity) mActivity;
		slidingMenu = main.getSlidingMenu();
		listView.setAdapter(new ConsultLvAdapter(mActivity));
		initListener();
	}
	private void initListener() {
		consult_left_user.setOnClickListener(this);
		consult_img_search.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.consult_img_user:
			slidingMenu.toggle();
			break;
		case R.id.consult_img_search:
			Intent intent = new Intent(getActivity(),HomeSearchActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}
}
