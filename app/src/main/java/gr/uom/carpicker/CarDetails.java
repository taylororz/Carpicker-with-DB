package gr.uom.carpicker;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.squareup.picasso.Picasso;

public class CarDetails extends AppCompatActivity {
    ImageView myImage;
    Button returnButton;
    TextView fname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);
        myImage = (ImageView) findViewById(R.id.myImage);
        returnButton = findViewById(R.id.backBtn);
        fname = findViewById(R.id.fullNameTXT);

        myImage.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        String imageUri = intent.getStringExtra("IMAGE");
        String full_name = intent.getStringExtra("FULL_NAME");

        fname.setText(full_name);
        Picasso.with(getApplicationContext()).load(Uri.parse(imageUri)).resize(300, 0).into(myImage);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}