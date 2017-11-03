package com.example.davpas.ejemplodibujo2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by davpas on 3/11/17.
 */

public class VistaDibujo extends View {
    private ShapeDrawable miDrawable;

    public VistaDibujo(Context c) {super(c);}
    public VistaDibujo(Context c, AttributeSet attrs){
        super(c, attrs);
    }
    protected void onDraw(Canvas lienzo) {
        Paint miPincel = new Paint();
        miPincel.setColor(Color.BLUE);
        miPincel.setStyle(Paint.Style.STROKE);
        lienzo.drawCircle(500, 500, 300, miPincel);

        miPincel.setTextSize(60);
        lienzo.drawText("MI CIRCULO", 500, 900, miPincel);
        String mensaje = "Ancho: " + getWidth() + " Alto: " + getHeight();
        lienzo.drawText(mensaje, 500, 1000, miPincel);
    }
}
