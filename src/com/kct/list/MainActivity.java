package com.kct.list;

//import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
//	private Button button;
	private TextView txv;
	private TasksDAO dao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dao = new TasksDAO(this);
		setListAdapter(new ThisAdapter(this, dao.getTasks()));
		
//		setContentView(R.layout.activity_main);
//		
//		txv = (TextView)findViewById(R.id.taskTitle);
//		txv.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent intent = new Intent(MainActivity.this, EditTaskActivity.class);
//				startActivity(intent);
//			}
//		});
	}
	
	

	/* (non-Javadoc)
	 * @see android.app.ListActivity#onListItemClick(android.widget.ListView, android.view.View, int, long)
	 */
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		Task task = (Task)getListAdapter().getItem(position);
		dao.deleteTask(task.getId());
		setListAdapter(new ThisAdapter(this, dao.getTasks()));
		Toast.makeText(getApplicationContext(), "Deleted!", Toast.LENGTH_LONG).show();
//		-----------------
//		Task task = (Task)getListAdapter().getItem(position);
//		Intent intent = new Intent(this, EditTaskActivity.class);
//		intent.putExtra("ID", id);
//		startActivity(intent);
//		this.finish();
//		dao.close();
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
		switch(item.getItemId()){
		case R.id.add_item:
			Intent intent = new Intent(this, EditTaskActivity.class);
			intent.putExtra("function", 1);
			startActivity(intent);
			this.finish();
			break;
		case R.id.edit_item:
			break;
		case R.id.delete_item:
//			Task task = (Task)getListAdapter().getItem(position);
//			dao.deleteTask(task.getId());
//			setListAdapter(new ThisAdapter(this, dao.getTasks()));
//			Toast.makeText(getApplicationContext(), "Deleted!", Toast.LENGTH_LONG).show();
			break;
		}
		
//		if (id == R.id.add_item) {
//			Intent intent = new Intent(this, EditTaskActivity.class);
//			intent.putExtra("function", 1);
//			startActivity(intent);
//			this.finish();
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
		return true;
	}
}
