package edu.galileo.todolist;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import edu.galileo.todolist.TodoCursorAdapter.ViewHolder;
import edu.galileo.todolist.data.TodoListContract.TodoEntry;

/**
 * Created by eonoe.
 */

public class TodoCursorAdapter extends RecyclerView.Adapter<ViewHolder> {
	private Cursor                  cursor;
	private ToggleTodoCheckListener toggleCheckListener;

	public TodoCursorAdapter(Cursor c, Context context) {
		cursor = c;
		try {
			// Instantiate the ToggleTodoCheckListener so we can send events to the host
			toggleCheckListener = (ToggleTodoCheckListener) context;
		}catch (ClassCastException e) {
			// The activity doesn't implement the interface, throw exception
			throw new ClassCastException(context.toString() + " must implement ToggleTodoCheckListener");
		}

	}

	@Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false);
		return new ViewHolder(view);
	}

	@Override public void onBindViewHolder(ViewHolder holder, int position) {
		cursor.moveToPosition(position);
		holder.bindView(cursor);
	}

	@Override public int getItemCount() {
		return cursor != null ? cursor.getCount() : 0;
	}

	public void swapCursor(Cursor cursor) {
		this.cursor = cursor;
		notifyDataSetChanged();
	}

	class ViewHolder extends RecyclerView.ViewHolder {
		private TextView todoDescTextView;
		private CheckBox todoTaskCheckBox;
		private int todoTaskID = -1;

		public ViewHolder(View view) {
			super(view);
			todoDescTextView = (TextView) view.findViewById(R.id.todo_item_description);
			todoTaskCheckBox = (CheckBox) view.findViewById(R.id.todo_item_checkbox);
		}

		private void bindView(Cursor cursor) {
			todoTaskID = cursor.getInt(cursor.getColumnIndex(TodoEntry._ID));
			boolean isTaskDone = cursor.getInt(cursor.getColumnIndex(TodoEntry.COLUMN_DONE)) == 1;
			String description = cursor.getString(cursor.getColumnIndex(TodoEntry.COLUMN_DESC));
			todoDescTextView.setText(description);
			toggleTask(isTaskDone);
			todoTaskCheckBox.setChecked(isTaskDone);

			todoTaskCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
					toggleTask(b);
					toggleCheckListener.onTodoItemChange(todoTaskID, b);
				}
			});
		}

		private void toggleTask(boolean done) {
			if (done) {
				todoDescTextView.setPaintFlags(todoDescTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
			}else {
				todoDescTextView.setPaintFlags(todoDescTextView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
			}
//			toggleCheckListener.onTodoItemChange(todoTaskID, done);
		}
	}

	/* The activity that uses an instance of this adapter must
 * implement this interface in order to receive event callbacks. */
	public interface ToggleTodoCheckListener {
		void onTodoItemChange(int todoID, boolean done);
	}


}
