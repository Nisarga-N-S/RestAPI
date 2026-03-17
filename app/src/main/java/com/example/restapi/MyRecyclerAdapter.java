package com.example.restapi;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
    private static List<UserData> data;

    private static ItemClickListener itemClickListener;


    public MyRecyclerAdapter(List<UserData> data, ItemClickListener itemClickListener) {
        this.itemClickListener=itemClickListener;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_data, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UserData item = data.get(position);
        holder.id.setText(String.valueOf(item.getId()));
        holder.title.setText(item.getTitle());
        holder.body.setText(item.getBody());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        itemClickListener.onItemClick(position);
                    }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id,title,body;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           id=itemView.findViewById(R.id.id);
           title=itemView.findViewById(R.id.titletext);
           body=itemView.findViewById(R.id.body);

        }
    }

}
