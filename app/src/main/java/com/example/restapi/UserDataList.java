package com.example.restapi;

import static androidx.databinding.DataBindingUtil.setContentView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.restapi.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDataList extends AppCompatActivity implements ItemClickListener{


    ApiInterface apiInterface;
    private List<UserData> data;
    MyRecyclerAdapter adapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        data = new ArrayList<>();
        binding.recylerview.setLayoutManager(new LinearLayoutManager(this));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<List<UserData>> call = apiInterface.getData();
        call.enqueue(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    data = response.body();
                    adapter = new MyRecyclerAdapter(data, UserDataList.this);
                    binding.recylerview.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {

            }
        });
    }


        @Override
        public void onItemClick (int positiion){
            UserData clickedItem = data.get(positiion);
//            Intent intent = new Intent(UserDataList.this, UserItemDisplay.class);
//            Bundle bundle = new Bundle();
//            bundle.putInt("id", clickedItem.getId());
//            bundle.putString("title", clickedItem.getTitle());
//            bundle.putString("body", clickedItem.getBody());
//            intent.putExtras(bundle);
//            startActivity(intent);
            Intent intent=new Intent(UserDataList.this,UserItemDisplay.class);
            intent.putExtra("Information",clickedItem);
            startActivity(intent);

        }

}