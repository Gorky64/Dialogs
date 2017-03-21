package com.example.fs02.dijalozi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Goran on 10.12.2016..
 */

public class YesNoDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIconAttribute(android.R.attr.alertDialogIcon);
        builder.setTitle("Izlaz iz aplikacije");
        builder.setMessage("Jeste li sigurni da želite izići iz aplikacije?");
        builder.setPositiveButton(R.string.DA, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                getActivity().finish();
            }

        });

        builder.setNegativeButton(R.string.NE, new DialogInterface.OnClickListener(){
            @Override
            public void  onClick(DialogInterface dialog, int which){
                dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        return dialog;
    }

}
