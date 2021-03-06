package com.example.davpas.prueba1;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo = (TextView) findViewById(R.id.saludo2);
        final Button miBoton2 = (Button) findViewById(R.id.Volver);
        final ImageButton miBoton3 = (ImageButton) findViewById(R.id.imgvolver);

        Bundle recogerBundle = getIntent().getExtras();
        otroSaludo.setText(recogerBundle.getString("TEXTO"));

        /*showToast("estoy en pantalla2");*/

        Toast.makeText(this, "estoy en pantalla2", Toast.LENGTH_SHORT).show();

        miBoton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(Pantalla2.this, MainActivity.class);

                startActivity(miIntent);
            }
        });

        miBoton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(Pantalla2.this, MainActivity.class);

                startActivity(miIntent);
            }
        });

    /*protected void showToast(CharSequence text) {
        Context context = getApplicationContext();

        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }*/

    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart- A2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume- A2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        Toast.makeText(this,"onPause- A2", Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop- A2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart- A2", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        Toast.makeText(this,"onDestroy- A2", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}