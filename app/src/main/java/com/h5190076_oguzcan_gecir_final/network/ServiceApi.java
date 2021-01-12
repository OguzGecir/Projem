package com.h5190076_oguzcan_gecir_final.network;


import com.h5190076_oguzcan_gecir_final.model.UyeModel;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //
    @GET("Uyeler.json")
    Observable<List<UyeModel>> uyeleriGetir();
}
