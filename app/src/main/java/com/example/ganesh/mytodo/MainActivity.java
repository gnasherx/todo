package com.example.ganesh.mytodo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    MyRecyclerViewAdapter adapter;
    ArrayList<Todo> todos = new ArrayList<>();
    private FloatingActionButton mFab;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFab = findViewById(R.id.fab);
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(todos);
        mRecyclerView.setAdapter(adapter);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDailogBox();
            }
        });


    }

    private void showDailogBox() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_box_layout, null);

        final EditText mTodoTitle = mView.findViewById(R.id.add_title);
        final EditText mTodoSubTitle = mView.findViewById(R.id.add_subtitle);
        final Button mSaveTodo = mView.findViewById(R.id.save_todo);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();

        dialog.show();

        mSaveTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mTodoTitle.getText().toString().isEmpty() && !mTodoSubTitle.getText().toString().isEmpty()) {
                    Log.d(TAG, "onClick: todo_title: " + mTodoSubTitle.getText().toString());
                    Todo todo = new Todo(mTodoTitle.getText().toString(), mTodoSubTitle.getText().toString());
                    todos.add(todo);
                    adapter.notifyDataSetChanged();
                    Log.d(TAG, "onClick: Adapter: " + adapter);

                    dialog.dismiss();

                } else {
                    Log.d(TAG, "onClick: Error while adding todo!");
                    dialog.dismiss();
                }
            }
        });
    }
}
