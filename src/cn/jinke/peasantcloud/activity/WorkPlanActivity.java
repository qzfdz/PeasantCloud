package cn.jinke.peasantcloud.activity;

import com.baidu.mapapi.SDKInitializer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.R.layout;
import cn.jinke.peasantcloud.adapter.ConsultLvAdapter;
import cn.jinke.peasantcloud.adapter.WorkplanDoneLvAdapter;
import cn.jinke.peasantcloud.adapter.WorkplanTodoLvAdapter;

public class WorkPlanActivity extends Activity implements OnItemClickListener{
	
	private View view;
	ListView todo_listview,done_listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SDKInitializer.initialize(getApplicationContext());  
		setContentView(R.layout.activity_work_plan);
		
		
		todo_listview = (ListView) findViewById(R.id.workplan_todo);
		done_listview = (ListView) findViewById(R.id.workplan_done);		
		
		todo_listview.setAdapter(new WorkplanTodoLvAdapter(this));
		done_listview.setAdapter(new WorkplanDoneLvAdapter(this));
		
		initListener();
		
	}
	private void initListener() {
		todo_listview.setOnItemClickListener(this);
	
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		switch(position)
		{
			case 0:
//				Toast.makeText(this,"You selected : " ,Toast.LENGTH_SHORT).show(); 
				Intent intent = new Intent(this,MapRouteActivity.class);
				startActivity(intent);
//				System.out.println("bb");
				break;
			case 1:
				break;
			case 2:   
				break;
			default:
				break;
		}
	}
}
