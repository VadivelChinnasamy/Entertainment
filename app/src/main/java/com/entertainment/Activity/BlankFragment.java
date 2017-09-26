package com.entertainment.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.entertainment.Adapter.VideosAdapter;
import com.entertainment.R;

import butterknife.ButterKnife;


public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    RecyclerView mRecycler_view;
    private SwipeRefreshLayout mRefresh;
    int img_arr[]={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4}; // Replace image url here

    public BlankFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /**
         * Implement Views and set adapter to recycleview
         * */
        mRecycler_view= (RecyclerView) view.findViewById(R.id.mRecycler_view);
        mRefresh= (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        mRefresh.setRefreshing(false);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecycler_view.setLayoutManager(mLayoutManager);
        mRecycler_view.setItemAnimator(new DefaultItemAnimator());
        mRecycler_view.setAdapter(new VideosAdapter(getActivity(),img_arr));

    }
}
