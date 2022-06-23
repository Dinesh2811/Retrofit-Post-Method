package com.dinesh.googlemaptest.retrofit;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.dinesh.googlemaptest.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "log_test";

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        postModel();
        postModelList();
        postByField();
    }

    private void postByField() {
        Call<Model> call = apiInterface.postByField("Dinesh","K","dk@gmail.com","8667024800","4");
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

                Log.i(TAG, "postModelList: " + response.isSuccessful());
                Log.i(TAG, "postModelList: " + response.code());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.i(TAG, "postModelList onFailure: " + t.getLocalizedMessage());
            }
        });
    }


    private void postModelList() {
        Model model = new Model("Dinesh","K","dk@gmail.com","8667024800","4");
        Call<List<Model>> call = apiInterface.postModelList(model);
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                Log.i(TAG, "postModelList: " + response.isSuccessful());
                Log.i(TAG, "postModelList: " + response.code());
            }
            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.i(TAG, "postModelList onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    private void postModel() {
        Model model = new Model("Dinesh","K","dk@gmail.com","8667024800","4");
        Call<Model> call = apiInterface.postModel(model);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Log.i(TAG, "onResponse: " + response.isSuccessful());
            }
            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.i(TAG, "postModel onFailure: " + t.getLocalizedMessage());
            }
        });
    }


}

