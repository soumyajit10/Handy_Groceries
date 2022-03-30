package com.example.handygrocery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.handygrocery.Adapters.CategoryAdapter;
import com.example.handygrocery.Adapters.DiscountedProductAdapter;
import com.example.handygrocery.Adapters.RecentlyViewedAdapter;
import com.example.handygrocery.Model.Category;
import com.example.handygrocery.Model.DiscountedProducts;
import com.example.handygrocery.Model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView discountRecycler,categoryRecycler,recentlyItemsRecycler;

    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts>  discountedProductsList;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    TextView allCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountRecycler = findViewById(R.id.discountRecycler);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        recentlyItemsRecycler = findViewById(R.id.recently_items);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AllCategoryActivity.class);
                startActivity(intent);
            }
        });

        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1,R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(2,R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(3,R.drawable.discountmeat));
        discountedProductsList.add(new DiscountedProducts(4,R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(5,R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(6,R.drawable.discountmeat));

        categoryList = new ArrayList<>();
        categoryList.add(new Category(1,R.drawable.ic_home_fruits));
        categoryList.add(new Category(2,R.drawable.ic_home_fish));
        categoryList.add(new Category(3,R.drawable.ic_home_meats));
        categoryList.add(new Category(4,R.drawable.ic_home_veggies));
        categoryList.add(new Category(5,R.drawable.ic_home_fruits));
        categoryList.add(new Category(6,R.drawable.ic_home_fish));
        categoryList.add(new Category(7,R.drawable.ic_home_meats));
        categoryList.add(new Category(8,R.drawable.ic_home_veggies));

        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Watermelon","Watermelon has high water content and also provides fiber a chilled fruit in summer","₹ 80", "1", "KG",R.drawable.card4, R.drawable.b4));
        recentlyViewedList.add(new RecentlyViewed("Papaya", "Papayas are spherical or pear-shaped fruits that can be as long as 20 inches.", "₹ 85", "1", "KG",R.drawable.card3, R.drawable.b3));
        recentlyViewedList.add(new RecentlyViewed("Strawberry", "The strawberry is a highly nutritious fruit, loaded with vitamin C.", "₹ 35", "1", "KG", R.drawable.card2, R.drawable.b1));
        recentlyViewedList.add(new RecentlyViewed("Kiwi", "Full of nutrients like vitamin C, vitamin K, vitamin E, folate, and potassium.", "₹ 30", "1", "PC", R.drawable.card1, R.drawable.b2));

        setDiscountedRecycler(discountedProductsList);
        setCategoryRecycler(categoryList);
        setRecentlyItemsRecycler(recentlyViewedList);


    }

    private void setRecentlyItemsRecycler(List<RecentlyViewed> recentlyViewedList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recentlyItemsRecycler.setLayoutManager(layoutManager);
        recentlyItemsRecycler.setHasFixedSize(true);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedList);
        recentlyItemsRecycler.setAdapter(recentlyViewedAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        categoryRecycler.setLayoutManager(layoutManager);
        categoryRecycler.setHasFixedSize(true);
        categoryAdapter = new CategoryAdapter(this,categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

    }

    private void setDiscountedRecycler(List<DiscountedProducts> discountedProductsList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        discountRecycler.setLayoutManager(layoutManager);
        discountRecycler.setHasFixedSize(true);
        discountedProductAdapter = new DiscountedProductAdapter(this,discountedProductsList);
        discountRecycler.setAdapter(discountedProductAdapter);


    }
}