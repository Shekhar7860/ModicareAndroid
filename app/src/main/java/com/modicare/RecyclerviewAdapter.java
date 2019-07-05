package com.modicare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

// import com.example.mac.androidtest.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by csa on 3/6/2017.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyHolder>{

    List<Listdata> listdata;
    public Context context;
    public RecyclerviewAdapter(Context context, List<Listdata> listdata) {
        this.listdata = listdata;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myview,parent,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }


    public void onBindViewHolder(MyHolder holder, final int position) {

        final Listdata data = listdata.get(position);
        holder.vname.setText(data.getName());
        holder.vemail.setText(data.getName());
        holder.vaddress.setText(data.getAddress());

         Picasso.with(context).load(data.getImage()).resize(120, 60).into(holder.image);
          holder.vemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, IdeasListActivity.class);
                intent.putExtra("value", data.getEmail());
                intent.putExtra("name", data.getName());
                context.startActivity(intent);
                Log.d("check", data.getEmail());
            }
        });

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{
        TextView vname , vaddress,vemail;
         ImageView image;
        public MyHolder(View itemView) {
            super(itemView);
            vname = (TextView) itemView.findViewById(R.id.vname);
            vemail = (TextView) itemView.findViewById(R.id.vemail);
            vaddress = (TextView) itemView.findViewById(R.id.vaddress);
            image = (ImageView) itemView.findViewById(R.id.profile_image);

        }
    }


}
