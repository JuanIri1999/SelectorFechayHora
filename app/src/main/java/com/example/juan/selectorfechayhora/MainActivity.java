package com.example.juan.selectorfechayhora;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button fecha, bhora;
    EditText efecha, ehora;
    private int dia, mes, ano, hora, minutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    fecha= (Button) findViewById(R.id.btn_fecha);
    bhora= (Button) findViewById(R.id.btn_hora);
    efecha= (EditText) findViewById(R.id.editText);
    ehora= (EditText) findViewById(R.id.editText2);

    fecha.setOnClickListener(this);
    bhora.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        if (v==fecha) {
        final Calendar c = Calendar.getInstance();
                dia=c.get(Calendar.DAY_OF_MONTH);
                mes=c.get(Calendar.MONTH);
                ano=c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    efecha.setText(dayOfMonth+"/" +(month+1)+"/"+year );
                }
            }
        ,ano,mes,dia);
        datePickerDialog.show();

        }

        if (v==bhora) {
            final Calendar c = Calendar.getInstance();
            hora=c.get(Calendar.HOUR_OF_DAY);
            minutos=c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    ehora.setText(hourOfDay+":" +minute);

                }
            }, hora,minutos, false);
            timePickerDialog.show();
        }
    }
}
