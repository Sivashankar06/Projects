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

import java.util.List;

/**
 * Created by sarumugam on 07/11/16.
 */
public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    public interface ItemClickListener {
        void onSelectingRestaurant(RestaurantDataModel data);
    }

    private Context mContext;
    private List<RestaurantDataModel> mDatas;
    private ItemClickListener mItemClickListener;

    public RestaurantAdapter(Context context, List<RestaurantDataModel> datas) {
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
        final RestaurantDataModel data = mDatas.get(position);
        holder.mNameText.setText(data.getRestaurantName());
        holder.mDeliveryTimeText.setText("Delivery Time : "+data.getTimeToDeliver());
        holder.mFoodTypeText.setText(data.getDisplayFoodType());
        holder.mMinOrderText.setText("Min Order : "+data.getMinimumOrder());
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

        public TextView mNameText,mDeliveryTimeText,mMinOrderText,mFoodTypeText;
        public ImageView mRestaurantLogo;
        public CardView mCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            mNameText = (TextView) itemView.findViewById(R.id.restaurant_name);
            mDeliveryTimeText = (TextView) itemView.findViewById(R.id.restaurant_delivery_time);
            mMinOrderText = (TextView) itemView.findViewById(R.id.restaurant_min_order);
            mFoodTypeText = (TextView) itemView.findViewById(R.id.restaurant_food_type);
            mRestaurantLogo = (ImageView) itemView.findViewById(R.id.restaurant_logo);
            mCardView = (CardView) itemView.findViewById(R.id.restaurant_card_item);
        }
    }
}
