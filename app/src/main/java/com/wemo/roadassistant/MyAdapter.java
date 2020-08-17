package com.wemo.roadassistant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wemo.model.UserForm;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<UserForm> userList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre, number;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            number = (TextView) view.findViewById(R.id.num);
        }
    }


    public MyAdapter(List<UserForm> userList) {
        this.userList = userList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        UserForm user = userList.get(position);
        holder.title.setText(user.getFullName());
        holder.genre.setText(user.getShopName());
        holder.year.setText(user.getShopAddress());
        holder.number.setText(user.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
