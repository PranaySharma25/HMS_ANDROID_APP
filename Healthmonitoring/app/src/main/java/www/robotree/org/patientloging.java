package www.robotree.org;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class patientloging extends AppCompatActivity {
    EditText email,password_1;
    Button go_button;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientloging);
        email=(EditText) findViewById(R.id.LogingasPatient);
        password_1=(EditText) findViewById(R.id.Patientcode);
        go_button=(Button)findViewById(R.id.show);

        firebaseAuth= FirebaseAuth.getInstance();

        go_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  Email =email.getText().toString().trim();
                String  Password = password_1.getText().toString().trim();
                if(TextUtils.isEmpty(Email))
                {
                    Toast.makeText(patientloging.this, "Enter Patient-User-ID", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(Password))
                {
                    Toast.makeText(patientloging .this, "Enter Patient-code", Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(Email, Password)
                        .addOnCompleteListener(patientloging.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    startActivity(new Intent(getApplicationContext(),viewstatus.class));

                                    Toast.makeText(patientloging .this, "Login ", Toast.LENGTH_SHORT).show();
                                } else
                                {
                                    Toast.makeText(patientloging .this, "Login Failed", Toast.LENGTH_SHORT).show();

                                }

                            }
                        });
            }
        });
    }
}