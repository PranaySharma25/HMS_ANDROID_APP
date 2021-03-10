package www.robotree.org;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class prescription extends AppCompatActivity {
    EditText prescription;
    Button pps;
    FirebaseDatabase database;
    DatabaseReference reff;
    int maxid=0;
    member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);
        prescription = findViewById(R.id.adp);
        pps = findViewById(R.id.pps);
        member=new member();
        reff= FirebaseDatabase.getInstance().getReference().child("Admin").child("prescription");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    maxid =(int) dataSnapshot.getChildrenCount();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        pps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                member.setPrescription( prescription.getText().toString());
                reff.child(String.valueOf(maxid+1)).setValue(member);
                Toast.makeText(prescription.this, "Data send to the server",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),viewstatusdoctor.class));

            }
        });

    }
}