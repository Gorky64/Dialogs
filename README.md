# Dialogs
A colection of various dialog fragments.


# Warning dialog

```java
public class WarningDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Unesite sve podatke");
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        return alertDialog;
    }
}
```

# Insert text dialog

```java
    public class InsertTextDialog extends DialogFragment {
    private EditText etText;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.Unesite_podatke);
        LayoutInflater li = getActivity().getLayoutInflater();
        View v = li.inflate(R.layout.text_dialog, null);
        builder.setView(v);

        etText = (EditText) v.findViewById(R.id.etText);


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                MainActivity ma = (MainActivity) getActivity();
                ma.setNameField(etText.getText().toString());
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
```

# Date picker dialog

```java
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
```

# Yes / No dialog

```java
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
```

# List dialog

```java
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
```
