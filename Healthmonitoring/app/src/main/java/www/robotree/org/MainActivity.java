package www.robotree.org;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button butt1 = (Button) findViewById(R.id.admin);
        Button butt2 = (Button) findViewById(R.id.patient);
        Button butt3 = (Button) findViewById(R.id.doctor);

                butt1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this,Adminlogin.class);
                        startActivity(intent);

            }
        });
        butt2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, patientloging.class);
                startActivity(intent);

            }
        });
        butt3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,doctorlogin.class);
                startActivity(intent);

            }
        });
    }
}