package tr.edu.medipol.ybs95150054;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PhotosActivity extends AppCompatActivity {

    final String[] places = {"Kayseri Bilim Merkezi", "Erciyes Dağı Kayak Merkezi", "Zamantı Irmağı", "Yedigöller", "Derebağ Şelalesi",
            "Ali Dağı", "Sultan Sazlığı"};

    String[] placesUrl = {"https://blog.biletbayi.com/wp-content/uploads/2020/06/kayseri-bilim-merkezi-scaled.jpg",
            "https://blog.biletbayi.com/wp-content/uploads/2020/06/erciyes-dagi-kayak-merkezi-scaled.jpg",
            "https://blog.biletbayi.com/wp-content/uploads/2020/06/zamanti-irmagi-scaled.jpg",
            "https://blog.biletbayi.com/wp-content/uploads/2020/06/yedigoller-scaled.jpg",
            "https://blog.biletbayi.com/wp-content/uploads/2020/06/derebag-selalesi-scaled.jpg",
            "https://blog.biletbayi.com/wp-content/uploads/2020/06/ali-dagi-scaled.jpg",
            "https://blog.biletbayi.com/wp-content/uploads/2020/06/sultan-sazligi-scaled.jpg"};

    ImageView image;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);


        for (int x = 0; x < 7; x++) {
            image = new ImageView(PhotosActivity.this);
            textView = new TextView(PhotosActivity.this);
            Glide.with(this).load(placesUrl[x]).into(image);
            textView.setText(places[x]);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(24);
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            linearLayout.addView(textView);
            linearLayout.addView(image);

            int finalX = x;
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(PhotosActivity.this, WebViewActivity.class);
                    intent.putExtra("url", placesUrl[finalX]);
                    startActivity(intent);
                }
            });
        }
    }
}