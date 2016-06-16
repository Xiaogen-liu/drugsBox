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
		//��һ����ʾѡ��ʱ���С����
		mon_button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 timePicDia.show();
			}});
		//��������ʾ������ʱ��Ĺ���
		mon_button.setOnLongClickListener(new OnLongClickListener() {
			public boolean onLongClick(View v) {
				Toast.makeText(SelectTime.this, "��ȡ��", Toast.LENGTH_SHORT)
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
				Toast.makeText(SelectTime.this, "��������",Toast.LENGTH_SHORT).show();
				smsManager.sendTextMessage("13112333810",null,mon_button.getText().toString(),paIntent,null);
//				//sendTextMessage�����е�һ��������ʾ���ŵ�Ŀ�ĵ绰���룬
//				�ڶ���������ʾ���ŷ������ĺ��룬���Ϊnull��ʹ��Ĭ�ϵĶ��ŷ������ĺ��롣��
//				����������ʾ�������ݣ����ĸ�������ʾ���Ͷ��Ž�����ݣ�
//				�����������ʾ���Ͷ��ŵ�Ŀ�ĵ�ַ��Ļظ���Ϣ��
				
				}
				else {
					Toast.makeText(SelectTime.this, "��û��ѡ����ȷ��ʱ��", Toast.LENGTH_SHORT).show();
					
				}
			}
			
			
		}
				
				);
		
		
		
		selectTimeMinis();//����С���ڣ�ѡ��ʱ�����
		
	}
	
	
	//����С���ڣ�ѡ��ʱ�����
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
