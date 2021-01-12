package com.h5190076_oguzcan_gecir_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.h5190076_oguzcan_gecir_final.R;
import com.h5190076_oguzcan_gecir_final.util.AlertDialogUtil;
import com.h5190076_oguzcan_gecir_final.util.NetworkUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        internetKontrol();

    }
    public void internetKontrol() {
        if (NetworkUtil.internetVarMi(getApplicationContext())) {
                    init();
        } else {

            AlertDialogUtil.alertDialog(this,
                    getResources().getString(R.string.InternetKontrolBaslik),
                    getResources().getString(R.string.InternetKontrolMesaj),
                    getResources().getString(R.string.InternetKontrolEvet),
                    getResources().getString(R.string.InternetKontrolHayir),
                    getResources().getString(R.string.InternetKontrolScreen));



        }

    }






    private void init() {
        CountDownTimer countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long l) {


            }

            @Override
            public void onFinish() {
                opennextActivity();

            }
        };

        countDownTimer.start();

    }

    private void opennextActivity() {


        Intent secondActivityIntent = new Intent(getApplicationContext(), ListeActivity.class);
        startActivity(secondActivityIntent);
        finish();


    }


}