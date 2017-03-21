package com.example.fs02.dijalozi;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvIme;
    TextView tvPrezime;
    TextView tvGrad;
    TextView tvUlica;
    TextView tvDatum;
    TextView tvNapomena;
    Button btnWarningDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnWarningDialog = (Button) findViewById(R.id.btnWarningDialog);


        tvIme = (TextView) findViewById(R.id.tvIme);
        tvPrezime = (TextView) findViewById(R.id.tvPrezime);
        tvGrad = (TextView) findViewById(R.id.tvGrad);
        tvUlica = (TextView) findViewById(R.id.tvUlica);
        tvDatum = (TextView) findViewById(R.id.tvDatum);
        tvNapomena = (TextView) findViewById(R.id.tvNapomena);


        btnWarningDialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String sIme=tvIme.getText().toString();
                String sPrezime=tvPrezime.getText().toString();
                String sGrad=tvGrad.getText().toString();
                String sUlica=tvUlica.getText().toString();
                String sDatum=tvDatum.getText().toString();

                if(sIme.equals("Ime")) {
                    WarningDialog wd = new WarningDialog();
                    wd.show(getFragmentManager(), "Warning dialog");
                }
                else if (sPrezime.equals("Prezime"))
                {
                    WarningDialog wd = new WarningDialog();
                    wd.show(getFragmentManager(), "Warning dialog");
                }
                else if (sGrad.equals("Grad")){
                    WarningDialog wd = new WarningDialog();
                    wd.show(getFragmentManager(), "Warning dialog");
                }
                else if (sUlica.equals("Ulica")){
                    WarningDialog wd = new WarningDialog();
                    wd.show(getFragmentManager(), "Warning dialog");
                }
                else if (sDatum.equals("Datum"))
                {
                    WarningDialog wd = new WarningDialog();
                    wd.show(getFragmentManager(), "Warning dialog");
                }
            }
        });

        tvGrad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ListDialog ld = new ListDialog();
                ld.show(getFragmentManager(), "List dialog");
            }


        });

        tvIme.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InsertTextDialog itd = new InsertTextDialog();
                itd.show(getFragmentManager(), "Unesite ime");
            }

        });

        tvPrezime.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                InsertTextDialog2 itd2 =new InsertTextDialog2();
                itd2.show(getFragmentManager(),"Unesite prezime");
            }
        });




        tvDatum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DatePickerFragment dpf = new DatePickerFragment();
                dpf.show(getFragmentManager(),"Date Picker");
            }

        });
    }


    public void onBackPressed() {

        YesNoDialog ed = new YesNoDialog();
        ed.show(getFragmentManager(), "Exit dialog");


    }


    public void setTextField(String item) {
        tvGrad.setText(item);

    }
    public void setNameField(String ime){
        tvIme.setText(ime);
    }
    public void setNameField2(String prezime){
        tvPrezime.setText(prezime);
    }

    public void setDatum(String datum){
        tvDatum.setText(datum);
    }

}

