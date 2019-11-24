package com.example.mycody;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    private ImageButton top_btn;
    private ImageButton bottom_btn;
    private Button Logout_btn;
    private Button Delete_Id_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance(); //회원탈퇴 및 로그아웃

        top_btn = findViewById(R.id.top_btn);
        top_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TopCody.class));
            }
        });

        bottom_btn = findViewById(R.id.bottom_btn);
        bottom_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BottomCody.class));
            }
        });

        Logout_btn = findViewById(R.id.signOutBtn);
        Logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
                Toast.makeText(getApplicationContext(), "로그아웃 되었습니다.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        Delete_Id_btn = findViewById(R.id.deleteID);
        Delete_Id_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                revokeAccess();
                Toast.makeText(getApplicationContext(), "회원탈퇴 되었습니다.", Toast.LENGTH_LONG).show();
                finishAffinity();
            }
        });


    }

    private void signOut(){
        FirebaseAuth.getInstance().signOut();
    }

    private void revokeAccess(){
        mAuth.getCurrentUser().delete();
    }
}
