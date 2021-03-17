package com.togapp.mission07;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;
    EditText usernameInput;
    EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        usernameInput = findViewById(R.id.editTextTextEmailAddress);
        passwordInput = findViewById(R.id.editTextTextPassword);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //EditText내용을 가져오기
                String id = usernameInput.getText().toString();
                String paw = passwordInput.getText().toString();
                if (id.getBytes().length <= 0){
                    Toast.makeText(getApplicationContext(), "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (paw.getBytes().length <= 0){
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    // Menu에서 받아서 처리
                    // Toast.makeText(getApplicationContext(), "입력한 아이디 : " + id + "\n입력한 패스워드 : " + paw, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    intent.putExtra("username", id);
                    intent.putExtra("password", paw);
                    startActivityForResult(intent, REQUEST_CODE_MENU);
                }

            }
        });


    }   //  end onCreate

    // ctrl + o  onActivityResult 검색
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_MENU){
            if ( resultCode == RESULT_OK ){
                String na = data.getStringExtra("name");
                if (na != null){
                    Toast.makeText(getApplicationContext(),na,Toast.LENGTH_LONG).show();
                }
            }
        }
    }


}   // end MainActivity