package com.anmapps.anstudio.foodinfo_v2_0;

import android.content.Intent;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;

import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;



public class DetailActivity extends AppCompatActivity {
    TextView tvDetail;
    ImageView dimgview, imgContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        CollapsingToolbarLayout cToolbar= (CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
        cToolbar.setTitleEnabled(false);
        // cToolbar.setExpandedTitleColor(Color.BLACK); //установить цвет Title черный


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tvDetail=(TextView)findViewById(R.id.tvDetail);
        tvDetail.setTextIsSelectable(true);
        dimgview= (ImageView) findViewById(R.id.dimgview);
        imgContent= (ImageView) findViewById(R.id.img_content_detail);


        Intent intent = getIntent();
        //получение текста и вывод
        String mChild = intent.getStringExtra("Details");//основной текст
        Spanned result = Html.fromHtml(mChild);
        tvDetail.setText(result);

        //получение заголовка
        String mTitle=intent.getStringExtra("Title");
        this.setTitle(mTitle);

        //получения картинки и вывод
        Bundle bundle=this.getIntent().getExtras();
        int pic=bundle.getInt("Image_url");
        dimgview.setImageResource(pic);
        imgContent.setImageResource(pic);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
