package com.example.davpas.ejemplolistatitular;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Titular[] datos = new Titular[] {
            new Titular("JUEGO DE TRONOS", "GEORGE R.R. MARTIN", "En el legendario mundo de los Siete Reinos,donde el verano puede durar décadas y el invierno todo una vida,y donde rastros de una magia inmemorial surgen en los rincones más sombríos,la tierra del norte,Invernalia,está resguardada por un colosal muro de hielo que detiene a fuerzas oscuras y sobrenaturales. En este majestuoso escenario,lord Stark y su familia se encuentran en el centro de un conflicto que desatará todas las pasiones: la traición y la lealtad,la compasión y la sed de venganza,el amor y el poder,la lujuria y el incesto,todo ello para ganar la más mortal de las batallas: el trono de hierro,una poderosa trampa que atrapará a los personajes...y al lector." , R.drawable.img1),
            new Titular("EL SEÑOR DE LOS ANILLOS", "J.R.R. TOLKIEN", "Su historia se desarrolla en la Tercera Edad del Sol de la Tierra Media, un lugar ficticio poblado por hombres y otras razas antropomorfas como los hobbits, los elfos o los enanos, así como por muchas otras criaturas reales y fantásticas. La novela narra el viaje del protagonista principal, el hobbit Frodo Bolsón, para destruir el Anillo Único y la consiguiente guerra que provocará el enemigo para recuperarlo, ya que es la principal fuente de poder de su creador, el Señor oscuro Sauron.", R.drawable.img2),
            new Titular("BLADE RUNNER", "PHILIP K. DICK", "Una de las mejores novelas de Philip K. Dick, y sin duda la más leída, esta obra es una alucinante pesadilla tecnológica, cuyo tema principal es el impreciso límite entre lo natural y lo artificial. En un mundo devastado, lleno de restos tecnológicos y bloques de apartamento vacíos, Rick Deckard es un cazador mercenario cuya tarea consiste en retirar de la circulación a los androides rebeldes, profesión que es causa también de no pocos problemas con su esposa. Sin embargo, los nuevos Nexus-6 son androides con características especiales, casi humanos, lo que dificulta notablemente su labor y puede llevarle a enfrentarse a problemas que es incapaz de imaginar siquiera. En esta espléndida novela se basó Ridley Scott para su película Blade Runner, un hito en el género de la ciencia ficción que recrea con lógica implacable algunas de las características del mundo de nuestros días y plantea una serie de temas de plena actualidad.",R.drawable.img3)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button miBoton= (Button)findViewById(R.id.btnGaleria);

        miBoton.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){

                Intent miIntent= new Intent(MainActivity.this, Pantalla2.class);

                startActivity(miIntent);
            }
        });

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                String messaje = "Titulo Libro: " + datos[position].getTitulo() + ". Autor:" + datos[position].getSubtitulo();
                Toast.makeText(getApplicationContext(), messaje, Toast.LENGTH_LONG).show();
            }
            public void onNothingSelected(AdapterView<?>adapterView) {
            }
        });
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
            ViewHolder holder;

            if (item == null) {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.listitem_titular, null);

                holder = new ViewHolder();
                holder.titulo = (TextView)item.findViewById(R.id.LblTitulo);
                holder.subtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
                holder.argumento = (TextView)item.findViewById(R.id.LblArgumento);
                holder.imagen = (ImageView)item.findViewById(R.id.ivImagen);

                item.setTag(holder);
            }
            else
                holder = (ViewHolder) item.getTag();

                holder.titulo.setText(datos[position].getTitulo());

                holder.subtitulo.setText(datos[position].getSubtitulo());

                holder.argumento.setText(datos[position].getArgumento());

                holder.imagen.setBackground(getDrawable(datos[position].getImagen()));

                return item;
        }
    }
}
