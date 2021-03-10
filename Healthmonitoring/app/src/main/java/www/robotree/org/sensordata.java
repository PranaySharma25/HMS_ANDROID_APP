package www.robotree.org;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class sensordata extends AppCompatActivity {
TextView bpm,tempr,humidity;
DatabaseReference dref;
String status;
String temp;
String humidit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensordata);
        bpm=(TextView)findViewById(R.id.bmp);
        tempr=(TextView)findViewById(R.id.temp);
        humidity=(TextView)findViewById(R.id.humidity);
        dref= FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                status=dataSnapshot.child("BPM").getValue().toString();
                bpm.setText(status);
                temp=dataSnapshot.child("temp").getValue().toString();
                tempr.setText(temp);
                humidit=dataSnapshot.child("hum").getValue().toString();
                humidity.setText(humidit);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}