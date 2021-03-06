package com.nore.kalkulator_gampang;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {
    TextView tv_nama;
    TextView tv_harga;
    Button btn_minus;
    Button btn_add;
    TextView jml;
    int qty = 0;
    Button btn_reset;

    TextView tv_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_nama=(TextView) findViewById(R.id.edit_nama); //Button
        tv_harga=(TextView) findViewById(R.id.edit_harga);
        btn_minus = (Button) findViewById(R.id.minus);
        btn_add = (Button) findViewById(R.id.add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openDialog();
                Intent tambah=new Intent(MainActivity.this,InputActivity.class);
                startActivity(tambah);
            }
        });
        jml = (TextView) findViewById(R.id.qty); ///tadi salah
        jml.setText(""+qty);
        btn_reset=(Button) findViewById(R.id.reset);

        tv_total = (TextView) findViewById(R.id.total);

        tv_nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qty++;
                jml.setText(""+qty);
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qty!=0){
                    qty--;
                    jml.setText(""+qty);
                }
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                qty = 0 ;
                jml.setText(""+qty);
            }
        });

        tv_total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("Detail Pembayaran",tv_nama.getText().toString());
            }
        });
    }

    public void openDialog(){
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"example dialog");

    }

    @Override
    public  void applyTexts(String nama, String harga){
        tv_nama.setText(nama);
        tv_harga.setText(harga);
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        //builder.setMessage(tv_nama.getText().toString());
        builder.show();
    }

}
