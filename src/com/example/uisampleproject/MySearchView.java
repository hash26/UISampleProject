package com.example.uisampleproject;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.SearchView;

public class MySearchView extends SearchView implements SearchView.OnQueryTextListener{

	public MySearchView(Context context) {
		super(context);
		setOnQueryTextListener(this);
	}

	public MySearchView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		Log.d("tag", newText);
		return false;
	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	
}
