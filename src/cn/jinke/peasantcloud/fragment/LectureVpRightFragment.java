package cn.jinke.peasantcloud.fragment;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.activity.LiveActivity;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import cn.jinke.peasantcloud.view.MyGridView;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 农技咨询直播fragment
 * 
 * @author QZ
 * 
 */
public class LectureVpRightFragment extends BaseFragment {

	private static final String[] AgricultureText = new String[] { "农业机械",
			"农技推广", "夷陵农业", "信息农业", "农业养殖", "农业执法", "中国农业", "农业种植", "农业科技" };
	private static final int[] AgriculturImg = { R.drawable.agriculture1,
			R.drawable.agriculture2, R.drawable.agriculture3,
			R.drawable.agriculture4, R.drawable.agriculture5,
			R.drawable.agriculture6, R.drawable.agriculture7,
			R.drawable.agriculture8, R.drawable.agriculture1 };
	private MyGridView gv;
	private View view;

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.lecture_vp_live, null);
		return view;
	}

	@Override
	public void initData() {
		gv = (MyGridView) view.findViewById(R.id.lecture_live_gv);
		gv.setAdapter(new LiveGvAdapter());
		initListener();
	}

	private void initListener() {
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(getActivity(), LiveActivity.class);
				startActivity(intent);

			}

		});

	}

	class LiveGvAdapter extends BaseAdapter {
		public int getCount() {
			// TODO Auto-generated method stub
			return 9;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(mActivity).inflate(
						R.layout.lecture_live_gv_list, parent, false);
			}
			ImageView img_name = BaseViewHolder.get(convertView,
					R.id.live_gv_img);
			TextView tv_name = BaseViewHolder.get(convertView, R.id.live_gv_tv);

			img_name.setBackgroundResource(AgriculturImg[position]);
			tv_name.setText(AgricultureText[position]);
			return convertView;
		}
	}

}
