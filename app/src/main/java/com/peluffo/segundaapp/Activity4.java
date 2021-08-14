package com.peluffo.segundaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {
    public TextView TVContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        accederContactos();
    }

    @SuppressLint("Range")
    private void accederContactos(){
        TVContactos = findViewById(R.id.TVContactos);
        StringBuilder sb = new StringBuilder();
        // Acceder a los contactos
        Uri contactos = ContactsContract.Contacts.CONTENT_URI ;
        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(contactos,
                null,
                null,
                null,
                null);
        String id = null;
        String nombre = null;
        if(c != null && c.getCount()> 0){
            while (c.moveToNext()){
                id = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                nombre = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                sb.append("ID: "+ id +".Nombre: "+ nombre + "\n");
            }
            TVContactos.setText(sb.toString());
        }
        else{
            TVContactos.setText("No hay registros");
        }
    }
}