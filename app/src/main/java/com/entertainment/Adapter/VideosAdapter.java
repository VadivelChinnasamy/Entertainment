package com.entertainment.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.entertainment.R;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;


public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.MyAdapter> {

    private  int[] mImg_url;

    Context mContext;
    String mTimer[]={"8 Hours Ago","12 Hours Ago","16 Hours Ago","18 Hours Ago"};
    String mName[]={"James ","Smith allan","Johny Abraham","Abraham","JohnyVel"};


    public VideosAdapter(Context ctx, int[] mImg_url) {
        mContext = ctx;

        this.mImg_url = mImg_url;
    }

    @Override
    public MyAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adpter_videos, parent, false);
        return new MyAdapter(itemView);
    }


    @Override
    public void onBindViewHolder(final MyAdapter holder, final int position) {
/*        Picasso.with(mContext).load(mImg_url[position])
                .into(holder.mProfile_view);*/

        Picasso.with(mContext).load(mImg_url[position]).placeholder(R.mipmap.ic_place_holder).networkPolicy(NetworkPolicy.OFFLINE).
        into(holder.mProfile_view);
            holder.user_name.setText(""+mName[position]);
        holder.last_active_time.setText(""+mTimer[position]);

    }


    @Override
    public int getItemCount() {
        return mImg_url.length;
    }

    public class MyAdapter extends RecyclerView.ViewHolder {

        ImageView mProfile_view;
TextView desc_txt,user_name,last_active_time;

        public MyAdapter(View itemView) {
            super(itemView);

            desc_txt= (TextView) itemView.findViewById(R.id.desc_txt);
            last_active_time= (TextView) itemView.findViewById(R.id.last_visit_time);
            user_name= (TextView) itemView.findViewById(R.id.name_txt);
            mProfile_view = (ImageView) itemView.findViewById(R.id.mProfile_view);

        }
    }
}

