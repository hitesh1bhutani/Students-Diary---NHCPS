package com.example.hitesh1bhutani.studentdiary_nhcps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        mRef = new Firebase("https://students-diary-nhcps.firebaseio.com/");

        final EditText studentId = (EditText) findViewById(R.id.et_mainActivity_StudetId);

        final Button logIn = (Button)findViewById(R.id.b_mainActivit_LogIn);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Firebase mRefChild = mRef.child("Student Id");

                if(studentId.getText().toString().length()!=0)
                    mRefChild.setValue(studentId.getText().toString());
                else Toast.makeText(getApplicationContext(), "Enter Student Id first !!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
