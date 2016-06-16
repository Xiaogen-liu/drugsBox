package com.example.select_time;

import java.util.Calendar;
import com.example.drugs1.R;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class SelectTime extends Activity {
	private Button mon_button,morning_button,correct_button;
	TimePickerDialog timePicDia;
	private Calendar c = null;
	PendingIntent paIntent;
	SmsManager smsManager;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selectday);
		mon_button = (Button) findViewById(R.id.monday_morning);
		  paIntent = PendingIntent.getBroadcast(this, 0, new Intent(), 0); 
	        smsManager = SmsManager.getDefault();
	        correct_button=(Button)findViewById(R.id.correct_button);
		//按一下显示选择时间的小窗口
		mon_button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 timePicDia.show();
			}});
		//长按就显示这个清除时间的功能
		mon_button.setOnLongClickListener(new OnLongClickListener() {
			public boolean onLongClick(View v) {
				Toast.makeText(SelectTime.this, "已取消", Toast.LENGTH_SHORT)
						.show();
				mon_button.setText("");
//				mon_button.setBackgroundColor(Color.GRAY);
				return true;
			}
		});
		correct_button.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				if(mon_button.getText()!="")
				{
				Toast.makeText(SelectTime.this, "发短信中",Toast.LENGTH_SHORT).show();
				smsManager.sendTextMessage("13112333810",null,mon_button.getText().toString(),paIntent,null);
//				//sendTextMessage方法中第一个参数表示短信的目的电话号码，
//				第二个参数表示短信服务中心号码，如果为null则使用默认的短信服务中心号码。第
//				三个参数表示短信内容，第四个参数表示发送短信结果内容，
//				第五个参数表示发送短信到目的地址后的回复信息。
				
				}
				else {
					Toast.makeText(SelectTime.this, "您没有选择正确的时间", Toast.LENGTH_SHORT).show();
					
				}
			}
			
			
		}
				
				);
		
		
		
		selectTimeMinis();//设置小窗口，选择时间的量
		
	}
	
	
	//设置小窗口，选择时间的量
	public void selectTimeMinis()
	{
		
		c = Calendar.getInstance();
		TimePickerDialog.OnTimeSetListener timePicDlgOnTimeSelLis = new TimePickerDialog.OnTimeSetListener() {
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				mon_button.setText("  " + hourOfDay + ":" + minute);
				if(mon_button.getText()!=null)
				{
//					mon_button.setBackgroundColor(DEFAULT_KEYS_DIALER);
				}
	

			}
		};
		timePicDia = new TimePickerDialog(this, timePicDlgOnTimeSelLis,
				c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), false);

		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}
