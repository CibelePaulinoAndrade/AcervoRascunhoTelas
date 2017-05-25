package com.example.cibele.testeacervo;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button camera;                       //Botão - Camera
    Spinner spin;                        //Conservação
    Spinner spin2;                       //Editora
    ArrayAdapter adp;                    //Array - Conservação
    ArrayAdapter adp2;                   //Array - Editora
    ImageView imagemLivro;               //Imagem do livro
    TextView volume;                     //Volume

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Imagem
        imagemLivro = (ImageView)findViewById(R.id.imgLivro);

        //ActionBar Edit
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.secYellow)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cadastro de Livro");

        //Spinner Conservação
        adp =  ArrayAdapter.createFromResource(this, R.array.Conservacao, R.layout.spinner_cadastro);
        spin = (Spinner)findViewById(R.id.spnConservacao);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adp);

        //Spinner Editora
        adp2 =  ArrayAdapter.createFromResource(this, R.array.Editora, R.layout.spinner_cadastro2);
        spin2 = (Spinner)findViewById(R.id.spnEditora);
        adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adp2);

        //Volume - Texto
        volume = (TextView)findViewById(R.id.textoMeio);
        volume.setText("0");

    }
    //Capturar a imagem do Livro
    //Chamado quando pressiona o botão "Camera"
    public void imagemLivro (View v){
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePicture, 0);
        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto , 1);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case 0:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    imagemLivro.setImageURI(selectedImage);
                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    imagemLivro.setImageURI(selectedImage);
                }
                break;
        }
    }
    //Guardar os dados de titulo e descrição do livro
    //Chamado quando pressiona o botão "Salvar"
    public void registrarLivro(View v){
        EditText tituloET = (EditText) findViewById(R.id.txtTitulo);
        EditText descricaoET = (EditText) findViewById(R.id.txtDescricao);
        String titulo = tituloET.getText().toString();
        String descricao = descricaoET.getText().toString();
    }
    //Aumenta o valor do Volume
    //Chamado quando pressiona o botão "Seta Superior"
    public void aumentaValor(View v){
        int x;
        x = Integer.valueOf(volume.getText().toString());
        Log.d("teste", "aumentaValor: "+x);
        int soma = x+1;
        Log.d("teste2", "aumentaValor: "+soma);
        volume.setText(String.valueOf(soma));

    }
    //Diminui o valor do Volume
    //Chamado quando pressiona o botão "Seta Inferior"
    public void diminuiValor(View v){
        int y;
        y = Integer.valueOf(volume.getText().toString());
        Log.d("teste3", "aumentaValor: "+y);
        int diminui = y-1;
        Log.d("teste4", "aumentaValor: "+diminui);
        if(diminui>=1){
            volume.setText(String.valueOf(diminui));
        }
        else{
            volume.setText("0");
        }
    }
}