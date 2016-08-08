package cn.jinke.peasantcloud.fragment;

import com.viewpagerindicator.TabPageIndicator;
import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.adapter.HomeListViewAdapter;
import cn.jinke.peasantcloud.view.DispatchViewPager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * 主页面左边农业资讯fragment
 * 
 * @author QZ
 * 
 */
public class HomeVpLeftFragment extends BaseFragment {

	private View view;
	private DispatchViewPager home_left_vp;
	private TabPageIndicator indicator;
	private static final String[] category = new String[] { "农业科技", "应时农业",
			"农事百科", "质量监督", "农业大全", "农事百科" };

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.home_vp_list_left, null);
		return view;
	}

	@Override
	public void initData() {
		home_left_vp = (DispatchViewPager) view.findViewById(R.id.home_left_vp);
		indicator = (TabPageIndicator) view.findViewById(R.id.indicator);
		home_left_vp.setAdapter(new HomeLeftVpAdapter());
		indicator.setViewPager(home_left_vp);
	}

	class HomeLeftVpAdapter extends PagerAdapter {
		@Override
		public CharSequence getPageTitle(int position) {
			return category[position];
		}

		@Override
		public int getCount() {
			return category.length;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		public Object instantiateItem(ViewGroup container, int position) {
			View leftvpView = View.inflate(mActivity,
					R.layout.home_leftvp_list, null);
			ListView lv = (ListView) leftvpView.findViewById(R.id.home_left_lv);
			lv.setAdapter(new HomeListViewAdapter(mActivity));
			container.addView(leftvpView);
			return leftvpView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}

}
