package com.wangban.popuowindow;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends Activity {
	private Button btnMore;
	private PopupWindow popupWindow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnMore = (Button) findViewById(R.id.button1);
		setListener();

	}

	private void setListener() {
		btnMore.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				View view = View.inflate(MainActivity.this, R.layout.move, null);
				if (popupWindow == null) {
					
					view.measure(0, 0);
					int hight = btnMore.getHeight();
					int width = btnMore.getWidth();
					int viewWidth = view.getWidth();
					int viewHeight = view.getHeight();

					popupWindow = new PopupWindow(view,
							ViewGroup.LayoutParams.WRAP_CONTENT,
							ViewGroup.LayoutParams.WRAP_CONTENT);
					popupWindow.showAsDropDown(btnMore, width, -hight);
				}
				Button btn2 = (Button) view.findViewById(R.id.button2);
				Button btn3 = (Button) view.findViewById(R.id.button3);
				btn2.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						popupWindow.dismiss();
						popupWindow = null;
					}
				});

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
