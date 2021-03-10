package www.robotree.org;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class viewstatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstatus);
        Button butt1 = (Button) findViewById(R.id.rt);
        Button butt2 = (Button) findViewById(R.id.pd);
        Button butt3 = (Button) findViewById(R.id.vps);
        butt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewstatus.this, sensordata.class);
                startActivity(intent);

            }
        });
        butt2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewstatus.this, viewpatientdata.class);
                startActivity(intent);

            }
        });
        butt3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewstatus.this, viewprescription.class);
                startActivity(intent);

            }
        });
    }
}