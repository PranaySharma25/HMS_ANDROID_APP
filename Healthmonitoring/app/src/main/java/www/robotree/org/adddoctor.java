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

public class adddoctor extends AppCompatActivity {

    EditText name,age,dob,phone,gender,address,email,city,Qualification,Specialization,Experience, Hospital;
    Button submit;
    FirebaseDatabase database;
    DatabaseReference reff;
    int maxid=0;
    member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddoctor);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        dob= findViewById(R.id.dob);
        phone = findViewById(R.id.phone);
        gender = findViewById(R.id.Gender);
        address = findViewById(R.id.Address);
        email = findViewById(R.id.Email);
        city= findViewById(R.id.City);
        Qualification=findViewById(R.id.Specialization);
        Specialization = findViewById(R.id.Experience);
        Experience= findViewById(R.id.Hospital);
        Hospital= findViewById(R.id.Qualification);

        submit = findViewById(R.id.submit);
        member=new member();
        reff= FirebaseDatabase.getInstance().getReference().child("Admin").child("Doctor");
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
                member.setQualification(Qualification.getText().toString());
                member.setSpecialization(Specialization.getText().toString());
                member.setExperience(Experience.getText().toString());
                member.setHospital(Hospital.getText().toString());
                reff.child(String.valueOf(maxid+1)).setValue(member);
                Toast.makeText(adddoctor.this, "Data send to the server",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });

    }
}