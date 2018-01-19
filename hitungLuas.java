package com.example.monalisa.hitungluas;

import android.os.StrictMode;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editPanjang, editLebar;
    private Button btnHitung;
    private TextView textLuas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Hitung Luas Persegi Panjang");

        editPanjang = (EditText)findViewById(R.id.edit_panjang);
        editLebar = (EditText)findViewById(R.id.edit_lebar);
        btnHitung = (Button)findViewById(R.id.btn_hitung);
        textLuas = (TextView)findViewById(R.id.text_luas);

        btnHitung.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                String  pattern = "[0-99]";
                String panjang = editPanjang.getText().toString();
                String lebar = editLebar.getText().toString();

                //validasi inputan tidak boleh kosong
                if(TextUtils.isEmpty(editPanjang.getText()) || TextUtils.isEmpty(editLebar.getText())) {

                    Toast.makeText(getApplicationContext(), "Nilai yang dimasukkan tidak boleh kosong", Toast.LENGTH_SHORT).show();

                } else if (!editPanjang.getText().toString().matches(pattern) || !editLebar.getText().toString().matches(pattern)) {
                    Toast.makeText(getApplicationContext(), "Hanya bisa diisi dengan angka", Toast.LENGTH_SHORT).show();

                } else if (editPanjang.getText().toString().matches(pattern) || editLebar.getText().toString().matches(pattern)){

                    double p = Double.parseDouble(panjang);
                    double l = Double.parseDouble(lebar);

                    double luas = p * l;
                    textLuas.setText("Luas : " + luas);
            }
            }
        });
    }
}
