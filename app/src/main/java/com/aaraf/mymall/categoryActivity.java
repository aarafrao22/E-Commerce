package com.aaraf.mymall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class categoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CategoryName");
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView catRecyclerView = findViewById(R.id.cat_recycler_view);


        //-------------------------->>>>>>>>>>>>>> Horizontal Product Layout


        List<HorizontalScrollProductModel> horizontalScrollProductModelList = new ArrayList<HorizontalScrollProductModel>();
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.mipmap.mobile, "Redmi 44 a", "100 mp Camera", "10000/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.mipmap.mobile, "Redmi 44 a", "100 mp Camera", "10000/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.mipmap.mobile, "Redmi 44 a", "100 mp Camera", "10000/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.mipmap.mobile, "Redmi 44 a", "100 mp Camera", "10000/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.mipmap.mobile, "Redmi 44 a", "100 mp Camera", "10000/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.mipmap.mobile, "Redmi 44 a", "100 mp Camera", "10000/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.mipmap.mobile, "Redmi 44 a", "100 mp Camera", "10000/-"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.mipmap.mobile, "Redmi 44 a", "100 mp Camera", "10000/-"));


        //-------------------------->>>>>>>>>>>>>> Horizontal Product Layout


        ///GRIDLAYOUT

        ///GRIDLAYOUT


        //////////////////////////////////////

        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(RecyclerView.VERTICAL);
        catRecyclerView.setLayoutManager(testingLayoutManager);


        List<HomePageModel> homePageModelList = new ArrayList<HomePageModel>();
        homePageModelList.add(new HomePageModel(0, "Deals of the Day", horizontalScrollProductModelList));
        homePageModelList.add(new HomePageModel(1, "Deals of the Day", horizontalScrollProductModelList));
        homePageModelList.add(new HomePageModel(1, "Deals of the Day", horizontalScrollProductModelList));
        homePageModelList.add(new HomePageModel(0, "Deals of the Day", horizontalScrollProductModelList));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        catRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search_main) {
            return true;
        } else if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}