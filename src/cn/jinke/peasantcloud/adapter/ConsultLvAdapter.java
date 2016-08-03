package cn.jinke.peasantcloud.adapter;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import cn.jinke.peasantcloud.view.MyGridView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 农技咨询界面ListView适配器
 * 
 * @author QZ
 * 
 */
public class ConsultLvAdapter extends BaseAdapter {

	private String[] consult_content = new String[] { "中央财政加大对新型职业农民培育工作支持力度",
			"洪涝灾害动物疫病防控技术指南", "聚焦绿色高产高效 引领农业转型升级", "高淳区武家嘴科技园葡萄采摘引游人 农旅结合显成效",
			"秋粮抗洪补救和防灾减灾技术意见", "全面启动实施农业基础性长期性科技工作", "六合区组织基层渔技推广人员参加市培训",
			"上半年全国农机深松整地工作开局良好", "牢记使命和责任担当攻坚克难真抓实干扎实做好农业农村改革发展稳定各项工作",
			"农民工返乡创业为三农发展注入新动力", "请问春茶采摘结束后，茶叶怎样管理有利于秋季茶叶的收成？",
			"求购淡水虾种苗及养殖基地位置所在。并求租鱼塘", "专家您好，桂花树移栽一年后树叶全部干了怎么办?",
			"南京浦口有180头散养的黑猪，能请章老师帮忙提供销售渠道的信息", "请问磨豆腐的下脚料豆渣可直接喂鹅吗？",
			"蔬菜叶子上出现很多白色的虫子，请问怎么防治？", "螃蟹池里的青苔因怎样除去?是不是气温高的时候青苔会自死掉?",
			"六合区冶山镇丘陵地带能够种植哪些经济作物?技术方法是什么?", "请问进行大规模土豆种植有什么技术规范？",
			"某些鸡掉毛现象比较严重，请问是何原因？" };

	private String[] consult_category = new String[] { "作物-其他", "化学", "提问",
			"求助" };
	private Context context;

	public ConsultLvAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
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

		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.consult_lv_list, parent, false);
		}
		TextView tv_category = BaseViewHolder.get(convertView,
				R.id.tv_consult_category);
		TextView tv_comment = BaseViewHolder.get(convertView,
				R.id.tv_consult_comment);
		TextView tv_content = BaseViewHolder.get(convertView,
				R.id.tv_consult_content);
		TextView tv_zan = BaseViewHolder.get(convertView, R.id.tv_consult_zan);
		TextView tv_zf = BaseViewHolder.get(convertView, R.id.tv_consult_zf);
		TextView tv_fav = BaseViewHolder.get(convertView, R.id.tv_consult_fav);
		tv_content.setText(consult_content[(int) (1 + Math.random() * 10)]);
		tv_category.setText(consult_category[position % 4]);
		tv_comment.setText(Integer.toString((int) (1 + Math.random()
				* (30 - 1 + 1))));
		tv_zan.setText(Integer.toString((int) (1 + Math.random() * (30 - 1 + 1))));
		tv_zf.setText(Integer.toString((int) (1 + Math.random() * (30 - 1 + 1))));
		tv_fav.setText(Integer.toString((int) (1 + Math.random() * (30 - 1 + 1))));
		return convertView;
	}

}
