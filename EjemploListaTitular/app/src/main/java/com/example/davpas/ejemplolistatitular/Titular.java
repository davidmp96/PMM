package com.example.davpas.ejemplolistatitular;

/**
 * Created by davpas on 20/10/17.
 */

public class Titular {
    private String titulo;
    private String subtitulo;
    private String argumento;
    private int imagen;

    public Titular(String tit, String sub, String argu, int imagen){
        this.titulo = tit;
        this.subtitulo = sub;
        this.argumento = argu;
        this.imagen = imagen;
    }

    public int getImagen() {return imagen;}
    public String getTitulo() {return titulo;}
    public String getSubtitulo() {return subtitulo;}
    public String getArgumento() {return argumento;}

    public void setImagen(int imagen) {this.imagen = imagen;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public void setSubtitulo(String subtitulo) {this.subtitulo = subtitulo;}
    public void setArgumento(String argumento) {this.argumento = argumento;}

    public String toString() {
        return (titulo + ", " + subtitulo + ", " + argumento);
    }
}
