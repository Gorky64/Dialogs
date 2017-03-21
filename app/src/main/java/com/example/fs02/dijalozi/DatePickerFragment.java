package com.example.fs02.dijalozi;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.DatePicker;

/**
 * Created by Goran on 10.12.2016..
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month= c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        android.app.DatePickerDialog dpd = new android.app.DatePickerDialog(getActivity(), this, year, month, day);
        return dpd;
    }
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
        String datum = dayOfMonth +"/"+monthOfYear+"/"+year;
        MainActivity ma = (MainActivity)getActivity();
        ma.setDatum(datum);

    }

}
