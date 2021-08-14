package com.peluffo.segundaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    private Button BTSiguiente2;
    private TextView TVSalida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        iniciarVista();
    }
    private void iniciarVista() {
        TVSalida = findViewById(R.id.TVSalida);
        String msj = getIntent().getStringExtra("mensaje");
        TVSalida.setText(msj);
        BTSiguiente2 = findViewById(R.id.BTSiguiente2);
        BTSiguiente2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this , Activity3.class);
                startActivity(intent);
            }
        });
    }
}