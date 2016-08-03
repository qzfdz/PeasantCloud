package cn.jinke.peasantcloud.fragment;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.adapter.HomeListViewAdapter;
import android.view.View;
import android.widget.ListView;

/**
 * 主页面右边专家栏目fragment
 * 
 * @author QZ
 * 
 */
public class HomeVpRightFragment extends BaseFragment {

	private View view;
	private ListView listView;

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.home_vp_list_right, null);
		return view;
	}

	@Override
	public void initData() {
		listView = (ListView) view.findViewById(R.id.home_right_lv);
		listView.setAdapter(new HomeListViewAdapter(getActivity()));
	}
}
