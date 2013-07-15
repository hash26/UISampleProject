package com.example.uisampleproject;

import com.example.uisampleproject.R.id;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DrawerActivity extends Activity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private TextView mTextView;

	public DrawerActivity() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawer);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		// mPlanetTitles = getResources().getStringArray(R.array.planets_array);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		mTextView = (TextView) findViewById(id.textview_drawer);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
			R.layout.cell_drawerlist, new String[] { "Title1", "Title2",
						"Title3" });
		mDrawerList.setAdapter(adapter);
		mDrawerList.setOnItemClickListener(_onItemClickListener);
		mDrawerLayout.setScrimColor(0x50000000);
	}
	
	
	private final OnItemClickListener _onItemClickListener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View view, int position,
				long arg3) {
			
			Log.d("debug", "_onItemClickListener");
			
			mTextView.setText("position:" + position);
		}
		
	};
}
