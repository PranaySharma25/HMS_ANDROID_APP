package www.robotree.org;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class doctorlogin extends AppCompatActivity {
    EditText email,password_1;
    Button go_button;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorlogin);
        email=(EditText) findViewById(R.id.Logingasdoctor);
        password_1=(EditText) findViewById(R.id.doctorcode);
        go_button=(Button)findViewById(R.id.goup);

        firebaseAuth= FirebaseAuth.getInstance();

        go_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  Email =email.getText().toString().trim();
                String  Password = password_1.getText().toString().trim();
                if(TextUtils.isEmpty(Email))
                {
                    Toast.makeText(doctorlogin.this, "Enter User-ID", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(Password))
                {
                    Toast.makeText(doctorlogin.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(Email, Password)
                        .addOnCompleteListener(doctorlogin.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    startActivity(new Intent(getApplicationContext(),enterpatientid.class));

                                    Toast.makeText(doctorlogin.this, "Login ", Toast.LENGTH_SHORT).show();
                                } else
                                {
                                    Toast.makeText(doctorlogin .this, "Login Failed", Toast.LENGTH_SHORT).show();

                                }

                            }
                        });
            }
        });
    }
}