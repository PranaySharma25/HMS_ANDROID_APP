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

public class addpatient extends AppCompatActivity {
EditText name,age,dob,phone,gender,address,email,city,problem,ward_no,sensor_no,consulting,bed_no;
Button submit;
FirebaseDatabase database;
DatabaseReference reff;
int maxid=0;
member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpatient);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        dob= findViewById(R.id.dob);
        phone = findViewById(R.id.phone);
        gender = findViewById(R.id.Gender);
        address = findViewById(R.id.Address);
        email = findViewById(R.id.Email);
        city= findViewById(R.id.City);
        problem=findViewById(R.id.Problem);
        ward_no = findViewById(R.id.Ward_No);
        sensor_no= findViewById(R.id.Sensor_No);
        consulting= findViewById(R.id.Consulting);
        bed_no = findViewById(R.id.Bed_No);
        submit = findViewById(R.id.submit);
        member=new member();
        reff= FirebaseDatabase.getInstance().getReference().child("Admin").child("Patient");
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
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                member.setName(name.getText().toString());
                member.setAge(age.getText().toString());
                member.setDob(dob.getText().toString());
                member.setGender(gender.getText().toString());
                member.setAddress(address.getText().toString());
                member.setEmail(email.getText().toString());
                member.setCity(city.getText().toString());
                member.setProblem(problem.getText().toString());
                member.setWard_no(ward_no.getText().toString());
                member.setSensor_no(sensor_no.getText().toString());
                member.setConsulting(consulting.getText().toString());
                member.setBed_no(bed_no.getText().toString());
                reff.child(String.valueOf(maxid+1)).setValue(member);
                Toast.makeText(addpatient.this, "Data send to the server",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),dataupload.class));


            }
        });


    }
}
