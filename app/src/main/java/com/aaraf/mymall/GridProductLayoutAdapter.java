package com.aaraf.mymall;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridProductLayoutAdapter extends BaseAdapter {
    List<HorizontalScrollProductModel> horizontalScrollProductModelList;

    public GridProductLayoutAdapter(List<HorizontalScrollProductModel> horizontalScrollProductModelList) {
        this.horizontalScrollProductModelList = horizontalScrollProductModelList;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView==null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout,null);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#ffffff"));

            ImageView productImage = view.findViewById(R.id.hs_product_Image);
            TextView productTitle = view.findViewById(R.id.hs_product_title);
            TextView productDescription = view.findViewById(R.id.hs_product_description);
            TextView productPrice = view.findViewById(R.id.hs_product_price);

            productImage.setImageResource(horizontalScrollProductModelList.get(position).getProductImage());
            productTitle.setText(horizontalScrollProductModelList.get(position).getProductTitle());
            productDescription.setText(horizontalScrollProductModelList.get(position).getProductDescription());
            productPrice.setText(horizontalScrollProductModelList.get(position).getProductPrice());

        }else {
            view=convertView;
        }
        return view;
    }
}
