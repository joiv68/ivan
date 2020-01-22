package com.nore.kalkulator_gampang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {
    EditText isi_nama;
    EditText isi_harga;
    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        isi_nama = (EditText) findViewById(R.id.nama) ;
        isi_harga = (EditText) findViewById(R.id.harga) ;
        ok = (Button) findViewById(R.id.btn_ok);

        Intent ganti=new Intent(InputActivity.this,MainActivity.class);

        startActivity(ganti);
    }
}
