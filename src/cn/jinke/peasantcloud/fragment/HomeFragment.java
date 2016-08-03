package cn.jinke.peasantcloud.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.view.NoScrollViewPager;
import cn.jinke.peasantcloud.view.SegmentView;
import cn.jinke.peasantcloud.view.SegmentView.onSegmentViewClickListener;

import cn.jinke.peasantcloud.activity.HomeSearchActivity;
import cn.jinke.peasantcloud.activity.MainActivity;
import cn.jinke.peasantcloud.adapter.FragmentAdapter;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * 主页面fragment,包含农业资讯和专家栏目两个fragment
 */

public class HomeFragment extends BaseFragment implements
		onSegmentViewClickListener, OnClickListener {

	private NoScrollViewPager viewPager;
	private SegmentView segmentView;
	private SlidingMenu slidingMenu;
	private ImageView home_left_user, home_img_search;
	private List<Fragment> fraglist = new ArrayList<Fragment>();
	private FragmentAdapter mFragmentAdapter;

	private HomeVpLeftFragment leftFragment;
	private HomeVpRightFragment rightFragment;

	private int page = 0;
	private View view;

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.fragment_home, null);
		return view;
	}

	@Override
	public void initData() {
		viewPager = (NoScrollViewPager) view.findViewById(R.id.home_vp);
		segmentView = (SegmentView) view.findViewById(R.id.home_seg);
		home_left_user = (ImageView) view.findViewById(R.id.home_img_user);
		home_img_search = (ImageView) view.findViewById(R.id.home_img_search);
		leftFragment = new HomeVpLeftFragment();
		rightFragment = new HomeVpRightFragment();
		fraglist.add(leftFragment);
		fraglist.add(rightFragment);
		mFragmentAdapter = new FragmentAdapter(getChildFragmentManager(),
				fraglist);

		viewPager.setAdapter(mFragmentAdapter);
		viewPager.setCurrentItem(0);
		MainActivity main = (MainActivity) mActivity;
		slidingMenu = main.getSlidingMenu();
		initListener();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		page = viewPager.getCurrentItem();
	}

	@Override
	public void onStop() {
		super.onStop();
		page = viewPager.getCurrentItem();
	}

	@Override
	public void onResume() {
		super.onResume();
		if (segmentView != null) {
			segmentView.setSelected(page);
		}
	}

	private void initListener() {
		segmentView.setOnSegmentViewClickListener(this);
		home_left_user.setOnClickListener(this);
		home_img_search.setOnClickListener(this);
	}

	@Override
	public void onSegmentViewClick(View v, int position) {
		if (position == 0) {
			viewPager.setCurrentItem(0, false);
		} else {
			viewPager.setCurrentItem(1, false);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.home_img_user:
			slidingMenu.toggle();
			break;
		case R.id.home_img_search:
			Intent intent = new Intent(mActivity, HomeSearchActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

}
