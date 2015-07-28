package com.kct.list;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ThisAdapter extends ArrayAdapter<Task>{
	private final Context context;
	private final List<Task> tasksList;

	public ThisAdapter(Context context, List<Task> tasksList) {
		super(context, R.layout.activity_main, tasksList);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.tasksList = tasksList;
	}

	/* (non-Javadoc)
	 * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.activity_main, parent, false);
		
		TextView taskText = (TextView) rowView.findViewById(R.id.taskTitle);
		taskText.setText(tasksList.get(position).getTitle());
		TextView dateText = (TextView) rowView.findViewById(R.id.taskDate);
//		String format = "yyyy-MM-dd HH:mm";
		String datetime = tasksList.get(position).getDate().substring(0, 10);
		dateText.setText(datetime);
		return rowView;
	}
	
	

}
