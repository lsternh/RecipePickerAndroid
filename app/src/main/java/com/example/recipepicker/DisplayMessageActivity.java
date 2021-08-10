package com.example.recipepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipepicker.domain.ImageModel;
import com.example.recipepicker.domain.Recipe;

import java.io.File;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayMessageActivity extends AppCompatActivity {

    RecipePickerAPI recipePickerAPI = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        initApi();
        getRecipes();
        getImage();
       // TextView textView = findViewById(R.id.textView);
        //textView.setText(message);
    }

    private void initApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8100/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        recipePickerAPI = retrofit.create(RecipePickerAPI.class);

    }

    public void getRecipes() {

        Call<List<Recipe>> call = recipePickerAPI.getRecipes();
        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {

                if (response.isSuccessful()) {
                    List<Recipe> recipes = response.body();
                    TextView textView = findViewById(R.id.textView);
                    textView.setText(recipes.get(3).getName()+"\n"+recipes.get(3).getSteps()+"\n"+recipes.get(3).getIngredientsList().get(0).toString());
                } else {
                    TextView textView = findViewById(R.id.textView);
                    textView.setText("FAIL");
                }
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                TextView textView = findViewById(R.id.textView);
                textView.setText("FAIL2");
            }

        });

    }

    public void getImage() {

        Call<ImageModel> call = recipePickerAPI.getImage(5);
        call.enqueue(new Callback<ImageModel>() {
            @Override
            public void onResponse(Call<ImageModel> call, Response<ImageModel> response) {

                if (response.isSuccessful()) {
                    ImageModel image = response.body();
                    byte[] bytes = Base64.decode(image.getImageBytes(), Base64.DEFAULT);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    ImageView imageView = findViewById(R.id.imageView);
                    imageView.setImageBitmap(bitmap);
                } else {
                    System.out.println("Here");
                   /// TextView textView = findViewById(R.id.textView2);
                   // textView.setText("Image FAIL");
                }
            }

            @Override
            public void onFailure(Call<ImageModel> call, Throwable t) {
                System.out.println("Here2");
                //TextView textView = findViewById(R.id.textView2);
                //textView.setText("Image FAIL2");
            }

        });

    }
}