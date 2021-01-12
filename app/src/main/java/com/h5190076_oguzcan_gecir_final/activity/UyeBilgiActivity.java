package com.h5190076_oguzcan_gecir_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190076_oguzcan_gecir_final.R;
import com.h5190076_oguzcan_gecir_final.model.UyeModel;
import com.h5190076_oguzcan_gecir_final.util.Constants;
import com.h5190076_oguzcan_gecir_final.util.GlideUtil;
import com.h5190076_oguzcan_gecir_final.util.ObjectUtil;

public class UyeBilgiActivity extends AppCompatActivity {

    ImageView imgkapak;
    TextView txtBaslik;
    TextView txtBilgi;
    WebView webViewBilgi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_bilgi);

        String tasinanUyeString  = getIntent().getStringExtra(Constants.TASINANIN_BASLIGI);

        UyeModel uyemodel = ObjectUtil.jsonStringUye(tasinanUyeString);

        imgkapak= findViewById(R.id.imgKapak2);
        txtBaslik = findViewById(R.id.txtBaslik);
        txtBilgi = findViewById(R.id.txtBilgi);
        webViewBilgi = findViewById(R.id.webViewBilgi);

        txtBaslik.setText(uyemodel.getAdiSoyadi());
        txtBilgi.setText(uyemodel.getBiyografi());

        GlideUtil.resmiIndiripGoster(getApplicationContext(),uyemodel.getResimURL(),imgkapak);

    }
}