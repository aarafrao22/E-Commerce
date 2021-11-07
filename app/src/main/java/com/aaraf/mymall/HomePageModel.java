package com.aaraf.mymall;

import java.util.List;

public class HomePageModel {
    public static final int HORIZONTAL_PRODUCT_VIEW = 0;
    public static final int GRID_PRODUCT_VIEW = 1;
    private int type;

    //-------------------------->>>>>>>>>>>>>> Horizontal Product Layout  && GRID PRODUCT LAYOUT

    private String title;
    private List<HorizontalScrollProductModel> horizontalScrollProductModelList;

    public HomePageModel(int type, String title, List<HorizontalScrollProductModel> horizontalScrollProductModelList) {
        this.type = type;
        this.title = title;
        this.horizontalScrollProductModelList = horizontalScrollProductModelList;
    }

    public static int getHorizontalProductView() {
        return HORIZONTAL_PRODUCT_VIEW;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<HorizontalScrollProductModel> getHorizontalScrollProductModelList() {
        return horizontalScrollProductModelList;
    }

    public void setHorizontalScrollProductModelList(List<HorizontalScrollProductModel> horizontalScrollProductModelList) {
        this.horizontalScrollProductModelList = horizontalScrollProductModelList;
    }

    //-------------------------->>>>>>>>>>>>>> Horizontal Product Layout

}
