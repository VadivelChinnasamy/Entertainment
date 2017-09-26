package com.entertainment.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.entertainment.R;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;


public class CustomPagerAdapter extends PagerAdapter {
    String[] mMovies_names = {
            "Logan",
            "A Grande Muralha",
            "Cinquenta Tons Mais Escuros",
            "Internet - O Filme",
            "LEGO Batman: O Filme",
            "BugiGangue no Espaço",
            "La La Land",
            "John Wick: Um Novo Dia Para Matar",
            "Allied"
    };



    Integer[] mImages_arr={R.drawable.flim_one,R.drawable.flime_two,R.drawable.flim_three,R.drawable.flim_one,R.drawable.flim_five};
  /*  String[] imagens = {
            *//*"http://imagens.cinemacomrapadura.com.br/2016/11/20161119-great-wall.jpg",
            "http://br.web.img3.acsta.net/r_640_360/videothumbnails/16/12/07/17/40/499455.jpg",
            "https://static.omelete.uol.com.br/media/extras/conteudos/internet-o-filme.jpg",
            "http://cinequattro.com/files/2016/12/lego-batman-the-movie-dc-superheroes-unite-515f6fcf7781f.jpg",
            "https://i.ytimg.com/vi/JjM0QtmjP1U/maxresdefault.jpg",
            "http://www.lalaland.movie/assets/images/og.jpg",
            "https://observatoriodocinema.bol.uol.com.br/wp-content/uploads/2016/09/john-wick-2-1.jpg",
            "https://i.ytimg.com/vi/HSCQWX-pUSg/maxresdefault.jpg"*//*
    };*/


    private final LayoutInflater mLayoutInflater;
    private Context mContext;

    public CustomPagerAdapter(Context mctx) {
        mContext = mctx;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mImages_arr.length;
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.include_video_view, container,
                false);
        Display mDisplay =((Activity) mContext).getWindowManager().getDefaultDisplay();
        final int width  = mDisplay.getWidth();
        final int height = mDisplay.getHeight()/2;



        ImageView mImageview = (ImageView) itemView.findViewById(R.id.mImage);
        TextView mTitle= (TextView) itemView.findViewById(R.id.title);
        TextView mSub_title= (TextView) itemView.findViewById(R.id.sub_title);
        RelativeLayout mLayout= (RelativeLayout) itemView.findViewById(R.id.mLayout);
        mLayout.getLayoutParams().height=height;

     /*   final ProgressBar mProgress = (ProgressBar) itemView.findViewById(R.id.progressBar);
        mProgress.setVisibility(View.VISIBLE);*/

        Picasso.with(mContext).
                load(mImages_arr[position]).networkPolicy(NetworkPolicy.OFFLINE).
                error(R.mipmap.ic_place_holder).into(mImageview);
        mTitle.setText(""+mMovies_names[position]);
        mSub_title.setText(""+mMovies_names[position]);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);

    }
}