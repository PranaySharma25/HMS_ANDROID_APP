package www.robotree.org;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admind extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admind);
        Button butt1 = (Button) findViewById(R.id.addpatient);
        Button butt2 = (Button) findViewById(R.id.adddoctor);
        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admind.this, addpatient.class);
                startActivity(intent);

            }
        });
        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admind.this, adddoctor.class);
                startActivity(intent);

            }
        });
    }
}