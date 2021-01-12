package com.h5190076_oguzcan_gecir_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.h5190076_oguzcan_gecir_final.R;
import com.h5190076_oguzcan_gecir_final.adaptor.UyeAdaptor;
import com.h5190076_oguzcan_gecir_final.model.UyeModel;
import com.h5190076_oguzcan_gecir_final.network.Service;
import com.h5190076_oguzcan_gecir_final.util.AlertDialogUtil;
import com.h5190076_oguzcan_gecir_final.util.Constants;
import com.h5190076_oguzcan_gecir_final.util.NetworkUtil;
import com.h5190076_oguzcan_gecir_final.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class ListeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        init();


        }



    private void init() {
        uyeleriGetir();
    }

    void uyeleriGetir() {

        new Service().getServiceApi().uyeleriGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UyeModel>>() {

                    List<UyeModel> uyeler = new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<UyeModel> uyeList) {

                        uyeler = uyeList;
                    }

                    @Override
                    public void onError(Throwable e) {


                    }

                    @Override
                    public void onComplete() {


                        if (uyeler.size() > 0) {


                            initRecycleView(uyeler);
                        }
                    }
                });
    }


    private void initRecycleView(List<UyeModel> uyeList) {
        recyclerView = findViewById(R.id.rcvUyeler);
        UyeAdaptor uyeAdaptor = new UyeAdaptor(uyeList, getApplicationContext(), new UyeAdaptor.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                UyeModel tiklananUye = uyeList.get(position);


                opennextActivity(tiklananUye);
                proggressDialog();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(uyeAdaptor);
    }

    private void opennextActivity(UyeModel tiklananUye) {


        Intent secondActivityIntent = new Intent(getApplicationContext(), UyeBilgiActivity.class);
        String tiklananUyeString = ObjectUtil.uyeToJsonString(tiklananUye);
        secondActivityIntent.putExtra(Constants.TASINANIN_BASLIGI, tiklananUyeString);
        startActivity(secondActivityIntent);


    }

    @Override
    public void onBackPressed() {

        AlertDialogUtil.alertDialog(this,
                getResources().getString(R.string.Baslik),
                getResources().getString(R.string.Mesaj),
                getResources().getString(R.string.Evet),
                getResources().getString(R.string.Hayir),
                getResources().getString(R.string.ListeActivity));

    }

    private void proggressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(ListeActivity.this);
        progressDialog.setMessage(getResources().getString(R.string.Alert));
        progressDialog.show();
    }


}


