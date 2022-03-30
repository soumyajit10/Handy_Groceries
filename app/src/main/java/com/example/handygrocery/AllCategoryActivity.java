package com.example.handygrocery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.example.handygrocery.Adapters.AllCategoryAdapter;
import com.example.handygrocery.Model.AllCategoryModel;

import java.util.ArrayList;
import java.util.List;

public class AllCategoryActivity extends AppCompatActivity {
    RecyclerView all_categoryRecycler;
    AllCategoryAdapter allCategoryAdapter;
    List<AllCategoryModel> allCategoryModelList;

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        all_categoryRecycler = findViewById(R.id.all_category);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(AllCategoryActivity.this,MainActivity.class);
                startActivity(back);
                finish();
            }
        });


        allCategoryModelList = new ArrayList<>();
        allCategoryModelList.add(new AllCategoryModel(1,R.drawable.ic_fruits));
        allCategoryModelList.add(new AllCategoryModel(2,R.drawable.ic_veggies));
        allCategoryModelList.add(new AllCategoryModel(1,R.drawable.ic_meat));
        allCategoryModelList.add(new AllCategoryModel(1,R.drawable.ic_fish));
        allCategoryModelList.add(new AllCategoryModel(1,R.drawable.ic_spices));
        allCategoryModelList.add(new AllCategoryModel(1,R.drawable.ic_egg));
        allCategoryModelList.add(new AllCategoryModel(1,R.drawable.ic_salad));
        allCategoryModelList.add(new AllCategoryModel(1,R.drawable.ic_dairy));
        allCategoryModelList.add(new AllCategoryModel(1,R.drawable.ic_desert));
        allCategoryModelList.add(new AllCategoryModel(1,R.drawable.ic_cookies));
        allCategoryModelList.add(new AllCategoryModel(1,R.drawable.ic_juice));
        allCategoryModelList.add(new AllCategoryModel(1,R.drawable.ic_dairy));

        setCategoryRecycler(allCategoryModelList);

    }

    private void setCategoryRecycler(List<AllCategoryModel> allCategoryModelList) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 4);
        all_categoryRecycler.setLayoutManager(layoutManager);
        all_categoryRecycler.addItemDecoration(new GridSpacingItemDecoration(4, dpToPx(16), true));
        all_categoryRecycler.setItemAnimator(new DefaultItemAnimator());
        allCategoryAdapter = new AllCategoryAdapter(this,allCategoryModelList);
        all_categoryRecycler.setAdapter(allCategoryAdapter);
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}