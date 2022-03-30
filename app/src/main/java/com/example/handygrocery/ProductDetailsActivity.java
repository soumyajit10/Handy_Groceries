package com.example.handygrocery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailsActivity extends AppCompatActivity {
    ImageView img, back;
    TextView productName, productPrice, productDesc, productQty, productUnit;

    String name, price, desc, qty, unit;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);


        Intent i = getIntent();

        name = i.getStringExtra("name");
        image = i.getIntExtra("image", R.drawable.b1);
        price = i.getStringExtra("price");
        desc = i.getStringExtra("desc");
        qty = i.getStringExtra("qty");
        unit = i.getStringExtra("unit");



        productName = findViewById(R.id.productName);
        productDesc = findViewById(R.id.prodDesc);
        productPrice = findViewById(R.id.prodPrice);
        productQty = findViewById(R.id.qty);
        productUnit = findViewById(R.id.unit);
        img = findViewById(R.id.big_image);
        back = findViewById(R.id.back2);

        productName.setText(name);
        productDesc.setText(desc);
        productPrice.setText(price);
        productUnit.setText(unit);
        productQty.setText(qty);

        img.setImageResource(image);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(ProductDetailsActivity.this,AllCategoryActivity.class);
                startActivity(back);
                finish();
            }
        });
    }


}