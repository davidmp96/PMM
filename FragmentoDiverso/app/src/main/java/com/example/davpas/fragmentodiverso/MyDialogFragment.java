package com.example.davpas.fragmentodiverso;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyDialogFragment  extends DialogFragment {
    public static MyDialogFragment newInstance(String valor) {
        MyDialogFragment frag = new MyDialogFragment();
   /*
   Bundle bundle = new Bundle();
   bundle("clave", valor);
   frag.setArguments(bundle);
   */
        return frag;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup dlgview = (ViewGroup) inflater.inflate(R.layout.activity_my_dialog_fragment, null);
        // botÃ³n nuevo Fragment
        Button buttonShow = (Button) dlgview.findViewById(R.id.newFrag);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((MainActivity) getActivity()).addFragment();
            }
        });
        // botÃ³n cancelar
        Button buttonCancel = (Button) dlgview.findViewById(R.id.cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dismiss();
            }
        });
        // botÃ³n ir a Fragment anterior
        Button buttonBack = (Button) dlgview.findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        // asignar el dialog a la vista
        return new AlertDialog.Builder(getActivity()).setView(dlgview).create();
    }
}
