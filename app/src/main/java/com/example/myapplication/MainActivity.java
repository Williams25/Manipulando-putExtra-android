package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText email,senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        email = findViewById(R.id.EdEmail);
        senha = findViewById(R.id.EdSenha);
        login = findViewById(R.id.BtnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((TextUtils.isEmpty(email.getText().toString()))) {
                    email.setError("Informe o email!");
                    email.requestFocus();
                } else if (TextUtils.isEmpty(senha.getText().toString())){
                    senha.setError("Informe sua senha!");
                    senha.requestFocus();
                } else {
                    Intent chamaTela = new Intent(MainActivity.this, Main2Activity.class);
                    chamaTela.putExtra("email_valido",email.getText().toString());
                    startActivity(chamaTela);
                    
                    email.setText("");
                    senha.setText("");
                }
            }
        });

    }
}
