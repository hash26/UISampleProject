package com.example.uisampleproject;

import com.example.uisampleproject.R.id;

import android.app.Activity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;

public class SearchViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);

		final Intent queryIntent = getIntent();
		final String queryAction = queryIntent.getAction();

		// ACTION_SEARCH の Intent で呼び出された場合
		if (Intent.ACTION_SEARCH.equals(queryAction)) {
			doSearchWithIntent(queryIntent);
			Log.d("tag", "onCreate");
		}
		
		setContentView(R.layout.activity_main);
		Log.d("tag", "onCreate");
	}

	private void doSearchWithIntent(Intent queryIntent) {
		// TODO 自動生成されたメソッド・スタブ
		Log.d("tag", "hoge");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_withsearch, menu);

		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(id.menu_search)
				.getActionView();
		ComponentName componentName =  getComponentName();
		SearchableInfo searchableInfo = searchManager
				.getSearchableInfo(componentName);
		searchView.setSearchableInfo(searchableInfo);
		searchView.setSubmitButtonEnabled(true);

		return true;
	}

	@Override
	protected void onNewIntent(Intent intent) {
		/*
		 * getIntent()で得られるIntentは、原初の時点でのIntentのままである。
		 * setIntent()を使うことにより、最新のIntentに更新される。
		 */
		setIntent(intent);
		if (Intent.ACTION_SEARCH.equals(intent.getAction()) == true) {
			String q = intent.getStringExtra(SearchManager.QUERY);
			Log.d("tag", "onNewIntent() : query==" + q);
			
			SearchRecentSuggestions suggestions = new SearchRecentSuggestions(getApplicationContext(), "com.exsample.uisampleproject", MySuggestionProvider.DATABASE_MODE_QUERIES);
			suggestions.saveRecentQuery(q, null);
		}
	}

}
