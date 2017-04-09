package com.mahmud.tourguide.PlacesInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by RAHAT on 2/11/2017.
 */

public interface PlacesDeatilsApi {
    @GET()
    Call<PlacesDeatils>getAllInfo(@Url String url);

}
