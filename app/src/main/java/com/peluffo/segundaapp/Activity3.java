package com.peluffo.segundaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {
    private Button BTSiguiente3;
    private TextView TVFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        iniciarVista();
        acceder();
    }
    private void iniciarVista(){
        BTSiguiente3 = findViewById(R.id.BTSiguiente3);
        BTSiguiente3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity3.this, Activity4.class);
                startActivity(intent);
            }
        });
    }
    @SuppressLint("Range")
    private void acceder(){
        TVFinal = findViewById(R.id.TVFinal);
        StringBuilder sb = new StringBuilder();
        Uri llamadas = Uri.parse("content://call_log/calls");
        ContentResolver cr = getContentResolver();

        Cursor c = cr.query( llamadas,
                null,
                null,
                null,
                null);
        String nro = null;
        String tiempo = null;
        if (c!=null && c.getCount()> 0){
            while (c.moveToNext()){
                nro = c.getString(c.getColumnIndex(CallLog.Calls.NUMBER));
                tiempo = c.getString(c.getColumnIndex(CallLog.Calls.DURATION));
                sb.append("Numero: "+ nro + " " + "Tiempo: " + tiempo + "\n");
            }
            TVFinal.setText(sb.toString());
        }
        else{
            TVFinal.setText("No hay registros");
        }
    }
}