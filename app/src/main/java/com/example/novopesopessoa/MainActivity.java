package com.example.novopesopessoa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText peso;
    TextView resultadoEmagrecer;
    TextView resultadoEngordar;
    Button consultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = (EditText) findViewById(R.id.editTextTextPersonName);
        resultadoEmagrecer = (TextView) findViewById(R.id.textView4);
        resultadoEngordar = (TextView) findViewById(R.id.textView5);
        consultar = (Button) findViewById(R.id.button);

        consultar.setOnClickListener(c->{
            if (peso.getText().toString().contains(",")){
                Toast.makeText(this, "Deve inserir um ponto no lugar da vírgula caso " +
                        "queira inserir um valor decimal", Toast.LENGTH_SHORT).show();
            }
            else{
                double emagrecer, engordar, perc_emagrecer, perc_engordar;
                perc_emagrecer = (Double.parseDouble(peso.getText().toString()) * 20)/100;
                perc_engordar = (Double.parseDouble(peso.getText().toString()) * 15)/100;
                emagrecer = (Double.parseDouble(peso.getText().toString())) - perc_emagrecer;
                engordar = (Double.parseDouble(peso.getText().toString())) + perc_engordar;

                resultadoEngordar.setText(Double.toString(engordar));
                resultadoEmagrecer.setText(Double.toString(emagrecer));
            }
        });
    }
}