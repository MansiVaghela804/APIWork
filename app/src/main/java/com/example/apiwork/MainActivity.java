package com.example.apiwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.apiwork.APIInterface.APIInterface;
import com.example.apiwork.APIManager.APIClient;
import com.example.apiwork.APIResponse.CategoryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadData();
    }

    private void loadData() {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<CategoryResponse> categoryResponseCall = apiInterface.GET_BRAND_RESPONSE_CALL_COMMON_CATEGORIES("rp");
        categoryResponseCall.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if (response.body().getSuccess() != null) {
                    List<CategoryResponse.ModelList> modelLists = response.body().getModelList();
                    CustomAdapter customAdapter = new CustomAdapter(response, getApplicationContext());
                    recyclerView.setAdapter(customAdapter);
                    customAdapter.Click(new CustomAdapter.RecyclerViewClickListener() {
                        @Override
                        public void onClick(int position) {
                            if (position == 0) {
                                Intent intent = new Intent(MainActivity.this, FurnitureActivity.class);
                                startActivity(intent);
                            } else if (position == 1) {
                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else if (position == 2) {
                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else if (position == 3) {
                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else if (position == 4) {
                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else if (position == 5) {
                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
