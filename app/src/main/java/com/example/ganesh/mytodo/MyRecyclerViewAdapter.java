package com.example.ganesh.mytodo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<Todo> todos;

    MyRecyclerViewAdapter(List<Todo> todos) {
        this.todos = todos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.title_textview.setText(todo.getTitle());
        holder.subTitle_textview.setText(todo.getSubTitle());
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title_textview, subTitle_textview;

        ViewHolder(View itemView) {
            super(itemView);
            title_textview = itemView.findViewById(R.id.textview_title);
            subTitle_textview = itemView.findViewById(R.id.textview_subtitle);
        }
    }
}