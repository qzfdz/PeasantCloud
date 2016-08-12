package cn.jinke.peasantcloud.adapter;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.view.HomeTabViewPager;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

public class HomeTabVpAdapter extends PagerAdapter {

	private static final int[] img_ID = { R.drawable.lunbo1, R.drawable.lunbo2,
			R.drawable.lunbo3, R.drawable.lunbo4 };

	private Context context;

	public HomeTabVpAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return 4;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	public Object instantiateItem(ViewGroup container, int position) {
		View view = View.inflate(context, R.layout.home_tab_vp_item, null);
		ImageView img = (ImageView) view.findViewById(R.id.home_tab_vp_img);
		img.setImageResource(img_ID[position]);
		container.addView(view);
		return view;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

}
