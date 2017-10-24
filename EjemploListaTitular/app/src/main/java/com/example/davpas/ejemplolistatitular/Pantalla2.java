package com.example.davpas.ejemplolistatitular;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla2 extends AppCompatActivity {

    private Titular[] datos = new Titular[] {
            new Titular("MI LIBRO FAVORITO!!!!!", " ", " ", R.drawable.img1)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        Pantalla2.AdaptadorTitulares adaptador = new Pantalla2.AdaptadorTitulares(this);
        ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);
    }

    static class ViewHolder {
        TextView titulo;
        TextView subtitulo;
        TextView argumento;
        ImageView imagen;
    }

    class AdaptadorTitulares extends ArrayAdapter {
        Activity context;

        AdaptadorTitulares(Activity context) {
            super(context, R.layout.listitem_titular, datos);
            this.context = context;
        }

        public View getView(int position, View contentView, ViewGroup parent) {
            View item = contentView;
            Pantalla2.ViewHolder holder;

            if (item == null) {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.listitem_titular, null);

                holder = new Pantalla2.ViewHolder();
                holder.titulo = (TextView)item.findViewById(R.id.LblTitulo);
                holder.subtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
                holder.argumento = (TextView)item.findViewById(R.id.LblArgumento);
                holder.imagen = (ImageView)item.findViewById(R.id.ivImagen);

                item.setTag(holder);
            }
            else
                holder = (Pantalla2.ViewHolder) item.getTag();

            holder.titulo.setText(datos[position].getTitulo());

            holder.subtitulo.setText(datos[position].getSubtitulo());

            holder.argumento.setText(datos[position].getArgumento());

            holder.imagen.setBackground(getDrawable(datos[position].getImagen()));

            return item;
        }
    }
}
