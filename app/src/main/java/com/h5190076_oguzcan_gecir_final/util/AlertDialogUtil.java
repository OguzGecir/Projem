package com.h5190076_oguzcan_gecir_final.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

import com.h5190076_oguzcan_gecir_final.activity.SplashActivity;

public class AlertDialogUtil {
    public static void alertDialog(Context context,String title,String message,String yes,String no, String screen){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(screen.toString().equals("SplashActivity")){
                    context.startActivity(new Intent(Settings.ACTION_SETTINGS));
                }
                else{
                    ((Activity)context).onBackPressed();
                    ((Activity)context).finish();
                }

            }
        });

        builder.setNegativeButton(no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface window, int which) {
                if(screen.toString().equals(SplashActivity.class)){
                    ((Activity)context).finish();

                }
                else{
                    window.dismiss();
                }
            }
        });
        builder.show();
    }


    }


