package com.example.android.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Place> mPlaceList;

    public PlaceAdapter(Context context, ArrayList<Place> placeList) {
        mContext = context;
        mPlaceList = placeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.card_main, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Place place = mPlaceList.get(position);

        holder.mImageView.setImageResource(place.getImageResourceId());
        holder.mTextView.setText(place.getPlaceName());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, PlaceDetailActivity.class);
                intent.putExtra("Place Detail", place);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPlaceList.size();
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
