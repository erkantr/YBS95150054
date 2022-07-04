package tr.edu.medipol.ybs95150054;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class DistrictActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);
        ListView listView = findViewById(R.id.list);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        this.setTitle(R.string.ilceler);

        final ArrayList<String> districts = new ArrayList<>();
        districts.add("Akkışla");
        districts.add("Bünyan");
        districts.add("Develi");
        districts.add("Felahiye");
        districts.add("Hacılar");
        districts.add("İncesu");
        districts.add("Kocasinan");
        districts.add("Melikgazi");
        districts.add("Özvatan");
        districts.add("Pınarbaşı");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, districts) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view = super.getView(position, convertView, parent);


                TextView tv = view.findViewById(android.R.id.text1);


                tv.setTextColor(Color.WHITE);


                return view;
            }
        };

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar snackbar = Snackbar.make(constraintLayout, listView.getAdapter().getItem(position).toString(), Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
        listView.setAdapter(arrayAdapter);

    }
}