package com.h5190076_oguzcan_gecir_final.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.h5190076_oguzcan_gecir_final.R;


public class GlideUtil {

    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .into(img);
    }
}
