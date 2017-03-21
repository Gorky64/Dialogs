package com.example.fs02.dijalozi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Goran on 10.12.2016..
 */

public class ListDialog extends DialogFragment {
    private String [] gradoviLista;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        gradoviLista=getResources().getStringArray(R.array.Gradovi);
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Odaberite grad");
        builder.setItems(gradoviLista, new DialogInterface.OnClickListener(){
           @Override
            public void onClick(DialogInterface dialog, int which){
               String grad = gradoviLista[which];
               ((MainActivity)getActivity()).setTextField(grad);
               dismiss();
           }
        });
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
