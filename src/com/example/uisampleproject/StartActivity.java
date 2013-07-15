package com.example.uisampleproject;

import com.example.uisampleproject.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Switch;

public class StartActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		findViewById(id.button_start_goTabSwipe).setOnClickListener(
				_onClickListener);
		findViewById(id.button_start_goNavigationDrawerSample)
				.setOnClickListener(_onClickListener);
		findViewById(id.button_start_goSearchView).setOnClickListener(
				_onClickListener);
	}

	private final OnClickListener _onClickListener = new OnClickListener() {

		@Override
		public void onClick(View view) {

			switch (view.getId()) {
				case id.button_start_goTabSwipe :

					Intent intentTabSwipe = new Intent(StartActivity.this,
							TabSwipeActivity.class);
					startActivity(intentTabSwipe);
					break;

				case id.button_start_goNavigationDrawerSample :

					Intent intent = new Intent(StartActivity.this,
							DrawerActivity.class);
					startActivity(intent);
					break;

				case id.button_start_goSearchView :

					Intent intentSearch = new Intent(StartActivity.this,
							SearchViewActivity.class);
					startActivity(intentSearch);
					break;

			}

		}
	};

}
