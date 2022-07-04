package tr.edu.medipol.ybs95150054;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle(R.string.kayseri);

        ImageView hava_durumu = findViewById(R.id.hava_durumu);
        Button galeri = findViewById(R.id.galeri);
        Button ilceler = findViewById(R.id.ilceler);
        Button kayseri = findViewById(R.id.kayseri);
        String url = this.getString(R.string.hava_durumu_url);
        Glide.with(this).load(url).into(hava_durumu);


        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PhotosActivity.class);
                startActivity(intent);
            }
        });

        ilceler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DistrictActivity.class);
                startActivity(intent);
            }
        });

        kayseri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("url", "http://www.kayseri.gov.tr/");
                startActivity(intent);
            }
        });

    }
}