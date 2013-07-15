package com.example.uisampleproject;

import android.content.SearchRecentSuggestionsProvider;

public class MySuggestionProvider extends SearchRecentSuggestionsProvider {

	public MySuggestionProvider() {
		// TODO 自動生成されたコンストラクター・スタブ
		setupSuggestions("com.exsample.uisampleproject", MySuggestionProvider.DATABASE_MODE_QUERIES);
	}

}
