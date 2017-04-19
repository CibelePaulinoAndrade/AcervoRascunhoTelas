package com.example.cibele.testeacervo;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spinner Conservação
        ArrayAdapter adp =  ArrayAdapter.createFromResource(this, R.array.Conservacao, R.layout.spinner_cadastro);
        Spinner spin = (Spinner)findViewById(R.id.spnConservacao);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adp);

        //Spinner Editora
        ArrayAdapter adp2 =  ArrayAdapter.createFromResource(this, R.array.Editora, R.layout.spinner_cadastro2);
        Spinner spin2 = (Spinner)findViewById(R.id.spnEditora);
        adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adp2);

        //ActionBar Edit
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.secYellow)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cadastro de Livro");
    }
}