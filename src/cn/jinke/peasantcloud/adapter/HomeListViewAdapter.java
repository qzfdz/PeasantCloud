package cn.jinke.peasantcloud.adapter;

import cn.jinke.peasantcloud.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.jinke.peasantcloud.utils.BaseViewHolder;

public class HomeListViewAdapter extends BaseAdapter{

	public String[] img_text = {"中央财政加大对新型职业农民培育工作支持力度", "洪涝灾害动物疫病防控技术指南",
			"聚焦绿色高产高效 引领农业转型升级", "高淳区武家嘴科技园葡萄采摘引游人 农旅结合显成效", 
			"秋粮抗洪补救和防灾减灾技术意见","全面启动实施农业基础性长期性科技工作","六合区组织基层渔技推广人员参加市培训",
			"上半年全国农机深松整地工作开局良好","牢记使命和责任担当攻坚克难真抓实干扎实做好农业农村改革发展稳定各项工作",
			"农民工返乡创业为三农发展注入新动力","请问春茶采摘结束后，茶叶怎样管理有利于秋季茶叶的收成？","求购淡水虾种苗及养殖基地位置所在。并求租鱼塘",
			"专家您好，桂花树移栽一年后树叶全部干了怎么办?","南京浦口有180头散养的黑猪，能请章老师帮忙提供销售渠道的信息","请问磨豆腐的下脚料豆渣可直接喂鹅吗？",
			"蔬菜叶子上出现很多白色的虫子，请问怎么防治？","螃蟹池里的青苔因怎样除去?是不是气温高的时候青苔会自死掉?","六合区冶山镇丘陵地带能够种植哪些经济作物?技术方法是什么?",
			"请问进行大规模土豆种植有什么技术规范？","某些鸡掉毛现象比较严重，请问是何原因？"};
	private Context context;
	public HomeListViewAdapter(Context context) {
		this.context = context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
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
			convertView = LayoutInflater.from(context).inflate(
					R.layout.home_left_lv_item, parent, false);
		}		
		TextView tv_content = BaseViewHolder.get(convertView, R.id.tv_home_content);
		TextView tv_comment = BaseViewHolder.get(convertView, R.id.tv_home_comment);
		tv_content.setText(img_text[(int)(1+Math.random()*10)]);		
		tv_comment.setText(Integer.toString((int)(1+Math.random()*(100-1+1))));		
		return convertView;
	}

}
