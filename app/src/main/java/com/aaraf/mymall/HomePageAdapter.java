package com.aaraf.mymall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter {

    private List<HomePageModel> homePageModelList;

    public HomePageAdapter(List<HomePageModel> homePageModelList) {
        this.homePageModelList = homePageModelList;
    }


    @Override
    public int getItemViewType(int position) {

        switch (homePageModelList.get(position).getType()) {
            case 0:
                return HomePageModel.HORIZONTAL_PRODUCT_VIEW;

            case 1:
                return HomePageModel.GRID_PRODUCT_VIEW;

            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return homePageModelList.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                View horizontalProductView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.horizontal_scroll_item_layout, parent, false);
                return new HorizontalProductViewHolder(horizontalProductView);

            case HomePageModel.GRID_PRODUCT_VIEW:
                View gridProductView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.grid_product_layout, parent, false);
                return new GridProductViewHolder(gridProductView);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (homePageModelList.get(position).getType()) {
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                String horizontalLayoutTitle = homePageModelList.get(position).getTitle();
                List<HorizontalScrollProductModel> horizontalScrollProductModelList = homePageModelList.get(position).getHorizontalScrollProductModelList();
                ((HorizontalProductViewHolder) holder).setHorizontalProductLayout(horizontalScrollProductModelList, horizontalLayoutTitle);
                break;

            case HomePageModel.GRID_PRODUCT_VIEW:
                String gridTitle = homePageModelList.get(position).getTitle();
                List<HorizontalScrollProductModel> gridScrollProductModelList = homePageModelList.get(position).getHorizontalScrollProductModelList();
                ((GridProductViewHolder) holder).setGridLayout(gridScrollProductModelList, gridTitle);
                break;


            default:
                return;
        }
    }

    public class HorizontalProductViewHolder extends RecyclerView.ViewHolder {

        private TextView horizontalLayoutTitle;
        private Button horizontalViewAllButton;
        private RecyclerView horizontalRecyclerView;

        public HorizontalProductViewHolder(@NonNull View itemView) {
            super(itemView);

            horizontalLayoutTitle = itemView.findViewById(R.id.hs_product_title);
            horizontalViewAllButton = itemView.findViewById(R.id.horizontal_scroll_view_all_button);
            horizontalRecyclerView = itemView.findViewById(R.id.horizontal_scroll_layout_recyclerView);
        }

        private void setHorizontalProductLayout(List<HorizontalScrollProductModel> horizontalScrollProductModelList, String title) {

            horizontalLayoutTitle.setText(title);

            if (horizontalScrollProductModelList.size() > 8) {
                horizontalViewAllButton.setVisibility(View.VISIBLE);
            }else {
                horizontalViewAllButton.setVisibility(View.INVISIBLE);
            }

            HorizontalScrollProductAdapter horizontalScrollProductAdapter = new HorizontalScrollProductAdapter(horizontalScrollProductModelList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            horizontalRecyclerView.setLayoutManager(linearLayoutManager);

            horizontalRecyclerView.setAdapter(horizontalScrollProductAdapter);
            horizontalScrollProductAdapter.notifyDataSetChanged();
        }
    }

    public class GridProductViewHolder extends RecyclerView.ViewHolder {
        private TextView gridLayoutTitle;
        private Button gridViewAllButton;
        private GridView gridView;

        public GridProductViewHolder(@NonNull View view) {
            super(view);
            TextView griLayoutTitle = view.findViewById(R.id.grid_product_layout_title);
            Button griLayoutButton = view.findViewById(R.id.grid_product_layout_view_all_button);
            GridView gridView = view.findViewById(R.id.grid_product_layout_gridview);
        }

        private void setGridLayout(List<HorizontalScrollProductModel> horizontalScrollProductModelList, String title) {
            gridLayoutTitle.setText(title);
            gridView.setAdapter(new GridProductLayoutAdapter(horizontalScrollProductModelList));
        }


    }
}
