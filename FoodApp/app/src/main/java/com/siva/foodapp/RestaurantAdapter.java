package com.siva.foodapp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.siva.foodapp.data.RestaurantDataModel;
import com.siva.foodapp.rest.model.Restaurants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarumugam on 07/11/16.
 */
public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    public interface ItemClickListener {
        void onSelectingRestaurant(Restaurants data);
    }

    private Context mContext;
    private ArrayList<Restaurants> mDatas;
    private ItemClickListener mItemClickListener;

    public RestaurantAdapter(Context context, ArrayList<Restaurants> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    public void setItemClickListener(ItemClickListener listener){
        mItemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_restaurant_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Restaurants data = mDatas.get(position);
        holder.mNameText.setText(data.getName());
        holder.mLocationText.setText(data.getLocation());
        holder.mDeliveryTimeText.setText("Delivery Time : "+data.getMindeliverytime());
        holder.mDeliveryCharge.setText("Delivery charge : "+data.getDeliveryCharge());
        holder.mRestaurantType.setImageResource(data.getRestaurantType().equals("veg")?
                R.drawable.restaurant_type_veg:R.drawable.restaurant_type_non_veg);
        holder.mMinOrderText.setText("Min Order : "+data.getMinDeliveryAmount());
//        holder.mRestaurantLogo.setImageResource();

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemClickListener.onSelectingRestaurant(data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mNameText,mDeliveryTimeText,mMinOrderText,mDeliveryCharge,mLocationText;
        public ImageView mRestaurantLogo,mRestaurantType;
        public CardView mCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            mNameText = (TextView) itemView.findViewById(R.id.restaurant_name);
            mLocationText = (TextView) itemView.findViewById(R.id.restaurant_location);
            mDeliveryTimeText = (TextView) itemView.findViewById(R.id.restaurant_delivery_time);
            mMinOrderText = (TextView) itemView.findViewById(R.id.restaurant_min_order);
            mDeliveryCharge = (TextView) itemView.findViewById(R.id.restaurant_delivery_charge);
            mRestaurantLogo = (ImageView) itemView.findViewById(R.id.restaurant_logo);
            mRestaurantType = (ImageView) itemView.findViewById(R.id.restaurant_type);
            mCardView = (CardView) itemView.findViewById(R.id.restaurant_card_item);
        }
    }
}
