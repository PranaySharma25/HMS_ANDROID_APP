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


public class signup extends AppCompatActivity {
    EditText text_Email_id , text_password, text_confirmPassword;
    Button sub_button;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        text_Email_id=(EditText) findViewById(R.id.Email);
        text_password=(EditText) findViewById(R.id.Password);
        text_confirmPassword=(EditText) findViewById(R.id.ConfirmPassword);
        sub_button=(Button)findViewById(R.id.Submit);
        firebaseAuth= FirebaseAuth.getInstance();

        sub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  Email = text_Email_id .getText().toString().trim();
                String  Password = text_password.getText().toString().trim();
                String  ConfirmPassword =  text_confirmPassword.getText().toString().trim();

                if(TextUtils.isEmpty(Email))
                {
                    Toast.makeText(signup.this, "Enter Email-ID", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(Password))
                {
                    Toast.makeText(signup .this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty( ConfirmPassword ))
                {
                    Toast.makeText(signup .this, "Enter ConfirmPassword", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(Password.equals(ConfirmPassword)){
                    firebaseAuth.createUserWithEmailAndPassword(Email, Password )
                            .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                        Toast.makeText(signup .this, "Registration Completed", Toast.LENGTH_SHORT).show();

                                    } else {
                                        Toast.makeText(signup .this, "Authentication Failed", Toast.LENGTH_SHORT).show();

                                    }
                                    // ...
                                }
                            });
                }
            }
        });
    }
}