package com.togapp.mission07;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    public static int REQUEST_CODE_CLIENT = 111;
    public static int REQUEST_CODE_SALES = 121;
    public static int REQUEST_CODE_PRODUCT = 131;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent receivedIntent = getIntent();
        String id = receivedIntent.getStringExtra("username");
        String paw = receivedIntent.getStringExtra("password");
        Toast.makeText(getApplicationContext(), "입력한 아이디 : " + id + "\n입력한 패스워드 : " + paw, Toast.LENGTH_SHORT).show();

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        // 고객 관리
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuClientActivity.class);
                intent.putExtra("name", "고객 관리");
                setResult(RESULT_OK, intent);
                startActivityForResult(intent, REQUEST_CODE_CLIENT);
            }
        });
        // 매출 관리
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuSalesActivity.class);
                intent.putExtra("name", "매출 관리");
                setResult(RESULT_OK, intent);
                startActivityForResult(intent, REQUEST_CODE_SALES);
            }
        });
        // 상품 관리
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProductMenuActivity.class);
                intent.putExtra("name", "상품 관리");
                setResult(RESULT_OK, intent);
                startActivityForResult(intent, REQUEST_CODE_PRODUCT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CLIENT){
            if (resultCode == RESULT_OK){
                String client = data.getStringExtra("client");
                if (client != null){
                    Toast.makeText(getApplicationContext(), "고객관리 응답, result code : " + resultCode + ", message : " + client, Toast.LENGTH_SHORT).show();
                }
            }
        }

        if (requestCode == REQUEST_CODE_SALES){
            if (resultCode == RESULT_OK){
                String sales = data.getStringExtra("sales");
                if (sales != null){
                    Toast.makeText(getApplicationContext(), "매출관리 응답, result code : " + resultCode + ", message : " +sales, Toast.LENGTH_SHORT).show();
                }
            }
        }

        if (requestCode == REQUEST_CODE_PRODUCT){
            if (resultCode == RESULT_OK){
                String product = data.getStringExtra("product");
                if (product != null){
                    Toast.makeText(getApplicationContext(), "상품관리 응답, result code : " + resultCode + ", message : " + product, Toast.LENGTH_SHORT).show();
                }
            }
        }


    }
}