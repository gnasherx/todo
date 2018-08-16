package com.example.ganesh.mytodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTodoActivity extends AppCompatActivity {

    private EditText mTitle, mSubTitle;
    private Button mAddTodo;
    private String title, subTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        mTitle = findViewById(R.id.title);
        mSubTitle = findViewById(R.id.subtitle);
        mAddTodo = findViewById(R.id.addTodoBtn);

        mAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMyTodoInRecyclerView();
            }
        });


    }

    private void sendMyTodoInRecyclerView() {
        title = mTitle.getText().toString().trim();
        subTitle = mSubTitle.getText().toString().trim();

        Todo newTodo = new Todo(title, subTitle);

//        Pass this newtodo obejct to main activity
        Intent i = new Intent(AddTodoActivity.this, MainActivity.class);
        i.putExtra("todo", newTodo);
        startActivity(i);


    }
}
