package com.kct.list;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class EditTaskActivity extends Activity implements OnClickListener{
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	private Spinner spinner;
    private String[] tags = {"個人", "工作"};
    private int function;			//1: new ; 2: edit ;
    
    /**
	 * @param function the function to set
	 */
	public void setFunction(int function) {
		this.function = function;
	}

	private EditText edt1, edt4;
    private TextView txv3;
    private Button btn_complete, btn_cancel, btn_date, btn_del;
    private ArrayAdapter<String> tagsList;
    
    private TasksDAO dao;
    private Calendar calendar;
    
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spin);
		setFunction(this.getIntent().getIntExtra("function", 1));
		getViews();
		dao = new TasksDAO(this);
		
		tagsList = new ArrayAdapter<String>(EditTaskActivity.this, R.layout.spinner_item, tags);
        spinner.setAdapter(tagsList);
        calendar = Calendar.getInstance();
        setOnClick();
	}

	protected void getViews(){
        edt1 = (EditText)findViewById(R.id.editText);
        spinner = (Spinner)findViewById(R.id.spinner);
        txv3 = (TextView)findViewById(R.id.textView3);
        edt4 = (EditText)findViewById(R.id.editText4);
        btn_complete = (Button)findViewById(R.id.button_comp);
        btn_cancel = (Button)findViewById(R.id.button_cancel);
        btn_date = (Button)findViewById(R.id.button_select);
//        btn_del = (Button)findViewById(R.id.button_del);
    }
	
	protected void setOnClick(){
        btn_complete.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
        btn_date.setOnClickListener(this);
//        btn_del.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button_select:
			DatePickerDialog dialog = 
	        	new DatePickerDialog(EditTaskActivity.this, datepicker,
	        	calendar.get(Calendar.YEAR), 
	        	calendar.get(Calendar.MONTH), 
	        	calendar.get(Calendar.DAY_OF_MONTH));
			dialog.show();		
			break;
		case R.id.button_comp:
			String title = edt1.getText().toString();
			String tag = spinner.getSelectedItem().toString();
			String date = txv3.getText().toString();
			String comment = edt4.getText().toString();
			if (function == 1) {
				dao.createTasks(title, tag, date, comment);
			}else if (function == 2) {
				int id = 0;					//測試用
				dao.updateTask(id, title, tag, date, comment);
			}
			Intent i = new Intent(EditTaskActivity.this, MainActivity.class);
			startActivity(i);
			EditTaskActivity.this.finish();
			dao.close();
//			onResume();
			break;
		case R.id.button_cancel:
			Intent ii = new Intent(EditTaskActivity.this, MainActivity.class);
			startActivity(ii);
			EditTaskActivity.this.finish();
			dao.close();
			break;
		default:
			break;
		}
	}

	DatePickerDialog.OnDateSetListener datepicker = new DatePickerDialog.OnDateSetListener(){

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
//			nYear = year;
//        	nMonth = monthOfYear;
//        	nDay = dayOfMonth;
//        	calendar.set(nYear, nMonth, nDay, nHour, nMinute);
			calendar.set(year, monthOfYear, dayOfMonth, 0, 0);
			String format = "yyyy-MM-dd HH:mm";
			SimpleDateFormat df = new SimpleDateFormat(format, Locale.TAIWAN);
			txv3.setText(df.format(calendar.getTime()));
		}
    	
    };
}
