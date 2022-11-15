package com.mcnex.apitrial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mcnex.apitrial.Interface.APIPassId;
import com.mcnex.apitrial.entities.Nation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
  private Spinner nation_spinner,region_spinner,golf_pitch_spinner;
  private ArrayList<String> getNationName=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nation_spinner=(Spinner)findViewById(R.id.nation_spinner);
        region_spinner=(Spinner)findViewById(R.id.region_spinner);
        golf_pitch_spinner=(Spinner)findViewById(R.id.golf_pitch_spinner);
        getNations();
    }

    private void getNations() {
      Retrofit retrofit=new Retrofit.Builder().baseUrl(APIPassId.BASE_URL).addConverterFactory(ScalarsConverterFactory.create()).build();
      APIPassId apiPassId=retrofit.create(APIPassId.class);
      Call<String> call=apiPassId.getNation();
      call.enqueue(new Callback<String>() {
          @Override
          public void onResponse(Call<String> call, Response<String> response) {
            Log.i("Response",response.body().toString());
            if(response.isSuccessful()){
                if (response.body()!=null){
                    Log.i("success",response.body().toString());
                    try{
                        String getResponse=response.body().toString();
                        List<Nation> getNationData=new ArrayList<Nation>();
                        JSONArray jsonArray=new JSONArray(getResponse);
                        getNationData.add(new Nation(-1,"----SELECT---","--SELECT--"));
                        for(int i=0;i<jsonArray.length(); i++){
                          Nation nations=new Nation();
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            nations.setNation_code(jsonObject.getInt("nation_code"));
                            nations.setNation_english("nation_english");
                            nations.setNation_native("nation_native");
                            getNationData.add(nations);
                        }
                        for(int i=0;i<getNationData.size();i++){
                            getNationName.add(getNationData.get(i).getNation_english().toString());
                        }
                        ArrayAdapter<String> spinNationAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,getNationName);
                        spinNationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        nation_spinner.setAdapter(spinNationAdapter);
                        nation_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                    }
                    catch(JSONException ex){
                        ex.printStackTrace();
                    }
                }
            }
          }

          @Override
          public void onFailure(Call<String> call, Throwable t) {

          }
      });

    }
}