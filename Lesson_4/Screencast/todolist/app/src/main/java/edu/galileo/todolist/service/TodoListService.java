package edu.galileo.todolist.service;

import android.app.IntentService;
import android.content.Intent;

public class TodoListService extends IntentService {
	private final String LOG_TAG = TodoListService.class.getSimpleName();

	public TodoListService() {
		super("TodoListService");
	}

	@Override protected void onHandleIntent(Intent intent) {
		//TODO add implementation to parse file

	}

}
