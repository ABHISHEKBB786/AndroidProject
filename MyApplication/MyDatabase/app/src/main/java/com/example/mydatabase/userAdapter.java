package com.example.mydatabase;
import android.content.Context;
import android.service.autofill.UserData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class userAdapter extends RecyclerView.Adapter< userAdapter.MyViewHolder >{

    private Context context;
    private ArrayList<member> userData;

    public userAdapter(Context c, ArrayList<locationhelper> userData){
        this.context = c;
        this.userData = this.userData;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        member member =this.userData.get(position);


        //holder.tvEmail.setText(member.getName());
        holder.tvName.setText(member.getEmail());


    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName,tvEmail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

          // tvName = itemView.findViewById(R.id.tvName);
           tvEmail = itemView.findViewById(R.id.tvemail);



        }
    }
}
