package www.robotree.org;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class viewpatientdata extends AppCompatActivity {
    TextView a,b,c,d,e,f,g,h,i,j,k,l;
    DatabaseReference dref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpatientdata);
        a = findViewById(R.id.name);
        b = findViewById(R.id.age);
        c= findViewById(R.id.dob);
        d = findViewById(R.id.Gender);
        e = findViewById(R.id.Address);
        f = findViewById(R.id.Email);
        g= findViewById(R.id.City);
        h=findViewById(R.id.Problem);
        i = findViewById(R.id.Ward_No);
        j= findViewById(R.id.Sensor_No);
        k= findViewById(R.id.Consulting);
        l = findViewById(R.id.Bed_No);
        dref= FirebaseDatabase.getInstance().getReference().child("Admin").child("Patient").child("1");
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                String name=dataSnapshot.child("name").getValue().toString();
                a.setText(name);
                String age=dataSnapshot.child("age").getValue().toString();
                b.setText(age);
                String dob=dataSnapshot.child("dob").getValue().toString();
                c.setText(dob);
                String gender=dataSnapshot.child("gender").getValue().toString();
                d.setText(gender);
                String address=dataSnapshot.child("address").getValue().toString();
                e.setText(address);
                String email=dataSnapshot.child("email").getValue().toString();
                f.setText(email);
                String city=dataSnapshot.child("city").getValue().toString();
                g.setText(city);
                String problem=dataSnapshot.child("problem").getValue().toString();
                h.setText(problem);
                String ward_no=dataSnapshot.child("ward_no").getValue().toString();
                i.setText(ward_no);
                String sensor_no=dataSnapshot.child("sensor_no").getValue().toString();
                j.setText(sensor_no);
                String Consulting=dataSnapshot.child("consulting").getValue().toString();
                k.setText(Consulting);
                String bed_no=dataSnapshot.child("bed_no").getValue().toString();
                l.setText(bed_no);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
