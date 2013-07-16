package com.example.uisampleproject;

import android.app.Activity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.uisampleproject.R.id;

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
		startActionMode(_callback);
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
		ComponentName componentName = getComponentName();
		SearchableInfo searchableInfo = searchManager
				.getSearchableInfo(componentName);
		searchView.setSearchableInfo(searchableInfo);
		searchView.setSubmitButtonEnabled(true);
		Log.d("tag", "onCreateOptionsMenu");
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

			SearchRecentSuggestions suggestions = new SearchRecentSuggestions(
					getApplicationContext(), "com.exsample.uisampleproject",
					MySuggestionProvider.DATABASE_MODE_QUERIES);
			suggestions.saveRecentQuery(q, null);
		}
	}

	private ActionMode.Callback _callback = new ActionMode.Callback(){
		/**
		 * 各メニューを作成する。 #getSupportMenuInflater().inflate(int,
		 * Menu)でインフレートさせることもできます。 戻り値がfalseの場合メニューは表示されません
		 */
		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			menu.add("Save").setIcon(android.R.drawable.ic_menu_save)
					.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
			menu.add("Search").setIcon(android.R.drawable.ic_menu_search)
					.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

			menu.add("Play").setIcon(android.R.drawable.ic_media_play)
					.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

			menu.add("Share").setIcon(android.R.drawable.ic_menu_share)
					.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

			menu.add("Call").setIcon(android.R.drawable.ic_menu_call)
					.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

			menu.add("Camera").setIcon(android.R.drawable.ic_menu_camera)
					.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
			return true;
		}

		/**
		 * アクションモードのメニューが表示される前に呼ばれる。
		 * 
		 * クリックされる前に値を設定する必要がある場合はここでする
		 */
		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			return false;
		}

		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

			// メニューを非表示にする
			mode.finish();
			return true;
		}

		@Override
		public void onDestroyActionMode(ActionMode mode) {
			Log.d("tag", "destroy");
		}
		
	};

}
