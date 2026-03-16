package com.example.restapi;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.restapi.databinding.ActivityDataDisplayBinding;

import java.util.List;

public class UserItemDisplay extends AppCompatActivity {

//    TextView id_text,title_text,body_text;

    ActivityDataDisplayBinding binding;

UserData userData=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
       binding= ActivityDataDisplayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//      title_text=findViewById(R.id.title_text);
//      body_text=findViewById(R.id.body_text);
//      id_text=findViewById(R.id.id_text);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//      Bundle bundle=getIntent().getExtras();
//        String title=bundle.getString("title");
//       String body=bundle.getString("body");
//     int id= bundle.getInt("id",0);


//         userData=getIntent().getParcelableExtra("Information");
        userData= (UserData) getIntent().getSerializableExtra("Information");

         binding.idText.setText(String.valueOf(userData.getId()));
         binding.titleText.setText(userData.getTitle());
         binding.bodyText.setText(userData.getBody());






    }
}