package com.example.android.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private Context mContext;
    private List<Place> mPlaceList;
    private List<Place> mFilteredList;

    public PlaceAdapter(Context context, List<Place> placeList) {
        mContext = context;
        mPlaceList = placeList;
        mFilteredList = new ArrayList<Place>(placeList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.card_main, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Place place = mFilteredList.get(position);

        holder.mImageView.setImageResource(place.getImageResourceId());
        holder.mTextView.setText(place.getPlaceName());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    public void setCategory(String category){
        mFilteredList.clear();
        for (int i = 0; i < mPlaceList.size(); i++){
            if (mPlaceList.get(i).getCategory().equals(category)){
                mFilteredList.add(mPlaceList.get(i));
            }
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View mCardView;
        private ImageView mImageView;
        private TextView mTextView;

        public ViewHolder(@NonNull View view) {
            super(view);
            mCardView = view;
            mImageView = (ImageView) view.findViewById(R.id.card_image);
            mTextView = (TextView) view.findViewById(R.id.card_text);
        }
    }
}
