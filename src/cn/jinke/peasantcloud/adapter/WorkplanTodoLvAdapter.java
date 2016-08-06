package cn.jinke.peasantcloud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import cn.jinke.peasantcloud.R;

/**
 * 未做工作列表Listview适配器
 * @author li
 *
 */
public class WorkplanTodoLvAdapter extends BaseAdapter{

	private Context context;
	
	public WorkplanTodoLvAdapter(Context context){
		this.context = context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(context).inflate(
				R.layout.workplan_todo_item, parent, false);
		
		return convertView;
	}

}
