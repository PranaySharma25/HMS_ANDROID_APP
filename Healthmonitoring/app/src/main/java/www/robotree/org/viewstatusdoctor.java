package www.robotree.org;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class viewstatusdoctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstatusdoctor);
        Button butt1 = (Button) findViewById(R.id.rt);
        Button butt2 = (Button) findViewById(R.id.pd);
        Button butt3 = (Button) findViewById(R.id.pr);
        Button butt4 = (Button) findViewById(R.id.report);
        butt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewstatusdoctor.this, sensordata.class);
                startActivity(intent);

            }
        });
        butt2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewstatusdoctor.this, viewpatientdata.class);
                startActivity(intent);

            }
        });
        butt3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewstatusdoctor.this, prescription.class);
                startActivity(intent);

            }
        });
        butt4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewstatusdoctor.this, viewimg.class);
                startActivity(intent);

            }
        });
    }
}