package com.aaraf.mymall;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aaraf.mymall.CategoryAdapter;
import com.aaraf.mymall.CategoryModel;
import com.aaraf.mymall.GridProductLayoutAdapter;
import com.aaraf.mymall.HomePageAdapter;
import com.aaraf.mymall.HomePageModel;
import com.aaraf.mymall.HorizontalScrollProductAdapter;
import com.aaraf.mymall.HorizontalScrollProductModel;
import com.aaraf.mymall.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomePageModel homeViewModel;
    private RecyclerView testing;


    private TextView horizontalLayoutTitle;
    private Button horizontalViewAllButton;
    private RecyclerView horizontalRecyclerView;

    public HomeFragment() {

    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        categoryRecyclerView = view.findViewById(R.id.categoryRecyckerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        final List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link", "HOME"));
        categoryModelList.add(new CategoryModel("link", "ELECTRONIC"));
        categoryModelList.add(new CategoryModel("link", "DOMESTIC"));
        categoryModelList.add(new CategoryModel("link", "WOODEN"));
        categoryModelList.add(new CategoryModel("link", "FASHION"));
        categoryModelList.add(new CategoryModel("link", "TOYS"));
        categoryModelList.add(new CategoryModel("link", "SPORTS"));
        categoryModelList.add(new CategoryModel("link", "ARTS"));
        categoryModelList.add(new CategoryModel("link", "BOOKS"));
        categoryModelList.add(new CategoryModel("link", "SHOES"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();


        //-------------------------->>>>>>>>>>>>>> Horizontal Product Layout

        horizontalLayoutTitle = view.findViewById(R.id.hs_product_title);
        horizontalViewAllButton = view.findViewById(R.id.horizontal_scroll_view_all_button);
        horizontalRecyclerView = (RecyclerView) view.findViewById(R.id.horizontal_scroll_layout_recyclerView);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);


        List<HorizontalScrollProductModel> horizontalScrollProductModelList = new ArrayList<HorizontalScrollProductModel>();
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.mipmap.mobile, "Redmi 44 a", "100 mp Camera", "10000/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.mipmap.mobile, "Redmi 44 a", "100 mp Camera", "10000/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.mipmap.mobile, "Redmi 44 a", "100 mp Camera", "10000/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.mipmap.mobile, "Redmi 44 a", "100 mp Camera", "10000/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.mipmap.mobile, "Redmi 44 a", "100 mp Camera", "10000/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.mipmap.mobile, "Redmi 44 a", "100 mp Camera", "10000/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.mipmap.mobile, "Redmi 44 a", "100 mp Camera", "10000/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.mipmap.mobile, "Redmi 44 a", "100 mp Camera", "10000/-"));


        HorizontalScrollProductAdapter horizontalScrollProductAdapter = new HorizontalScrollProductAdapter(horizontalScrollProductModelList);
        horizontalRecyclerView.setAdapter(horizontalScrollProductAdapter);
        horizontalScrollProductAdapter.notifyDataSetChanged();

        //-------------------------->>>>>>>>>>>>>> Horizontal Product Layout


        ///GRIDLAYOUT

        TextView griLayoutTitle = view.findViewById(R.id.grid_product_layout_title);
        Button griLayoutButton = view.findViewById(R.id.grid_product_layout_view_all_button);
        GridView gridView = view.findViewById(R.id.grid_product_layout_gridview);

        gridView.setAdapter(new GridProductLayoutAdapter(horizontalScrollProductModelList));

        ///GRIDLAYOUT


        //////////////////////////////////////

        testing = view.findViewById(R.id.homePageRecyclerView);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getActivity());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);


        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0, "Deals of the Day", horizontalScrollProductModelList));
        homePageModelList.add(new HomePageModel(1, "Deals of the Day", horizontalScrollProductModelList));
        homePageModelList.add(new HomePageModel(1, "Deals of the Day", horizontalScrollProductModelList));
        homePageModelList.add(new HomePageModel(0, "Deals of the Day", horizontalScrollProductModelList));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        /////////////////////////////////////

        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }
}