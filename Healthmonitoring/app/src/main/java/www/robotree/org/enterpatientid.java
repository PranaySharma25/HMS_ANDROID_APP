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

public class enterpatientid extends AppCompatActivity {
    EditText email,password;
    Button gobutton;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterpatientid);
        email=(EditText) findViewById(R.id.Logingasp);
        password=(EditText) findViewById(R.id.code);
        gobutton=(Button)findViewById(R.id.goa);

        firebaseAuth= FirebaseAuth.getInstance();

        gobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  Email =email.getText().toString().trim();
                String  Password = password.getText().toString().trim();
                if(TextUtils.isEmpty(Email))
                {
                    Toast.makeText(enterpatientid.this, "Enter Patient-User-ID", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(Password))
                {
                    Toast.makeText(enterpatientid.this, "Enter Patient-code", Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(Email, Password)
                        .addOnCompleteListener(enterpatientid.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    startActivity(new Intent(getApplicationContext(),viewstatusdoctor.class));

                                    Toast.makeText(enterpatientid.this, "Login ", Toast.LENGTH_SHORT).show();
                                } else
                                {
                                    Toast.makeText(enterpatientid.this, "Login Failed", Toast.LENGTH_SHORT).show();

                                }

                            }
                        });
            }
        });
    }
}
