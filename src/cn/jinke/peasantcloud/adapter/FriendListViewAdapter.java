package cn.jinke.peasantcloud.adapter;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FriendListViewAdapter implements ExpandableListAdapter {

	private Context ctx;
	private String[] groups = new String[]{
            "专家", "农技员", "种植户"
    };
	public FriendListViewAdapter(Context ctx) {
		// TODO Auto-generated constructor stub
		this.ctx=ctx;
	}
	@Override
	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public View getChildView(int groupPosition, int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {
		
		if (convertView == null) {
			convertView = LayoutInflater.from(ctx).inflate(
					R.layout.listview_item_friendlist, parent, false);
		}
//		View view = View.inflate(ctx, R.layout.listview_item_friendlist, null);		
		return convertView;
		
	}
	@Override
	public int getChildrenCount(int arg0) {
		// TODO Auto-generated method stub
		return 5;
	}
	@Override
	public long getCombinedChildId(long arg0, long arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public long getCombinedGroupId(long arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return groups.length;
	}
	@Override
	public long getGroupId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
            View convertView, ViewGroup parent) {
		
		if (convertView == null) {
			convertView = LayoutInflater.from(ctx).inflate(
					R.layout.listview_item_friendlist_type, parent, false);
		}
//		View view = View.inflate(ctx, R.layout.listview_item_friendlist_type, null);	
		ImageView img=BaseViewHolder.get(convertView, R.id.img_indicator);
		
		TextView tv_type= BaseViewHolder.get(convertView, R.id.tv_friendtype);
		tv_type.setText(groups[groupPosition]);
		 if (isExpanded)
	            img.setImageResource(
	                    R.drawable.triangle_bottom);
	        else
	            img.setImageResource(
	                    R.drawable.triangle_right);
		return convertView;
	}
	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void onGroupCollapsed(int arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onGroupExpanded(int arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void registerDataSetObserver(DataSetObserver arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void unregisterDataSetObserver(DataSetObserver arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
