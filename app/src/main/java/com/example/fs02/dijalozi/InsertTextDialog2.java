package com.example.fs02.dijalozi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Goran on 10.12.2016..
 */

public class InsertTextDialog2 extends DialogFragment {

    private EditText etPrezime;
    private EditText etUlica;
    private EditText etNapomena;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.Unesite_podatke);
        LayoutInflater li = getActivity().getLayoutInflater();
        View v = li.inflate(R.layout.text_dialog, null);
        builder.setView(v);

        etPrezime = (EditText) v.findViewById(R.id.etText);


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                MainActivity ma = (MainActivity) getActivity();
                ma.setNameField2(etPrezime.getText().toString());
                dismiss();
            }

        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });


        AlertDialog dialog = builder.create();
        return dialog;
    }


}
