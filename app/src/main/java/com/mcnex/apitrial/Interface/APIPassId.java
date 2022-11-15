package com.mcnex.apitrial.Interface;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
public interface APIPassId {

    String BASE_URL="https://eyeclonview.com/albatross/find/nation.php";
    @GET("getNation")
    Call<String> getNation();

    /*@GET("getSDistrict/{id}")
    Call<String> getSDistrict(@Path("id")int id);
    @GET("getSubDistrict/{id}")
    Call<String> getSubDistrict(@Path("id")int id);*/

    @GET("https://eyeclonview.com/albatross/find/region.php?nation_code={id}")
    Call<String> getRegion(@Path("id")int id);

    @GET("https://eyeclonview.com/albatross/find/golf.php?nation_code=82&region_code={id}")
    Call<String> getGolfPitch(@Path("id")int id);
}
