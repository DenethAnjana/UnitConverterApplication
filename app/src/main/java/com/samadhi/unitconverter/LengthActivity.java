package com.samadhi.unitconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class LengthActivity extends AppCompatActivity {

    Spinner convertFrom;
    Spinner convertTo;
    Button convert;
    EditText editTextLength;
    TextView result;
    String[] unitTypes = {"centimeter", "meter","inch","feet","yard", "mile"};
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        setSupportActionBar(toolbar);

        convertFrom = (Spinner) findViewById(R.id.spinnerConvertFrom);
        convertTo = (Spinner) findViewById(R.id.spinnerConvertTo);
        convert = (Button) findViewById(R.id.btnLengthConverter);
        editTextLength = (EditText) findViewById(R.id.editTextLength);
        result = (TextView) findViewById(R.id.tvLengthResult);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(LengthActivity.this, android.R.layout.simple_list_item_1,unitTypes);

        convertFrom.setAdapter(spinnerAdapter);
        convertTo.setAdapter(spinnerAdapter);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 double beginingQty;
                 double endingQty;
                 String beginingUnitType;
                 String endingUnitType;

                 Length_Conversion lengthConverter = new Length_Conversion();
                 beginingQty = Double.parseDouble(editTextLength.getText().toString());
                 beginingUnitType = convertFrom.getSelectedItem().toString();
                 endingUnitType = convertTo.getSelectedItem().toString();

                 if(!editTextLength.getText().toString().equals("")){

                     if (beginingUnitType == endingUnitType){
                         Toast.makeText(getApplicationContext(),"Source unit and Destination unit are same",Toast.LENGTH_LONG ).show();
                         result.setText("");
                     }else {

                         lengthConverter.setBeginingQty(beginingQty);
                         lengthConverter.setBeginingUnitType(beginingUnitType);
                         lengthConverter.setEndingUnitType(endingUnitType);

                         endingQty = lengthConverter.calculateEndingQty();
                         lengthConverter.setEndingQty(endingQty);

                         result.setText(lengthConverter.toString());
                     }

                 }else{
                     Toast.makeText(getApplicationContext(),"Enter the Length to process",Toast.LENGTH_LONG ).show();
                     result.setText("");
                 }

            }
        });
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getSupportActionBar().setTitle("Length Conversion");

    }

}