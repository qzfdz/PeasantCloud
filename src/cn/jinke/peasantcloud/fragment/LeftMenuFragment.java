package cn.jinke.peasantcloud.fragment;

import cn.jinke.peasantcloud.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 侧边栏fragment
 * 
 * @author QZ
 * 
 */
public class LeftMenuFragment extends BaseFragment {

	private static final String[] LEFT_MENU_TEXT = new String[] { "农情提醒",
			"扫一扫", "消息通知", "我的工作", "系统设置" };
	private static final int[] LEFT_MENU_IMG = new int[] {
			R.drawable.home_left_menu_list1, R.drawable.home_left_menu_list2,
			R.drawable.home_left_menu_list3, R.drawable.home_left_menu_list4,
			R.drawable.home_left_menu_list5 };
	private View view;

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.fragment_left_menu, null);
		return view;
	}

	@Override
	public void initData() {
		ListView home_left_menu_lv = (ListView) view
				.findViewById(R.id.home_left_menu_lv);
		home_left_menu_lv.setAdapter(new MenuAdapter());
	}

	class MenuAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 5;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = View.inflate(mActivity, R.layout.home_menu_lv_item,
					null);
			ImageView imageView = (ImageView) view
					.findViewById(R.id.home_left_menu_lv_img);
			TextView textView = (TextView) view
					.findViewById(R.id.home_left_menu_lv_text);
			imageView.setBackgroundResource(LEFT_MENU_IMG[position]);
			textView.setText(LEFT_MENU_TEXT[position]);
			return view;
		}

	}

}
